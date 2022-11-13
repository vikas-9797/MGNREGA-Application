package com.mgnrega.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mgnrega.exceptions.BDOException;
import com.mgnrega.exceptions.GPMException;
import com.mgnrega.exceptions.ProjectException;
import com.mgnrega.model.BDO;
import com.mgnrega.model.EmployeeProjectDTO;
import com.mgnrega.model.GPM;
import com.mgnrega.model.Project;
import com.mgnrega.utility.DBUtil;


public class BDODaoImpl implements BDODao {

	@Override
	public BDO loginBDO(String email, String password) throws BDOException {
		BDO bdo =null;
		
		try (Connection conn = DBUtil.provideConnection()){
		PreparedStatement ps=	conn.prepareStatement("select * from bdo where bemail=? AND bpassword=?");
		ps.setString(1,email );
		ps.setString(2, password);
		
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
			int id =rs.getInt("bid");
			String n = rs.getString("bname");
			String e = rs.getString("bemail");
			String p = rs.getString("bpassword");
			String a = rs.getString("baddress");
			
			bdo = new BDO(id, n, e, p, a);
		} else
			throw new BDOException("Invalid email or password");
		
		} catch (SQLException e) {
			throw new BDOException(e.getMessage());
		}
		return bdo;
	}

	@Override
	public String createProject(int pid, String pname, String pcost, String pissuedate) {
		
		String message = "Not Done...";
		
		try (Connection conn = DBUtil.provideConnection()){
			PreparedStatement ps=	conn.prepareStatement("insert into project(pid,pname,pcost,pissuedate)values(?,?,?,?)");
			
			ps.setInt(1, pid);
			ps.setString(2, pname);
			ps.setString(3, pcost);
			ps.setString(4, pissuedate);
			
			int x= ps.executeUpdate();
			
			if(x>0)
				message = "Project Created Sucessfully....";

			} catch (SQLException e) {
				message = e.getMessage();
			}
			return message;
		
	}

	@Override
	public List<Project> allProjectList() throws ProjectException {
		List<Project> list = new ArrayList<>();
		
		try(Connection conn = DBUtil.provideConnection()){
			PreparedStatement ps=	conn.prepareStatement("select * from project");
			
		ResultSet rs =	ps.executeQuery();
		
		while(rs.next()) {
			int id = rs.getInt("pid");
			String n = rs.getString("pname");
			String c = rs.getString("pcost");
			String i = rs.getString("pissuedate");
			int gpmid = rs.getInt("gpmid");
			
			Project project = new Project(id,n,c,i,gpmid);
			list.add(project);
				
		    }
		} catch (SQLException e) {
			throw new ProjectException(e.getMessage());
		}
		if(list.size()==0)
			throw new ProjectException("No Project Fount...");
		return list;
	}

	@Override
	public String createGPM(int gid, String gname, String gemail, String gpassword, String gmobile, String gaddress,
			int bdoid) {
		String message = "Not done...";
		
		try (Connection conn = DBUtil.provideConnection()){
			PreparedStatement ps=	conn.prepareStatement("insert into gpm(gid,gname,gemail,gpassword,gmobile,gaddress,bdoid)values(?,?,?,?,?,?,?)");
			
			ps.setInt(1, gid);
			ps.setString(2, gname);
			ps.setString(3, gemail);
			ps.setString(4, gpassword);
			ps.setString(5, gmobile);
			ps.setString(6, gaddress);
			ps.setInt(7, bdoid);
			
			int x= ps.executeUpdate();
			
			if(x>0)
				message = "Done Sucessfully....";

			} catch (SQLException e) {
				message = e.getMessage();
			}
			return message;
	}

	@Override
	public List<GPM> allGramPanchayatList() throws GPMException {
	List<GPM> gpmlist = new ArrayList<>();
		
		try(Connection conn = DBUtil.provideConnection()){
			PreparedStatement ps=	conn.prepareStatement("select * from gpm");
			
		ResultSet rs =	ps.executeQuery();
		
		while(rs.next()) {
			int gid = rs.getInt("gid");
			String n = rs.getString("gname");
			String e = rs.getString("gemail");
			String p = rs.getString("gpassword");
			String m = rs.getString("gmobile");
			String a = rs.getString("gaddress");
			int bdo = rs.getInt("bdoid");
			
			GPM gpm =new GPM(gid, n, e, p, m, a, bdo);
			
			gpmlist.add(gpm);
	
		    }
		} catch (SQLException e) {
			throw new GPMException(e.getMessage());
		}
		if(gpmlist.size()==0)
			throw new GPMException("No member Found...");
		return gpmlist;
	}

	@Override
	public String allocateProjectToGPM(int pid, int gid) throws ProjectException, GPMException {
		String message = "Not Alloted...";
		
		try(Connection conn = DBUtil.provideConnection()){
		PreparedStatement ps =	conn.prepareStatement("select * from gpm where gid=?");
		
		ps.setInt(1, gid);
     	ResultSet rs =	ps.executeQuery();
     	
     	if(rs.next()) {
     		PreparedStatement ps2 =	conn.prepareStatement("select * from project where pid=?");
     		ps2.setInt(1, pid);
         	ResultSet rs2 =	ps.executeQuery();
         	
         	if(rs2.next()) {
         		PreparedStatement ps3 =	conn.prepareStatement("insert into project_gpm values(?,?)");
         		ps3.setInt(1, pid);
         		ps3.setInt(2, gid);
         		
         		int x = ps3.executeUpdate();
         		
         		if(x>0)
         			message = "Project assigend to GPM Sucessfully...";
         		
         	} else
         		throw new ProjectException("not valid project....");	
     	} else
     		throw new GPMException("not valid gpm....");
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new GPMException(e.getMessage());
		}
		return message;
	}

	@Override
	public List<EmployeeProjectDTO> showAllEmployeeDetailUnderProject(String pname) throws ProjectException {
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

