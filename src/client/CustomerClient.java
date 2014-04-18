package client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import cusData.ActionType;
import cusData.CusAction;
import cusData.CusResult;

public class CustomerClient {

	public static void main(String args[]) {
		String phoneNum, strAction;
		float amount;
		ActionType intAction;

		CusAction cusAction;

		final int defaultPort = 9732;
		final String server = "localhost";

		Socket addSocket = null;
		ObjectOutputStream strmToServer = null;
		ObjectInputStream strmFromServer = null;

		int length = args.length;
		if (length == 3) {
			phoneNum = args[0];
			strAction = args[1].toLowerCase();
			amount = Float.parseFloat(args[2]);

			if (strAction.equals("payment")) {
				intAction = ActionType.payment;
			} else if (strAction.equals("purchase")) {
				intAction = ActionType.purchase;
			} else {
				System.out.println("Error- action type");
				return;
			}

			cusAction = new CusAction(phoneNum, intAction, amount);
		} else {
			System.out.println("Error - parameters size");
			return;
		}

		// connect to server
		try {
			addSocket = new Socket(server, defaultPort);
			strmToServer = new ObjectOutputStream(addSocket.getOutputStream());
			strmFromServer = new ObjectInputStream(addSocket.getInputStream());
			System.out.println("Connected to Server");
			
		} catch (UnknownHostException ex) {
			System.out.println("Unable to find server: " + server);
			System.exit(1);
		} catch (IOException ex) {
			System.out.println("Unable to open I/O stream to server: "
					+ server);
			System.exit(1);
		} 
		// send & read data from server
		try {

			strmToServer.writeObject(cusAction);
			System.out.println("Send data: " + cusAction);

			Object obj = strmFromServer.readObject();

			if (obj != null) {
				if (obj instanceof CusResult) {
					CusResult result = (CusResult) obj;

					if (result.isDone()) {
						System.out.println("Result from server: the new balance is: "
								+ result.getNewBalance());
					} else {
						System.out.println(result.getMsg());
					}

				}
			}

			strmFromServer.close();
			strmToServer.close();
			addSocket.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}
