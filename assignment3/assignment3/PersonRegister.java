package assignment3;

import java.util.ArrayList;

public class PersonRegister {
	
	ArrayList<Person> persons = new ArrayList<Person>();
	
	Person person1 = new Person("ID001", "Adam", 30);
	Person person2 = new Person("ID002", "Eve", 30);
	
	persons.add(person1);
	persons.add(person2);
	
}
