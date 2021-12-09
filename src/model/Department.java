package model;

import java.util.List;

@Entity(name = "departments")
public class Department {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "department_id")
	private int departmentId;
	
	@Column(name = "department_name")
	@NotNull
    private String name;// name is shown as a string in the uml
	
	@Column(name = "department_abbreviation")
	@NotNull
    private String abbreviation;// abbreviation is shown as a string in the uml
	
    // The bidirectional link to course
	@OneToMany(mappedBy = "course")
    private List<Course> courses;
    
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
