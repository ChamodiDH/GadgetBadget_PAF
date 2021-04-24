package com;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import model.Courier_dt;

public class Courier {

	public Connection connect() {
		Connection con = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/gadgetbadgetdb", "root", "hashini123");
			// For testing
			System.out.print("Successfully connected");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return con;
	}
	
	
	public List<Courier_dt> getCouriers() {
		List<Courier_dt> couriers = new ArrayList<>();
		try {

			Connection con = connect();

			if (con == null) {
				// return "Error while connecting to the database for updating";
			}

			String sql = "select * from courier";

			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {

				Courier_dt r = new Courier_dt();

				r.setId(rs.getInt(1));
				r.setName(rs.getString(2));
				r.setTelno(rs.getInt(3));
				r.setCompany(rs.getString(4));
				r.setVehical(rs.getString(5));
				r.setEmail(rs.getString(6));

				couriers.add(r);

			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return couriers;
	}
	
	public Courier_dt getCouriers(int id) {
		Courier_dt r = new Courier_dt();

		try {
			Connection con = connect();

			if (con == null) {
				// return "Error while connecting to the database for updating";
			}
			String sql = "select * from courier where id =" + id;

			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if (rs.next()) {

				r.setId(rs.getInt(1));
				r.setName(rs.getString(2));
				r.setTelno(rs.getInt(3));
				r.setCompany(rs.getString(4));
				r.setVehical(rs.getString(5));
				r.setEmail(rs.getString(6));

			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return r;
	}
	
	public Courier_dt getCourier(int id) {
		Courier_dt r = new Courier_dt();

		try {
			Connection con = connect();

			if (con == null) {
				// return "Error while connecting to the database for updating";
			}
			String sql = "select * from courier where id =" + id;

			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if (rs.next()) {

				r.setId(rs.getInt(1));
				r.setName(rs.getString(2));
				r.setTelno(rs.getInt(3));
				r.setCompany(rs.getString(4));
				r.setVehical(rs.getString(5));
				r.setEmail(rs.getString(6));

			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return r;
	}
	
	public void create(Courier_dt r1) {
		try {
			Connection con = connect();

			if (con == null) {
				// return "Error while connecting to the database for updating";
			}
			String sql = "insert into courier values(?,?,?,?,?,?)";

			PreparedStatement st = con.prepareStatement(sql);

			st.setInt(1, r1.getId());
			st.setString(2, r1.getName());
			st.setInt(3, r1.getTelno());
			st.setString(4, r1.getCompany());
			st.setString(5, r1.getVehical());
			st.setString(6, r1.getEmail());

			st.executeUpdate();

		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void update(Courier_dt r1) {

		try {
			Connection con = connect();

			if (con == null) {
				// return "Error while connecting to the database for updating";
			}

			String sql = "UPDATE courier SET name=?,telno=?,company=?,vehical=?,email=? WHERE id=?";

			PreparedStatement st = con.prepareStatement(sql);

			st.setString(1, r1.getName());
			st.setInt(2, r1.getTelno());
			st.setString(3, r1.getCompany());
			st.setString(4, r1.getVehical());
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

			String sql = "delete from courier where id=?";

			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id);
			st.executeUpdate();

		} catch (Exception e) {
			System.out.println(e);
		}

	}
	
	public String getCourierTable() {

		String output = "";
		output = "<table border='1'><tr><th>Courier ID</th><th>Name</th>"+
		"<th>Tel No</th>"+
		"<th>Company</th>"+
		"<th>Vehical</th>"+
		"<th>Email</th></tr>";
		try {
			Connection con = connect();

			if (con == null) {
				// return "Error while connecting to the database for updating";
			}
			String sql = "select * from courier";

			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {

				Courier_dt r = new Courier_dt();

				r.setId(rs.getInt(1));
				r.setName(rs.getString(2));
				r.setTelno(rs.getInt(3));
				r.setCompany(rs.getString(4));
				r.setVehical(rs.getString(5));
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
