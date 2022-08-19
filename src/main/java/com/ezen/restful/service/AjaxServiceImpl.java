package com.ezen.restful.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezen.restful.dto.Pizza;
import com.ezen.restful.pizza.mapper.PizzaMapper;

@Service
public class AjaxServiceImpl implements AjaxService {

	@Autowired
	PizzaMapper mapper;
	
	@Override
	public List<Pizza> getPizzaList() {
		return mapper.getAll();
	}

}
