

public class Student 
{
	private int studentID;//int was chosen for student id because it is likely a studnet id will fall between 0 - 2147483648
	@Length(min = 1, max = 128)
	private String name;
}