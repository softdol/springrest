package com.ezen.restful.pizza.service;

import java.util.List;

import com.ezen.restful.dto.Pizza;

public interface PizzaService {
	
	public List<Pizza> getPizzaList();
	public Integer addPizza(Pizza pizza);
	public Pizza updatePizzaForm(int id);
	public Integer uptPizza(Pizza pizza);
	public Integer delPizza(int id);
	
	public Pizza getPizza(int pk);

}
