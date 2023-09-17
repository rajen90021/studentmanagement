package com.student.rest.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.student.rest.response.basicresponsemsg;
import com.student.rest.response.studentrequestvo;
import com.student.rest.service.studentservice;

@RestController
public class mycontroller {

	@Autowired
	private studentservice studentservice;

	@PostMapping("/savestudent")
	public ResponseEntity<basicresponsemsg> savestudent(@RequestBody studentrequestvo studentrequestvo) {

		basicresponsemsg response = new basicresponsemsg();
		try {

			response = studentservice.savestudent(studentrequestvo);

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<basicresponsemsg> res = new ResponseEntity<>(response, HttpStatus.OK);

//		return new  ResponseEntity<>(response,HttpStatus.OK);
		return res;
	}
	//////// get student by iD????????????????

	@GetMapping("/getstudent")
	public ResponseEntity<basicresponsemsg> getstudentbyid(@RequestBody studentrequestvo studentrequestvo) {

		basicresponsemsg response = new basicresponsemsg();
		try {

			response = studentservice.getstudentbyid(studentrequestvo);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		ResponseEntity<basicresponsemsg> res = new ResponseEntity<>(response, HttpStatus.OK);

		return res;
	}

	/// get all student

	@GetMapping("/getallstudent")
	public ResponseEntity<basicresponsemsg> getallstudent(@RequestBody studentrequestvo studentrequestvo) {
		basicresponsemsg response = new basicresponsemsg();

		try {

			response = studentservice.getallstudent(studentrequestvo);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		ResponseEntity<basicresponsemsg> res = new ResponseEntity<>(response, HttpStatus.OK);

		return res;
	}

	@PutMapping("/updatestudentbyid")
	public ResponseEntity<basicresponsemsg> updatestudent(@RequestBody studentrequestvo studentrequestvo) {

		basicresponsemsg response = new basicresponsemsg();
		
		try {
			
			  response=  studentservice.updatestudentbyid(studentrequestvo);
			
		} catch (Exception e) {
			// TODO: handle exception
			
			e.printStackTrace();
		}
		
		    
		return new ResponseEntity<>(response,HttpStatus.OK);

	}
	
	@DeleteMapping("/deletebyid")
	public ResponseEntity<basicresponsemsg> deletebyid(@RequestBody studentrequestvo studentrequestvo){
basicresponsemsg response = new basicresponsemsg();
		
		try {
			
			  response=  studentservice.deletebyid(studentrequestvo);
			
		} catch (Exception e) {
			// TODO: handle exception
			
			e.printStackTrace();
		}
		
		    
		return new ResponseEntity<>(response,HttpStatus.OK);
		
		
		
	}
	
	
	
	
}
