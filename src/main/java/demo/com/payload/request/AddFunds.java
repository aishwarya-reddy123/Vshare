package demo.com.payload.request;

import java.time.LocalDateTime;

public class AddFunds {
	
	private String payment_Id;
	private double amount;
	private Long user_id;
	private LocalDateTime date;
	public String getPayment_Id() {
		return payment_Id;
	}
	public void setPayment_Id(String payment_Id) {
		this.payment_Id = payment_Id;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Long getUser_id() {
		return user_id;
	}
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	
	
}
