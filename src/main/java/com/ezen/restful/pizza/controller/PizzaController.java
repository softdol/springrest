package com.ezen.restful.pizza.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ezen.restful.dto.Pizza;
import com.ezen.restful.pizza.service.PizzaService;

import lombok.extern.log4j.Log4j2;

@RequestMapping("/pizza")
@Log4j2
@Controller
public class PizzaController {
	

	
	@Autowired
	PizzaService service;
	
	@GetMapping({"/",""})
	public String index() {
		return "redirect:/pizza/list";
	}

	@GetMapping("/list")
	public void list(Model model) {
		model.addAttribute("pizzas", service.getPizzaList());
	}
	
	@GetMapping("/add")
	public void add() {
		
	}
	
	@PostMapping("/add")
	public String setAdd(Pizza pizza) {	
		Integer id = service.addPizza(pizza);
		
		return "redirect:/pizza/list";
	}
	
	@GetMapping("/update")
	public String pizzaUpdateForm(Model model,Integer id) {
		log.info("to update id : " + id);
		
		if(id == null) {
			return "redirect:/pizza/list";
		}
		
		model.addAttribute("pizza", service.updatePizzaForm(id));
		
		return "pizza/update";
	}
	
	@PostMapping("/update")
	public String pizzaUpdate(Pizza pizza) {
		
		//Integer id = service.uptPizza(pizza);
		
		return "redirect:/pizza/list";
	}
	
	@GetMapping("/info")
	public String view(Integer id, Model model) {
		if(id == 0) {
			return "redirect:/pizza/list";
		}
		
		try {			
			Pizza pizza = service.updatePizzaForm(id);			
			model.addAttribute("pizza", pizza);			
		}catch (Exception e) {
			e.printStackTrace();
			return "redirect:/pizza/list";
		}
		
		return "pizza/info";
	}
	
	@GetMapping("/del")
	public String del(Integer id) {		
		if(service.delPizza(id) < 1) {
			log.info("삭제 실패 : " + id);
		}		
		return "redirect:/pizza/list";
	}
	
	@GetMapping("/view")
	public String mod(Integer id, Model model) {
		if(id == 0) {
			return "redirect:/pizza/list";
		}
		
		try {			
			Pizza pizza = service.updatePizzaForm(id);			
			model.addAttribute("pizza", pizza);			
		}catch (Exception e) {
			e.printStackTrace();
			return "redirect:/pizza/list";
		}
		
		return "pizza/info";
	}
	
	@GetMapping("/mod")
	public void upt(Integer id, Model model) {
		model.addAttribute("pizza", service.updatePizzaForm(id));
		// "redirect:/pizza/list";
	}
	
	@PostMapping("/mod")
	public String upt(Pizza pizza) {		
		if(service.uptPizza(pizza) < 1) {
			log.info("수정 실패 : " + pizza);
		}
		return "redirect:/pizza/list";
	}
	
}
