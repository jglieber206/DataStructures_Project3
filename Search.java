import java.io.*;
import java.util.*;

public class Search {
	public static HashTable table = new HashTable();
	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
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
		readInput(args[1]);
	
	}
	
	public static void readInput(String filename) throws FileNotFoundException, UnsupportedEncodingException {
		
		Scanner query = null; 
		PrintWriter writer = null;
		byte[] outputbyte;
		try 
		{
			query = new Scanner(new File(filename));
			writer = new PrintWriter("testoutput.txt", "UTF-8");
			
		}
		catch (FileNotFoundException e) 
		{
			
		}
		while(query.hasNextLine()) 
		{
			if(query.nextLine() != null)
			{
			String line = (String) query.nextLine();
			
			if (!table.contains(line))  
			{
				System.out.println(line);
				
				writer.println(line);
			}
			else
			{
				ArrayList<Integer> intList = (ArrayList<Integer>) table.getValue(line);
				StringBuilder builder = new StringBuilder();
				for(int i = 0; i < intList.size(); i++)
				{
					builder.append(intList.get(i));
					builder.append(" ");
				}
				System.out.println(line + " " + builder.toString());
				writer.println(line + " " + builder.toString());
			}
		}
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

