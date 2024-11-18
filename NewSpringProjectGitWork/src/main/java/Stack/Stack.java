package Stack;

import java.util.EmptyStackException;

import Interface_form.StackInterface;
import edu.emory.mathcs.backport.java.util.Arrays;

public class Stack<E> implements StackInterface<E> {

	private static final int DEFAULT_CAPACITY = 10; // 최소(기본) 용적 크기

	private static final Object[] EMPTY_ARRAY = {}; // 빈 배열

	private Object[] array; // 요소를 담을 배열

	private int size; // 요소 개수

	// 생성자1 (초기 공간 할당 X)
	public Stack() {
		this.array = EMPTY_ARRAY;
		this.size = 0;
	}

	// 생성자2 (초기 공간 할당 O)
	public Stack(int capacity) {
		this.array = new Object[capacity];
		this.size = 0;
	}

	// 실에 요소의 개수에 맞게 용적을 조절한다.
	private void resize() {

		if (Arrays.equals(array, EMPTY_ARRAY)) {
			array = new Object[DEFAULT_CAPACITY];
			return;
		}

		// 계속 주의 요소의 개수가 아니다..!
		int arrayCapacity = array.length; // 현재 용적 크기

		if (size == arrayCapacity) {
			Arrays.copyOf(array, arrayCapacity * 2);
			return;

		}
		// 용적의 절반 미만으로 요소가 차지하고 있을 경우
		if (size < arrayCapacity / 2) {
			int newCapacity = (arrayCapacity / 2);
			// 단 최악의 경우로 디펄트 용적이 10 이니 10은 유지시켜야기에 max로 택한다.
			Arrays.copyOf(array, Math.max(newCapacity, DEFAULT_CAPACITY));
			return;
		}

	}

	// 1. 기본삽입 : push(E item)
	@Override
	public E push(E item) {

		// 혹시 가득 찾을 수도 있으니 빵
		if (size == array.length) {
			resize();
		}

		array[size - 1] = item;
		size++;

		return item;
	}

	// pop는 stack의 자료형의 요구처럼 맨 위의 데이터를 제거하는것임.
	// 또한 없는 데이터의 에러 EmptyStackException 를 발생시킨다.
	@Override
	public E pop() {

		// 즉 애초에 데이터 조차 업는데 제거를 시도할시 에러 출력
		if (size == 0) {
			throw new EmptyStackException();
		}
		E obj = (E) array[size - 1];

		array[size - 1] = null;
		// 또한 제거했는데 size가 용적의 절반이 되엇다면 용적남비이니깐 그런 케이스도 처리
		if (size < (array.length) / 2) {
			resize();
		}
		size--;

		return obj;
	}

	// 가장 상단에 있는 데이터를 확인만
	@Override
	public E peek() {
		// 즉 데이터조차 없는데 조회를 하면 에러 던지자.
		if (size == 0) {
			throw new EmptyStackException();
		}
		E obj = (E) array[size - 1];

		return obj;
	}

	// 찾으려는 데이터가 상단의 데이터로부터 얼마만큼 떨어져 있는지'에 대한 상대적 위치 값
	// Top으로부터 떨어져있는 거리를 의미한다 단 Top 데이터 자체라면 1 이며 1부터 시작한다.

	@Override
	public int search(Object value) {

		if (value == null) {

			for (int idx = size - 1; idx >= 0; idx--) {
				if (array[idx] == null) {
					return size - idx;
				}
			}

		} else {
			// 초기값은 idx 배열의 마지막값 즉 top의 index를 가르킴
			for (int idx = size - 1; idx >= 0; idx--) {
				
				if (array[idx].equals(value)) {
					
					// 아우 배열 index가 지랄맞는데 아무튼
					//첫 최상단 값이라면 size-size+1 이 되어 탑은 1다.
					//앞서 이야기 했지만 주의할건 stack에서의 search는 탑으로부터 거리이며 1부터시작한다.
					return size - idx;
					
				}
			}

		}

		return -1;
	}

	@Override
	public int size() {
		
		return size;
	}

	@Override
	public void clear() {
	
		// 저장되어있던 모든 요소를 null 처리 해준다.
		for(int i = 0; i < size; i++) {
			array[i] = null;
		}
		
		size = 0;
		resize();

	}

	//말그대로 비어있니 즉 요소가 없니 물어본다.
	@Override
	public boolean empty() {
		// TODO Auto-generated method stub
		return size==0;
	}

}
