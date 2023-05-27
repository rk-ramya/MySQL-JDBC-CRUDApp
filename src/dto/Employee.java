package dto;

public class Employee {
	private String name;
	private String empid;
	private String designation;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmpid() {
		return empid;
	}
	public void setEmpid(String empid) {
		this.empid = empid;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", empid=" + empid + ", designation=" + designation + "]";
	}
	public Employee(String name, String empid, String designation) {
		super();
		this.name = name;
		this.empid = empid;
		this.designation = designation;
	}
	public Employee() {
		
	}
	

}
