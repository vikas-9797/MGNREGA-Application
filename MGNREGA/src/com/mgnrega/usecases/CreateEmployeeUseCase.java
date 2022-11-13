package com.mgnrega.usecases;

import java.util.Scanner;

import com.mgnrega.dao.GPMDao;
import com.mgnrega.dao.GPMDaoImpl;
import com.mgnrega.model.Employee;

public class CreateEmployeeUseCase {

	public static void execute() {
		    Scanner sc = new Scanner(System.in);
			
			System.out.println("Enter Employee id :-");
			int eid = sc.nextInt();
			
			System.out.println("Enter Employee Name :-");
			String ename = sc.next();
			
			System.out.println("Enter Employee EmailID :-");
			String email = sc.next();
			
			System.out.println("Enter Employee Mobile Number :-");
			String emobile = sc.next();
			
			System.out.println("Enter Employee Address:-");
			String eaddress = sc.next();
			
			System.out.println("Enter Employee WorkDuration  :-");
			int w = sc.nextInt();
			
			System.out.println("Enter Employee salary :-");
			String s = sc.next();		
			
			Employee emp = new Employee();
			emp.setEid(eid);
			emp.setEname(ename);
			emp.setEmail(email);
			emp.setEmobile(emobile);
			emp.setEaddress(eaddress);
			emp.setEworkduration(w);
			emp.setEsalary(s);
			
			GPMDao dao = new GPMDaoImpl();
			
			String result = dao.createEmployee(emp);
			
			
			
			System.out.println(result);

	}

}
