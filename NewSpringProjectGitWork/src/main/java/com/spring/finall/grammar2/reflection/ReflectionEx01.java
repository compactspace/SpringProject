package com.spring.finall.grammar2.reflection;

import java.io.DataInputStream;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;


//그냥 런타임시에 리플렉션 확인해보려고 클래스로더 구현해본거임
public class ReflectionEx01  extends ClassLoader {
	
	public int x=4;
	public String y;
	
	
	static {}
	
	
	
	public ReflectionEx01() {
		System.out.println("기본생성자 호출시 난 뜹니다.");
		this.x=1;
		this.y="하하";
		
	}
	
	public ReflectionEx01(int x) {
		
		this.x=1;
		this.y="하하";
		
	}
	
	
	
	public void show() {
		System.out.println("안녕하십니까 씨발");
	}
	
	
	public int show2(int x) {
		
		return 10;
	}
	
	
	static {
		System.out.println("로드시작실패?");
	}
	
	
	    // 인스턴스가 생성될 때 현재 클래스로더의 부모 클래스로더도 설정해 줘야 한다
	    public ReflectionEx01(ClassLoader parent) {
	        super(parent);
	    }

	    // 클래스가 포함된 패키지로부터 클래스를 로드하여 Class 인스턴스를 생성하고 리턴한다
	    private Class getClass(String name) throws ClassNotFoundException {
	        String file = name.replace('.', File.separatorChar) + ".class";
	        byte[] buf = null;
	        try {
	            // 파일 시스템으로부터 .class 파일을 byte[]으로 로드한다
	            buf = loadBytes(file);
	            // byte[]를 지정된 이름의 클래스에 해당하는 Class 인스턴스로 변환한다
	            Class cls = defineClass(name, buf, 0, buf.length);
	            resolveClass(cls); // 링크한다. 이미 링크된 경우에는 아무 것도 하지 않는다
	            return cls;
	        } catch (IOException e) {
	            e.printStackTrace();
	            return null;
	        }
	    }
	 
	    // JVM은 클래스를 로드할 때 이 메소드를 호출하여 클래스를 로드한다.
	    // 현재 프로그램(특정 패키지)에 포함된 클래스만 커스텀 클래스로더를 이용하여 로드하고 
	    // 시스템 클래스는 시스템 클래스로더가 로드하도록 위임한다(Delegation)
	    @Override
	    public Class<?> loadClass(String name) throws ClassNotFoundException {
	        System.out.println("로드 시작("+name+")");
	        if (name.startsWith("org.kdea.cloader")) {
	            System.out.println("\t\t\t--> by MyClassLoader");
	            return getClass(name);
	        }
	        return super.loadClass(name);
	    }
	 
	    //파일 시스템에서 .class 파일을 읽어서 byte[] 형으로 리턴한다
	    private byte[] loadBytes(String name) throws IOException {
	        InputStream stream = 
	        		getClass().getClassLoader().getResourceAsStream(name);
	        int size = stream.available();
	        byte buff[] = new byte[size];
	        DataInputStream in = new DataInputStream(stream);
	        in.readFully(buff);
	        in.close();
	        return buff;
	    }
	

}
