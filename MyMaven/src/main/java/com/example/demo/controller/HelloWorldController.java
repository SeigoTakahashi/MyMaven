package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloWorldController {

	@RequestMapping(path = "/helloworld", method = RequestMethod.GET)
	public String hello(Model model) {

		model.addAttribute("message", "Hello!!");
		return "helloworld";
	}
}