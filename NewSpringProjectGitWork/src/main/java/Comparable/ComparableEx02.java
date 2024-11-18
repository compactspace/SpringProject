package Comparable;

public class ComparableEx02 {

	public static void main(String[] args) {
		
		Comparable<? super Integer> comp=1;		
		//크거나 같으면 0
		//작으면 -1
		//System.out.println(comp.compareTo(2));
		
		String str1="가나다";
		String str2="가나다라";
		Comparable<? super String> comp2=str1;
		
		System.out.println(comp2.compareTo(str2));
		
		
	}
}
