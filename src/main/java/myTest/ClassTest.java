package myTest;

import java.lang.reflect.Field;
import java.util.regex.Pattern;

import com.ezen.restful.dto.Pizza;

public class ClassTest {
	
	/**
	 * °ª ³ÎÃ¼Å© ¹®ÀÚ ±æÀÌ°¡ 0ÀÌ¾îµµ false
	 * @param o (±âº» Å¬·¡½º, ¸ðµ¨ Å¬·¡½º ¸¸ °¡´É)
	 * @return true(null ¾Æ´Ô) false(null ÀÓ)
	 */
	public static boolean chkNotNull(Object o) {
		
		if(o == null) {
			return false;
		}
		
		String[] arrEnt = o.getClass().getTypeName().toString().split("\\.");
		
		if(arrEnt.length > 1) {
			
			if(arrEnt[0].equals("java") && arrEnt[1].equals("lang")) {
				
				String s = String.valueOf(o);
				return s.trim().length() > 0;
				
			}else {
				for(Field f : o.getClass().getDeclaredFields()) {
					
					f.setAccessible(true);
					
					try {
						if(f.get(o) == null || f.get(o).toString().trim().length() < 1) {
							return false;
						}
					} catch (IllegalArgumentException | IllegalAccessException e) {
						e.printStackTrace();
					}
				}
			}
			return false;

		}else {
			return false;
		}
	}
	
	// Á¤±Ô½Ä
	// Á¤±Ô½ÄÀ¸·Î ºñ¹Ð¹øÈ£ ¼³Á¤ÇÏ±â(ÃÖ¼Ò8±ÛÀÚ, ÃÖ¼Ò ¼ýÀÚ1°³, ¹®ÀÚ1°³)
	// ^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{8,}$
//	3-4 Á¤±Ô½ÄÀ¸·Î ºñ¹Ð¹øÈ£ ¼³Á¤ÇÏ±â (ÃÖ¼Ò 8±ÛÀÚ, ±ÛÀÚ 1°³, ¼ýÀÚ 1°³, Æ¯¼ö¹®ÀÚ 1°³)
//	Á¤±Ô½Ä = ^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*#?&])[A-Za-z\d@$!%*#?&]{8,}$	 
//
//	3-5 Á¤±Ô½ÄÀ¸·Î ºñ¹Ð¹øÈ£ ¼³Á¤ÇÏ±â (ÃÖ¼Ò 8±ÛÀÚ, ´ë¹®ÀÚ 1°³, ¼Ò¹®ÀÚ 1°³, ¼ýÀÚ 1°³)
//	Á¤±Ô½Ä = ^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[a-zA-Z\d]{8,}$
//
//	3-6 Á¤±Ô½ÄÀ¸·Î ºñ¹Ð¹øÈ£ ¼³Á¤ÇÏ±â (ÃÖ¼Ò 8±ÛÀÚ~10ÀÚ, ´ë¹®ÀÚ 1°³, ¼Ò¹®ÀÚ 1°³, ¼ýÀÚ 1°³, Æ¯¼ö¹®ÀÚ 1°³)
//	Á¤±Ô½Ä = ^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,10}$
//	ºñ¹Ð¹øÈ£ (¼ýÀÚ, ¹®ÀÚ Æ÷ÇÔÀÇ 6~12ÀÚ¸® ÀÌ³»)	^[A-Za-z0-9]{6,12}$

//	ºÐ·ù	Á¤±Ô½Ä ÆÐÅÏ
//	¼ýÀÚ	^[0-9]*$
//	¿µ¹®ÀÚ	^[a-zA-Z]*$
//	ÇÑ±Û	^[°¡-ÆR]*$
//	¿µ¾î&¼ýÀÚ	^[a-zA-Z0-9]*$
//	ºñ¹Ð¹øÈ£ (¼ýÀÚ, ¹®ÀÚ Æ÷ÇÔÀÇ 6~12ÀÚ¸® ÀÌ³»)	^[A-Za-z0-9]{6,12}$
//	ºñ¹Ð¹øÈ£ (¼ýÀÚ, ¹®ÀÚ, Æ¯¼ö¹®ÀÚ Æ÷ÇÔ 8~15ÀÚ¸® ÀÌ³»)	^.*(?=^.{8,15}$)(?=.*\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$
//	ÀÌ¸ÞÀÏ	^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$
//	ÈÞ´ëÀüÈ­	^\\d{3}-\\d{3,4}-\\d{4}$
//	ÀÏ¹ÝÀüÈ­	^\\d{2,3}-\\d{3,4}-\\d{4}$
//	ÁÖ¹Îµî·Ï¹øÈ£	\d{6} \- [1-4]\d{6}
//	ÆÄÀÏÈ®ÀåÀÚ	^\\S+.(?i)(txt|pdf|hwp|xls)$
//	ÀÌÁß ÆÄÀÏÈ®ÀåÀÚ	(.+?)((\\.tar)?\\.gz)$
	
//	String str = "123456a";
//	Pattern pattern = Pattern.compile("^[0-9]*$");
//	Matcher matcher = pattern.matcher(str);
//	                
//	if(matcher.find()) {
//	    System.out.println(Integer.parseInt(str));
//	} else {
//	    System.out.println("¼ýÀÚ°¡ ¾Æ´Ñ °ªÀÌ Æ÷ÇÔµÇ¾î ÀÖ½À´Ï´Ù. ");
//	}
	
//	String pattern2 = "^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$";
//	String str2 = "abc_123@gmail.com";
//	if(Pattern.matches(pattern2, str2)) {
//	    System.out.println("¿Ã¹Ù¸¥ ÀÌ¸ÞÀÏ Çü½ÄÀÔ´Ï´Ù. ");
//	} else {            
//	    System.out.println("¿Ã¹Ù¸¥ ÀÌ¸ÞÀÏ Çü½ÄÀÌ ¾Æ´Õ´Ï´Ù. ");
//	}
	
//	pattern2 = "^\\S+.(?i)(txt|pdf|hwp|xls)$";
//	str2 = "abc.txt";
//	// ÀÌÁßÈ®ÀåÀÚ 
//	// pattern2 = "(.+?)((\\.tar)?\\.gz)$";
//	// str2= "lib.tar.gz";
//	 
//	if(Pattern.matches(pattern2, str2)) {
//	    System.out.println("¿Ã¹Ù¸¥ È®ÀåÀÚ Çü½ÄÀÔ´Ï´Ù. ");
//	} else {            
//	    System.out.println("¿Ã¹Ù¸¥ È®ÀåÀÚ Çü½ÄÀÌ ¾Æ´Õ´Ï´Ù. ");
//	}


	
	
	public static void main(String[] args) {
		
		Pizza pizza = new Pizza();
		
		System.out.println(chkNotNull(pizza));
		
		Integer i= null;
		System.out.println(chkNotNull(i));
		
		int i2 = 10;
		System.out.println("int :" + chkNotNull(i2));
		
		String a = "";
		System.out.println("String : " + chkNotNull(a));
		
		boolean b = true;
		System.out.println(chkNotNull(b));
		
		Boolean b2 = false;
		System.out.println(chkNotNull(b2));
		
		String pattern = "^.*(?=^.{8,15}$)(?=.*\\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$";
		String value = "yy99fj#j9";
		System.out.println("pattern : " + Pattern.matches(pattern, value)); 
		
	
		
	}

}
