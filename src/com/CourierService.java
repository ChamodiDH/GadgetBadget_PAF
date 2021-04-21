package com;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import model.Courier_dt;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

@Path("Couriers")


public class CourierService {
	
	//Read all Couriers in  XML Format
		Courier rs = new Courier();
		@Path("/Dxml")
		@GET
		@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
		public List<Courier_dt> getCouriers()
		 {
			System.out.println("Loading Researcher..");
			return rs.getCouriers();
		 } 
		//Read a Courier using ID
		@GET
		@Path("/{id}")
		@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
		public Courier_dt getCourier(@PathParam("id")int id)
		 {
			
			return rs.getCourier(id);
		 } 
		
		//Read all Courier in HTML Table
		@GET
		@Path("/")
		@Produces(MediaType.TEXT_HTML)
		public String getCourierTable()
		 {
			
			System.out.println("Loading Reasearcher Table..");
			return rs.getCourierTable();
		 }
		
		//creating a record for a Courier
		@POST
		@Path("/")
		
		@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
		
		public String createCourier(Courier_dt d1) {
			String output ="";
			System.out.println(d1);
			rs.create(d1);
			 output = "Inserted successfully";
			
			 
			return output;
		}
		@PUT
		@Path("/")
		@Consumes({MediaType.TEXT_PLAIN,MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
		public String updateCourier(Courier_dt d1) {
			String output ="";
			System.out.println(d1);
			if(rs.getCourier(d1.getId()).getId()==0) {
				
				output = "Inavlide ID";
			
			}else {
			rs.update(d1);
			 output = "Updated successfully";
			}
				return output;
		}
		
		//Delete a recode
				@DELETE
				@Path("/{id}")
				public String deleteResearcher(@PathParam("id")int id) {
					
					String output = "";
					Courier_dt a =rs.getCourier(id);
					
					if(a.getId()!=0) { 
						
						rs.delete(id);
					System.out.println("Courier delete");
					output = "Courier Account deleted";
					}else {
						output = "Inavlide ID";
					}
					return output;
				}

}
