import	java.util.Comparator;
public class CompareInt implements Comparator<Person>
{
	public int compare(Person p1, Person p2)
	{
		return p1.getID() - p2.getID();
	}
}
