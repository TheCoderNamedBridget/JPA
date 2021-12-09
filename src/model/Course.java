package model;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class Course {
    @Column(name = "COURSE_NUMBER")
    private String number;// course number could be anywhere from 100-9000lvl and in the UML it is shown
                          // as a string
    @Column(name = "COURSE_TITLE")
    private String title;// title is shown as a string in the uml
    @Column(name = "COURSE_UNITS")
    private byte units;// no course will have more than 127 units which is the biggest value for a byte
    
    // The unidirectional link to Section
    @OneToMany
    @JoinColumn(name = "DEPARTMENT_NAME")
    private Department department;
    
    //TODO need to add I think a bidirectional link between courses and prereq?
    //I dont think we need a link to section number because course is it's parent
    
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