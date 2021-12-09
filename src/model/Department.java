package model;

import jakarta.persistence.Column;

public class Department {
	@Column(name = "department_name")
    private String name;// name is shown as a string in the uml
	@Column(name = "department_abbreviation")
    private String abbreviation;// abbreviation is shown as a string in the uml
    
    public Department() {
    }

    public Department(String name, String abbreviation) {
        this.name = name;
        this.abbreviation = abbreviation;
    }

    @Override
    public String toString() {
        return "Department " + name + " (abbreviation " + abbreviation + ")";
    }
    
    public String getDepartmentName() {
        return name;
    }

    public void setDepartmentName(String name) {
        this.name = name;
    }

    public String getDepartmentAbbreviation() {
        return abbreviation;
    }

    public void setDepartmentAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

}
