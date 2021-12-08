
public class Section 
{
	private byte sectionNumber;//short is chosen because it is likely that a class section number will be < 127
	private short maxCapacity;//short is chosen because a lecture hall class could be > 127(size of byte)
}
