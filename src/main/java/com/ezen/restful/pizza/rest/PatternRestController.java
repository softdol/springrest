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
	
//	분류	정규식 패턴
//	숫자	^[0-9]*$
//	영문자	^[a-zA-Z]*$
//	한글	^[가-힣]*$
//	영어&숫자	^[a-zA-Z0-9]*$
//	비밀번호 (숫자, 문자 포함의 6~12자리 이내)	^[A-Za-z0-9]{6,12}$
//	비밀번호 (숫자, 문자, 특수문자 포함 8~15자리 이내)	^.*(?=^.{8,15}$)(?=.*\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$
//	이메일	^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$
//	휴대전화	^\\d{3}-\\d{3,4}-\\d{4}$
//	일반전화	^\\d{2,3}-\\d{3,4}-\\d{4}$
//	주민등록번호	\d{6} \- [1-4]\d{6}
//	파일확장자	^\\S+.(?i)(txt|pdf|hwp|xls)$
//	이중 파일확장자	(.+?)((\\.tar)?\\.gz)$
	
	// 비밀번호 체크
	@PostMapping(value = "/pattern/password", produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String,Boolean> chkPassword(@RequestBody Map<String,String> param) {
		
		// 비밀번호 (숫자, 문자 포함의 6~12자리 이내)	
		String pattern = "^[A-Za-z0-9]{6,12}$";
		String value = param.get("value");
		log.info(value + " : " + Pattern.matches(pattern, value));
		
		Map<String, Boolean> returnMap = new HashMap<>();
				
		returnMap.put("result" , Pattern.matches(pattern, value));
		
		return returnMap;
	}

}
