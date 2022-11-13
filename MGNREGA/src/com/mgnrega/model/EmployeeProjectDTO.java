package com.mgnrega.model;

public class EmployeeProjectDTO {
	
	private String ename;
	private String emobile;
	private int eworkduration;
	private String esalary;
	
	private String pname;
	private String pissuedate;
	
	public EmployeeProjectDTO() {
		
	}

	public EmployeeProjectDTO(String ename, String emobile, int eworkduration, String esalary, String pname,
			String pissuedate) {
		super();
		this.ename = ename;
		this.emobile = emobile;
		this.eworkduration = eworkduration;
		this.esalary = esalary;
		this.pname = pname;
		this.pissuedate = pissuedate;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getEmobile() {
		return emobile;
	}

	public void setEmobile(String emobile) {
		this.emobile = emobile;
	}

	public int getEworkduration() {
		return eworkduration;
	}

	public void setEworkduration(int eworkduration) {
		this.eworkduration = eworkduration;
	}

	public String getEsalary() {
		return esalary;
	}

	public void setEsalary(String esalary) {
		this.esalary = esalary;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPissuedate() {
		return pissuedate;
	}

	public void setPissuedate(String pissuedate) {
		this.pissuedate = pissuedate;
	}

	@Override
	public String toString() {
		return "EmployeeProjectDTO [ename=" + ename + ", emobile=" + emobile + ", eworkduration=" + eworkduration
				+ ", esalary=" + esalary + ", pname=" + pname + ", pissuedate=" + pissuedate + "]";
	}
	

}