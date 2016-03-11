
public class Person implements Comparable<Person>
{
	private int id;
	private String name;
	private String street;
	private String city;
	private String state;
	private String phoneNumber;

	public Person(int num, String n, String s, String c,
			String st, String p)
	{
		id = num;
		name = n;
		street = s;
		city = c;
		state = st;
		phoneNumber = p;
	}

	public Person(String n) //(initialize the name and sets the other values to null or 0 as appropriate)
	{
		id = 0;
		name = n;
		street = null;
		city = null;
		state = null;
		phoneNumber = null;
	}
	
	public Person(int n) //(initialize the id number and sets the other values to null)
	{
		id = n;
		name = null;
		street = null;
		city = null;
		state = null;
		phoneNumber = null;
	}
	
	public String toString() //(which concatenates all Person instance variables)
	{
		return id + " " + name + " " + street + " " + city + " " + state + " " + phoneNumber;
	}
	
	public int getID() //(accessor method for the id instance variable)
	{
		return id;
	}

	public int compareTo(Person person) {
		return this.name.compareTo(person.name);
	}
}