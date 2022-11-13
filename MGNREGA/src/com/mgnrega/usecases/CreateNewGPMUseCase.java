package com.mgnrega.usecases;

import java.util.Scanner;

import com.mgnrega.dao.BDODao;
import com.mgnrega.dao.BDODaoImpl;

public class CreateNewGPMUseCase {

	public static void execute() {
	    Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter GPM id :-");
		int gid = sc.nextInt();
		
		System.out.println("Enter GPM Name :-");
		String gname = sc.next();
		
		System.out.println("Enter GPM EmailID :-");
		String gemail = sc.next();
		
		System.out.println("create GPM password :-");
		String gpassword = sc.next();
		
		System.out.println("Enter GPM Mobile Number :-");
		String gmobile = sc.next();
		
		System.out.println("Enter GPM Address:-");
		String gaddress = sc.next();
		
		System.out.println("Enter Your id :-");
		int bdoid = sc.nextInt();
		
		
		
		
		BDODao dao = new BDODaoImpl();
		
		String result = dao.createGPM(gid, gname, gemail, gpassword, gmobile, gaddress, bdoid);
		
		System.out.println(result);

	}

}
