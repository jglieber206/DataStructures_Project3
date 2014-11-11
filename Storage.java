
public class Storage 
{
	public int value;
	public String label;

	public Storage(String l, int v) {
		label = l;
		value = v;
	}
	
	public int getValue() {
		return value;
	}
	
	public String getString() {
		return label;
	}
	
	public void setLabel(String s) {
		label = s;
	}
	
	public void setValue (int i) {
		value = i;
	}
	public String toString()
	{
		return label+" " + value;
	}
}
