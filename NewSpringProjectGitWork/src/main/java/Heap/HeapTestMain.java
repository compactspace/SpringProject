package Heap;

public class HeapTestMain {

	public static void main(String[] args) {
	
		Heap heap = new Heap();
		heap.add(1);
		heap.add(100);
		heap.add(20);
		heap.add(35);
		heap.add(27);
		heap.add(13);
		for(int k=0; k<heap.array.length; k++) {
			System.out.println("값 : "+heap.array[k]);
		}		
		heap.remove();
		System.out.println("최고 루트 1 제거후 재배열하자.");
		
		for(int k=0; k<heap.array.length; k++) {
			System.out.println("값 : "+heap.array[k]);
		}	
		heap.remove();
System.out.println("최고 루트 13 제거후 재배열하자.");
		
		for(int k=0; k<heap.array.length; k++) {
			System.out.println("값 : "+heap.array[k]);
		}	
	}

}
