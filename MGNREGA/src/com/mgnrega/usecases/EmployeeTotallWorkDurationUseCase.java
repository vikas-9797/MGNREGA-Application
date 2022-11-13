package com.mgnrega.usecases;

import java.util.List;
import java.util.Scanner;

import com.mgnrega.dao.GPMDao;
import com.mgnrega.dao.GPMDaoImpl;
import com.mgnrega.exceptions.ProjectException;
import com.mgnrega.model.EmployeeProjectDTO;

public class EmployeeTotallWorkDurationUseCase {

	public static void execute() {
    Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Project Name : ");
		String pname = sc.next();
		
		GPMDao dao = new GPMDaoImpl();
		
		try {
			List<EmployeeProjectDTO> emplist = dao.totalWorkDurationUnderProject(pname);
			System.out.println("  :::  ====Employee Total Work Duration By Project Name====  :::");
			System.out.println("");
			
			emplist.forEach(el->{
				
				System.out.println("Emplouee Name : "+el.getEname());
				System.out.println("Employee Work Duration : "+el.getEworkduration());
				System.out.println("Employee Salary : "+el.getEsalary());
				
				System.out.println("---------------------------------");
			});
		} catch (ProjectException e) {
			System.out.println(e.getMessage());
			
		}

	}

}
