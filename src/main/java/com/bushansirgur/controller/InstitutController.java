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

import com.bushansirgur.model.Formation;
import com.bushansirgur.model.Institut;
import com.bushansirgur.service.FormationService;
import com.bushansirgur.service.ServiceInstitut;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class InstitutController {
	
	@Autowired
	   private ServiceInstitut institutService;
	
	 @GetMapping("/instituts")
	   public ResponseEntity<List<Institut>> list() {
	      List<Institut> instituts = institutService.list();
	      return ResponseEntity.ok().body(instituts);
	   }
	 
	 /*---Get a Institut by iduser---*/
	   @GetMapping("/instituts/iduser/{id}")
	   public ResponseEntity<?> getbyidUser(@PathVariable("id") long id) {
		   List<Institut> instituts = institutService.list();
		   List<Institut> list = new ArrayList<Institut>() ;
	      
	      for (Institut i : instituts) {
			if(i.getUserId()==id)  list.add(i);
		}
	      return ResponseEntity.ok().body(list);
	   }
	 
	 /*---Get a Institut by id---*/
	   @GetMapping("/instituts/{id}")
	   public ResponseEntity<Institut> get(@PathVariable("id") long id) {
	      Institut institut = institutService.get(id);
	      return ResponseEntity.ok().body(institut);
	   }
	   
	   /*---Add new ins---*/
	   @PostMapping("/instituts")
	   public ResponseEntity<?> save(@RequestBody Institut formation) {
	      long id = institutService.save(formation);
	      return ResponseEntity.ok().body("New institut has been saved with ID:" + id);
	   }
	   
	   /*---Update a ins by id---*/
	   @PutMapping("/instituts/{id}")
	   public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody Institut formation) {
	      institutService.update(id, formation);
	      return ResponseEntity.ok().body("Institut has been updated successfully.");
	   }
	   
	   /*---Soft Delete a book by id---*/
	   @DeleteMapping("/instituts/{id}")
	   public ResponseEntity<?> delete(@PathVariable("id") long id) {
	      institutService.delete(id);
	      return ResponseEntity.ok().body("Institut has been softdeleted successfully.");
	   }
	  

}
