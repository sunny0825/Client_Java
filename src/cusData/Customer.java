package cusData;

public class Customer {
	private int cusID;
	private String firstName;
	private String lastName;
	private String phoneNum;
	private double balance;
	
	
	public Customer(String fName, String lName, String pNum, double balance){
		this.firstName = fName;
		this.lastName = lName;
		this.phoneNum = pNum;
		this.balance = balance;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public int getCusID() {
		return cusID;
	}

	public void setCusID(int cusID) {
		this.cusID = cusID;
	}
	
	

}
