package Interface_form;

public class SLinkedListTestMain {

	public static void main(String[] args) {
		
		SLinkedList<String> slink= new SLinkedList<String>();
		
		//System.out.println("기본생성자 head값: "+slink.head+"기본생성자 tail값: "+slink.tail+"기본생성자 size: "+slink.size);
		slink.add("첫노드 삽입");
		//System.out.println("첫노드 삽입후 head값: "+slink.head+"첫노드 삽입후 tail값: "+slink.tail+"첫노드 삽입후 size: "+slink.size);

		
		Node<String> node=slink.search(0);
		System.out.println("해당노드의 data: "+node.data+"해당 노드의 넥스트: "+node.next);
		slink.add("두번째 노드 삽입");
		
		
		

	}

}
