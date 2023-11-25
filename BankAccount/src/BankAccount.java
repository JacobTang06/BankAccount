import java.util.Random;

public class BankAccount {
	
	private String name, address, dateOfBirth;
	private long phoneNumber;
	private double minDeposit, totalCash;

	
	public BankAccount(String name, String address, long phoneNumber, String dateOfBirth, double minDeposit) {
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.dateOfBirth = dateOfBirth;
		this.minDeposit = minDeposit;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public long getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setDateOfBirth(String dob) {
		dateOfBirth = dob;
	}
	
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	
	public void setMinDeposit(double minDeposit) {
		this.minDeposit = minDeposit;
		totalCash = minDeposit;
	}
	
	public double getMinDeposit() {
		return minDeposit;
	}
	
	public void setTotalMoney(double totalCash) {
		this.totalCash = totalCash;
	}
	
	public double getTotalMoney() {
		return totalCash;
	}
	
	public void withdraw(double withdrawAmt) {
		totalCash -= withdrawAmt;
	}
	
	public void deposit(double depositAmt) {
		totalCash += depositAmt;
	}
	
	
//	public int getID() {
//		return (int)Math.floor(Math.random() * (999999 - 100000 + 1) * 100000);
//	}

}
