package com.mgnrega.usecases;

import java.util.List;

import com.mgnrega.dao.GPMDao;
import com.mgnrega.dao.GPMDaoImpl;
import com.mgnrega.exceptions.EmployeeException;
import com.mgnrega.model.Employee;



public class EmployeeListUseCase {

	public static void execute() {
	GPMDao dao = new GPMDaoImpl();
		
		try {
			List<Employee> elist = dao.allEmployeeList();
			System.out.println("  :::  ====List of All Employee====  :::");
			System.out.println("");
		
			
			elist.forEach(e->{
				System.out.println("Employee id : "+e.getEid());
				System.out.println("Employee name : "+e.getEname());
				System.out.println("Employee EmailID : "+e.getEmail());
				System.out.println("Employee Mobile Number : "+e.getEmobile());
				System.out.println("Employee total works duration : "+e.getEworkduration());
				System.out.println("Employee total wages : "+e.getEsalary());
				
				System.out.println("---------------------------------");
			});

		} catch (EmployeeException e) {
			System.out.println(e.getMessage());
		}

	}

}
