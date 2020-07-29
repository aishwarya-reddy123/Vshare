package demo.com.model;

import javax.persistence.Entity;
import javax.persistence.Table;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
@Table(name="portfolio")
public class Portfolio {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	public Portfolio() {
		super();
	}

	@ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;
 

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	@Column
	private double currentvalue;
	@Column
	private double investmentvalue;
	@Column
	private double profitorloss;
	@Column
	private double equitybalance;
	

	public double getCurrentvalue() {
		return currentvalue;
	}
	public void setCurrentvalue(double currentvalue) {
		this.currentvalue = currentvalue;
	}
	
	public double getInvestmentvalue() {
		return investmentvalue;
	}
	public void setInvestmentvalue(double investmentvalue) {
		this.investmentvalue = investmentvalue;
	}
	public double getProfitorloss() {
		return profitorloss;
	}
	public void setProfitorloss(double profitorloss) {
		this.profitorloss = profitorloss;
	}
	public double getEquitybalance() {
		return equitybalance;
	}
	public void setEquitybalance(double equitybalance) {
		this.equitybalance = equitybalance;
	}
	
	@Override
	public String toString() {
		return "Portfolio [id=" + id + ", currentvalue=" + currentvalue + ", Investmentvalue=" + investmentvalue + ", profitorloss=" + profitorloss
				+ "]";
	}
	
}
