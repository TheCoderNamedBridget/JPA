package model;

import jakarta.persistence.*;

@Entity(name = "transcripts")
public class Transcript {
    @Id
    @JoinColumn(name = "student_id")
    @ManyToOne
    private Student student;

    @Id
    @JoinColumn(name = "section_id")
    @ManyToOne
    private Section section;

    @Column(name = "grade_earned", length = 2)
    private String gradeEarned;

    public Transcript() {

    }

    public Transcript(Student student, Section section) {
        this.student = student;
        this.section = section;
    }

    public Student getStudent() {
        return student;
    }

    /*
     * StudentId is a primary key therefore no setters
     */
    // public void setStudentId(Student studentId) {
    // this.studentId = studentId;
    // }

    public Section getSectionId() {
        return section;
    }

    /*
     * Section ID is a primary key therefore no setters
     */
    // public void setSectionId(Section sectionId) {
    // this.sectionId = sectionId;
    // }

    public String getGradeEarned() {
        return gradeEarned;
    }

    public void setGradeEarned(String gradeEarned) {
        this.gradeEarned = gradeEarned;
    }

}