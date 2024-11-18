package com.spring.finall.grammar2.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class RMainEx01 {
	//-Djava.system.class.loader=MyClassLoader.MyClassLoader MyClassLoader.Main
	
	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException {
		
		//그져, Class 객체이다. 이름에 낚이지 말자.
		Class<?> cls= Class.forName("com.spring.finall.grammar2.reflection.ReflectionEx01");
		
		
		//다음은 기본 생성자 이름을 가져오는 명령어이다.
		Constructor<?> cts = cls.getConstructor();
		System.out.println(cts);
		System.out.println("\n");
		//다음은 기본,기타 생성자 이름을 가져오는 명령어이다.
		Constructor<?>[] cts2 = cls.getConstructors();
		for(Constructor x: cts2) {
			System.out.println(x);
		}
		System.out.println("\n");
		//다음은 필드들을 가져오는 것이다.
		Field f= cls.getField("x");
		System.out.println("필드의정보를 가져오기"+f);
	
		System.out.println("\n");
		//다음은 모든 필드를 가져오는 것이다.
		Field[] f2= cls.getFields();
	
		for(Field x: f2) {
			System.out.println(x);
		}
		System.out.println("\n");
		//다음은 메서드 정보를 가져오는 것이다.
		//몰래 상속받은 투스트링 등등 다뜬다.
		Method[] md=cls.getMethods();
		
		for(Method m :md) {
			System.out.println("메서드정보"+m);
		}
		System.out.println("\n");
		Method methodvoid=cls.getMethod("show", null);
		Method methodreturn=cls.getMethod("show2",int.class);
		System.out.println("단건 으로 가져와봄 method->"+methodvoid);
		System.out.println("단건 으로 가져와봄 method->"+methodreturn);
	
		System.out.println("\n");
		// 다음은 가져온 생성자로 진짜 객체를 만들어 보는 것이다.
		// 실제로 생성된걸 확인해보면
		//생성자속 기본생성자 호출시 난 뜹니다. 이 호출된다.
		Object obj =cts.newInstance();
		
		
		
		// 다음은 객체를 생성후 실제 필드의 값을 가져오거나, 수정하거나, 매서드들을 호출해보기
		//중요한건 반드시 객체화를 한후 진행해야 한다.
		
		
		
		
		
		System.out.println("\n");
		System.out.println("----------------필드값을 가져오기----------------");
		System.out.println("필드값 가져오기"+f2[0].get(obj));
		System.out.println("필드값 가져오기"+f2[1].get(obj));
		System.out.println("----------------메서드를 호출하기----------------");
			methodvoid.invoke(obj);
			methodreturn.invoke(obj, 20);
			System.out.println(methodreturn.invoke(obj, 20));
		
	
		
	
		
		
	}
	
	

}
