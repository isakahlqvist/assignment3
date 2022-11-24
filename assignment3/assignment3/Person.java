package assignment3;

public class Person {
	private String identificationNumber;
	private String name;
	private int age;
	
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
	
	

}
