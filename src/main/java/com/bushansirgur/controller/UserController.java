package com.bushansirgur.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bushansirgur.model.Book;
import com.bushansirgur.model.Institut;
import com.bushansirgur.model.User;
import com.bushansirgur.model.role;
import com.bushansirgur.service.UserService;

@Controller
@CrossOrigin
@RestController
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	   private UserService userService;
	
	 /*---get all books---*/
	   @GetMapping("/students")
	   public ResponseEntity<List<User>> listStudents() {
	      List<User> users = userService.list();
	      
	      List<User> students = new ArrayList<User>() ;
	      
	      for (User u : users) {
	    	  
	    	  if(u.getRole()==role.STUDENT) students.add(u);		
		}
	         
	      return ResponseEntity.ok().body(students);
	   }
	   
	   /*---get all books---*/
	   @GetMapping("/managers")
	   public ResponseEntity<List<User>> listManagers() {
	      List<User> users = userService.list();
	      
	      List<User> students = new ArrayList<User>() ;
	      
	      for (User u : users) {
	    	  
	    	  if(u.getRole()==role.MANAGER) students.add(u);		
		}
	         
	      return ResponseEntity.ok().body(students);
	   }
	   
	   /*---get all books---*/
	   @GetMapping("/teachers")
	   public ResponseEntity<List<User>> listTeachers() {
	      List<User> users = userService.list();
	      
	      List<User> students = new ArrayList<User>() ;
	      
	      for (User u : users) {
	    	  
	    	  if(u.getRole()==role.TEACHER) students.add(u);		
		}
	         
	      return ResponseEntity.ok().body(students);
	   }
	   

	   /*---Get a book by id---*/
	   
	   @GetMapping("/{id}")
	   public ResponseEntity<User> get(@PathVariable("id") long id) {
	      User book = userService.get(id);
	      return ResponseEntity.ok().body(book);
	   }
	   

	   /*---Update a book by id---*/
	   @PutMapping("/update/{id}")
	   public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody User user) {
	      userService.update(id, user);
	      return ResponseEntity.ok().body("User has been updated successfully.");
	   }
	   
	   /*---Get a book by id---*/
	   @GetMapping("/activate/{id}")
	   public ResponseEntity<User> activate(@PathVariable("id") long id) {
	      User user = userService.get(id);
	      user.setIsactive(true);
	      userService.update(id, user);
	      return ResponseEntity.ok().body(user);
	   }
	   
	   
	   /*---Add new User---*/
	   @PostMapping("/")
	   public ResponseEntity<?> save(@RequestBody User u) {
	      long id = userService.save(u);
	      return ResponseEntity.ok().body("New User has been saved with ID:" + id);
	   }
	   
	   
	   /*---login---*/
	   @GetMapping("/login")
	   public ResponseEntity<?> login(@RequestParam(name = "email") String email , @RequestParam(name = "password") String password ) {
	      List<User> list = userService.list();
	      User u = new User();
	      for (User user : list) {
			if(user.getEmail().equals(email)&& user.getPassword().equals(password)&&user.getIsactive()==true) u = user;
				
			
		}
	      if(u==null) return ResponseEntity.ok().body("not found");
	      return ResponseEntity.ok().body(u);
	   }
	   
	   
	   @DeleteMapping("/{id}")
	   public ResponseEntity<?> deleteInscription(@PathVariable("id") long id) {
		userService.delete(id);  
	      return ResponseEntity.ok().body("deleted successfully");
	   }
	   
	   

}
