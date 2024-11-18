package Comparable;

import java.util.Comparator;

import com.spring.finall.admindomain.Student;

public class ComparableEx01 {

	public static void main(String[] args) {
	
//static 키워드는 하단에서 초기화 해도됨
System.out.println("comparator: "+comparator);
 //System.out.println(x);
	}
	//static int x=-1;
	private static Comparator<Student> comparator = new Comparator<Student>() {
		@Override
		public int compare(Student o1, Student o2) {
			// 나이가 같다면 이름순
			if(o1.age == o2.age) {
				return o1.name.compareTo(o2.name);
			}
			
			return o2.age - o1.age;	// 나이 내림차순
		}
	};
	
	private static class Student implements Comparable<Student> {
		
		String name;
		int age;
		
		public Student(String name, int age) {
			
			this.name = name;
			this.age = age;
		}
 
		@Override
		public int compareTo(Student o) {
			// 이름이 같다면 나이순 (오름차순)
			if(this.name.compareTo(o.name) == 0) { 
				return this.age - o.age;
			}
			// 이름순
			return this.name.compareTo(o.name);
			
		}
		
		
		public String toString() {
			return "이름 : " + name + "\t나이 : " + age;
		}
		
		
	}
}
