package com.spring.validation.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.validation.constraints.CommonString;
import com.spring.validation.constraints.REGEX;

@RestController
@RequestMapping("/api")
@Validated //Enable custom constraint validation on method.
public class TestController {

	@GetMapping("/test/{var}")
	ResponseEntity<?> test(@PathVariable("var") @CommonString(length = 10, regex = REGEX.ALPHABET) String var) {
		return ResponseEntity.ok().body(new ResponseModel(var));
	}
	
	class ResponseModel {
		String body;
		
		ResponseModel(String body) { this.body = body; }
		
		public String getBody() { return body; }
	}
}
