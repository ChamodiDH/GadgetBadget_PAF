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

import model.BuyerTNM;


@Path("Buyers")


public class BuyerService {
	//Read all Buyers in  XML Format
	Buyer rs = new Buyer();
	
	@Path("/Dxml")
	@GET
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public List<BuyerTNM> getBuyers()
	 {
		System.out.println("Loading Buyer..");
		return rs.getBuyers();
	 } 
	//Read a Buyer using ID
	@GET
	@Path("/{id}")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public BuyerTNM getBuyer(@PathParam("id")int id)
	 {
		
		return rs.getBuyer(id);
	 } 
	
	//Read all Buyers in HTML Table
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String getBuyerTable()
	 {
		
		System.out.println("Loading Buyer Table..");
		return rs.getBuyerTable();
	 }
	
	//creating a record for a buyer
	
	@POST
	@Path("/")
	
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	
	public String createBuyer(BuyerTNM d1) {
		String output ="";
		System.out.println(d1);
		rs.create(d1);
		 output = "Inserted successfully";
		
		 
		return output;
	}
	@PUT
	@Path("/")
	@Consumes({MediaType.TEXT_PLAIN,MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public String updateBuyer(BuyerTNM d1) {
		String output ="";
		System.out.println(d1);
		if(rs.getBuyer(d1.getId()).getId()==0) {
			
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
			public String deleteBuyer(@PathParam("id")int id) {
				
				String output = "";
				BuyerTNM a =rs.getBuyer(id);
				
				if(a.getId()!=0) { 
					
					rs.delete(id);
				System.out.println("Buyer delete");
				output = "Buyer Account deleted";
				}else {
					output = "Inavlide ID";
				}
				return output;
			}
}
