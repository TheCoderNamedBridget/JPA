package model;

import java.text.DecimalFormat;
import java.time.LocalTime;
import java.util.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity(name = "students")
public class Student {
	private static final DecimalFormat df = new DecimalFormat("0.00");
    /*
     * StudentID should be unique already since its a PK
     */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "student_id")
    private int studentId;

    @Column(length = 128)
    @NotNull
    private String name;

    /*
     * Bidirectional ManyToMany Student[Parent] -> Section[Child]
     * Many students enroll in many sections
     */
    @ManyToMany
    @JoinTable(name = "enrolled", joinColumns = @JoinColumn(name = "student_id"), inverseJoinColumns = @JoinColumn(name = "section_id"))
    private Set<Section> enrolled;

    /*
     * Unidirectional ManyToMany Student[Parent] -> Section[Child]
     * Many students earn a grade in many sections -> Transcipt Class
     */
    @OneToMany(mappedBy = "student")
    private Set<Transcript> transcripts;

    public Student() {

    }

    public Student(@NotNull String name) {
        this.name = name;
        transcripts = new HashSet<Transcript>();
    }

    /*
     * converting each letter grade in the transcript to its "grade points". 4
     * points for A, 3 for B, 2 for C, 1 for D. 0 for everything else.
     * multiplying each grade point by the number of units for that course. An A in
     * CECS 174 gives 4 * 3 = 12 points.
     * summing all the grade points multiplied by their units.
     * dividing the sum by the total number of units in the transcript.
     */
    public double getGPA() {
    	
    	double sumGrades = 0;
    	double numClasses = 0;
    	
    	Iterator<Transcript> itr = transcripts.iterator();
    	
    	while( itr.hasNext() )
    	{
    		Transcript t = itr.next();
    		
    		System.out.println("tryin to get GPA [" + t.getGradeEarned() + "] [" + t.getSectionId().getSectionNumber() + "] [" + t.getStudent().getName() +"]");
    		switch ( t.getGradeEarned() )
    		{
    			case " A":
    				sumGrades+=4;
    				break;
    			case " B":
    				sumGrades+=3;
    				break;
    			case " C":
    				sumGrades+=2;
    				break;
    			case " D":
    				sumGrades+=1;
    				break;
    				//otherwise do nothing
//    			default:
//    				sumGrades+=0;
    		}
    		numClasses++;
    	}
    	System.out.println("printing gpa " + sumGrades + " " + numClasses + " " + (sumGrades/numClasses));
    	//limiting gpa to 2 decimal places
    	Double d = Double.parseDouble(df.format((sumGrades/numClasses)));
    	System.out.println("printing gpa " + d );
        return d;
    }

    /*
     * Attempts to register the student for the given course section. If the student
     * is able to register, mutates the Section's enrolled-students set and the
     * Student's enrolled-sections set. Returns a RegistrationResult value
     * indicating the success of that operation, which can fail for many reasons:
     * The student has already received a "C" or better in the course.
     * The student is already enrolled in the section.
     * The student has not met the course prerequisites.
     * The student is enrolled in a different section of that course.
     * The student is enrolled in another course section with a time conflict: the
     * sections meet on the same day, with at least 1 minute of overlap in their
     * start and end times.
     */
    public RegistrationResult registerForSection(Section s) {
    	//iterate through transcript to see if student has already taken course and got at least a c
    	Iterator<Transcript> transItr = transcripts.iterator();
    	while( transItr.hasNext() )
    	{
    		Transcript t = transItr.next();
    		
    		System.out.println("trying to see whcih courses taken " + t.getSectionId().getCourse().getCourseTitle());
    		if ( t.getSectionId().getCourse().getCourseTitle().equals( s.getCourse().getCourseTitle()) )
    		{
    			if ( t.getGradeEarned().equals(" A" ) || t.getGradeEarned().equals(" B" ) || t.getGradeEarned().equals(" C" ) )
    			{
    				return RegistrationResult.ALREADY_PASSED;
    			}
    		}
    	}
    	//iterate through list of students in the section to see if this student is already registered.
    	Iterator<Student> alreadyReg = s.getStudents().iterator();
    	while( alreadyReg.hasNext() )
    	{
    		Student t = alreadyReg.next();
    		
    		System.out.println("trying to see if already registered");
    		if ( t.studentId == studentId )
    		{
    			return RegistrationResult.ENROLLED_IN_SECTION;
    		}
    	}
    	//TODO Check for course prereq 
    	Set<Prerequisite> prereqs = s.getCourse().getPreq();
    	Iterator<Prerequisite> prereqsItr = prereqs.iterator();
//    	while( prereqsItr.hasNext() )
//    	{
//    		Prerequisite t = prereqsItr.next();
//    		
//    		System.out.println("trying to see if took prereqs");
//    		if ( t. )
//    		{
//    			return RegistrationResult.ENROLLED_IN_ANOTHER;
//    		}
//    	}RegistrationResult.NO_PREREQUISITES
    	
    	//iterate through enrolled list to see if student is already enrolled in a different section of course
    	
    	Iterator<Section> enrolledItr = enrolled.iterator();
    	while( enrolledItr.hasNext() )
    	{
    		Section t = enrolledItr.next();
    		
    		System.out.println("trying to see if already registered");
    		if ( t.getCourse().getCourseTitle().equals( s.getCourse().getCourseTitle()) )
    		{
    			return RegistrationResult.ENROLLED_IN_ANOTHER;
    		}
    	}
    	
    	//iterate through enrolled list to see if there is at least 1 minute of overlap in the schedule 
    	Iterator<Section> timeConflictItr = enrolled.iterator();
    	while( timeConflictItr.hasNext() )
    	{
    		Section t = timeConflictItr.next();
    		LocalTime startTimeT = t.getTimeslot().getStartTime();
    		LocalTime endTimeT = t.getTimeslot().getStartTime();
    		
    		LocalTime startTimeS = s.getTimeslot().getStartTime();
    		LocalTime endTimeS = s.getTimeslot().getStartTime();
    		//t1.compareto(t2)
    		//if t1 > t1 return 1
    		//if t1 < t2 return -1
    		//if equal return 0
    		System.out.println("trying to see if time conflict");
    		//Comparing just the start and end time of variable t should be enough to tell if the section times overlap
    		//startTimeT.compareTo(startTimeS) == 1 && startTimeT.compareTo(endTimeS) == -1 
    		//endTimeT.compareTo(startTimeS) == 1 && endTimeT.compareTo(endTimeS) == -1 
    		if ( (startTimeT.compareTo(startTimeS) == 1 && startTimeT.compareTo(endTimeS) == -1) || 
    				(endTimeT.compareTo(startTimeS) == 1 && endTimeT.compareTo(endTimeS) == -1 ) )
    		{
    			return RegistrationResult.TIME_CONFLICT;
    		}
    	}
        return RegistrationResult.SUCCESS;
    }

    public int getStudentId() {
        return studentId;
    }

    /*
     * Student ID is a primary key therefore no setters
     */
    // public void setStudentId(int studentId) {
    // this.studentId = studentId;
    // }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Section> getEnrolled() {
        return enrolled;
    }

    public void setSections(Set<Section> enrolled) {
        this.enrolled = enrolled;
    }

    public Set<Transcript> getTranscripts() {
        return transcripts;
    }

    public void setTranscripts(Set<Transcript> transcripts) {
        this.transcripts = transcripts;
    }

}