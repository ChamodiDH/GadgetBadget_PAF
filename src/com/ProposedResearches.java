package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.ProposedResearchesDt;
import model.ResearcherDt;

public class ProposedResearches {
	
	public Connection connect() {
		Connection con = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/gadgetbadgetdb", "root", "123qwebnm");
			// For testing
			System.out.print("Successfully connected");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return con;
	}
	
	public List<ProposedResearchesDt> getProposedResearches() {
		List<ProposedResearchesDt> presearches = new ArrayList<>();
		try {

			Connection con = connect();

			if (con == null) {
				// return "Error while connecting to the database for updating";
			}

			String sql = "select * from proposedresearches ";

			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {

				ProposedResearchesDt r = new ProposedResearchesDt();

				r.setrid(rs.getInt(1));
				r.setrchrid(rs.getInt(2));
				r.setresearchName(rs.getString(3));
				r.setCriteria(rs.getString(4));
				r.setuniversity(rs.getString(5));
				r.setdoclink(rs.getString(6));

				presearches.add(r);

			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return presearches;
	}
	
	public ProposedResearchesDt getProposedResearch(int rid) {
		ProposedResearchesDt r = new ProposedResearchesDt();

		try {
			Connection con = connect();

			if (con == null) {
				// return "Error while connecting to the database for updating";
			}
			String sql = "select * from proposedresearches where rid =" + rid;

			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if (rs.next()) {

				r.setrid(rs.getInt(1));
				r.setrchrid(rs.getInt(2));
				r.setresearchName(rs.getString(3));
				r.setCriteria(rs.getString(4));
				r.setuniversity(rs.getString(5));
				r.setdoclink(rs.getString(6));

			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return r;
	}

	public void create(ProposedResearchesDt r1) {
		try {
			Connection con = connect();

			if (con == null) {
				// return "Error while connecting to the database for updating";
			}
			String sql = "insert into proposedresearches values(?,?,?,?,?,?)";

			PreparedStatement r = con.prepareStatement(sql);

			r.setInt(1,r1.getrId());;
			r.setInt(2, r1.getrchrid());
			r.setString(3,r1.getresearchName());
			r.setString(4,r1.getCriteria());
			r.setString(5,r1.getuniversity());
			r.setString(6, r1.getdoclink());


			r.executeUpdate();

		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void update(ProposedResearchesDt r1) {

		try {
			Connection con = connect();

			if (con == null) {
				// return "Error while connecting to the database for updating";
			}

			String sql = "UPDATE  proposedresearches SET rchrid=?researchName=?,criteria=?,university=?,doclink=? WHERE rid=?";

			PreparedStatement r = con.prepareStatement(sql);

			r.setInt(1,r1.getrId());
			r.setInt(2, r1.getrchrid());
			r.setString(3,r1.getresearchName());
			r.setString(4,r1.getCriteria());
			r.setString(5,r1.getuniversity());
			r.setString(6, r1.getdoclink());


		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void delete(int rid) {

		try {
			Connection con = connect();

			if (con == null) {
				// return "Error while connecting to the database for updating";
			}

			String sql = "delete from proposedresearches where rid=?";

			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, rid);
			st.executeUpdate();

		} catch (Exception e) {
			System.out.println(e);
		}

	}
	
	public String getProposedResearchesTable() {

		String output = "";
		output = "<table border='1'><tr><th>Research ID</th><th>Researcher ID</th>"+
		"<th>Research Name</th>"+
		"<th>Criteria</th>"+
		"<th>University</th>"+
		"<th>Document Link</th></tr>";
		try {
			Connection con = connect();

			if (con == null) {
				// return "Error while connecting to the database for updating";
			}
			String sql = "select * from proposedresearches ";

			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {

				ProposedResearchesDt r = new ProposedResearchesDt();

				r.setrid(rs.getInt(1));
				r.setrchrid(rs.getInt(2));
				r.setresearchName(rs.getString(3));
				r.setCriteria(rs.getString(4));
				r.setuniversity(rs.getString(5));
				r.setdoclink(rs.getString(6));

				// Add into the html table
				output += "<tr><td>" + rs.getInt(1) + "</td>";
				output += "<td>" + rs.getInt(2) + "</td>";
				output += "<td>" + rs.getString(3) + "</td>";
				output += "<td>" + rs.getString(4) + "</td>";
				output += "<td>" + rs.getString(5) + "</td>";
				output += "<td>" + rs.getString(6) + "</td></tr>";

			}
			output += "</table>";
		} catch (Exception e) {
			System.out.println(e);
		}

		return output;
	}

}

//proposedresearches