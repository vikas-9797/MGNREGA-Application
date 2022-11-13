package com.mgnrega.usecases;

import java.util.List;
import java.util.Scanner;

import com.mgnrega.dao.BDODao;
import com.mgnrega.dao.BDODaoImpl;
import com.mgnrega.exceptions.ProjectException;
import com.mgnrega.model.EmployeeProjectDTO;

public class AllEmployeeByPnameUseCase {

	public static void execute() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Project Name : ");
		String pname = sc.next();
		
		BDODao dao = new BDODaoImpl();
		
		try {
			List<EmployeeProjectDTO> emplist = dao.showAllEmployeeDetailUnderProject(pname);
			System.out.println("  :::  ====List of All Employee By Project Name====  :::");
			System.out.println("");
			
			emplist.forEach(el->{
				
				System.out.println("Emplouee Name : "+el.getEname());
				System.out.println("Employee Salary : "+el.getEsalary());
				
				System.out.println("---------------------------------");
			});
		} catch (ProjectException e) {
			System.out.println(e.getMessage());
			
		}

	}

}
