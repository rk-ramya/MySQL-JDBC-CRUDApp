package controller;

import java.util.Scanner;

import service.ServiceImpl;
import serviceFactory.ServiceFactory;
import dto.Employee;

public class ControllerJDBC {

	public static void main(String[] args) {
	ServiceImpl service = ServiceFactory.getService();

	Scanner scanner = new Scanner(System.in);
	String sname, sid, sdesg;
	while(true) {
	System.out.println("****employee menu*******");
	System.out.println("1. INSERT EMPLOYEE RECORDS \n 2. UPDATE INSERT EMPLOYEE RECORDS"
			+ " \n 3. SEARCH EMPLOYEE RECORDS \n 4. DELETE EMPLOYEE RECORDS\n");
	
	switch(scanner.nextInt()){
	case 1:
		System.out.print("Enter the employee name :: ");
		sname = scanner.next();
		System.out.print("Enter the employee id :: ");
		sid = scanner.next();
		System.out.print("Enter the employee designation :: ");
		sdesg = scanner.next();
		String msg = service.addEmployee(sname, sid, sdesg);
		if (msg.equalsIgnoreCase("success")) {
			System.out.println("record inserted succesfully");
		} else {
			System.out.println("record insertion failed....");
		}
		break;
		
	case 2:
		
		System.out.print("Enter the employee id to update :: ");
		sid = scanner.next();
		System.out.print("Enter the employee name :: ");
		sname = scanner.next();
		System.out.print("Enter the employee designation :: ");
		sdesg = scanner.next();
		msg=service.updateEmployee(sname, sid, sdesg);
		if (msg.equalsIgnoreCase("success")) {
			System.out.println("record updated succesfully");
		} else {
			System.out.println("record update failed....");
		}		
		break;
		
	case 3:
		
		System.out.print("Enter the employee id to search :: ");
		sid = scanner.next();
		
		Employee employee = service.searchEmployee(sid);
        msg= (employee==null)?"record update failed":"record found"+employee;
		System.out.println(msg);
	break;
		
	case 4: 
		System.out.print("Enter the employee id to  delete:: ");
		sid = scanner.next();
		msg=service.deleteEmployee(sid);
		if (msg.equalsIgnoreCase("success")) {
			System.out.println("record deleted succesfully");
		} else {
			System.out.println("record delete failed....");
		}
		break;
		
	default: 
		System.out.print("QUIT");
		System.exit(0);
		break;
	}	


}

}
}
