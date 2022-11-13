package com.mgnrega.main;

import java.util.Scanner;

import com.mgnrega.usecases.AssignProjectToEmployeeUseCase;
import com.mgnrega.usecases.CreateEmployeeUseCase;
import com.mgnrega.usecases.EmployeeListUseCase;
import com.mgnrega.usecases.EmployeeTotallWorkDurationUseCase;

public class GPMMain {

	public static void execute(){
	
	    Scanner s = new Scanner(System.in);
			
		System.out.println("===================================="
				           + "\n****** GRAM PANCHAYAT MEMBER *******"
				           + "\n====================================");
//		System.out.println("");
    	System.out.println("");
		
		System.out.println("* Please select an option below *\n"
				           + "------------------------------------");
		
		System.out.println("\n"
				+ "1. CREATE NEW EMPLOYEE\n"
				+ "2. VIEW THE DETAILS OF ALL EMPLOYEES\n"
				+ "3. ASSIGN EMPLOYEE TO A PROJECT.\n"
				+ "4. VIEW TOTAL NO. OF DAYs EMPLOYEE WORKED IN A PROJECT AND THEIR WAGES\n"
				+ "5. LOGOUT");
		
		int select = s.nextInt();
		
		switch (select) {
		case 1:
			CreateEmployeeUseCase.execute();
			execute();
			break;
			
		case 2:
			EmployeeListUseCase.execute();
			execute();
			break;
			
		case 3:
			AssignProjectToEmployeeUseCase.execute();
			execute();
			break;
			
		case 4:
			EmployeeTotallWorkDurationUseCase.execute();
			execute();
			break;
			
		case 5:
			Main.execute();
			break;
			
		default:
			System.out.println("Please Enter a valid key...");
			execute();
			break;
		}
		
		
			
		
			
			
	}

}


