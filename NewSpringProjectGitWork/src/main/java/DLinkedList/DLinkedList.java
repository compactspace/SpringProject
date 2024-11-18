package DLinkedList;

import java.util.NoSuchElementException;

import org.hibernate.internal.build.AllowSysOut;

import Interface_form.List;

public class DLinkedList<E> implements List<E> {

	private Node<E> head; // 노드의 첫 부분
	private Node<E> tail; // 노드의 마지막 부분
	public int size; // 요소 개수

	public DLinkedList() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}

	// [search 메소드 구현]
	// 자료구조들도 만약 가능하다면 검색(탐색) 메소드부터 구현해놓는 것이 매우 편리하다.
	// 또한 양뱡향 이니 head 또는 tail에 가까울지 케이스로 구현

	// 특정 위치의 노드를 반환하는 메소드
	// 개발 확인용으로 잠시 public처리
	public Node<E> search(int index) {

		// System.out.println("서치펑션 index: "+index+" 그리고 size: "+size);

		if (index >= size || index < 0) {
			throw new IndexOutOfBoundsException();
		}

		// 뒤에서검색=꼬리=size값부터
		// 그니깐 요청 index의 값이 절반보다 크다면 뒤부터 탐색이 유리하다 뭐다 그런거

		if (index + 1 > size / 2) {
			Node<E> x = tail;

			// k =>index 가아닌 k >index 인 이유는? 이전 노드를 prev로 찾을꺼니깐
			// = 붙이면 값이 틀리게나온다. 1-2-3-4 노드가 있는데
			// index =3 이라면 리턴이 3 이고
			// index =2 라면? 리턴이 2 이다.
			for (int k = size - 1; k > index; k--) {
				// System.out.println("x.prev: "+x.prev);
				x = x.prev;
			}

			return x;

		} else {
			Node<E> x = head;

			for (int k = 0; k < index; k++) {
				// System.out.println("x.next: "+x.next);
				x = x.next;

			}

			return x;

		}

	}

	// 1. addFisrt(E value)
	public void addFirst(E value) {
		// 말그대로 입력값 으로 노드객체 생성
		Node<E> newNode = new Node<E>(value);
		// 이제 새로운 노드의 넥스트인 이전head를 가르키도록
		newNode.next = head;

		/**
		 * head가 null이 아닐 경우에만 기존 head노드의 prev 변수가 새 노드를 가리키도록 한다. 이유는 기존 head노드가 없는
		 * 경우(null)는 데이터가 아무 것도 없던 상태였으므로 head.prev를 하면 잘못된 참조가 된다.
		 */
		if (head != null) {
			head.prev = newNode;
		}
		// 그다음 현재 DLinked의 head는 newNode가 되야함
		head = newNode;
		size++;

		// 한편 최초 삽입이라면 head의 넥스트는 null이므로
		if (head.next == null) {
			tail = head;
		}
		// 주의 해라 최초 삽입이 아닌 2번째 삽입 이상부터라 해보자.
		// 그러면 tail은 여전히 최초 삽입값을 가르키고 있음으로 걱정할필요가 없음

	}

	@Override
	public boolean add(E value) {
		addLast(value);
		return true;
	}

	// 말그대로 마지막에 삽입시도
	public void addLast(E value) {
		Node<E> newNode = new Node<E>(value);

		// 최초삽입.
		if (size == 0) {
			// System.out.println("최초삽입닙니까?");
			addFirst(value);
			return;
		}

		// 최초 삽입이 아닌 경우
		Node<E> origintail = tail;
		System.out.println("tail: " + tail);
		origintail.next = newNode;
		newNode.prev = origintail;
		tail = newNode;
		// System.out.println("마지막노드의 데이터값: "+tail.data);
		size++;

	}

	@Override
	public void add(int index, E value) {
		// 잘못된 인덱스를 참조할 경우 예외 발생
		if (index > size || index < 0) {
			throw new IndexOutOfBoundsException();
		}
		// index가 최초냐 마지막이냐 인경우
		if (index == 0) {
			addFirst(value);
			return;
		}

		if (index == size - 1) {
			addLast(value);
			return;
		}

		// 이제부턴 사이값에 대한처리
		Node<E> newNode = new Node<E>(value);

		// index 로 삽입후 삽입된 노드를 가르키도록 하는 이전노드를 찾는다.
		Node<E> prevNode = search(index - 1);
		Node<E> nextNode = prevNode.next;
		// 따라서 다음노드를 newNode로 변경하고
		prevNode.next = newNode;
		nextNode.prev = newNode;
		newNode.prev = prevNode;
		newNode.next = nextNode;

		size++;

	}
//[remove 메소드 구현]
	// 역시 index 가 처음 이나 마지막이냐 사이값이냐로 분기처리

	// 가장 앞을 제거한다.
	public E remove() {
		// 말그대로 맨 앞에 있는걸 가져온다.
		Node<E> headNode = head;
		// 즉 노드가 siez=0
		if (headNode == null) {
			throw new NoSuchElementException();
		}

		// 삭제된 노드를 반환하기 위한 임시 변수
		E element = headNode.data;

		// head의 다음 노드
		Node<E> nextNode = head.next;

		// head 노드의 데이터들을 모두 삭제
		head.data = null;
		head.next = null;

		// 즉 넥스트노드가 널이 아니라면 이전 prev객체 노드를 가지고 있는데 위에서 삭제하려 null처리 했으니
		// 뭔 이상값을 참조할거같으니 null처리한다.
		if (nextNode != null) {
			nextNode.prev = null;
		}

		head = nextNode;
		size--;

		// 삭제된 요소가 유일한 한개의 노드엿다면 즉 nextNode=null
		if (size == 0) {
			tail = null;
		}

		return element;
	}

// 특정 위치(index)를 리스트에서 찾아서 삭제하는 것이다.	 add(int index, E value) 와 정반대로 구현해주면됨
	@Override
	public E remove(int index) {

		if (index >= size || index < 0) {
			throw new IndexOutOfBoundsException();
		}

		if (index == 0) {
			E element = head.data;
			remove();
			return element;
		}
		// System.out.println("받은 index: "+index);
		Node<E> prevNode = search(index - 1);
//System.out.println("prevNode: "+prevNode+" 그리고  prevNode.data: "+prevNode.data);

		Node<E> removeNode = prevNode.next;
		// System.out.println("prevNode.next: "+prevNode.next);

		Node<E> NextNode = removeNode.next;

		prevNode.next = NextNode;
		// 한편 NextNode=null 즉 운나빠서 마지막노드 제거를 했다고 친다면?
		// 여기서 NextNode.prev를 처리하면 널포인트 익셉션등 빠지니 밑에서 처리한다. 주석처리
		// NextNode.prev=prevNode;

		E element = removeNode.data;

		removeNode.data = null;
		removeNode.prev = null;
		removeNode.next = null;
		removeNode = null;

		// 바로 위에서 하면 오류위험이있음
		if (NextNode != null) {

			NextNode.prev = prevNode;
			prevNode.next = NextNode;

		} else {
			// 즉 널인경우는 마지막에 존재하는 노드를 삭제 했단 소리이다.
			// 따라서 tail는 prevNode; 이다.
			tail = prevNode;
		}

		size--;

		return element;
	}

//다만 고려해야 할 점은 '삭제하려는 요소가 존재하는지'를 염두해두어야 함	
	@Override
	public boolean remove(Object value) {

		int index = 0;
		Node<E> x = head;
		boolean check = false;

		for (x = head; x != null;) {
			E data = x.data;
			// System.out.println("받은값: "+value+"비교대상값:"+data+"컨테인 메서드속 value가 같니?:
			// "+value.equals(x.next));
			if (value.equals(data)) {
				check = true;
				break;
			}
			x = x.next;
			// 노상관 운좋게 0번에서 걸리면 바로 if문 break와 위 초기화 값 0으로 가능
			index++;
			check = false;
		}

		// System.out.println("포문 탈출후 인덱스값: " +index+" check 값: "+check);

		if (check) {

			// System.out.println("check가 true일시 index값: "+index);

			if (index == 0) {
				remove();
				return true;
			}
			remove(index);
			return true;

		}
		return false;
	}

	@Override
	public E get(int index) {

		Node<E> searchNode = search(index);
		// System.out.println("getNode: "+searchNode);

		return searchNode.data;
	}

	@Override
	public boolean contains(Object value) {
		int index = 0;
		Node<E> x = head;
		for (x = head; x != null;) {
			E data = x.data;
			// System.out.println("받은값: "+value+"비교대상값:"+data+"컨테인 메서드속 value가 같니?:
			// "+value.equals(x.next));
			if (value.equals(data)) {
				break;
			}
			x = x.next;
			// 노상관 운좋게 0번에서 걸리면 바로 if문 break와 위 초기화 값 0으로 가능
			index++;
		}

		if (x != null) {
			return true;
		}

		return false;
	}

	// set은 '교체'라는 점을 기억해두도록 하자.
	@Override
	public void set(int index, E value) {
		System.out.println("set펑션 받은 index: " + index + " 받은 벨류: " + value);
		if (index > size || index < 0) {
			throw new IndexOutOfBoundsException();
		}

		Node<E> serchNode = search(index);
		serchNode.data = value;

	}

	// 이건 head 부터 찾는거고 tail부터 찾는것은 따로 만든다.
	@Override
	public int indexOf(Object value) {

		int index = 0;
		for (Node<E> x = head; x.next != null;) {

			if (x.data.equals(value)) {
				return index;
			}
			x = x.next;
			index++;
		}

		return -1;
	}

	public int lastindexOf(Object value) {

		int index = size;

		for (Node<E> x = tail; x.prev != null;) {

			if (x.data.equals(value)) {
				System.out.println("역방향 리턴직전 index: " + index);
				return index;
			}
			x = x.prev;
			index--;
		}

		System.out.println("역방향 값을 못찾은 경우 index: " + index);
		return -1;
	}

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

	// 모든 요소를 지워버린다.
	// 그냥 객체 자체를 null 해주기 보다는 모든 노드를 하나하나 null 해주는 것이
	// 자바의 가비지 컬렉터가 명시적으로 해당 메모리를 안쓴다고 인지하기 떄문에 메모리 관리 효율 측면에서 조금이나마 더 좋다.
	@Override
	public void clear() {
		
		//이게 머리가 안돌아가네 어휴
		for (Node<E> x = head; x.next != null;) {
			//최초 반복에서 head의 다음것을 가져온다.
			Node<E> nextNode=x.next;
			
			//System.out.println("x.next: "+x.next+" x.prev: "+x.prev+" x.data: "+x.data);
			//최초 반복에서 head의 필드들을 초기화 한다.
			x.next=null;
			x.prev=null;
			x.data=null;
			//그다음 반복변수 x 에 x의다음갑을 넣는다.
			x=nextNode;			
		}
		//그다음 head,tail을 널로 만들자. 위 반복문에선 head와 tail이 제외니깐
		head=null;
		tail=null;
		//마찬가지로 size도 0으로!
		size=0;

	}

}
