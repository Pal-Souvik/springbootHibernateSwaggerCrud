package com.souvik.SpringHibernateCrudSwagger.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.souvik.SpringHibernateCrudSwagger.Exception.BuisnessExeption;
import com.souvik.SpringHibernateCrudSwagger.Exception.ControllerException;
import com.souvik.SpringHibernateCrudSwagger.Model.Student;
import com.souvik.SpringHibernateCrudSwagger.Service.StudentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/students")
	public ResponseEntity<?> findallStud(){
		List<Student> student =  studentService.findallStud();
		return new ResponseEntity<List<Student>>(student,HttpStatus.FOUND);
		
	}
	@GetMapping("/student/{id}")
	public ResponseEntity<?> findbyID(@PathVariable(name = "id") Long id){
		Optional<Student>  student =  studentService.findbyID(id);
		return new ResponseEntity<Optional<Student>>(student,HttpStatus.FOUND);
		
	}
	@PostMapping("/student") //use of global Exception
	public ResponseEntity<?> saveStud(@Valid @RequestBody Student student){
	    student =  studentService.saveStud(student);
		return new ResponseEntity<Student>(student,HttpStatus.CREATED);
		
	}
	@PutMapping("/student") //custom exception
	public ResponseEntity<?> updateStud(@Valid @RequestBody Student student){
		try {
			student =  studentService.updateStud(student);
		}
		catch(BuisnessExeption se) {
		  ControllerException ce = new ControllerException(se.getErrorCode(), se.getErrorMessage()); 
		  return new ResponseEntity<ControllerException>(ce,HttpStatus.BAD_REQUEST); 
		  }
		catch(Exception ex) {
			ControllerException ce = new ControllerException(ex.getMessage(), "Some Checked Exception"); 
			  return new ResponseEntity<ControllerException>(ce,HttpStatus.BAD_REQUEST);
			
		}
		 
		return new ResponseEntity<Student>(student,HttpStatus.FOUND);
		
	}
	@DeleteMapping("/student")
	public ResponseEntity<?> DeleteeStud(@RequestBody Student student){
	    studentService.deleteStud(student);
		return new ResponseEntity<Void>(HttpStatus.GONE);
		
	}

}
