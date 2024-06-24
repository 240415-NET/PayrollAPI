package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dtos.PayrollAdjustment;
import com.example.demo.dtos.PayrollPeriod;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping("/payroll")
public class PayrollController {

@GetMapping
public String getPayrollStatus() {
	return "Status: ALL GOOD";
}
	
@PostMapping
@Operation(
		summary = "Submit an adjustment to payroll operations for a single employee over a period of time",
		requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(content = @Content(schema = @Schema(implementation = PayrollAdjustment.class))),
		responses = {
				@ApiResponse(description = "Successful payroll adjustment", responseCode = "200"),
				@ApiResponse(description = "Improper date format", responseCode = "400"),
				@ApiResponse(description = "Unrecognized pay type", responseCode = "400")
		}
		)
public ResponseEntity<String> postPayroll(@RequestBody PayrollAdjustment body ) {
	
	Pattern p = Pattern.compile("\\d\\d-\\d\\d-\\d\\d\\d\\d");
	Matcher approvalDateMatcher = p.matcher(body.getApprovalDate());
	if (approvalDateMatcher.matches()) {
		
		List<String> types = new ArrayList<String>();
		types.add("Paid Time Off");
		types.add("Unpaid Time Off");
		types.add("Holiday");
		types.add("Floating Holiday");
		types.add("Relocation"); 
		types.add("Medical");
		
		for(PayrollPeriod pp : body.getPayrollPeriods()) {
			Matcher payrollPeriodMatcher = p.matcher(pp.getDate());
			if (!payrollPeriodMatcher.matches()) {
				System.out.println("Effected Date: " + pp.getDate());
				ResponseEntity<String> response = new ResponseEntity<String>("Improper date format", HttpStatusCode.valueOf(400));
				
				return response;
			}
			
			if (!types.contains(pp.getType())) {
				
				ResponseEntity<String> response = new ResponseEntity<String>("Unrecognized pay type", HttpStatusCode.valueOf(400));
				
				return response;
				
			}
			
		}
		
	}	else {
		
		System.out.println("Approval Date: " + body.getApprovalDate());
		
		ResponseEntity<String> response = new ResponseEntity<String>("Improper date format", HttpStatusCode.valueOf(400));
		
		return response;
		
	}
	
	
	
	
	
	ResponseEntity<String> response = new ResponseEntity<String>("Successful Update", HttpStatusCode.valueOf(200));
	
	if (Math.random()<.3) {
		response = new ResponseEntity<String>("Server Error", HttpStatusCode.valueOf(500));
	}
	
	return response;
	
}

}
