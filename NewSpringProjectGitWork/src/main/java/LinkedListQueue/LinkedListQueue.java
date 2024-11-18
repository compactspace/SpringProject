package LinkedListQueue;

import java.util.NoSuchElementException;

import Interface_form.Queue;

public class LinkedListQueue<E> implements Queue<E> {

	private Node<E> head;
	private Node<E> tail;
	private int size;

	public LinkedListQueue() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}

	// [offer 메소드 구현]
	@Override
	public boolean offer(E e) {
		// 이제는 연결리스트 큐로 연결대상이 노드니깐 뭐...할말더이상 없음
		Node<E> newNode = new Node<E>(e);

		// 즉 최초 삽입인경우
		if (size == 0) {
			head = newNode;

			// 주의 해라..지금은 큐니깐 마지막에 추가해야함.
		} else {
			// 따라서 현재 꼬리의 다음을 뉴노드로 하고
			tail.next = newNode;
		}

		// 현재 꼬리를 newNode 로 한다잉
		tail = newNode;

		size++;

		return true;
	}

	// 주의할껀 현재 큐를 만들고있으니 선입선출로 가장 앞의 노드를 제거 해야한다.
	@Override
	public E poll() {

		if (size == 0) {
			return null;
		}
		// 주의. 지금은 노드의 필드 data를 담은것
		E deltarget = head.data;

		// head 노드의 다음노드
		Node<E> nextNode = head.next;

		head.data = null;
		head.next = null;

		head = nextNode;

		size--;

		return deltarget;
	}

	// 주의할건 리무브는 없을시 에러를 던지라한다.
	// 또한 큐는 맨 앞에 있는 것을 제거하는것이다.
	public E remove() {
		E e = poll();
		if (e == null) {
			throw new NoSuchElementException();
		}

		return e;

	}

	// 가장 앞에 있는 데이터(head.data)를 확인만
	@Override
	public E peek() {

		if (size == 0) {
			return null;
		}

		return head.data;
	}

	// element() 메소드 peek와 같으나 단 없을시 에러를 던지는게 특징이다.

	public E element() {
		E e = peek();
		if (e == null) {
			throw new NoSuchElementException();
		}
		return e;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	// 현재 찾고자하는 요소가 큐에 들어가있는지를 알려주는 메소드
	public boolean contains(Object value) {

		for (Node<E> x = head; x.next != null;) {
			if (value.equals(value)) {
				return true;
			}
			x = x.next;
		}

		return false;
	}
	//clear() 메소드는 단어 그대로 Queue의 모든 요소를 비워버린다.
	public void clear() {
		
		for (Node<E> x = head; x.next != null;) {
			Node<E> nextNode=x.next;
				x.next=null;
				x.data=null;
				x=nextNode;
		}
		size=0;
		head = tail = null;
		
	}
	

}
