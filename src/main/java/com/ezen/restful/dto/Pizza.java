package com.ezen.restful.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

// Mybatis�� �̿��� CRUD�� �����غ�����. 

@NoArgsConstructor
@Data
public class Pizza {
	
	private Integer id;
	private String 	name;
	private Integer price;
	private Double	calories;

}
