package com.ezen.restful.pizza.mapper;

import java.util.List;

import com.ezen.restful.dto.Pizza;

public interface PizzaMapper {
	
	Pizza get(int pk);
	
	Integer updateView(int pk);
	
	
	public List<Pizza> getAll();
	
	public int add(Pizza pizza);
	
	public Integer getIdByName(Pizza pizza);	
	
	public Pizza getPizza(int id);
	
	public Integer uptPizza(Pizza pizza);
	
	public Integer delPizza(int id);
	

}
