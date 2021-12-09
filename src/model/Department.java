package model;

public class Department {
	@Column(name = "DEPARTMENT_NAME")
    private String name;// name is shown as a string in the uml
	@Column(name = "DEPARTMENT_ABBREVIATION")
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

    public void setDepartmentName(String abbreviation) {
        this.abbreviation = abbreviation;
    }

}
