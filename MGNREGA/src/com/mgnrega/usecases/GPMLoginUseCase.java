package com.mgnrega.usecases;

import java.util.Scanner;

import com.mgnrega.dao.GPMDao;
import com.mgnrega.dao.GPMDaoImpl;
import com.mgnrega.exceptions.GPMException;
import com.mgnrega.model.GPM;


public class GPMLoginUseCase {

	public static boolean execute() {
		
        Scanner sc= new Scanner(System.in);
        boolean b =false;
		
		System.out.println("Enter Your EmailID:-");
		String email = sc.next();
		
		System.out.println("Enter Your Password:-");
		String pass=  sc.next();
		
		GPMDao dao = new GPMDaoImpl();
		
		try {
			GPM gpm = dao.loginGPM(email, pass);
			if(gpm!=null) {
				b =true;
			}
			System.out.println("Welcome : "+ gpm.getGname());
			
		} catch (GPMException e) {
			System.out.println(e.getMessage());
		}
		return b;

	}

	

}
