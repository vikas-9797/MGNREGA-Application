package com.mgnrega.usecases;

import java.util.List;

import com.mgnrega.dao.BDODao;
import com.mgnrega.dao.BDODaoImpl;
import com.mgnrega.exceptions.ProjectException;
import com.mgnrega.model.Project;

public class AllProjectListUseCase {

	public static void execute() {
		
		BDODao dao = new BDODaoImpl();
		
		try {
			List<Project> list = dao.allProjectList();
			System.out.println("  :::  ====List of All Project====  :::");
			System.out.println("");
			
			list.forEach(p->{
				System.out.println("Project id : "+p.getPid());
				System.out.println("Project Nmae : "+p.getPname());
				System.out.println("Project cost : "+p.getPcost());
				System.out.println("Project Issue date : "+p.getPissuedate());
				
				System.out.println("------------------------------");
			});
			
			
			
		} catch (ProjectException e) {
			
		}
		

	}

}
