package com.ezen.restful;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ezen.restful.dto.Pizza;
import com.ezen.restful.pizza.service.PizzaService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
public class PizzaRestController {
	
	@Autowired
	PizzaService service;

	// GET방식으로 피자의 ID와 함께 요청을 보내면 해당 피자의 정보를 JSON 형식으로 반환	
	@SuppressWarnings("deprecation")
	@GetMapping(value = "/pizza/addjson/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Pizza getPizza(@PathVariable Integer id) {
		Pizza pizza = new Pizza();
		try {			
			pizza = service.updatePizzaForm(id);
		}catch (Exception e) {
			//e.printStackTrace();
		}		
		return pizza;
	}
	
	@GetMapping(value = "/sample/pizza/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Pizza getPizzaSP(@PathVariable Integer id) {
		
		// 피자의 조회수가 있다. 조회할 때마다 1씩 증가해야 한다.
		return service.getPizza(id);
		
	}
	
	// POST방식으로 파마미터의 피자 데이터와 함께 요청 보내면 해당 피자를 DB에 추가
	@SuppressWarnings("deprecation")
	@PostMapping(value = "/pizza/addjson", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Map<String,Integer> insertPizza(@RequestBody Pizza pizza) {
		//log.info(pizza);
		Map<String, Integer> returnMap = new HashMap<>();
		//returnMap.put("resultCode", 0);
		returnMap.put("resultCode", service.addPizza(pizza));		
		return returnMap;
	}
	
	@PostMapping(value = "/sample/pizza")
	public ResponseEntity<Pizza> insPizza(@RequestBody Pizza pizza) {
		log.info("받은 피자 : " + pizza);
		// ResponseEntity : 상황에 따라 원하는 응답을 만들 수 있다.(상태 코드 활용)
		ResponseEntity<Pizza> response = null;	
		
		// ResponseEntity.ok() : Http 상태코드 200의 읍답을 만든다.
		response = ResponseEntity.ok(null);
		
		// ResponseEntity.notFound() : Http 상태코드 404의 읍답을 만든다.
		response = ResponseEntity.notFound().build();
		
		// 자유롭게 응답만들기
		
		response = ResponseEntity.status(HttpStatus.OK)
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.body(service.getPizza(22)); 
		
		
		return response;
		
	}
	
	// PUT방식으로 파라미터에 피자 데이터를 함께 요청 보내면 해당 피자의 정보를 받아서 수정
	@SuppressWarnings("deprecation")
	@PutMapping(value = "/pizza/addjson", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Map<String,Integer> updatePizza(@RequestBody Pizza pizza) {
		Map<String, Integer> returnMap = new HashMap<>();
		returnMap.put("put_update", service.uptPizza(pizza));
		return returnMap;
	}
	
	@PutMapping(value = "/sample/pizza", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Integer uptPizza(@RequestBody Pizza pizza) {
		log.info("받은 피자 : " + pizza);
		return 3;
		
	}
	
	
	// DELETE 방식으로 파지의 ID와 함께 요청을 보내면 해당 피자를 DB에서 삭제
	@DeleteMapping(value = "/pizza/addjson/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Map<String,Integer> deletePizza(@PathVariable Integer id) {		
		log.info("del : " + id);
		Map<String, Integer> returnMap = new HashMap<>();
		returnMap.put("put_delete", service.delPizza(id));
		return returnMap;
	}
	
	@DeleteMapping(value = "/pizza/addjson/{id}")
	public Integer delPizza() {
		
		return 3;
		
	}
	
}
