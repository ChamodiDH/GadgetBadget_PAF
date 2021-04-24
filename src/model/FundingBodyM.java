package model;
import javax.xml.bind.annotation.XmlRootElement;



@XmlRootElement

public class FundingBodyM {
	
	private int id;
	private String name;
	private int telno;
	private String companyname;
	private String companyaddress;
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
	public String getCompanyname() {
		return companyname;
	}
	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}
	public String getCompanyaddress() {
		return companyaddress;
	}
	public void setCompanyaddress(String companyaddress) {
		this.companyaddress = companyaddress;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "FundingBodyM [id=" + id + ", name=" + name + ", Tel=" + telno + ", companyname=" + companyname + ", companyaddress="
				+ companyaddress + ", email=" + email + "]";
	}
}
