package com.ezen.restful.pizza.rest;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
public class PatternRestController {
	
//	�з�	���Խ� ����
//	����	^[0-9]*$
//	������	^[a-zA-Z]*$
//	�ѱ�	^[��-�R]*$
//	����&����	^[a-zA-Z0-9]*$
//	��й�ȣ (����, ���� ������ 6~12�ڸ� �̳�)	^[A-Za-z0-9]{6,12}$
//	��й�ȣ (����, ����, Ư������ ���� 8~15�ڸ� �̳�)	^.*(?=^.{8,15}$)(?=.*\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$
//	�̸���	^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$
//	�޴���ȭ	^\\d{3}-\\d{3,4}-\\d{4}$
//	�Ϲ���ȭ	^\\d{2,3}-\\d{3,4}-\\d{4}$
//	�ֹε�Ϲ�ȣ	\d{6} \- [1-4]\d{6}
//	����Ȯ����	^\\S+.(?i)(txt|pdf|hwp|xls)$
//	���� ����Ȯ����	(.+?)((\\.tar)?\\.gz)$
	
	// ��й�ȣ üũ
	@PostMapping(value = "/pattern/password", produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String,Boolean> chkPassword(@RequestBody Map<String,String> param) {
		
		// ��й�ȣ (����, ���� ������ 6~12�ڸ� �̳�)	
		String pattern = "^[A-Za-z0-9]{6,12}$";
		String value = param.get("value");
		log.info(value + " : " + Pattern.matches(pattern, value));
		
		Map<String, Boolean> returnMap = new HashMap<>();
				
		returnMap.put("result" , Pattern.matches(pattern, value));
		
		return returnMap;
	}

}
