package com.mgnrega.main;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.mgnrega.usecases.BDOLoginUseCase;
import com.mgnrega.usecases.GPMLoginUseCase;

public class Main {
	
   public static void execute() {
	   
     	Scanner s = new Scanner(System.in);
		
    	System.out.println("===================================="
    			+ "\n******** WELCOME TO MGNREGA ********"
    			+ "\n====================================");
//    	System.out.println("");
    	System.out.println("");
    	System.out.println("* Please select an option below *\n"
    			+ "------------------------------------");
    	
    	System.out.println("\n"
    			+ "1. LOGIN AS BLOCK DEVELOPMENT OFFICER\n"
    			+ "2. LOGIN AS GRAM PANCHAYAT MEMBER");
    	
    	int n=0;
    	try {
    		 n = s.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("");
			System.out.println("Invalid input !!!");
		
			Main.execute();
		}
    	
    	
    	switch (n) {
		case 1: 
			if(BDOLoginUseCase.execute()) {  	
			BDOMain.execute();
			} else {
				BDOLoginUseCase.execute();
				Main.execute();
			}
			break;
			
		case 2: 
			if(GPMLoginUseCase.execute()) {
		    GPMMain.execute();
			} else {
				GPMLoginUseCase.execute();
				Main.execute();
			}
		    break;

		default: System.out.println("Please enter a valid key...");
		    execute();
			break;
		}
    	
		
	}

	public static void main(String[] args) {
		execute();

	}

	

	

}
