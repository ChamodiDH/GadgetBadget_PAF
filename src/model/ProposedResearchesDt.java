package model;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement

public class ProposedResearchesDt {
	private int rid;
	private int rchrid;
	private String researchName;
	private String criteria;
	private String university;
	private String doclink;
	
	public int getrId() {
		return rid;
	}
	public void setrid(int  rid) {
		this. rid =  rid;
	}
	public int getrchrid() {
		return rchrid;
	}
	public void setrchrid(int rchrid) {
		this.rchrid = rchrid;
	}
	public String getresearchName() {
		return researchName;
	}
	public void setresearchName(String researchName) {
		this.researchName = researchName;
	}
	public String getCriteria() {
		return criteria;
	}
	public void setCriteria(String criteria) {
		this.criteria = criteria;
	}
	public String getuniversity() {
		return university;
	}
	public void setuniversity(String university) {
		this.university = university;
	}
	public String getdoclink() {
		return doclink;
	}
	public void setdoclink(String doclink) {
		this.doclink = doclink;
	}
	
	
	
	@Override
	public String toString() {
		return "ProposedResearchesDt [ rid=" + rid + ", rchrid=" + rchrid + ", researchName=" + researchName + ", criteria=" + criteria + ", university="
				+ university + ", doclink=" +doclink + "]";
	}
}
