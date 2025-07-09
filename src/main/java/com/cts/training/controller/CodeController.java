package com.cts.training.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CodeController {

	
	@GetMapping("/code")
	public String code(@RequestParam String code)
	
	{
		
		return code;
	}
}
