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

import model.FundingBodyM;

@Path("FundingBodies")
public class FundingBodyService {

	//Read all Researchers in  XML Format
		FundingBody rs = new FundingBody();
		@Path("/Dxml")
		@GET
		@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
		public List<FundingBodyM> getResearchers()
		 {
			System.out.println("Loading FundingBody..");
			return rs.getFundingBodies();
		 } 
		//Read a FundingBody using ID
			@GET
			@Path("/{id}")
			@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
			public FundingBodyM getFundingBody(@PathParam("id")int id)
			 {
				
				return rs.getFundingBody(id);
			 } 
			
			//Read all Researchers in HTML Table
			@GET
			@Path("/")
			@Produces(MediaType.TEXT_HTML)
			public String getReasercherTable()
			 {
				
				System.out.println("Loading Reasearcher Table..");
				return rs.getFundingBodyTable();
			 }
			
			//creating a record for a funding body
			@POST
			@Path("/")
			
			@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
			
			public String createFundingBody(FundingBodyM d1) {
				String output ="";
				System.out.println(d1);
				rs.create(d1);
				 output = "Inserted successfully";
				
				 
				return output;
}
			
			@PUT
			@Path("/")
			@Consumes({MediaType.TEXT_PLAIN,MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
			public String updateReasercher(FundingBodyM d1) {
				String output ="";
				System.out.println(d1);
				if(rs.getFundingBody(d1.getId()).getId()==0) {
					
					output = "Inavlid ID";
				
				}else {
				rs.update(d1);
				 output = "Updated successfully";
				}
					return output;
			}
			
			//Delete a recode
			@DELETE
			@Path("/{id}")
			public String deleteFundingBody(@PathParam("id")int id) {
				
				String output = "";
				FundingBodyM a =rs.getFundingBody(id);
				
				if(a.getId()!=0) { 
					
					rs.delete(id);
				System.out.println("FundingBody delete");
				output = "FundingBody Account deleted";
				}else {
					output = "Inavlid ID";
				}
				return output;
			}
			
}
