package model;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

public class Course {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "course_id")
    private int courseId;
	
    @Column(name = "course_number", length = 8)
    private String number;// course number could be anywhere from 100-9000lvl and in the UML it is shown
                          // as a string
    @Column(name = "course_title")
    private String title;// title is shown as a string in the uml
    @Column(name = "course_units")
    private byte units;// no course will have more than 127 units which is the biggest value for a byte
    
    // The unidirectional link to Section
    @OneToMany
    @JoinColumn(name = "department_name")
    private Department department;
    
    /*
     * Unidirectional
     * A course has many preqs
     */
    @ManyToOne
    private Set<Prerequisite> prereqs;
    
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

    public String getCourseTitle() {
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