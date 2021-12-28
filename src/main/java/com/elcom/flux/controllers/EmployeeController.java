package com.elcom.flux.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.elcom.flux.entities.Employee;
import com.elcom.flux.exceptions.RessourceNotFoundException;
import com.elcom.flux.repositories.EmployeeRepository;
@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
	@Autowired
	private EmployeeRepository employeeRepository;
	//get all employees
	@GetMapping("employees")
	public List<Employee> getAllEmployees(){
		return employeeRepository.findAll();
	}
	// create employee rest api
	@PostMapping("/employees")
	public Employee createEmployee(@RequestBody Employee employee) {
		return employeeRepository.save(employee);
	}
	//get employee by id
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable(name="id") Integer id) {
	
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new RessourceNotFoundException("matricule inexistane"+id));
	    return ResponseEntity.ok(employee);
	}
	//update employee
	@PutMapping("/employees/{id}")
	
	public ResponseEntity<Employee> updateEmployee(@PathVariable Integer id,@RequestBody Employee employeeDetails){
		return null;

//		Employee employee = employeeRepository.findById(id)
//				.orElseThrow(() -> new RessourceNotFoundException("matricule inexistane"+id));
//		
//		employee.setNom(employeeDetails.getNom());
//		employee.setPrenom(employeeDetails.getPrenom());
//		employee.setEmail(employeeDetails.getEmail());
//		employee.setTel(employeeDetails.getTel());
//		Employee updatedEmployee = employeeRepository.save(employee);
//		return ResponseEntity.ok(updatedEmployee);
	}
	
	//delete employee
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Map<String, Boolean>>deleteEmployee(@PathVariable Integer id){
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new RessourceNotFoundException("matricule inexistane"+id));
		employeeRepository.delete(employee);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
		
	}
	

} 	
