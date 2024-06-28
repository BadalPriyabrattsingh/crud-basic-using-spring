package com.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller("/web")
public class WebController {

	@GetMapping("/greeting")
	public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		model.addAttribute("name", name);
		return "greetings";
	}
	@GetMapping("/index")
	public String index() {
		
		return "index";
	}
	@GetMapping("/login")
	public String login(@RequestParam  Model model) {
		
		return "index";
	}
	
}
