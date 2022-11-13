package com.mgnrega.model;

public class Employee {
	private int eid;
	private String ename;
	private String email;
	private String emobile;
	private String eaddress;
	private int eworkduration;
	private String esalary;
	
	public Employee() {
		
	}

	public Employee(int eid, String ename, String email, String emobile, String eaddress, int eworkduration,
			String esalary) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.email = email;
		this.emobile = emobile;
		this.eaddress = eaddress;
		this.eworkduration = eworkduration;
		this.esalary = esalary;
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmobile() {
		return emobile;
	}

	public void setEmobile(String emobile) {
		this.emobile = emobile;
	}

	public String getEaddress() {
		return eaddress;
	}

	public void setEaddress(String eaddress) {
		this.eaddress = eaddress;
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

	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", email=" + email + ", emobile=" + emobile + ", eaddress="
				+ eaddress + ", eworkduration=" + eworkduration + ", esalary=" + esalary + "]";
	}
	

}
