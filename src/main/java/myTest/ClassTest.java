package myTest;

import java.lang.reflect.Field;
import java.util.regex.Pattern;

import com.ezen.restful.dto.Pizza;

public class ClassTest {
	
	/**
	 * �� ��üũ ���� ���̰� 0�̾ false
	 * @param o (�⺻ Ŭ����, �� Ŭ���� �� ����)
	 * @return true(null �ƴ�) false(null ��)
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
	
	// ���Խ�
	// ���Խ����� ��й�ȣ �����ϱ�(�ּ�8����, �ּ� ����1��, ����1��)
	// ^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{8,}$
//	3-4 ���Խ����� ��й�ȣ �����ϱ� (�ּ� 8����, ���� 1��, ���� 1��, Ư������ 1��)
//	���Խ� = ^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*#?&])[A-Za-z\d@$!%*#?&]{8,}$	 
//
//	3-5 ���Խ����� ��й�ȣ �����ϱ� (�ּ� 8����, �빮�� 1��, �ҹ��� 1��, ���� 1��)
//	���Խ� = ^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[a-zA-Z\d]{8,}$
//
//	3-6 ���Խ����� ��й�ȣ �����ϱ� (�ּ� 8����~10��, �빮�� 1��, �ҹ��� 1��, ���� 1��, Ư������ 1��)
//	���Խ� = ^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,10}$
//	��й�ȣ (����, ���� ������ 6~12�ڸ� �̳�)	^[A-Za-z0-9]{6,12}$

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
	
//	String str = "123456a";
//	Pattern pattern = Pattern.compile("^[0-9]*$");
//	Matcher matcher = pattern.matcher(str);
//	                
//	if(matcher.find()) {
//	    System.out.println(Integer.parseInt(str));
//	} else {
//	    System.out.println("���ڰ� �ƴ� ���� ���ԵǾ� �ֽ��ϴ�. ");
//	}
	
//	String pattern2 = "^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$";
//	String str2 = "abc_123@gmail.com";
//	if(Pattern.matches(pattern2, str2)) {
//	    System.out.println("�ùٸ� �̸��� �����Դϴ�. ");
//	} else {            
//	    System.out.println("�ùٸ� �̸��� ������ �ƴմϴ�. ");
//	}
	
//	pattern2 = "^\\S+.(?i)(txt|pdf|hwp|xls)$";
//	str2 = "abc.txt";
//	// ����Ȯ���� 
//	// pattern2 = "(.+?)((\\.tar)?\\.gz)$";
//	// str2= "lib.tar.gz";
//	 
//	if(Pattern.matches(pattern2, str2)) {
//	    System.out.println("�ùٸ� Ȯ���� �����Դϴ�. ");
//	} else {            
//	    System.out.println("�ùٸ� Ȯ���� ������ �ƴմϴ�. ");
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
