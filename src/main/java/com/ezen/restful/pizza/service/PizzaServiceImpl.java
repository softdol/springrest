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
	 * 	 - ��ݸ� �ۼ��س����� Mybatis�� �ڵ����� �ϼ����ִ� ��
	 *   - �˾Ƽ� ������ JDBC �ڵ带 �ڵ����� ������ ��
	 *     mybatis-spring:scan�� ���� spring-context�� ��ϵȴ�
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
//		// pizza name�� unique�� �ɷ��ִٰ� ����
//		
//		// 1. ���ڸ� �߰��Ѵ�
//		int row = pizzaMapper.add(pizza);
//		
//		// 2. ��� �߰��� ������ ���̵�� �������� �𸣹Ƿ� �̸����� �ٽ� �����´�
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
//		// pizza �������� ���� �˻�
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
