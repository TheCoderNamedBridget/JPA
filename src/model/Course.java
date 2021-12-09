package model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
@Entity(name = "courses")

@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = { "department_id", "course_id" })
})
public class Course {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "course_id")
	private int courseId;
	
    @Column(name = "course_number")
    @NotNull
    private String number;// course number could be anywhere from 100-9000lvl and in the UML it is shown
                          // as a string
    
    @Column(name = "course_title")
    @NotNull
    private String title;// title is shown as a string in the uml
    
    @Column(name = "course_units")
    @NotNull
    private byte units;// no course will have more than 127 units which is the biggest value for a byte
    
    // The bidirectional link to Department
    //course has one and exactly 1 department
    @OneToOne
    @JoinColumn(name = "department_id")
    private Department department;
    
    // The bidirectional link to course
	@OneToMany(mappedBy = "section")
    private List<Section> sections;
    
    //TODO not sure if this is the way to represent a recurrsive association in JPA
    @OneToMany(mappedBy="prerequisite")
    private Set<Prerequisite> prerequisite;
    
    public Course() {
    }

    public Course(String number, String title, byte units) {
        this.number = number;
        this.title = title;
        this.units = units;
    }

    @Override
    public String toString() {
        return "Course " + title + " (number " + number + ")";
    }
    
    public String getCourseNumber() {
        return number;
    }

    public void setCourseNumber(String number) {
        this.number = number;
    }

    public int getCourseTitle() {
        return title;
    }

    public void setCourseTitle(String title) {
        this.title = title;
    }

    public int getCourseUnits() {
        return units;
    }

    public void setCourseUnits(byte units) {
        this.units = units;
    }
    
    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}