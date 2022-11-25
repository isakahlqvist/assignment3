package assignment3;

import java.util.ArrayList;

public class PersonRegister {
	private ArrayList<Person> persons = new ArrayList<Person>();

	public void addPerson(Person person) {
		if (!persons.contains(person)) {
			persons.add(person);
			System.out.print(person.getName() + " has been added to the register.");
		} else {
			System.out.print(person.getName() + " has already been added to the register.");
		}
	}
	
	public Person findPerson(String identificationNumber) {
		for(Person tmpPerson : persons) {
			String id = tmpPerson.getIdentificationNumber();
			if(id.equals(identificationNumber)) {
				return tmpPerson;
			}
		}
		return null;
	}
	
	public BankAccount findBankAccount(String bankAccountNumber) {
		for(Person tmpPerson : persons) {
			BankAccount tmpBankAccount = tmpPerson.findBankAccount(bankAccountNumber);
			if(tmpBankAccount != null) {
				return tmpBankAccount;
			}
		}
		System.out.println("There is no such account with that account number");
		return null;
	}
	
	public double calculateTotalBalance() {
		double totalBalance = 0;
		for(Person tmpPerson : persons) {
			totalBalance += tmpPerson.calculateTotalBalance();
		}
		return totalBalance;
	}
}