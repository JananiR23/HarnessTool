package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.ParameterMasterVO;
import com.example.demo.service.HarnessService;

@RestController
public class HarnessController {

	@Autowired
	private HarnessService harnessService;
	
	
	
	@GetMapping("/listofParameter")
	public List<ParameterMasterVO> findParamer(){
		List<ParameterMasterVO> parameterList = (List<ParameterMasterVO>)harnessService.findAll();
		
		if (parameterList.isEmpty()) {
            return (List<ParameterMasterVO>) new ResponseEntity(HttpStatus.NO_CONTENT);
            // You many decide to return HttpStatus.NOT_FOUND
        }
        return (List<ParameterMasterVO>) new ResponseEntity<List<ParameterMasterVO>>(parameterList, HttpStatus.OK);
        
		
		
	}
	
	
	
}
