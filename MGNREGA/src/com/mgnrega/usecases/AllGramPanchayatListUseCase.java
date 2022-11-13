package com.mgnrega.usecases;

import java.util.List;

import com.mgnrega.dao.BDODao;
import com.mgnrega.dao.BDODaoImpl;
import com.mgnrega.exceptions.GPMException;
import com.mgnrega.model.GPM;

public class AllGramPanchayatListUseCase {

	public static void execute() {
		
		BDODao dao = new BDODaoImpl();
		
		try {
			List<GPM> gpmlist = dao.allGramPanchayatList();
			System.out.println("  :::  ====List of All Gram Panchayat member====  :::");
			System.out.println("");
			
			
			gpmlist.forEach(g->{
				System.out.println("GPM id : "+g.getGid());
				System.out.println("GPM Name : "+ g.getGname());
				System.out.println("GPM Mobile Number : "+g.getGmobile());
				System.out.println("GPM EmaiID : "+g.getGemail());
				System.out.println("GOMpassword : "+g.getGpassword());
				System.out.println("GPM Address : "+g.getGaddress());
				
				System.out.println("----------------------------------");
			});
			
		} catch (GPMException e) {
			System.out.println(e.getMessage());
		}

	}

}
