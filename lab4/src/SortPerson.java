//	Run the following main like this:
//		java SortPerson "Isaac Newton" 301
//	Note that the quotation marks are required!
//
//      Setting Command Line Arguments in the Eclipse IDE:
//      1. "Run" (top menu) -> "Run Configurations..."
//      2. Select the "(x)= Arguments" tab
//      3. Add the command line arguments in the "Program arguments:" text area
//      4. Press "Apply"


import	java.util.*;

public class SortPerson
{
	private	ArrayList<Person>	people = new ArrayList<Person>();

	public SortPerson()
	{
		people.add(new Person(301, "Albert Einstein", "123 My Street", "Your Town", "UT", "123-4567"));
		people.add(new Person(860, "John Smith", "867 Elm St.", "Lake Forest", "AZ", "555-6543"));
		people.add(new Person(51, "Cranston Snort", "1600 Pennsylvania Ave", "Washington", "DC", "1-800-123-4783"));
		people.add(new Person(602, "Fred Wally", "123 E. Wilson", "Sunset", "UT", "678-4351"));
		people.add(new Person(857, "Isaac Newton", "1234 W. 900 S.", "Salt Lake City", "UT", "563-4567"));
		people.add(new Person(403, "Wilson", "1492 USA Way", "Morristown", "NJ", "345-8765"));
		people.add(new Person(4567, "John Smith", "417 El Toro", "Irvine", "CA", "869-3482"));
	}

	public void sortByName(String name)
	{
		// sort list people by name here
		Collections.sort(people);

		for (Person p : people)				// print sorted list
			System.out.println(p);


		System.out.println("\nSearching for: " + name);

		// make key based on search name
		Person key = new Person(0, name, null, null, null, null);

		// add natural (by name in this case) search code here
		int index = Collections.binarySearch(people, key);
		
		if (index >= 0)
			System.out.println(people.get(index));
		else
			System.out.println(name + " was not found");

		System.out.println();				// print a blank line
	
	}

	public void sortByID(int id)
	{
		// make a int-based compartor here
		Comparator<Person> comp = new CompareInt();

		// sort list people by id here
		Collections.sort(people, comp);

		for (Person p : people)				// print sorted list
			System.out.println(p);


		System.out.println("\nSearching for: " + id);

		// make key based on id
		Person key = new Person(id, null, null, null, null, null);

		// add comparator-based search code here
		int index = Collections.binarySearch(people, key, comp);

		if (index >= 0)
			System.out.println(people.get(index));
		else
			System.out.println(id + " was not found");	
	}

	public static void main(String args[])
	{
		SortPerson	sp = new SortPerson();
		sp.sortByName(args[0]);
		sp.sortByID(Integer.parseInt(args[1]));
	}
}