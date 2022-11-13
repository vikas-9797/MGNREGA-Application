package com.mgnrega.usecases;

import java.util.Scanner;

import com.mgnrega.dao.BDODao;
import com.mgnrega.dao.BDODaoImpl;
import com.mgnrega.exceptions.BDOException;
import com.mgnrega.model.BDO;

public class BDOLoginUseCase {

	public static boolean execute() {
		Scanner sc= new Scanner(System.in);
		boolean b = false;;
		
		System.out.println("Enter Your EmailID:-");
		String email = sc.next();
		
		System.out.println("Enter Your Password:-");
		String pass=  sc.next();
		
		BDODao dao = new BDODaoImpl();
		
		try {
			BDO bdo = dao.loginBDO(email, pass);
			if(bdo!=null) {
			      b = true;
			}
			System.out.println("Welcome :"+ bdo.getBname());
			
		} catch (BDOException e) {
			System.out.println(e.getMessage());
		}
		return b;
		

	}

	

}
