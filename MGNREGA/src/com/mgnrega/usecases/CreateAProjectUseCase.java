package com.mgnrega.usecases;

import java.util.Scanner;

import com.mgnrega.dao.BDODao;
import com.mgnrega.dao.BDODaoImpl;

public class CreateAProjectUseCase {

	public static void execute() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Project id:-");
		int pid = sc.nextInt();
		
		System.out.println("Enter Project Name:-");
		String pname = sc.next();
		
		System.out.println("Enter Project cost:-");
		String pcost = sc.next();
		
		System.out.println("Enter Project Isssue date:-");
		String pissuedate = sc.next();
		
		BDODao dao = new BDODaoImpl();
		
		String result = dao.createProject(pid, pname, pcost, pissuedate);
		
		System.out.println(result);
	}

	
}
