package com.mgnrega.model;

public class BDO {
	private int bid;
	private String bname;
	private String bemail;
	private String bpassword;
	private String address;
	
	public BDO() {
		
	}

	public BDO(int bid, String bname, String bemail, String bpassword, String address) {
		super();
		this.bid = bid;
		this.bname = bname;
		this.bemail = bemail;
		this.bpassword = bpassword;
		this.address = address;
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public String getBemail() {
		return bemail;
	}

	public void setBemail(String bemail) {
		this.bemail = bemail;
	}

	public String getBpassword() {
		return bpassword;
	}

	public void setBpassword(String bpassword) {
		this.bpassword = bpassword;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "BDO [bid=" + bid + ", bname=" + bname + ", bemail=" + bemail + ", bpassword=" + bpassword + ", address="
				+ address + "]";
	}
	

}
