package cusData;

import java.io.Serializable;

public class CusAction implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String phoneNum;
	private ActionType action; // 1-payment; 2-purchase  || can be enumerator 
	private float amount;

	public CusAction(String phoneNum, ActionType action, float amount) {
		this.phoneNum = phoneNum;
		this.action = action;
		this.amount = amount;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public ActionType getAction() {
		return action;
	}

	public void setAction(ActionType action) {
		if (action == ActionType.payment || action == ActionType.purchase) {
			this.action = action;
		} 
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public String actionToStr() {
		if (action == ActionType.payment) {
			return "payment";
		} else if (action == ActionType.purchase) {
			return "purchase";
		} else {
			return "none";
		}
	}

	@Override
	public String toString() {
		return phoneNum + ", " + actionToStr() + ", " + amount;
	}

}
