package com.gc.controller;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gc.dto.ProductDto;

/*
 * @author: Michael Chan
 *
 */

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public ModelAndView helloWorld() {
		Configuration config = new Configuration().configure("hibernate.cfg.xml");
		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Criteria crit = session.createCriteria(ProductDto.class);
		ArrayList<ProductDto> list = (ArrayList<ProductDto>) crit.list();
		for (int i=0; i < list.size() ; i++) {
			System.out.println(i + " " + list.get(i));
		}
		tx.commit();
		session.close();
		return new ModelAndView("ItemAdmin", "cList", list);
	}
	
	@RequestMapping("/AddItem")
	public String addItem(Model model, @RequestParam("productID") int productID, @RequestParam("description") String description,
			@RequestParam("quantity") String quantity, @RequestParam("price") Double price) {
			
		Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
		SessionFactory sessionFact = cfg.buildSessionFactory();
		Session session = sessionFact.openSession();
		Transaction tx = session.beginTransaction();
		ProductDto newProduct = new ProductDto();
		newProduct.setProductID(productID);
		newProduct.setType(description);
		newProduct.setFlavor(quantity);
		newProduct.setListprice(price);
		session.save(newProduct);
		tx.commit();
		session.close();

		model.addAttribute("newStuff", newProduct);
		return "addprodsuccess";
	}
	
	@RequestMapping("/EditItem")
	public ModelAndView editItem() {
		Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
		SessionFactory sessionFact = cfg.buildSessionFactory();
		Session session = sessionFact.openSession();
		Transaction tx = session.beginTransaction();
		ProductDto newProduct = new ProductDto();
		newProduct.setProductID(productID);
		newProduct.setType(description);
		newProduct.setFlavor(quantity);
		newProduct.setListprice(price);
		session.save(newProduct);
		tx.commit();
		session.close();
		
		
	}
	
	@RequestMapping("/register")
	public ModelAndView register() {
		return new ModelAndView("register");
	}
	
	@RequestMapping(value = "/addUser", method=RequestMethod.POST)
	public String submitForm(Model model, @RequestParam("fname") String fname, @RequestParam("lname") String lname,
		@RequestParam("email") String email, @RequestParam("pnum") String pnum, @RequestParam("pword") String pword) {
		
		model.addAttribute("name", "Welcome " + fname);
		
		return "addUser";
	}
	
	@RequestMapping(value = "/checkout", method=RequestMethod.POST)
	public ModelAndView purchasing(Model model, @RequestParam("item") String item) {
				
		model.addAttribute("bought", "You just bought: " + item);
			
		return new ModelAndView("checkout");
	}
	
}