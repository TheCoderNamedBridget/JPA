package model;

import java.util.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity(name = "sections")
// @Table(uniqueConstraints = {
// @UniqueConstraint(columnNames = { "semester_id", "course_id",
// "section_number" })
// })
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = { "semester_id", "section_number" })
})
public class Section {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "section_id")
    private int sectionId;

    /*
     * Reason:
     */
    @Column(name = "section_number")
    @NotNull
    private byte sectionNumber;

    /*
     * Reason:
     */
    @Column(name = "max_capacity")
    @NotNull
    private short maxCapacity;

    /*
     * Bidirectional OneToOne Section[Child] <- Semester[Parent]
     * A section has one semester
     */
    @OneToOne
    @JoinColumn(name = "semester_id")
    private Semester semester;

    /*
     * Bidirectional[Enrollment] ManyToMany Section[Child] <- Student[Parent]
     * A section has many students
     */
    @ManyToMany(mappedBy = "enrolled")
    private Set<Student> students;

    /*
     * Unidirectional OneToOne Section[Parent] -> TimeSlot[Child]
     * A section has one timeslot
     */
    @OneToOne
    @JoinColumn(name = "timeslot_id")
    private Timeslot timeslot;

    /*
     * Unidirectional OneToOne Section[Child] <- Course[Parent]
     * A section has one course
     */
    // @OneToOne
    // @JoinColumn(name = "course_id")
    // private Course course;

    public Section() {

    }

    /*
     * A section must know its sectionNumber, maxCapacitor, semester, timeSlot and
     * course to initialize
     * Section Id is autogenerated
     * !!Regenerated this
     */
    // public Section(byte sectionNumber, short maxCapacity, Semester semester,
    // Timeslot timeslot,
    // Course course) {
    // this.sectionNumber = sectionNumber;
    // this.maxCapacity = maxCapacity;
    // this.semester = semester;
    // this.timeslot = timeslot;
    // this.course = course;
    // }

    public Section(byte sectionNumber, short maxCapacity, Semester semester, Timeslot timeslot) {
        this.sectionNumber = sectionNumber;
        this.maxCapacity = maxCapacity;
        this.semester = semester;
        this.timeslot = timeslot;

    }

    // @Override
    // public String toString() {
    // return "Section [course=" + course + ", maxCapacity=" + maxCapacity + ",
    // sectionId=" + sectionId
    // + ", sectionNumber=" + sectionNumber + ", semester=" + semester + ",
    // students=" + students
    // + ", timeslot=" + timeslot + "]";
    // }

    public int getSectionId() {
        return sectionId;
    }

    /*
     * Section ID is a primary key therefore no setters
     */
    // public void setSectionId(int sectionId) {
    // this.sectionId = sectionId;
    // }

    public byte getSectionNumber() {
        return sectionNumber;
    }

    public void setSectionNumber(byte sectionNumber) {
        this.sectionNumber = sectionNumber;
    }

    public short getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(short maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public Semester getSemester() {
        return semester;
    }

    public void setSemester(Semester semester) {
        this.semester = semester;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public Timeslot getTimeslot() {
        return timeslot;
    }

    public void setTimeslot(Timeslot timeslot) {
        this.timeslot = timeslot;
    }

    // public Course getCourse() {
    // return course;
    // }

    // public void setCourse(Course course) {
    // this.course = course;
    // }

}