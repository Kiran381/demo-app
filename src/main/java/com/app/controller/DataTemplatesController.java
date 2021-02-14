package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.domain.DataTemplates;
import com.app.repository.DataTemplatesRepository;

@RestController
@RequestMapping("/app")
public class DataTemplatesController {
	
	@Autowired
	DataTemplatesRepository dataTemplatesRepository;

	@GetMapping("/getDataTempaltes")
	public DataTemplates getDataTempaltes() {
		try {
			System.out.println("Get APi Called");
			System.out.println("Size of Data Templates: ");//+ dataTemplatesRepository.findAll().size());
		}
		catch(Exception exp) {
			exp.printStackTrace();
		}
		return null;
	}
	
}
