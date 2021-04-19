package model;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement

public class ResearcherDt {
	
	private int id;
	private String name;
	private int telno;
	private String university;
	private String specialization;
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
	public int getTel() {
		return telno;
	}
	public void setTel(int telno) {
		this.telno = telno;
	}
	public String getuniversity() {
		return university;
	}
	public void setuniversity(String university) {
		this.university = university;
	}
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "ResearcherDt [id=" + id + ", name=" + name + ", Tel=" + telno + ", University=" + university + ", Specialization="
				+ specialization + ", email=" + email + "]";
	}
	

}
