package com.bushansirgur.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bushansirgur.model.Formation;
import com.bushansirgur.model.Inscrit_institut;
import com.bushansirgur.model.Institut;
import com.bushansirgur.model.Participation_Formation;
import com.bushansirgur.model.User;
import com.bushansirgur.service.FormationService;
import com.bushansirgur.service.Inscrit_InstitutService;
import com.bushansirgur.service.ServiceInstitut;
import com.bushansirgur.service.UserService;

@Controller
@RequestMapping("/api")
public class Inscrit_InstitutController {
	
	@Autowired
	   private UserService userService;
	
	@Autowired
	   private ServiceInstitut institutService;
	
	@Autowired
	private Inscrit_InstitutService inscri_service;
	
	/*---Add new Inscription institut---*/
	@GetMapping("/inscrit_institut/{idu}/{idi}")
   public ResponseEntity<?> save(@PathVariable("idu") long iduser, @PathVariable("idi") long idInstitut) {	   
	   User u = new User(); 
	   Institut institut = new Institut();    
	   u = userService.get(iduser); 
	   institut = institutService.get(idInstitut);
	   
	   Inscrit_institut i = new Inscrit_institut(); 
	   i.setUser_i(u);
	   i.setInstitut_p(institut);
	   i.setValide(false);
      long id = inscri_service.save(i);
      return ResponseEntity.ok().body("New Inscription has been saved with ID:" + id);
   }
	
	
	/*---get my participations---*/
	@GetMapping("/inscrit_institut/{idu}")
   public ResponseEntity<?> particiationByIdUser(@PathVariable("idu") long iduser) {	   
	   User u = new User(); 
	   List<Inscrit_institut> list= new ArrayList<Inscrit_institut>() ;
	   list = inscri_service.list();
	   List<Inscrit_institut> participations = new ArrayList<Inscrit_institut>() ;
	   u = userService.get(iduser); 
	   
	   if(list.size()>0) {
		   for (Inscrit_institut p : list ) {
			   if(p.getUser_i().getId()==iduser) participations.add(p);
				   		
		}   
	   }
      return ResponseEntity.ok().body(participations);
   }
	
	/*---get inscription in the institute---*/
	@GetMapping("/participantsinstitut/{idi}")
   public ResponseEntity<?> particiationByIdInstitut(@PathVariable("idi") long idInstitut) {	   
	   User u = new User(); 
	   List<Inscrit_institut> list= new ArrayList<Inscrit_institut>() ;
	   list = inscri_service.list();
	   List<Inscrit_institut> participations = new ArrayList<Inscrit_institut>() ;
	   
	   if(list.size()>0) {
		   for (Inscrit_institut p : list ) {
			   if(p.getInstitut_p().getId()==idInstitut) participations.add(p);
				   		
		}   
	   }
      return ResponseEntity.ok().body(participations);
   }
	// validate inscription 
	@GetMapping("/valide_inscrit_institut/{id}")
	   public ResponseEntity<?> valider(@PathVariable("id") long idInscrit) {
		
		Inscrit_institut p = new Inscrit_institut(); 
		p = inscri_service.get(idInscrit);	
		inscri_service.update(idInscrit, p);  
	      return ResponseEntity.ok().body("validated successfully");
	   }
	
	//delete inscription 
	@DeleteMapping("/inscrit/{idi}")
	   public ResponseEntity<?> deleteInscription(@PathVariable("idi") long idparticipation) {
		inscri_service.delete(idparticipation);  
	      return ResponseEntity.ok().body("deleted successfully");
	   }

}
