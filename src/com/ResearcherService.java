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

import model.ProposedResearchesDt;
import model.ResearcherDt;

@Path("Researchers")


public class ResearcherService {
	//Read all Researchers in  XML Format
	Researcher rs = new Researcher();
	ProposedResearches ps = new ProposedResearches();
	@Path("/Dxml")
	@GET
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public List<ResearcherDt> getResearchers()
	 {
		System.out.println("Loading Researcher..");
		return rs.getResearchers();
	 } 
	//Read a Researcher using ID
		@GET
		@Path("/{id}")
		@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
		public ResearcherDt getResearcher(@PathParam("id")int id)
		 {
			
			return rs.getResearcher(id);
		 } 
		
		//Read all Researchers in HTML Table
		@GET
		@Path("/")
		@Produces(MediaType.TEXT_HTML)
		public String getReasercherTable()
		 {
			
			System.out.println("Loading Reasearcher Table..");
			return rs.getResearcherTable();
		 }
		
		//creating a record for a reasearcher
		@POST
		@Path("/")
		
		@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
		
		public String createResearcher(ResearcherDt d1) {
			String output ="";
			System.out.println(d1);
			rs.create(d1);
			 output = "Inserted successfully";
			
			 
			return output;
		}
		
		@PUT
		@Path("/")
		@Consumes({MediaType.TEXT_PLAIN,MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
		public String updateReasercher(ResearcherDt d1) {
			String output ="";
			System.out.println(d1);
			if(rs.getResearcher(d1.getId()).getId()==0) {
				
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
			ResearcherDt a =rs.getResearcher(id);
			
			if(a.getId()!=0) { 
				
				rs.delete(id);
			System.out.println("Researcher delete");
			output = "Researcher Account deleted";
			}else {
				output = "Inavlide ID";
			}
			return output;
		}
		
	//read xml proposed researches
		
		@Path("proposed")
		@GET
		@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
		public List<ProposedResearchesDt> getProposedResearches()
		 {
			System.out.println("Loading proposed researches..");
			return ps.getProposedResearches();
		 } 
		//Read a proposed Research using ID
				@GET
				@Path("proposed/{rid}")
				@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
				public ProposedResearchesDt getProposedResearch(@PathParam("rid")int rid)
				 {
					
					return ps.getProposedResearch(rid);
				 } 				
				
				//Read all Proposed Researches in HTML Table
				
				@GET
				@Path("proposed/all")
				@Produces(MediaType.TEXT_HTML)
				public String getProposedResearchesTable()
				 {
					
					System.out.println("Loading Proposed Reasearches Table..");
					return ps.getProposedResearchesTable();
				 }
				
				@POST
				@Path("proposed")
				
				@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
				
				public String ProposedResearches(ProposedResearchesDt d1) {
					String output ="";
					System.out.println(d1);
					ps.create(d1);
					 output = "Inserted successfully";
					
					 
					return output;
				}
				
				@PUT
				@Path("proposed")
				@Consumes({MediaType.TEXT_PLAIN,MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
				public String updateProposedResearches(ProposedResearchesDt d1) {
					String output ="";
					System.out.println(d1);
					if(ps.getProposedResearch(d1.getrId()).getrId()==0) {
						
						output = "Inavlide ID";
					
					}else {
					ps.update(d1);
					 output = "Updated successfully";
					}
						return output;
				}
				
				//Delete a recode
				@DELETE
				@Path("proposed/{id}")
				public String deleteProposedResearcher(@PathParam("rid")int rid) {
					
					String output = "";
					ProposedResearchesDt a =ps.getProposedResearch(rid);
					
					if(a.getrId()!=0) { 
						
						rs.delete(rid);
					System.out.println("Researcher delete");
					output = "Researcher Account deleted";
					}else {
						output = "Inavlide ID";
					}
					return output;
				}
				

}
