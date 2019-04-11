/*
 * Author:Maciej Skrzypczynski
 * Date: 28/03/2019
 * Description: Person class storing name surname and city 
 */
package lab8.work.com;

public class Person 
{
	private String firstName;
	private String surname;
	private String city;
	
	public Person(String firstName,String surname,String city)
	{
		this.setFirstName(firstName);
		this.setCity(city);
		this.setSurname(surname);
	}
	public String toString()
	{
		return "Persons name is "+getFirstName()+" their surname is "+getSurname()+" they live in "+getCity();
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
}
