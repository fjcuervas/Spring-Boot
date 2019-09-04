package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.repo.IPersonRepo;

@Controller
public class PersonController {

	@Autowired
	private IPersonRepo iPersonRepo;
	
	@GetMapping("/greeting")
	public String greeting(@RequestParam(name="msg") String message, Model model) {
		model.addAttribute("msg",message);
		return "greeting";
	}
	
	@GetMapping("/people")
	public String people(Model model) {
		//model.addAttribute("msg",message);
		model.addAttribute("people",iPersonRepo.findAll());
		return "people";
	}
}
