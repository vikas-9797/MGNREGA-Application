package com.mgnrega.usecases;

import java.util.Scanner;

import com.mgnrega.dao.GPMDao;
import com.mgnrega.dao.GPMDaoImpl;
import com.mgnrega.exceptions.EmployeeException;
import com.mgnrega.exceptions.ProjectException;

public class AssignProjectToEmployeeUseCase {

	public static void execute() {
	    Scanner sc  = new Scanner(System.in);
		
		System.out.println("Enter Project id : ");
		int pid = sc.nextInt();
		
		System.out.println("Enter Employee id : ");
		int gid = sc.nextInt();
		
		GPMDao dao = new GPMDaoImpl();
		
		try {
			String result = dao.assignEmployeeToProject(pid, gid);
			System.out.println(result);
		} catch (ProjectException e) {
			System.out.println("Project is not there with this id");

	    } catch(EmployeeException e) {
	    	System.out.println("Employee is not there with this id");
	    }

  }
}
