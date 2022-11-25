package assignment3;

import java.util.ArrayList;

public class Person {
	private String identificationNumber;
	private String name;
	private int age;
	private ArrayList<BankAccount> bankAccounts = new ArrayList<BankAccount>();
	
	public Person() {
	}
	
	public Person(String identificationNumber, String name, int age) {
		this.identificationNumber = identificationNumber;
		this.name = name;
		this.age = age;
	}
	
	public String getIdentificationNumber() {
		return identificationNumber;
	}
	public void setIdentificationNumber(String identificationNumber) {
		this.identificationNumber = identificationNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public void addBankAccount(BankAccount BankAccount) {
		if(bankAccounts.size() > 3 && this.age >= 18 && !bankAccounts.contains(BankAccount)) {
			bankAccounts.add(BankAccount);
			System.out.println("Account has been added to " + this.name);
		} else if(this.age < 18) {
			System.out.println("This person is not yet 18 and cannot open any bank accounts.");
		} else if(bankAccounts.contains(BankAccount)) {
			System.out.println("This account already exists for " + this.name + "'s profile");
		} else {
			System.out.println("You can only have a maximum of 3 accounts per person.");
		}
	}
	
	public BankAccount findBankAccount(String bankAccountNumber) {
		for(BankAccount tmpBankAccount : bankAccounts) {
			if(tmpBankAccount.getBankAccountNumber().equals(bankAccountNumber)) {
				return tmpBankAccount;
			}
		}
		return null;
	}
	
	public double calculateTotalBalance() {
		double totalBalance = 0;
		for(BankAccount tmpBankAccount : bankAccounts) {
			totalBalance += tmpBankAccount.getBalance();
		}
		return totalBalance;
	}
	


}