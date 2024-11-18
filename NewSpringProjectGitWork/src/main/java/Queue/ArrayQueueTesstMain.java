package Queue;

public class ArrayQueueTesstMain {

	public static void main(String[] args) {
	
		ArrayQueue<Integer> arrq= new ArrayQueue<Integer>();
		arrq.offer(1);
		arrq.offer(2);
		arrq.offer(3);

		System.out.println("값 포함되어있니?: "+arrq.contains(1));
		System.out.println("값 포함되어있니?: "+arrq.contains(2));
		System.out.println("값 포함되어있니?: "+arrq.contains(3));
		System.out.println("값 포함되어있니?: "+arrq.contains(4));
		
		System.out.println("가장 먼저 들어왔던건?: "+arrq.peek());
	}

}
