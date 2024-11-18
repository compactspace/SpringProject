package DLinkedList;

public class DLinkedListTestMain {

	public static void main(String[] args) {
		DLinkedList<String> dlink= new DLinkedList<String>();
		//주의해라 add 는 꼬리에다가 추가하도록 로직이 짜여있음..
		dlink.add("하1");
		dlink.add("하2");
		dlink.add("하3");
		dlink.add("하4");
		
		
		//search 의 for문에서 
		//k =>index 가아닌  k >index 인 이유는? 이전 노드를 prev로 찾을꺼니깐
		// = 붙이면 값이 틀리게나온다. 1-2-3-4  노드가 있는데
		// index =3 이라면 리턴이 3 이고
		// index =2 라면? 리턴이 2 이다.
		//한번 = 을 붙여보면안다.
		//System.out.println("index 3:"+dlink.search(3).data);
		//System.out.println("index 2:"+dlink.search(2).data);		
		
		System.out.println(dlink.lastindexOf("하4"));
		dlink.clear();
		System.out.println("클리어 진행후 사이즈 확인: "+dlink.size());
		
		
		
//		dlink.remove("하2");		
//		System.out.println("삭제된 하2가 포함되어있니?: "+dlink.contains("하2"));
//		System.out.println("삭제된 하1가 포함되어있니?: "+dlink.contains("하1"));
//		System.out.println("옳바르게 삭제 되엇다면 index 1번은 하3가 와야함: "+dlink.get(1));

	}

}
