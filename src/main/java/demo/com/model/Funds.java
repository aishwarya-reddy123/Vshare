package demo.com.model;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="funds")
public class Funds {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	
	@ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Column
	private double amount;
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	@Column
	private LocalDateTime  date;
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Column
	private String payment_id;
	public String getPayment_id() {
		return payment_id;
	}
	public void setPayment_id(String payment_id) {
		this.payment_id = payment_id;
	}
	@Override
	public String toString() {
		return "Funds [id=" + id + ", Amount=" + amount + ", Date=" + date + ", Payment_Id=" + payment_id
				+ "]";
	}
}
