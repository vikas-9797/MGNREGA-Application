package com.mgnrega.dao;

import java.util.List;

import com.mgnrega.exceptions.BDOException;
import com.mgnrega.exceptions.GPMException;
import com.mgnrega.exceptions.ProjectException;
import com.mgnrega.model.BDO;
import com.mgnrega.model.EmployeeProjectDTO;
import com.mgnrega.model.GPM;
import com.mgnrega.model.Project;

public interface BDODao {

	public BDO loginBDO(String username, String password)throws BDOException;	
	
	public String createProject(int pid, String pname, String pcost, String pissuedate);
	
	public List<Project> allProjectList()throws ProjectException;
	
	public String createGPM(int gid, String gname, String gemail, String gpassword, String gmobile, String gaddress,int bdoid);
	
	public List<GPM> allGramPanchayatList()throws GPMException;
	
	public String allocateProjectToGPM(int pid, int gid)throws ProjectException,GPMException;
	
	public List<EmployeeProjectDTO> showAllEmployeeDetailUnderProject(String pname)throws ProjectException;
}
