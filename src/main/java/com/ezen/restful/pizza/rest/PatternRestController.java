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
	
//	ºĞ·ù	Á¤±Ô½Ä ÆĞÅÏ
//	¼ıÀÚ	^[0-9]*$
//	¿µ¹®ÀÚ	^[a-zA-Z]*$
//	ÇÑ±Û	^[°¡-ÆR]*$
//	¿µ¾î&¼ıÀÚ	^[a-zA-Z0-9]*$
//	ºñ¹Ğ¹øÈ£ (¼ıÀÚ, ¹®ÀÚ Æ÷ÇÔÀÇ 6~12ÀÚ¸® ÀÌ³»)	^[A-Za-z0-9]{6,12}$
//	ºñ¹Ğ¹øÈ£ (¼ıÀÚ, ¹®ÀÚ, Æ¯¼ö¹®ÀÚ Æ÷ÇÔ 8~15ÀÚ¸® ÀÌ³»)	^.*(?=^.{8,15}$)(?=.*\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$
//	ÀÌ¸ŞÀÏ	^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$
//	ÈŞ´ëÀüÈ­	^\\d{3}-\\d{3,4}-\\d{4}$
//	ÀÏ¹İÀüÈ­	^\\d{2,3}-\\d{3,4}-\\d{4}$
//	ÁÖ¹Îµî·Ï¹øÈ£	\d{6} \- [1-4]\d{6}
//	ÆÄÀÏÈ®ÀåÀÚ	^\\S+.(?i)(txt|pdf|hwp|xls)$
//	ÀÌÁß ÆÄÀÏÈ®ÀåÀÚ	(.+?)((\\.tar)?\\.gz)$
	
	// ºñ¹Ğ¹øÈ£ Ã¼Å©
	@PostMapping(value = "/pattern/password", produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String,Boolean> chkPassword(@RequestBody Map<String,String> param) {
		
		// ºñ¹Ğ¹øÈ£ (¼ıÀÚ, ¹®ÀÚ Æ÷ÇÔÀÇ 6~12ÀÚ¸® ÀÌ³»)	
		String pattern = "^[A-Za-z0-9]{6,12}$";
		String value = param.get("value");
		log.info(value + " : " + Pattern.matches(pattern, value));
		
		Map<String, Boolean> returnMap = new HashMap<>();
				
		returnMap.put("result" , Pattern.matches(pattern, value));
		
		return returnMap;
	}

}
