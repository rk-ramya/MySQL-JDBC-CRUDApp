package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.Employee;
import util.UtilityClass;

public class EmployeeDAOImp implements IEmployeeDAO{
	Connection connection =null;
	PreparedStatement pstmt = null;
	ResultSet resultSet=null;
	
	@Override
	public String addEmployee(String name, String empid, String desgn)  {
		try {
		connection = UtilityClass.getJdbcConnection();
		String query = "insert into employee(`name`,`empid`,`designation`) values(?,?,?)";
		pstmt= connection.prepareStatement(query);
		pstmt.setString(1, name) ;
		pstmt.setString(2, empid) ;
		pstmt.setString(3, desgn) ;
		int rows = pstmt.executeUpdate();
		if(rows==1)
			return "SUCCESS";		
		}		
		catch(Exception e)
		{ e.printStackTrace();
		}
		return "FAILURE";
	}
		

	@Override
	public String updateEmployee(String name, String empid, String desgn) {
		String sqlUpdateQuery = "update employee set name=?,designation=? where EMPid=?";
		try {
			connection = UtilityClass.getJdbcConnection();

			if (connection != null)
				pstmt = connection.prepareStatement(sqlUpdateQuery);

			if (pstmt != null) {

				pstmt.setString(1, name) ;
				pstmt.setString(2, desgn) ;
				pstmt.setString(3, empid) ;

				int rowAffected = pstmt.executeUpdate();
				if (rowAffected == 1) {
					return "success";
				}
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		return "failure";
	}

	@Override
	public Employee searchEmployee(String empid) {
		String sqlSelectQuery = "select name,empid,designation from employee where empid = ?";
		Employee emp;

		try {
			connection = UtilityClass.getJdbcConnection();

			if (connection != null)
				pstmt = connection.prepareStatement(sqlSelectQuery);

			if (pstmt != null)
				pstmt.setString(1, empid);

			if (pstmt != null) {
				resultSet = pstmt.executeQuery();
			}

			if (resultSet != null) {

				if (resultSet.next()) {
					emp = new Employee();

					// copy resultSet data to student object
				
					emp.setName(resultSet.getString(1));
					emp.setEmpid(resultSet.getString(2));
					emp.setDesignation(resultSet.getString(3));

					return emp;
				}

			}

		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String deleteEmployee(String empid) {
		String sqlDeleteQuery = "delete from employee where EMPid = ?";
		try {
			connection = UtilityClass.getJdbcConnection();

			if (connection != null)
				pstmt = connection.prepareStatement(sqlDeleteQuery);

			if (pstmt != null) {

				pstmt.setString(1, empid);

				int rowAffected = pstmt.executeUpdate();
				if (rowAffected == 1) {
					return "success";
				} else {
					return "not found";
				}
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
			return "failure";
		}
		return "failure";

	}
}
