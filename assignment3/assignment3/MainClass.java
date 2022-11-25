package assignment3;

import java.util.Scanner;

public class MainClass {
	static Scanner scanner = new Scanner(System.in);
	private PersonRegister personRegister = new PersonRegister();
	
	Person person1 = new Person("ID001", "Adam", 30);
	Person person2 = new Person("ID002", "Eve", 30);
	
	public MainClass() {
	}
	
	public void options() {
		String[] options = { "1. Add Person", "2. Find Person", "3. Calculate personal total", 
				"4. Calculate register total", "5. Add Account", "6. Check Account Balance",
				"7. Withdraw money from an account", "8. Deposit money to an account"};
		for (String option : options) {
			System.out.print(option + "\n\n");
		}
	}
	
	public void console() {
		personRegister.addPerson(person1);
		personRegister.addPerson(person2);
		
		Person person3 = new Person("ID003", "Steve", 31);
		personRegister.addPerson(person3);
		
		personRegister.findPerson("ID001").addBankAccount(new BankAccount("1"));
		personRegister.findPerson("ID002").addBankAccount(new BankAccount("2"));
		personRegister.findPerson("ID003").addBankAccount(new BankAccount("3"));
		
		personRegister.findBankAccount("1").setBalance(200);
		personRegister.findBankAccount("1").withdraw(200);
		personRegister.findBankAccount("1").withdraw(100);
		personRegister.findBankAccount("2").deposit(250);
		
		System.out.println("The total balance of all accounts is: " + personRegister.calculateTotalBalance());
		System.out.println(personRegister.findPerson("ID001") + " has " + personRegister.findPerson("ID001").calculateTotalBalance());
		
		options();
		
		System.out.println("Please enter a number to initiate an action.");

		int selection = scanner.nextInt();
		
		switch(selection) {
		case 1:
			addPerson();
			break;
		case 2:
			findPerson();
			break;
		case 3:
			calculatePersonalTotal();
			break;
		case 4:
			calculateTotal();
			break;
		case 5:
			addAccount();
			break;
		case 6:
			findAccount();
			break;
		case 7:
			withdraw();
			break;
		case 8:
			deposit();
			break;
		default:
			System.out.println("Couldn't recognize command. Please try again.");
			console();
			break;
		}
		System.out.println("\n");
		options();
		console();
	}
	
	public void addPerson() {
		System.out.println("Enter Identification Number: ");
		String identificationNumber = scanner.nextLine();
		System.out.println("Enter Name: ");
		String name = scanner.nextLine();
		System.out.println("Enter Age: ");
		int age = scanner.nextInt();
		
		personRegister.addPerson(new Person(identificationNumber, name, age));
	}
	
	public Person findPerson() {
		System.out.println("Enter Identification Number: ");
		String idNumber = scanner.nextLine();
		Person tmpPerson = personRegister.findPerson(idNumber);
		if (tmpPerson == null) {
			System.out.println("No matching ID with that person");
			return findPerson();
		} else {
			System.out.println("The person with ID: " + idNumber + " is named " + tmpPerson.getName() + 
			", and is " + tmpPerson.getAge() + " years old.");
			return tmpPerson;
		}
	}
	
	public void calculatePersonalTotal() {
		Person tmpPerson = findPerson();
		if (tmpPerson == null) {
			System.out.println("There is no such person.");
		}
		System.out.println(tmpPerson.calculateTotalBalance());
	}
	
	public void calculateTotal() {
		System.out.println(personRegister.calculateTotalBalance());
	}
	
	public void addAccount() {
		System.out.println("Enter identification number: ");
		Person tmpPerson = personRegister.findPerson(scanner.nextLine());
		if (tmpPerson != null) {
			System.out.println("Enter the new account number: ");
			String accountNumber = scanner.nextLine();
			BankAccount bankAccount = new BankAccount(accountNumber);
			tmpPerson.addBankAccount(bankAccount);
			System.out.println("Account created for " + tmpPerson.getName() + tmpPerson.getIdentificationNumber() + 
								", with the account number: " + accountNumber);
			
		}
	}
	
	public void findAccount() {
		System.out.println("Enter account number: ");
		String accountNumber = scanner.nextLine();
		if (personRegister.findBankAccount(accountNumber) != null) {
			System.out.println("The balance of your account is: " + 
								personRegister.findBankAccount(accountNumber).getBalance());
		} else {
			System.out.println("There is no account connected to the given number. Please try again.");
			findAccount();
		}
	}
	
	public void withdraw() {
		System.out.println("Please enter the account number from which you would like to make a withdrawal: ");
		String accountNumber = scanner.nextLine();
		if (personRegister.findBankAccount(accountNumber) != null) {
			System.out.println("How much would you like to withdraw?");
			int input1 = scanner.nextInt();
			personRegister.findBankAccount(accountNumber).withdraw(input1);
			scanner.nextLine();
		} else {
			withdraw();
		}
	}
	
	public void deposit() {
		System.out.println("Please enter the account number to which you would like to make a deposit: ");
		String accountNumber = scanner.nextLine();
		if (personRegister.findBankAccount(accountNumber) != null) {
			System.out.println("How much would you like to deposit?");
			int input2 = scanner.nextInt();
			personRegister.findBankAccount(accountNumber).deposit(input2);
			scanner.nextLine();
		} else {
			deposit();
		}
	}
	
}