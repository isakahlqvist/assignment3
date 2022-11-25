package assignment3;

import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		
		System.out.println("Hello");
		PersonRegister register1 = new PersonRegister();

		Person person1 = new Person("ID001", "Adam", 30);
		Person person2 = new Person("ID002", "Eve", 30);
		
		ArrayList<Person> personArr = new ArrayList<Person>();

		personArr.add(person1);
		personArr.add(person2);
		
	}
}