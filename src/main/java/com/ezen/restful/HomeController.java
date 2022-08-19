package com.ezen.restful;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ezen.restful.pizza.service.PizzaService;
import com.ezen.restful.service.AjaxService;

import lombok.extern.log4j.Log4j2;

/**
 * Handles requests for the application home page.
 */
@Log4j2
@Controller
public class HomeController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		log.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@Autowired
	PizzaService service;
	
	@Autowired
	AjaxService aSv;
	
	@RequestMapping(value = "/ajax", method = RequestMethod.GET)
	public String ajax(Locale locale, Model model) {
		//log.info("ajax", locale);
		
		//model.addAttribute("pizzas", service.getPizzaList());
		model.addAttribute("pizzas", aSv.getPizzaList());
		return "ajax";
	}
	
}
