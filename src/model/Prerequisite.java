package model;
@Entity(name = "prerequisites")
public class Prerequisite {
	@Column(name = "prerequisite_minimum_grade")
    private char minimumGrade;
	
    @OneToOne
    @JoinColumn(name = "course_id")
    private Course course_id;
    
    public Prerequisite() {
    }

    public Prerequisite(char minimumGrade) {
        this.minimumGrade = minimumGrade;
    }

    @Override
    public String toString() {
        return "Prerequisite minimum grade" + minimumGrade;
    }
    
    public String getPrerequisiteMinimumGrade() {
        return minimumGrade;
    }

    public void setPrerequisiteMinimumGrade(char minimumGrade) {
        this.minimumGrade = minimumGrade;
    }
}
