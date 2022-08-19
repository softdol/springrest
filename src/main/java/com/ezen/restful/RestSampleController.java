package com.ezen.restful;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ezen.restful.dto.Pizza;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
public class RestSampleController {
	
	@GetMapping(value = "/test1", produces = "text/plain; charset=EUC-KR")
	public String test1() {
		return "Hello, RESTFUL!!";
	}
	
	
	// jackson-databind : 자바 객체를 JSON타입 또는 XML타입으로 알아서 변환해주는 라이브러리
	@SuppressWarnings("deprecation")
	//@GetMapping(value = "/pizza", produces = "application/json; charset=EUC-KR")
	@GetMapping(value = "/pizza", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Pizza getPizza() {
		Pizza pizza = new Pizza();
		
		pizza.setId(13);
		pizza.setName("페퍼로니");
		pizza.setCalories(30.52);
		pizza.setPrice(8000);
		log.info("info : " + pizza);
		return pizza;
	}
	
	@SuppressWarnings("deprecation")
	//@GetMapping(value = "/pizza", produces = "application/json; charset=EUC-KR")
	@GetMapping(value = "/pizza2", produces = MediaType.APPLICATION_XML_VALUE)
	public Pizza getPizza2() {
		Pizza pizza = new Pizza();
		
		pizza.setId(13);
		pizza.setName("paperroni");
		pizza.setCalories(30.52);
		pizza.setPrice(8000);
		log.info("info : " + pizza);
		return pizza;
	}
	
	@SuppressWarnings("deprecation")
	@GetMapping(value = "/pizzas", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Pizza> getPizzaList() {
		List<Pizza> pizzas = new ArrayList<>();
		
		for(int i = 0, max = 10; i < max; i++) {
			pizzas.add(new Pizza());
		}
		
		return pizzas;
	}
	
	@SuppressWarnings("deprecation")
	@GetMapping(value = "/pizza_map", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Map<String, Pizza> getPizzaMap(){
		
		Map<String, Pizza> pizzaMap = new HashMap<>();
		
		pizzaMap.put("menu1", new Pizza());
		pizzaMap.put("menu2", new Pizza());
		pizzaMap.put("menu3", new Pizza());
		
		return pizzaMap;
	}
	

}















