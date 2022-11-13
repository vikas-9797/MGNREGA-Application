package com.mgnrega.usecases;

import java.util.Scanner;

import com.mgnrega.dao.BDODao;
import com.mgnrega.dao.BDODaoImpl;

public class AllocateProjectToGPMUseCase {

	public static void execute() {
		
		Scanner sc  = new Scanner(System.in);
		
		System.out.println("Enter Project id : ");
		int pid = sc.nextInt();
		
		System.out.println("Enter GPM id : ");
		int gid = sc.nextInt();
		
		BDODao dao = new BDODaoImpl();
		
		try {
			String result = dao.allocateProjectToGPM(pid, gid);
			System.out.println(result);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
