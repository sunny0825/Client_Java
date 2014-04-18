package cusData;

import java.io.Serializable;

public class CusResult implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private boolean done;
	private float newBalance;
	private String msg;
	
	public CusResult() {
		this.done = false;
		this.newBalance = 0;
		this.msg = null;
	}
	
	public CusResult(boolean done, float newBalance, String msg) {
		this.done = done;
		this.newBalance = newBalance;
		this.msg = msg;
	}

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}

	public float getNewBalance() {
		return newBalance;
	}

	public void setNewBalance(float newBalance) {
		this.newBalance = newBalance;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
	

}
