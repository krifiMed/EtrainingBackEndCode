package com.bushansirgur.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bushansirgur.model.Book;
import com.bushansirgur.model.Formation;
import com.bushansirgur.service.BookService;
import com.bushansirgur.service.FormationService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class FormationController {
	
	  @Autowired
	   private FormationService formationService;
	  
	  @GetMapping("/formations")
	   public ResponseEntity<List<Formation>> list() {
	      List<Formation> formations = formationService.list();
	      return ResponseEntity.ok().body(formations);
	   }
	  
	  /*---Get a formation by id---*/
	   @GetMapping("/formations/{id}")
	   public ResponseEntity<Formation> get(@PathVariable("id") long id) {
	      Formation formation = formationService.get(id);
	      return ResponseEntity.ok().body(formation);
	   }
	   
	   /*---Get a formation by iduser---*/
	   @GetMapping("/formations/iduser/{id}")
	   public ResponseEntity<List<Formation>> getbyIdUser(@PathVariable("id") long id) {
		   List<Formation> formations = formationService.list();
		   List<Formation> list = new ArrayList<Formation>() ;
		   for (Formation f : formations) {
			   
			   if(f.getUserId()==id) list.add(f);
			
		}
	      return ResponseEntity.ok().body(list);
	   }
	   
	   /*---Add new formation---*/
	   @PostMapping("/formations")
	   public ResponseEntity<?> save(@RequestBody Formation formation) {
	      long id = formationService.save(formation);
	      return ResponseEntity.ok().body("New Formation has been saved with ID:" + id);
	   }
	   
	   /*---Update a Formation by id---*/
	   @PutMapping("/formations/{id}")
	   public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody Formation formation) {
	      formationService.update(id, formation);
	      return ResponseEntity.ok().body("Formation has been updated successfully.");
	   }
	   
	   /*---Soft Delete a book by id---*/
	   @DeleteMapping("/formations/{id}")
	   public ResponseEntity<?> delete(@PathVariable("id") long id) {
		   Formation f = formationService.get(id); 
		   
	      formationService.delete(id);
	      return ResponseEntity.ok().body("Formation has been softdeleted successfully.");
	   }

}
