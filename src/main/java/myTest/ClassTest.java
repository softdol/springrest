package myTest;

import java.lang.reflect.Field;
import java.util.regex.Pattern;

import com.ezen.restful.dto.Pizza;

public class ClassTest {
	
	/**
	 * 값 널체크 문자 길이가 0이어도 false
	 * @param o (기본 클래스, 모델 클래스 만 가능)
	 * @return true(null 아님) false(null 임)
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
	
	// 정규식
	// 정규식으로 비밀번호 설정하기(최소8글자, 최소 숫자1개, 문자1개)
	// ^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{8,}$
//	3-4 정규식으로 비밀번호 설정하기 (최소 8글자, 글자 1개, 숫자 1개, 특수문자 1개)
//	정규식 = ^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*#?&])[A-Za-z\d@$!%*#?&]{8,}$	 
//
//	3-5 정규식으로 비밀번호 설정하기 (최소 8글자, 대문자 1개, 소문자 1개, 숫자 1개)
//	정규식 = ^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[a-zA-Z\d]{8,}$
//
//	3-6 정규식으로 비밀번호 설정하기 (최소 8글자~10자, 대문자 1개, 소문자 1개, 숫자 1개, 특수문자 1개)
//	정규식 = ^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,10}$
//	비밀번호 (숫자, 문자 포함의 6~12자리 이내)	^[A-Za-z0-9]{6,12}$

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
	
//	String str = "123456a";
//	Pattern pattern = Pattern.compile("^[0-9]*$");
//	Matcher matcher = pattern.matcher(str);
//	                
//	if(matcher.find()) {
//	    System.out.println(Integer.parseInt(str));
//	} else {
//	    System.out.println("숫자가 아닌 값이 포함되어 있습니다. ");
//	}
	
//	String pattern2 = "^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$";
//	String str2 = "abc_123@gmail.com";
//	if(Pattern.matches(pattern2, str2)) {
//	    System.out.println("올바른 이메일 형식입니다. ");
//	} else {            
//	    System.out.println("올바른 이메일 형식이 아닙니다. ");
//	}
	
//	pattern2 = "^\\S+.(?i)(txt|pdf|hwp|xls)$";
//	str2 = "abc.txt";
//	// 이중확장자 
//	// pattern2 = "(.+?)((\\.tar)?\\.gz)$";
//	// str2= "lib.tar.gz";
//	 
//	if(Pattern.matches(pattern2, str2)) {
//	    System.out.println("올바른 확장자 형식입니다. ");
//	} else {            
//	    System.out.println("올바른 확장자 형식이 아닙니다. ");
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
