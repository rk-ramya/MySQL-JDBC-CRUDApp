package service;

import dao.IEmployeeDAO;
import daoFactory.DAOFactory;
import dto.Employee;

public class ServiceImpl implements IEmployeeService{

	IEmployeeDAO iEmployeeDAO =null;
	@Override
	public String addEmployee(String name, String empid, String desgn) {
		iEmployeeDAO = DAOFactory.getEmployeeDAO();
		return iEmployeeDAO.addEmployee(name, empid, desgn);
	}

	@Override
	public String updateEmployee(String name, String empid, String desgn) {
		iEmployeeDAO = DAOFactory.getEmployeeDAO();
		return iEmployeeDAO.updateEmployee(name, empid, desgn);
		
	}

	@Override
	public Employee searchEmployee(String empid) {
		iEmployeeDAO = DAOFactory.getEmployeeDAO();
		return iEmployeeDAO.searchEmployee(empid);
		
	}

	@Override
	public String deleteEmployee(String empid) {
		iEmployeeDAO = DAOFactory.getEmployeeDAO();
		return iEmployeeDAO.deleteEmployee(empid);
		
		
	}

}
