package structure;

public class Person {
	private String surName;
	private String lastName;
	private NewDate age;
	public Person(String surName, String lastName, NewDate age){
		this.surName = surName;
		this.lastName = lastName;
		this.age = age;
	}
	/**
	 * @return the surName
	 */
	public String getSurName() {
		return surName;
	}
	/**
	 * @param surName the surName to set
	 */
	public void setSurName(String surName) {
		this.surName = surName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the age
	 */
	public NewDate getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(NewDate age) {
		this.age = age;
	}
	
	
}
