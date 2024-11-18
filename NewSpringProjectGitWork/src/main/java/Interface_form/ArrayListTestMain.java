package Interface_form;

public class ArrayListTestMain {

	//오류 없는거 보니 뭐..그럭저럭 돌아가는듯
	public static void main(String[] args) {

		List<String> list = new ArrayList<String>();

		list.add("1값");
		list.add("2값");
		list.add("3값");
		System.out.println("사이즈갑: "+list.size());
		for (int k = 0; k < list.size(); k++) {
			System.out.println("index: " + k + " 요소: " + list.get(k));
			
		}
		list.clear();
		System.out.println("클리어 진행후 사이즈값: "+list.size());
	

	}

}
