package demo.com.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "stocks")
public class Company {

	private long id;
	private String name;
	private String index;
	private double marketcapital;
	private double price;
	private double open;
	private double close;
	private double high;
	private double low;
	public Company()
	{
		
	}
	
	
	public Company(long id, String name, String index, double marketcapital, double price, double open, double close,
			double high, double low) {
		super();
		this.id = id;
		this.name = name;
		this.index = index;
		this.marketcapital = marketcapital;
		this.price = price;
		this.open = open;
		this.close = close;
		this.high = high;
		this.low = low;
	}


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	@Column(name = "name", nullable = false)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name = "index", nullable = false)
	public String getIndex() {
		return index;
	}
	public void setIndex(String index) {
		this.index = index;
	}
	@Column(name = "marketcapital", nullable = false)
	public double getMarketcapital() {
		return marketcapital;
	}
	public void setMarketcapital(double marketcapital) {
		this.marketcapital = marketcapital;
	}
	public double getOpen() {
		return open;
	}
	public void setOpen(double open) {
		this.open = open;
	}
	public double getClose() {
		return close;
	}
	public void setClose(double close) {
		this.close = close;
	}
	public double getHigh() {
		return high;
	}
	public void setHigh(double high) {
		this.high = high;
	}
	public double getLow() {
		return low;
	}
	public void setLow(double low) {
		this.low = low;
	}
	
	
	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	@Override
	public String toString() {
		return "Company [id=" + id + ", Name=" + name + ", Index=" + index + ", marketcapital=" + marketcapital
				+ "]";
	}
	
	
}
