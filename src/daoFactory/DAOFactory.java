package daoFactory;

import dao.EmployeeDAOImp;
import dao.IEmployeeDAO;

public class DAOFactory {
	
	private DAOFactory(){}
	
	private static IEmployeeDAO iEmployeeDAO =null;
	
	public static IEmployeeDAO getEmployeeDAO() {
		if(iEmployeeDAO==null) {
			return new EmployeeDAOImp();
		}
		return iEmployeeDAO;
	}
	
	

}
