package com.bushansirgur.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bushansirgur.model.Formation;
import com.bushansirgur.model.Institut;
import com.bushansirgur.model.Participation_Formation;
import com.bushansirgur.model.User;
import com.bushansirgur.service.FormationService;
import com.bushansirgur.service.Participation_FormationService;
import com.bushansirgur.service.ServiceInstitut;
import com.bushansirgur.service.UserService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class ParticipationFormationController {
	
	@Autowired
	   private Participation_FormationService participationService;
	
	@Autowired
	   private UserService userService;
	
	@Autowired
	   private FormationService formationService;
	
	  /*---Add new participation---*/
		@GetMapping("/participe/{idu}/{idf}")
	   public ResponseEntity<?> save(@PathVariable("idu") long iduser, @PathVariable("idf") long idformation) {	   
		   User u = new User(); 
		   Formation f = new Formation();    
		   u = userService.get(iduser); 
		   f = formationService.get(idformation);
		   
		   Participation_Formation p = new Participation_Formation(); 
		   p.setUser_p(u);
		   p.setFormation_p(f);
		   p.setDate(new Date());
		   p.setValide(false);
	      long id = participationService.save(p);
	      return ResponseEntity.ok().body("New Participataion has been saved with ID:" + id);
	   }
		
		/*---get my participations---*/
		@GetMapping("/participe/{idu}")
	   public ResponseEntity<?> particiationByIdUser(@PathVariable("idu") long iduser) {	   
		   User u = new User(); 
		   List<Participation_Formation> list= new ArrayList<Participation_Formation>() ;
		   list = participationService.list();
		   List<Participation_Formation> participations = new ArrayList<Participation_Formation>() ;
		   u = userService.get(iduser); 
		   
		   if(list.size()>0) {
			   for (Participation_Formation p : list ) {
				   if(p.getUser_p().getId()==iduser) participations.add(p);
					   		
			}   
		   }
	      return ResponseEntity.ok().body(participations);
	   }
		
		/*---get my participations---*/
		@GetMapping("/participantsformation/{idf}")
	   public ResponseEntity<?> particiationByIdFormation(@PathVariable("idf") long idformation) {	   
		   User u = new User(); 
		   List<Participation_Formation> list= new ArrayList<Participation_Formation>() ;
		   list = participationService.list();
		   List<Participation_Formation> participations = new ArrayList<Participation_Formation>() ;
		   
		   if(list.size()>0) {
			   for (Participation_Formation p : list ) {
				   if(p.getFormation_p().getId()==idformation) participations.add(p);
					   		
			}   
		   }
	      return ResponseEntity.ok().body(participations);
	   }
		
		
		
		@GetMapping("/valide/{idp}")
		   public ResponseEntity<?> valider(@PathVariable("idp") long idparticipation) {
			
			Participation_Formation p = new Participation_Formation(); 
			p = participationService.get(idparticipation);	
			participationService.update(idparticipation, p);  
		      return ResponseEntity.ok().body("validated successfully");
		   }
		
		
		
		@GetMapping("/presence/{idp}")
		   public ResponseEntity<?> validerprensence(@PathVariable("idp") long idparticipation) {
			
			Participation_Formation p = new Participation_Formation(); 
			p = participationService.get(idparticipation);
			//p.setPresence(true);
			participationService.updatePresnece(idparticipation, p);  
		      return ResponseEntity.ok().body(p);
		   }
		
		@GetMapping("/note/{idp}/{note}")
		   public ResponseEntity<?> validernote(@PathVariable("idp") long idparticipation,@PathVariable("note") int note) {
			
			Participation_Formation p = new Participation_Formation(); 
			p = participationService.get(idparticipation);
			p.setNote(note);
			participationService.updateNote(idparticipation, p);  
		      return ResponseEntity.ok().body("Notted successfully");
		   }
		
		@DeleteMapping("/participe/{idp}")
		   public ResponseEntity<?> deleteParticipation(@PathVariable("idp") long idparticipation) {
			participationService.delete(idparticipation);  
		      return ResponseEntity.ok().body("deleted successfully");
		   }

}
