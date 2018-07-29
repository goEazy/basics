package com.goeazy.learn.controllers;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.goeazy.learn.context.Application;
import com.goeazy.learn.dao.CustomersDaoImpl;
import com.goeazy.learn.entity.Customer;

@Controller
public class GeneralController {
	
	Logger log = Logger.getLogger(GeneralController.class);

	@RequestMapping("/result")
	public ModelAndView add(HttpServletRequest request, HttpServletResponse response){
		double i = Double.parseDouble("0"+request.getParameter("t1"));
		double j = Double.parseDouble("0"+request.getParameter("t2"));
		double k = i+j;
		/*ModelAndView model = new ModelAndView();
		model.setViewName("add.jsp");
		model.addObject("result", k+"");*/
		try{
			CustomersDaoImpl customersDao = Application.getInstance().getCustomersDao();
			
			Customer cus1 = new Customer();
			cus1.setCustId(220);
			cus1.setFirstName("TestName");
			cus1.setLastName("LastName");
			cus1.setCity("Yokohama");
			cus1.setSalesmanId(22);
			customersDao.save(cus1);
		}catch(Exception e){
			log.error("Error in Saving" + e);
		}
		ModelAndView model = new ModelAndView();
		model.setViewName("addResult.jsp");
		log.info("Calling Add Result Page");
		return model;
	}
	
	@RequestMapping(value="/welcome", method=RequestMethod.GET)
	public String doWelcome(ModelMap model, Principal princpal){
		String name = princpal.getName();
		model.addAttribute("username", name);
		model.addAttribute("message","Good Morning");
		System.out.println("I am logged in as = " + name);
		log.info("Calling hello.jsp");
		return "hello.jsp";
	}
	
	@RequestMapping("/logout")
	public String logoutCtrl(){
		return "/logout";
	}
	
	@RequestMapping("/*")
	public String homePage(){
		return "index.jsp";
	}
	@RequestMapping("/add")
	public String sumPage(){
		return "add.jsp";
	}
	
}
