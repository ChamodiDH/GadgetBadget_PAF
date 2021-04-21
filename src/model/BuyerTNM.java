package model;


public class BuyerTNM {
	private int id;
	private String name;
	private int telno;
	private String address;
	private String companyname;
	private String email;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getTelno() {
		return telno;
	}
	public void setTelno(int telno) {
		this.telno = telno;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCompanyname() {
		return companyname;
	}
	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "ResearcherDt [id=" + id + ", name=" + name + ", Tel=" + telno + ", address=" + address + ", Companyname="
				+ companyname + ", email=" + email + "]";
	}

}
