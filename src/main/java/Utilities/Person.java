package Utilities;
/**
 * This is a POJO class to store the data from JSON file
 */
public class Person {
    private String name;
    private int age;
    private String gender;

     public Person(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public Person() {
		// TODO Auto-generated constructor stub
	}
    
//Getters and Setters
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
