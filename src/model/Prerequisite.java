package model;

public class Prerequisite {
	@Column(name = "PREREQUISITE_MINIMUM_GRADE")
    private char minimumGrade;
    
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
