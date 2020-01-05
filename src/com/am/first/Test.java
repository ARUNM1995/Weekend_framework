package com.am.first;

import com.am.first.dao.EmployeeDao;
import com.am.first.dto.Employee;

public class Test {

	
	public static void main(String[] args) {
				Employee employee = new Employee();
				employee.setId(new Long(3));
				employee.setName("XYZ");
				employee.setContact(new Long(2334444));
				employee.setDesc("java developer");
				employee.setSalary(100.00);
				System.out.println(employee);
				
				
				
				EmployeeDao employeeDao = new EmployeeDao();
				//employeeDao.save(employee);
				employeeDao.getEmployee(new Long(20));
				
	}

}
