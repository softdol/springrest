package com.ezen.restful.pizza.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezen.restful.dto.Pizza;
import com.ezen.restful.pizza.mapper.PizzaMapper;

@Service
public class PizzaServiceImpl implements PizzaService {
	
	/*
	 * 	# Mapper Interface
	 * 
	 * 	 - 골격만 작성해놓으면 Mybatis가 자동으로 완성해주는 것
	 *   - 알아서 귀찮은 JDBC 코드를 자동으로 생성한 후
	 *     mybatis-spring:scan을 통해 spring-context에 등록된다
	 */
	
	@Autowired
	PizzaMapper pizzaMapper;
	
	@Override
	public Pizza getPizza(int pk) {
		pizzaMapper.updateView(pk);		
		return pizzaMapper.get(pk);
	}
	
//
	@Override
	public List<Pizza> getPizzaList() {
		return pizzaMapper.getAll();
	}

//	@Override
//	public Integer addPizza(Pizza pizza) {
//		// pizza name에 unique가 걸려있다고 가정
//		
//		// 1. 피자를 추가한다
//		int row = pizzaMapper.add(pizza);
//		
//		// 2. 방금 추가한 피자의 아이디는 시퀀스라 모르므로 이름으로 다시 가져온다
//		if( row > 0) {
//			return pizzaMapper.getIdByName(pizza);
//		}else {
//			return null;
//		}
//		
//	}
//
	@Override
	public Pizza updatePizzaForm(int id) {
		// TODO Auto-generated method stub
		return pizzaMapper.getPizza(id);
	}
//
//	@Override
//	public Integer uptPizza(Pizza pizza) {
//		
//		// pizza 수정값에 대한 검사
//		return pizzaMapper.uptPizza(pizza);
//	}

	@Override
	public Integer addPizza(Pizza pizza) {
		return pizzaMapper.add(pizza);
	}

	@Override
	public Integer uptPizza(Pizza pizza) {
		return pizzaMapper.uptPizza(pizza);
	}

	@Override
	public Integer delPizza(int id) {
		return pizzaMapper.delPizza(id);
	}	

}
