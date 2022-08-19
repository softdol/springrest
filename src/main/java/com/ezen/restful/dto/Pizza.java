package com.ezen.restful.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

// Mybatis를 이용해 CRUD를 구현해보세요. 

@NoArgsConstructor
@Data
public class Pizza {
	
	private Integer id;
	private String 	name;
	private Integer price;
	private Double	calories;

}
