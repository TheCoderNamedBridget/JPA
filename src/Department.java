



public class Department 
{
	@Length(min = 1, max = 128)
	private String name;//name is shown as a string in the uml
	@Length(min = 1, max = 8)
	private String abbreviation;//abbreviation is shown as a string in the uml
}
