import java.time.LocalDate;
public class Semester 
{
	@Length(min = 1, max = 16)
	private String title;
	private LocalDate startDate;
}
