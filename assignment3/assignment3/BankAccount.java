package assignment3;

public class BankAccount {
	private String bankAccountNumber;
	private double balance;
	
	public BankAccount(String bankAccountNumber){
		this.bankAccountNumber = bankAccountNumber;
		this.balance = 0;
	}
	
	public BankAccount() {
	}
	
	public String getBankAccountNumber() {
		return bankAccountNumber;
	}
	public void setBankAccountNumber(String bankAccountNumber) {
		this.bankAccountNumber = bankAccountNumber;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	public void deposit(double amount) {
		if(amount >= 0) {
			this.balance += amount;
			System.out.println("Deposit successful. Total balance of this account is:" + this.balance);
		} else {
			System.out.println("You cannot deposit a negative number. Try withdrawing.");
		}
	}
	
	public void withdraw(double amount) {
		if (amount < 0) {
			System.out.println("You cannot withdraw a negative number. Try depositing.");
		}
		else if(amount <= this.balance / 2) {
			System.out.println("You cannot withdraw more than half of your current balance at a time");
		}
		else if(this.balance < 0) {
			System.out.println("You cannot withdraw from an account without any money");
		}else {
			this.balance -= amount;
			System.out.println("Withdrawal successful. Total balance of this account is: " + this.balance);
		}
	}

}
