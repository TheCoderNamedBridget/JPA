package model;

import java.util.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity(name = "students")
public class Student {

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
        return 0;
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
        return null;
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

    public Set<Section> getSections() {
        return sections;
    }

    public void setSections(Set<Section> sections) {
        this.sections = sections;
    }

    public Set<Transcript> getTranscripts() {
        return transcripts;
    }

    public void setTranscripts(Set<Transcript> transcripts) {
        this.transcripts = transcripts;
    }

}
