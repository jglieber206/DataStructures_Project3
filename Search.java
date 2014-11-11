import java.io.*;
import java.util.*;

public class Search {
	public static HashTable table = new HashTable();
	public static void main(String[] args) {
		Hashtable t = new Hashtable<String, ArrayList<Integer>>();
		t.put("a", 1);
		
		
		String file = args[0]; 
		Scanner inputStream = null;
		ArrayList<Storage> list = new ArrayList<Storage>();
		ArrayList<String> str = new ArrayList<String>();
		/*try/catch in case file name is typed in wrong / does not exist.
		 * 
		 */
		try {
			inputStream = new Scanner( new File(file) );

		}   catch (FileNotFoundException e) {
			System.out.print("THE FILE DOES NOT EXIST!");
			System.exit(0);
		}
		int i = 0 ;
		
		while(inputStream.hasNextLine()) {
			
			String aLine = inputStream.nextLine();
			String[] strArray = aLine.split(" ");

			if(strArray.length == 2)
			{
				String aString = strArray[0];
//				System.out.println(aString);
				int aVal = Integer.parseInt(strArray[1]);
				Storage one = new Storage(aString, aVal);
				list.add(one);
				
				if(table.contains(aString)) 
				{
					((ArrayList<Integer>)table.getValue(aString)).add(aVal);
				}
				else {
//					System.out.println("add to the table");
					ArrayList<Integer> aList = new ArrayList<Integer>();
					aList.add(aVal);
					table.add(aString, aList);
					
				}
			}
			i++ ;
			
		}
		inputStream.close() ;		
		
		System.out.println(table.toString());
		
		//test
		
	
		
//		table.add("ha", 12);
//		table.add("hoho", 24);
//		table.add("oo", 36);
//		table.add("ya", 48);
		
//		table.toString();
//		Object a = table.getValue(table.toString());

//		System.out.println(table.toString()+table.getNumElements());
		
	}
	
	public String readInput(String filename) {
		Scanner query = null; 
		ArrayList<String> queries = new ArrayList();
		
		while(query.hasNextLine()) {
			String line = query.next();
			if (!table.contains(line))  {
				return query.next();
			}
			return table.getValue(line);
		}
	}

}

	//scan input files
		//store each (string, int) pair into hashtable
		//hashtable.Add(string, int)
	//quick sort function
		//take each integer list as parameter, sort the list
		//return the sorted list
	//loop through the table, print out string + list of ints

