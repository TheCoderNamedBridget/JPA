



public class Course 
{
	@Length(min = 1, max = 8)
	private String number;//course number could be anywhere from 100-9000lvl and in the UML it is shown as a string
	@Length(min = 1, max = 64)
	private String title;//title is shown as a string in the uml
	private byte units;//no course will have more than 127 units which is the biggest value for a byte
	
}
