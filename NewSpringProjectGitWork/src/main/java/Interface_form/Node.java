package Interface_form;

class Node<E> {

	E data;
	Node<E> next; // 다음 노드객체를 가리키는 래퍼런스 변수

	//생성자로 다음 노드 만들다.
	Node(E data) {
		this.data = data;
		this.next = null;
	}
}