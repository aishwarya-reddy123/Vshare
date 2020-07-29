package demo.com.payload.request;

public class CreatePortfolio {
	
	private Long id;
	private Long user_id;
	private double currentvalue,investmentvalue,profitorloss,equitybalance;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getUser_id() {
		return user_id;
	}
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}
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
	
	

}
