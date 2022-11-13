package com.mgnrega.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mgnrega.exceptions.EmployeeException;
import com.mgnrega.exceptions.GPMException;
import com.mgnrega.exceptions.ProjectException;
import com.mgnrega.model.Employee;
import com.mgnrega.model.EmployeeProjectDTO;
import com.mgnrega.model.GPM;
import com.mgnrega.model.Project;
import com.mgnrega.utility.DBUtil;

public class GPMDaoImpl implements GPMDao {

	@Override
	public GPM loginGPM(String username, String password) throws GPMException {
		
	GPM gpm =null;
		
		try (Connection conn = DBUtil.provideConnection()){
		PreparedStatement ps=	conn.prepareStatement("select * from gpm where gemail=? AND gpassword=?");
		ps.setString(1,username );
		ps.setString(2, password);
		
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
			int id =rs.getInt("gid");
			String n = rs.getString("gname");
			String e = rs.getString("gemail");
			String p = rs.getString("gpassword");
			String m = rs.getString("gmobile");
			String a = rs.getString("gaddress");
			int bdoid = rs.getInt("bdoid");
			
			gpm = new GPM(id, n, e, p, m, a, bdoid);
		} else
			throw new GPMException("Invalid email or password");
		
		} catch (SQLException e) {
			throw new GPMException(e.getMessage());
		}
		return gpm;
	}

	@Override
	public String createEmployee(Employee emp) {
		
	String message = "Not done...";
		
		try (Connection conn = DBUtil.provideConnection()){
			PreparedStatement ps=	conn.prepareStatement("insert into employee(eid,ename,email,emobile,eaddress,eworkduration,esalary)values(?,?,?,?,?,?,?)");
			
			ps.setInt(1, emp.getEid());
			ps.setString(2, emp.getEname());
			ps.setString(3, emp.getEmail());
			ps.setString(4, emp.getEmobile());
			ps.setString(5, emp.getEaddress());
			ps.setInt(6, emp.getEworkduration());
			ps.setString(7, emp.getEsalary());
			
			int x= ps.executeUpdate();
			
			if(x>0)
				message = "Done Sucessfully....";

			} catch (SQLException e) {
				message = e.getMessage();
			}
			return message;
	}

	@Override
	public List<Employee> allEmployeeList() throws EmployeeException {
	List<Employee> elist = new ArrayList<>();
		
		try(Connection conn = DBUtil.provideConnection()){
			PreparedStatement ps=	conn.prepareStatement("select * from employee");
			
		ResultSet rs =	ps.executeQuery();
		
		while(rs.next()) {
			int id = rs.getInt("eid");
			String n = rs.getString("ename");
			String e = rs.getString("email");
			String m = rs.getString("emobile");
			String a = rs.getString("eaddress");
			String w = rs.getString("eworkduration");
			String s = rs.getString("esalary");
			
			Employee emp = new Employee(id, n, e, m, a, id, s);
			elist.add(emp);
				
		    }
		} catch (SQLException e) {
			throw new EmployeeException(e.getMessage());
		}
		if(elist.size()==0)
			throw new EmployeeException("No Project Fount...");
		return elist;
		
	}

	@Override
	public String assignEmployeeToProject(int pid, int eid) throws ProjectException, EmployeeException {
	String message = "Not Alloted...";
		
		try(Connection conn = DBUtil.provideConnection()){
		PreparedStatement ps =	conn.prepareStatement("select * from employee where eid=?");
		
		ps.setInt(1, eid);
     	ResultSet rs =	ps.executeQuery();
     	
     	if(rs.next()) {
     		PreparedStatement ps2 =	conn.prepareStatement("select * from project where pid=?");
     		ps2.setInt(1, pid);
         	ResultSet rs2 =	ps.executeQuery();
         	
         	if(rs2.next()) {
         		PreparedStatement ps3 =	conn.prepareStatement("insert into employee_project values(?,?)");
         		ps3.setInt(1, pid);
         		ps3.setInt(2, eid);
         		
         		int x = ps3.executeUpdate();
         		
         		if(x>0)
         			message = "Project assigend to Employee Sucessfully...";
         		
         	} else
         		throw new ProjectException("not valid project....");	
     	} else
     		throw new EmployeeException("not valid gpm....");
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new EmployeeException(e.getMessage());
		}
		return message;
		
	}

	@Override
	public List<EmployeeProjectDTO> totalWorkDurationUnderProject(String pname) throws ProjectException {
	List<EmployeeProjectDTO> emplist = new ArrayList<>();
		
		try(Connection conn = DBUtil.provideConnection()) {
			PreparedStatement ps =	conn.prepareStatement("select e.ename,e.emobile,e.eworkduration,"
					+ "e.esalary,p.pname,p.pissuedate from employee e INNER JOIN"
					+ " project p INNER JOIN employee_project ep ON e.eid=ep.eid AND"
					+ " p.pid=ep.pid AND p.pname=?");
			
			ps.setString(1, pname);
		    ResultSet rs =	ps.executeQuery();
		    
		    while(rs.next()) {
		    	
		    	EmployeeProjectDTO dto = new EmployeeProjectDTO();
		    	dto.setEname(rs.getString("ename"));
		    	dto.setEmobile(rs.getString("emobile"));
		    	dto.setEworkduration(rs.getInt("eworkduration"));
		    	dto.setEsalary(rs.getString("esalary"));
		    	dto.setPname(rs.getString("pname"));
		    	dto.setPissuedate("pissuedate");
		    	
		    	emplist.add(dto);
		    }
		    
		    if(emplist.size()==0)
		    	throw new ProjectException("employee not found for that project name");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ProjectException(e.getMessage());
		}
		
		
	
		return emplist;
		
	}

}
