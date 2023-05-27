package service;

import dto.Employee;

public interface IEmployeeService {
	public String addEmployee(String name, String empid, String desgn);
	public String updateEmployee(String name, String empid, String desgn);
	public Employee searchEmployee(String empid);
	public String deleteEmployee(String empid);
}
