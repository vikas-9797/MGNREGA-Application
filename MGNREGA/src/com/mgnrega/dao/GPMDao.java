package com.mgnrega.dao;

import java.util.List;

import com.mgnrega.exceptions.EmployeeException;
import com.mgnrega.exceptions.GPMException;
import com.mgnrega.exceptions.ProjectException;
import com.mgnrega.model.Employee;
import com.mgnrega.model.EmployeeProjectDTO;
import com.mgnrega.model.GPM;

public interface GPMDao {
	
	public GPM loginGPM(String username,String password)throws GPMException;
	
	public String createEmployee(Employee emp);
	
	public List<Employee> allEmployeeList()throws EmployeeException;
	
	public String assignEmployeeToProject(int pid,int eid)throws ProjectException,EmployeeException;
	
	public List<EmployeeProjectDTO> totalWorkDurationUnderProject(String pname)throws ProjectException;
	
}
