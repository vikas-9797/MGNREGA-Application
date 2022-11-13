package com.mgnrega.main;

import java.util.Scanner;

import com.mgnrega.usecases.AllEmployeeByPnameUseCase;
import com.mgnrega.usecases.AllGramPanchayatListUseCase;
import com.mgnrega.usecases.AllProjectListUseCase;
import com.mgnrega.usecases.AllocateProjectToGPMUseCase;
import com.mgnrega.usecases.CreateAProjectUseCase;
import com.mgnrega.usecases.CreateNewGPMUseCase;

public class BDOMain {

	public static void execute() {
		
	Scanner s = new Scanner(System.in);
		
		System.out.println("===================================="
			       + "\n**** Block Development Officer *****"
			       + "\n====================================");
//		System.out.println("");
    	System.out.println("");
	
	    System.out.println("* Please select an option below *\n"
			       + "------------------------------------");
	
	    System.out.println("\n"
			       + "1. CREATE NEW PROJECT\n"
		       	   + "2. VIEW LIST OF PROJECT\n"
		           + "3. CREATE NEW GRAM PANCHAYAT MEMBER(GPM)\n"
		           + "4. VIEW ALL GRAM PANCHAYAT MEMBER\n"
			       + "5. ALLOCATE PROJECT TO GRAM PANCHAYAT MEMBER\n"
			       + "6. SEE LIST OF EMPLOYEE WORKING ON A PROJECT AND THEIR WAGES\n"
			       + "7. LOGOUT");
	
	int select = s.nextInt();
	
	switch (select) {
	case 1:
		CreateAProjectUseCase.execute();
		execute();
		break;
		
	case 2:
		AllProjectListUseCase.execute();
		execute();
		break;
		
	case 3:
		CreateNewGPMUseCase.execute();
		execute();
		break;
		
	case 4:
		AllGramPanchayatListUseCase.execute();
		execute();
		break;
		
	case 5:
		AllocateProjectToGPMUseCase.execute();
		execute();
		break;
		
	case 6:
		AllEmployeeByPnameUseCase.execute();
		execute();
		break;
		
	case 7:
		Main.execute();
		break;

	default:
		System.out.println("Please Enter a valid key...");
		execute();
		break;
	}
		
		
	}

}
