package com.gc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/*
 * author: Antonella Solomon
 *
 */

@Controller
public class HomeController {
	
	@RequestMapping("/register")
	public ModelAndView helloWorld() {
				
		return new ModelAndView("register");
	}
	
	
	@RequestMapping(value = "/addUser", method=RequestMethod.POST)
	public String submitForm(Model model, @RequestParam("fname") String fname, @RequestParam("lname") String lname,
		@RequestParam("email") String email, @RequestParam("pnum") String pnum, @RequestParam("pword") String pword) {
		
		model.addAttribute("name", "Welcome " + fname);
		
		return "addUser";
	}
	
	/*
	@RequestMapping("/welcome")
	public ModelAndView helloWorld() {

		String message = "<br><div style='text-align:center;'>"
				+ "<h3>This message is coming from HomeController.java</h3>";
		return new ModelAndView("welcome", "message", message);
	}
	
	@RequestMapping(value = "/submitform", method = RequestMethod.POST)
	public String submitForm(Model model, @RequestParam("customerID") String custID,
			@RequestParam("companyName") String comp, @RequestParam("contactName") String contact) {

		model.addAttribute("addDataToPage", custID + " " + comp + " " + contact);
		return "newPage";
	}
	*/
}