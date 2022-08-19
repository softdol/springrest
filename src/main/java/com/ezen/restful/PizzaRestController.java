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

	// GET������� ������ ID�� �Բ� ��û�� ������ �ش� ������ ������ JSON �������� ��ȯ	
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
		
		// ������ ��ȸ���� �ִ�. ��ȸ�� ������ 1�� �����ؾ� �Ѵ�.
		return service.getPizza(id);
		
	}
	
	// POST������� �ĸ������� ���� �����Ϳ� �Բ� ��û ������ �ش� ���ڸ� DB�� �߰�
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
		log.info("���� ���� : " + pizza);
		// ResponseEntity : ��Ȳ�� ���� ���ϴ� ������ ���� �� �ִ�.(���� �ڵ� Ȱ��)
		ResponseEntity<Pizza> response = null;	
		
		// ResponseEntity.ok() : Http �����ڵ� 200�� ������ �����.
		response = ResponseEntity.ok(null);
		
		// ResponseEntity.notFound() : Http �����ڵ� 404�� ������ �����.
		response = ResponseEntity.notFound().build();
		
		// �����Ӱ� ���丸���
		
		response = ResponseEntity.status(HttpStatus.OK)
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.body(service.getPizza(22)); 
		
		
		return response;
		
	}
	
	// PUT������� �Ķ���Ϳ� ���� �����͸� �Բ� ��û ������ �ش� ������ ������ �޾Ƽ� ����
	@SuppressWarnings("deprecation")
	@PutMapping(value = "/pizza/addjson", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Map<String,Integer> updatePizza(@RequestBody Pizza pizza) {
		Map<String, Integer> returnMap = new HashMap<>();
		returnMap.put("put_update", service.uptPizza(pizza));
		return returnMap;
	}
	
	@PutMapping(value = "/sample/pizza", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Integer uptPizza(@RequestBody Pizza pizza) {
		log.info("���� ���� : " + pizza);
		return 3;
		
	}
	
	
	// DELETE ������� ������ ID�� �Բ� ��û�� ������ �ش� ���ڸ� DB���� ����
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
