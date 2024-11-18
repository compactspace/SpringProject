package Queue;

import java.util.NoSuchElementException;

import Interface_form.Queue;

public class ArrayQueue<E> implements Queue<E> {

	private static final int DEFAULT_CAPACITY = 64; // 최소(기본) 용적 크기

	private Object[] array; // 요소를 담을 배열
	private int size; // 요소 개수

	private int front; // 시작 인덱스를 가리키는 변수(빈 공간임을 유의)
	private int rear; // 마지막 요소의 인덱스를 가리키는 변수

	// 생성자1 (초기 용적 할당을 안할 경우)
	public ArrayQueue() {
		this.array = new Object[DEFAULT_CAPACITY];
		this.size = 0;
		this.front = 0;
		this.rear = 0;
	}

	// 생성자2 (초기 용적 할당을 할 경우)
	public ArrayQueue(int capacity) {
		this.array = new Object[capacity];
		this.size = 0;
		this.front = 0;
		this.rear = 0;
	}

	private void resize(int newCapacity) {

		int arrayCapacity = array.length; // 현재 용적 크기

		Object[] newArray = new Object[newCapacity]; // 용적을 변경한 배열

		/*
		 * i = new array index j = original array index 요소 개수(size)만큼 새 배열에 값 복사
		 */

		// 4-5(마지막 rear)-빈공간 front -2-1-5 인 큐가 있다고하자.
		// 렝스가 6 이고, front + 1 는 인덱스 4 이니
		// 6%4 나머지 값은 2 이다.

		// 따라서 orgin 배열의 각 원소들을
		// newArray[i] = array[j % arrayCapacity];
		// newArray[1]=array[2]

		for (int i = 1, j = front + 1; i <= size; i++, j++) {
			// 자바의 나머지 연산 % 은 정수론의 나눗셈정리 값이다.
			// 결국 프론트앞에 있는 인덱스가 나머지값으로 증가시키며 프론트값을 땡겨오는거임
			newArray[i] = array[j % arrayCapacity];
		}

		this.array = null;
		this.array = newArray; // 새 배열을 기존 array의 배열로 덮어씌움

		front = 0;
		rear = size;

	}

	// 1. 기본 삽입 : offer(E item)
	@Override
	public boolean offer(E e) {

		// 용적이 가득 찼을 경우
		if ((rear + 1) % array.length == front) {
			resize(array.length * 2); // 용적을 두 배 늘려
		}
	
		// 주의할건 최초 삽입시 인데
		// 다연하게 최초 삽입시는 font=rear 인 상태에서
		//fonrt=0 이고,rear = (rear + 1) % array.length; 로 rear=1 이 된뒤
		// array[rear] = e; 에 추가하는거다.
		rear = (rear + 1) % array.length; // rear을 rear의 다음 위치로 갱신

		array[rear] = e;
		size++; // 사이즈 1 증가

		return true;

	}

	// [poll 메소드 구현]
	@Override
	public E poll() {

		if (size == 0) { // 삭제할 요소가 없을 경우 null 반환
			return null;
		}

		array[front + 1] = null;
		front = (front + 1) % array.length;
		E item = (E) array[front]; // 반환할 데이터 임시 저장

		array[front] = null; // 해당 front의 데이터 삭제
		size--; // 사이즈 감소

		// 용적이 최소 크기(64)보다 크고 요소 개수가 1/4 미만일 경우
		if (array.length > DEFAULT_CAPACITY && size < (array.length / 4)) {

			// 아무리 작아도 최소용적 미만으로 줄이지는 않도록 한다.
			resize(Math.max(DEFAULT_CAPACITY, array.length / 2));
		}

		return item;
	}

	// poll 과 차이점은 remove는 에러를 던지며 poll는 없다면 null을 던진다.
	public E remove() {

		E item = poll();

		if (item == null) {
			throw new NoSuchElementException();
		}

		return item;
	}

	// 가장 최신 데이터를 가져온다.
	@Override
	public E peek() {

		// 요소가 없을 경우 null 반환
		if (size == 0) {
			return null;
		}
		
		System.out.println((front + 1) % array.length);
		E item = (E) array[(front + 1) % array.length];

		return item;
	}
	// 3. contains() 메소드 contains() 는 현재 찾고자하는 요소가 큐에 들어가있는지를 알려주는 메소드다.

	public boolean contains(Object value) {

		System.out.println("컨테인펑션 받은값: "+value);
		// 주의할껀 지금 용적이 동적 할당이 이루어지기에 검사에 유리한 변수 하나를 더만들고 font처리
		for (int k = 0, idx = front + 1; k <size; k++, idx++) {
			if (value.equals(array[idx])) {
				return true;
			}

		}

		return false;
	}
	
	public void clear() {
		
		for(int i = 0; i < array.length; i++) {
			array[i] = null;
		}
			
		front = rear = size = 0;
	}
	
	
	public int size() {
		return size;
	}
	
	
	
}