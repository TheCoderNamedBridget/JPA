package model;

import jakarta.persistence.Column;

public class Prerequisite {
	@Column(name = "prerequisite_minimum_grade")
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
    
    public char getPrerequisiteMinimumGrade() {
        return minimumGrade;
    }

    public void setPrerequisiteMinimumGrade(char minimumGrade) {
        this.minimumGrade = minimumGrade;
    }
}
