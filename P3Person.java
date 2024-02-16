package Project2;

public class Person
{
	protected String name;
	protected int age;
	protected String height;
	protected String gender;
	protected String state;
	
	public Person(String name, int age, String height, String gender, String state) {
		super();
		this.name = name;
		this.age = age;
		this.height = height;
		this.gender = gender;
		this.state = state;
	}

	public String getName() {			
		return name;
	}
	
	public int getAge() {
		return age;
	}
	public String getHeight() {
		return height;
	}
	public String getGender() {
		return gender;
	}
	public String getState() {
		return state;
	}																															
	public String DescriptionStatement() {																										//flexible method will be used to print the youngest skaters for both genders
		return name+" who stands "+height+" tall, and is only "+age+ " years old, born and raised in "+state;
	}
}