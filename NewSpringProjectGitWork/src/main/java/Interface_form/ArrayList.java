package Interface_form;

import edu.emory.mathcs.backport.java.util.Arrays;

public class ArrayList<E> implements List<E> {

	private static final int DEFAULT_CAPACITY = 10; // 최소(기본) 용적 크기 (용적의 크기임 요소개수아님)

	private static final Object[] EMPTY_ARRAY = {}; // 빈 배열

	private int size; // 요소 개수 (요소의 개수임! 용적 사이즈 아님 주의)

	Object[] array; // 요소를 담을 배열

	// 생성자1 (초기 공간=길이 할당 X)
	public ArrayList() {
		this.array = EMPTY_ARRAY;
		this.size = 0;

	}

	// 생성자2 (초기 공간=길이 할당 O)
	public ArrayList(int capacity) {
		this.array = new Object[capacity];
		this.size = 0;
	}

	// 주의할건 역시 (size는 요소(원소)의 개수를 의미하는 것이다. 공간을 할당해놓는 것하고는 다른 개념이다.)

	private void resize() {
		int array_capacity = array.length;
		// 용적이 0이라면?
		// 주소가 아닌 값을 비교해야 하기 때문에 Arrays.equals() 메소드를 사용하도록 하자.
		if (Arrays.equals(array, EMPTY_ARRAY)) {
			// 기본 용적을 갖는 배열로 만든다.
			array = new Object[DEFAULT_CAPACITY];
			return;

		}

		// 요소가 꽉찬경우
		if (size == array_capacity) {
			int new_capacity = array_capacity * 2;

			array = Arrays.copyOf(array, new_capacity);
			return;
		}

		// 용적의 절반 미만으로 요소가 차지하고 있을 경우
		if (size < (array_capacity) / 2) {
			int new_capacity = array_capacity / 2;
			// 기본용적 또는 1/2 때린 갑중 큰 용적으로 다시 세팅한다.
			array = Arrays.copyOf(array, Math.max(new_capacity, DEFAULT_CAPACITY));
			return;
		}

	}

	// 기본삽입 : add(E value) & addLast(E value) 메소드
	// 자바 기본제공 add도 디펄트가 맨뒤에 추가됨을 잊지 말자.!!

	@Override
	public boolean add(E value) {
		// 따라서 디펄트로 마지막에 추가하는걸 만든다.
		addLast(value);
		return false;
	}

	public void addLast(E value) {

		// 기존 Array가 용적이 꽉차이는경우라면 재할당.
		if (size == array.length) {
			resize();
		}

		// 그리고 일반 배열첨 하던대로 그냥 집어 넣으면된다.
		// 자꾸 말하지만 size는 요소의 갯수임!! 리사이즈는 용적량이고
		array[size] = value;
		// 그리고 사이즈 1 증가 시키자.
		size++;

	}

	// 2. 중간삽입 : add(int index, E value)

	@Override
	public void add(int index, E value) {
		// 영역을 벗어날 경우 예외 발생
		if (index >= size || index < 0) {
			throw new IndexOutOfBoundsException();
		}

		// index가 마지막 위치라면 addLast 메소드로 요소추가
		if (index == size) {
			addLast(value);
		} else {
			// 꽉차있다면 용적 재할당
			if (size == array.length) {
				resize();
			}

			// 현재는 꽉차있는 용적 재할당을 뚫고 온것이기에 array[size] 해도 인덱스아웃 익셉션 없음.
			// index 기준 후자에 있는 모든 요소들 한 칸씩 뒤로 밀기
			for (int i = size; i > index; i--) {
				array[i] = array[i - 1];
			}
			// 이제 index기준으로 다 오른쪽으로 한칸씩 밀렷기에 빈공간에 집어 넣자.
			array[index] = value;
			// 그다음 용적의 개수 1 증가
			size++;

		}

	}

	// 사실 위에서 메서드를 만들엇으니 근야 바로 중첩 호출하면 된다.
	public void addFirst(E value) {
		add(0, value);
	}

	// 검색하여 가져오는 메서드이다.
	@Override
	public E get(int index) {
		if (index > size || index < 0) {

			throw new IndexOutOfBoundsException();
		}

		// 마찬가지로 일반 배열이 제공하는 가져오세요 기법을 쓰면된다.
		// 주의 할건 Object[] 기반으로 만들고 있기에 캐스팅이 필요하다.
		E value = (E) array[index];

		return value;

	}

	// 2. set(int index, E value) 메소드
	// set 메소드는 기존에 index에 위치한 데이터를 새로운 데이터(value)으로 '교체'하는 것
	@Override
	public void set(int index, E value) {
		if (index > size || index < 0) {
			throw new IndexOutOfBoundsException();
		}

		array[index] = value;
	}

	// 3. indexOf(Object value) 메소드
	// 요소의 인덱스를 반환한다는 것이다.
	@Override
	public int indexOf(Object value) {
		int i = 0;

		// 이건 반복문 돌려서 찾아도됨
		for (int k = 0; k < size; k++) {

			if (value.equals(array[k])) {
				i = k;
				return i;
			}

		}

		// 반복문으로 돌려보고 없다면 -1을 반환한다.
		return -1;
	}

	// 3 - 1. LastindexOf(Object value) 메소드
	// 거꾸로 탐색을 해보자.
	public int lastIndexOf(Object value) {
		int i = 0;
		for (int k = size - 1; k >= 0; k--) {
			if (value.equals(array[k])) {
				i = k;
				return i;
			}
		}

		return -1;
	}

	// 4. contains(Object value) 메소드
	// contains는 사용자가 찾고자 하는 요소(value)가 존재 하는지 안하는지를 반환

	@Override
	public boolean contains(Object value) {
		int index = indexOf(value);
		if (index != -1) {
			return true;
		}

		return false;
	}

//	[remove 메소드 구현]
	// 특정 인덱스로 요소를 삭제
	@Override
	public E remove(int index) {

		if (index > size || index < 0) {
			throw new IndexOutOfBoundsException();
		}

		E element = (E) array[index]; // 삭제될 요소를 반환하기 위해 임시로 담아둠
		array[index] = null;

		for (int k = index; k < size - 1; k++) {
			// 먼저 왼쪽으로 당겨 덮어쓰고
			array[k] = array[k + 1];
			// 당김당한 원래놈은 null로 바꿔주자.
			array[k + 1] = null;
		}
		// 요소를 제거했으니 요소갯수를 줄인다.
		size--;
		resize();
		return element;
	}

	//// 특정 요소로 찾아 요소를 삭제
	@Override
	public boolean remove(Object value) {
		int findindex = indexOf(value);
		if (findindex >= 0) {
			remove(findindex);
			return true;
		}
		return false;
	}

	// 말그대로 요소의 개수를 반환한다.
	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {

		if (size == 0) {
			return true;
		}

		return false;
	}

//3. clear() 메소드 요소들을 비워버린다.

	@Override
	public void clear() {

		for (int k = 0; k < size; k++) {
			array[k] = null;
		}
		size = 0;
		
		resize();
	}

}
