package Interface_form;

import java.util.NoSuchElementException;

//단방향 연결리스트의 구현
public class SLinkedList<E> implements List<E> {

	// 그래도 개발시에는 봐야하니 잠시 필드를 public 처리한다. 나중엔 private로 밖루ㅏ.
	public Node<E> head; // 노드의 첫 부분

	public Node<E> tail; // 노드의 마지막 부분

	public int size; // 요소 개수

	// 생성자
	public SLinkedList() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}

	// 특정 위치의 노드를 반환하는 메소드
	// 주의할건 노드는 인덱스 개념이 아니고, 검색시 for을 강제로 돌리기 위한 형식적인 index이다.
	public Node<E> search(int index) {

		// 범위 밖(잘못된 위치)일 경우 예외 던지기
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}

		// 첫 노드
		Node<E> x = head;

		// 재미 있는게 여기서 배열(어레이리스트포함) 과 차이점이 있다.
		// 배열은 찾는 시간이 O(1) 이나 LinkedList는 여기서 O(n)이다.
		for (int k = 0; k < index; k++) {
			// 받은 index까지의 next 노드를 현재 head의 노드로 덮어 쓴다.
			x = x.next;
		}

		// 그다음 리턴한다.
		return x;
	}

	// [add 메소드 구현]
	// 1.맨앞에
	// 2.맨뒤에
	// 3.특정위치에

	public void addFirst(E value) {

		Node<E> newnode = new Node<E>(value);
		// 새롭게 만든 노드의 넥스트를 현재의 head라 가르키고
		newnode.next = head;
		// 현재의 헤드를 널로 하고
		head = null;
		// 현재의 헤드를 새롭게 만든 노드로 바꿔치기하자.
		head = newnode;
		size++;
		// 여기서 또 배열과 다른게 배열은 추가삭제에서 for문으로 O(n) 이였다면
		// LinkedList는 O(1) 이다.!!

		if (head.next == null) {
			tail = head;
		}

	}

	@Override
	public boolean add(E value) {
		addLast(value);
		return true;
	}

	public void addLast(E value) {
		Node<E> newNode = new Node<E>(value); // 새 노드 생성
		System.out.println("노드삽입 data: " + newNode.data + "next:" + newNode);
		System.out.println("tail: " + tail);

		if (tail == null) {
			head = newNode;
			tail = head;
		}

		System.out.println("노드삽입 data: " + newNode.data + "next:" + newNode);
		System.out.println("tail: " + tail + "head: " + head);
		// 현재의 꼬리의 다음 노드를 새롭게 생성한 노드로 덮어 씌운다.
		tail.next = newNode;
		// 그다음 기존의 꼬리를 널처리하자.
		tail = null;
		// 그다음 새롭게 만든 노드를 tail로 저장
		tail = newNode;
		size++;

		if (size == 0) { // 처음 넣는 노드일 경우 addFisrt로 추가
			addFirst(value);
			return;
		}

	}

	// 원하는 곳에 노드를 추가하자.
	@Override
	public void add(int index, E value) {
		if (index > size || index < 0) {
			throw new IndexOutOfBoundsException();
		}

		// 추가하려는 index가 가장 앞에 추가하려는 경우 addFirst 호출
		if (index == 0) {
			addFirst(value);
			return;
		}
		// 추가하려는 index가 마지막 위치일 경우 addLast 호출
		if (index == size) {
			addLast(value);
			return;
		}

		// 먼저 삽입할 노드를 먼저 생성한다.
		Node<E> newnode = new Node<E>(value);

		// 정신 차리라! serch메서드로 찾는다. 필요한건 삽입 전 인덱스와 삽입후 인덱스 에 관한 노드이다.
		// 주의해라 노드 자체는 인덱스가 아니고 서치메서드에서 형식적인 for을 돌리기위한 index이다. 노드는 index가없음
		Node<E> prevnode = search(index - 1);
		Node<E> nextnode = prevnode.next;
		// 자꾸 주의해라 노드는 인덱스개념이 없다. 저건 찾기위한 형식적인 인덱스이다.
		prevnode.next = newnode;
		newnode.next = nextnode;
		size++;

	}

	// 먼저 디펄트로 멘처음 노드를 제거하는 메서드
	public E remove() {

		// 맨처음제거다생 head를 가져온다.
		Node<E> headNode = head;

		// 맨처음 head조차 없는 경우
		if (headNode == null) {
			throw new NoSuchElementException();
		}

		// 이유는 모르겠으나 제거대상값을 미리 담아두고 리턴을 해주는형식이다.
		E data = headNode.data;

		// 맨처음의 다음 노드를 가져온다.
		Node<E> nextNode = headNode.next;

		// 그다음 head를 널 로 하고 바꿔치기 한다.

		head = null;

		head = nextNode;
		// 제거했으니 사이즈1 줄인다.
		size--;

		// 위에서 size-- 로 인해 0 이 된경우라면
		// 유일하게 한게가 있었단 소리 이다.
		// 그러면 꼬리도 null처리
		if (size == 0) {

			tail = null;
		}

		return data;
	}

	// 말그대로 노드를 인덱스로 하여 삭제한다.
	@Override
	public E remove(int index) {

		// 삭제하려는 노드가 첫 번째 원소일 경우
		// 미리 만든 첫 노드 제거함수 호출
		if (index == 0) {
			return remove();
		}

		if (index > size || index < 0) {
			throw new IndexOutOfBoundsException();
		}

		// 계속 주의해라 노드는 인덱스 개념이 없으나 형식적으로 강제 반복문을 돌려 next .next로 찾아야 하기에 필요한거임
		Node<E> preveNode = search(index - 1);

		Node<E> removeNode = search(index);

		Node<E> nextNode = removeNode.next;

		removeNode = null;

		// 이제 preveNode을 nextNode로 연결해주자.
		preveNode.next = nextNode;

		E element = removeNode.data;
		// 즉 제거대상 노드가 tail이였던 경우는?
		if (preveNode.next == null) {
			tail = preveNode;
		}

		return element;
	}

	// 3. remove(Object value) 메소드 요소로 검색하여 삭제하기
	// 먼저 존재성에 관한 true false 값이 필요하다.

	@Override
	public boolean remove(Object value) {

		Node<E> prevNode = head;

		boolean hasValue = false;

		Node<E> x = head; // removedNode

		// 역시 for 반복문으로 찾는다.
		for (; x != null; x = x.next) {

			if ((x.data).equals(value)) {
				hasValue = true;
				break;
			}

			// 사실 좀 미묘한데 if문에서 x가 걸렸다면
			// 가령 4-3-10-5-7 의 LinkedList가 있다고하자.
			// 5를 삭제하고자 한다면 5노드가 x가 되며 그다음 prevNode = x; 라 선언했으니
			// ㅍprevNode 는 1이된다
			prevNode = x;
		}

		if (x == null) {
			return false;
		}

		// 즉 삭제하려는 것이 헤드라면 첫 요소 제거함수 호출하면그만
		if (x.equals(head)) {
			remove();

			return true;

		} else {

			// 이전 노드의 링크를 삭제하려는 노드의 다음 노드로 연결
			prevNode.next = x.next;
			// 만약 삭제했던 노드가 마지막 노드라면 tail을 prevNode로 갱신
			if (prevNode.next == null) {
				tail = prevNode;
			}
			x.data = null;
			x.next = null;
			size--;
			return true;

		}

	}

//1. get(int index) 메소드
	// 주의할건 search는 노드를 리턴하고, 지금 구현할 get는 노드의 data를 리턴하면된다.
	@Override
	public E get(int index) {

		return search(index).data;
	}

	// set은 data의 를 덮어 쓰는것이다. 단 주의할건 노드엔 data와 다음 nextnode가 있는데
	// data를 덮어 쓴다는거다.
	@Override
	public void set(int index, E value) {

		Node<E> replaceNode = search(index);
		replaceNode.data = null;
		replaceNode.data = value;
	}

	// indexOf 메소드는 사용자가 찾고자 하는 요소(value)의 '위치(index)'를 반환하는 메소드다.
	@Override
	public int indexOf(Object value) {
		int index = 0;
		// 흠..뭔가 객체 포문 같은데
		for (Node<E> x = head; x != null; x = x.next) {
			if (value.equals(x)) {
				return index;
			}

			// 조심할건 0번 인덱스에서 걸릴 수 있으니 ++ 연산을 맨 밑에 두는것이다.
			index++;

		}
		return -1;
	}

	// 존재 하는지 안하는지를 반환하는 메소드다. 찾고자 하는 요소가 존재한다면 true를, 존재하지 않는다면 false를 반환한다.
	@Override
	public boolean contains(Object value) {
		if (indexOf(value) > -1) {
			return true;
		}
		return false;
	}

	@Override
	public int size() {

		return size;
	}

	@Override
	public boolean isEmpty() {

		if (size != 0) {
			return false;
		}
		return true;
	}

	@Override
	public void clear() {

		// 먼저 순서대로 지운다.
		//문제가 지금 객체 포문 때문에 해석이 꼬이는데
		for (Node<E> x = head; x != null;) {
			//첫 반복에서 헤드의 다음 노드를 가져온다.
			Node<E> nextNode = x.next;
			//그리고 x(head) 의 값과 next를 널러치
			//자꾸 주의해라! x는 data 와 다음 노드를 가르키는 Node<E>를 가지고 있는 객체이다.
			x.data = null;
			x.next = null;
			//그리고 x를 다음노드로 재초기화 그러면 x!=null 이니 반복문을 탄다.
			x = nextNode;
		}
		
		//반복문을 탈출시 x가 null 이라면 nextNode가 tail 이였음으로
		head=null;
		tail=head;
		//그리고 요소개수 역시 0으로
		size=0;
		
	}

}
