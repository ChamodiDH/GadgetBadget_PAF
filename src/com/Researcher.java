package com;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import model.ResearcherDt;

public class Researcher {

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

	public List<ResearcherDt> getResearchers() {
		List<ResearcherDt> researcher = new ArrayList<>();
		try {

			Connection con = connect();

			if (con == null) {
				// return "Error while connecting to the database for updating";
			}

			String sql = "select * from researcher ";

			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {

				ResearcherDt r = new ResearcherDt();

				r.setId(rs.getInt(1));
				r.setName(rs.getString(2));
				r.setTel(rs.getInt(3));
				r.setSpecialization(rs.getString(4));
				r.setuniversity(rs.getString(5));
				r.setEmail(rs.getString(6));

				researcher.add(r);

			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return researcher;
	}

	public ResearcherDt getResearcher(int id) {
		ResearcherDt r = new ResearcherDt();

		try {
			Connection con = connect();

			if (con == null) {
				// return "Error while connecting to the database for updating";
			}
			String sql = "select * from researcher where id =" + id;

			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if (rs.next()) {

				r.setId(rs.getInt(1));
				r.setName(rs.getString(2));
				r.setTel(rs.getInt(3));
				r.setSpecialization(rs.getString(4));
				r.setuniversity(rs.getString(5));
				r.setEmail(rs.getString(6));

			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return r;
	}

	public void create(ResearcherDt r1) {
		try {
			Connection con = connect();

			if (con == null) {
				// return "Error while connecting to the database for updating";
			}
			String sql = "insert into researcher values(?,?,?,?,?,?)";

			PreparedStatement st = con.prepareStatement(sql);

			st.setInt(1, r1.getId());
			st.setString(2, r1.getName());
			st.setInt(3, r1.getTel());
			st.setString(4, r1.getSpecialization());
			st.setString(5, r1.getuniversity());
			st.setString(6, r1.getEmail());

			st.executeUpdate();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void update(ResearcherDt r1) {

		try {
			Connection con = connect();

			if (con == null) {
				// return "Error while connecting to the database for updating";
			}

			String sql = "UPDATE researcher SET name=?,telno=?,specialization=?,university=?,email=? WHERE id=?";

			PreparedStatement st = con.prepareStatement(sql);

			st.setString(1, r1.getName());
			st.setInt(2, r1.getTel());
			st.setString(3, r1.getSpecialization());
			st.setString(4, r1.getuniversity());
			st.setString(5, r1.getEmail());
			st.setInt(6, r1.getId());
			st.executeUpdate();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void delete(int id) {

		try {
			Connection con = connect();

			if (con == null) {
				// return "Error while connecting to the database for updating";
			}

			String sql = "delete from researcher where id=?";

			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id);
			st.executeUpdate();

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public String getResearcherTable() {

		String output = "";
		output = "<table border='1'><tr><th>Researcher ID</th><th>Name</th>"+
		"<th>Tel No</th>"+
		"<th>Specialization</th>"+
		"<th>University</th>"+
		"<th>Email</th></tr>";
		try {
			Connection con = connect();

			if (con == null) {
				// return "Error while connecting to the database for updating";
			}
			String sql = "select * from researcher ";

			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {

				ResearcherDt r = new ResearcherDt();

				r.setId(rs.getInt(1));
				r.setName(rs.getString(2));
				r.setTel(rs.getInt(3));
				r.setSpecialization(rs.getString(4));
				r.setuniversity(rs.getString(5));
				r.setEmail(rs.getString(6));

				// Add into the html table
				output += "<tr><td>" + rs.getInt(1) + "</td>";
				output += "<td>" + rs.getString(2) + "</td>";
				output += "<td>" + rs.getInt(3) + "</td>";
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
