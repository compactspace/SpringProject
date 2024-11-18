package Heap;

import java.util.Comparator;
import java.util.NoSuchElementException;

public class Heap<E> {

	private final Comparator<? super E> comparator;

	private static final int DEFAULT_CAPACITY = 10; // 최소(기본) 용적 크기

	private int size; // 요소 개수

	public Object[] array; // 요소를 담을 배열

	// 생성자 Type 1 (초기 공간 할당 X)
	public Heap() {

		this(null);
	}

	public Heap(Comparator<? super E> comparator) {
		System.out.println(comparator);
		this.array = new Object[DEFAULT_CAPACITY];
		this.size = 0;
		this.comparator = comparator;
	}

	// 생성자 Type 2 (초기 공간 할당 O)
	public Heap(int capacity) {
		this(capacity, null);
	}

	public Heap(int capacity, Comparator<? super E> comparator) {
		this.array = new Object[capacity];
		this.size = 0;
		this.comparator = comparator;
	}

	// 매개변수 index로 받은 부모노드 인덱스 리턴
	private int getParent(int index) {
		// 레벨 n의 index 는 짝 또는 홀이다.
		// 그리고 부모레벨을 k라 하자 즉 k<n 이라하자.
		// index=2^n+j 이라하자.
		// index / 2; <=> 2^(n-1)+j이다.
		// n-1<n 으로 이는 k레벨의 원소를 의미한다.
		// 그런데 index 가 홀수이면 index-1은 짝수이므로
		// 이는 같은 부모를 공유하기에 (index-1)/2=2^n-1 꼴로 역시 k레벨의 원소이며 부모의 노드는 짝수이므로
		// 따라서 이는 연산의 결과가 아닌 가르키는 노드가 짝수임을 뜻하므로 부모노드를 리턴한다.
		return index / 2;
	}

	// 받은 인덱스의 왼쪽 자식 노드 인덱스를 반환
	private int getLeftChild(int index) {
		// 레벨 n 이라 하자. 그러면 인덱스는
		// [2^n, (1-2^n)+2^n] 이다.
		// 그리고 이들은 쌍으로 짝홀이다.
		// 2^n<q< (1-2^n)+2^n 인 q=2^n+j가 홀이라하자.
		// k가 n의 다음레벨 이라면
		// [2^k, (1-2^k)+2^k] 이고, q의 왼쪽 자식노드는 짝수이므로 2k꼴이다.
		// q=2^n+j는 홀수이므로 (2^n+j)*2 는 짝수이이다.
		// 2^(n+1)+j 이고 n+1>n으로 이는 이전 레벨 n의 원소가 아니다.
		// 따라서 q*2는 다음레벨 k의 원소이다.
		// 그런데 k레벨 역시 쌍으로 짝홀을 가짐으로 따라서 q*2는 왼쪽자식노드를 가르킨다.

		return index * 2;
	}

	// 받은 인덱스의 오른쪽 자식 노드 인덱스를 반환
	private int getRightChild(int index) {
		// 비슷하게 짝수정리로 index * 2 는 다음레벨의 왼쪽짝수노드이므로 +1는 홀수이다.
		return (index * 2) + 1;
	}

	// [resize 메소드 구현]
	// 모든 자료구조는 기본적으로 동적으로 만들 수 있어야 한다.
	/**
	 * @param newCapacity 새로운 용적 크기
	 */
	private void resize(int newCapacity) {

		Object[] newArray = new Object[newCapacity];
		// 새 배열에 기존에 있던 배열의 요소들을 모두 복사해준다.
		for (int i = 1; i <= size; i++) {
			newArray[i] = array[i];
		}

		/*
		 * 현재 배열은 GC 처리를 위해 null로 처리한 뒤, 새 배열을 연결해준다.
		 */
		this.array = null;
		this.array = newArray;

	}

	public void add(E value) {

		// 배열 용적이 꽉 차있을 경우 용적을 두 배로 늘려준다.
		if (size + 1 == array.length) {
			resize(array.length * 2);
		}

		// 개발자 취향인데 인덱스가 1부터인 heap을 만들려고 size+1로 시작하는듯
		siftUp(size + 1, value); // 가장 마지막에 추가 되는 위치와 넣을 값(타겟)을 넘겨줌
		size++; // 정상적으로 재배치가 끝나면 사이즈를 증가
	}

	// 상향 선별
	/**
	 * @param idx    추가할 노드의 인덱스
	 * @param target 재배치 할 노드
	 */
	private void siftUp(int idx, E target) {
		// comparator가 존재할 경우 comparator 을 인자로 넘겨준다.
		if (comparator != null) {
			siftUpComparator(idx, target, comparator);
			// comparable 로 할경우
		} else {
			siftUpComparable(idx, target);
		}
	}

	// Comparator을 이용한 sift-up
	@SuppressWarnings("unchecked")
	// 흐름이 길어지는데 idx:size+1로 넘어온 값 이고 target:는 add펑션 호출시 삽입되는 value값이다.
	private void siftUpComparator(int idx, E target, Comparator<? super E> comp) {

		// root노드보다 클 때까지만 탐색한다.
		while (idx > 1) {
			// 위에서 구한 메서드로 부모노드의 인덱스를 리턴한다.
			int parent = getParent(idx); // 삽입노드의 부모노드 인덱스 구하기
			//
			Object parentVal = array[parent]; // 부모노드의 값

			// 타겟 노드 값이 부모노드보다 크면 반복문 종료
			if (comp.compare(target, (E) parentVal) >= 0) {
				break;
			}

			/*
			 * 부모노드가 타겟노드보다 크므로 현재 삽입 될 위치에 부모노드 값으로 교체해주고 타겟 노드의 위치를 부모노드의 위치로 변경해준다.
			 */
			array[idx] = parentVal;
			idx = parent;
		}

		// 최종적으로 삽입될 위치에 타겟 노드 값을 저장해준다.
		array[idx] = target;
	}

	/**
	 * @param idx    추가할 노드의 인덱스
	 * @param target 재배치 할 노드
	 */
	// 삽입 할 객체의 Comparable을 이용한 sift-up
	@SuppressWarnings("unchecked")
	private void siftUpComparable(int idx, E target) {

		//System.out.println("idx: " + idx);
		// 타겟노드가 비교 될 수 있도록 한 변수를 만든다.
		Comparable<? super E> comp = (Comparable<? super E>) target;

		while (idx > 1) {

			// 삽입시도 인덱스의 부모 노드 인덱스를 찾는다.
			int parent = getParent(idx);
			// 그다음 부모노드를 가져온다.
			Object parentVal = array[parent];
			// 명심해라 2진트리의 약속임 부모의 노드값은 자식의 노드값보다 작아야한다!!.

			// 그다음 Comparable 인터페이스의 의 public 메서드 compareTo를 용한다.
			// 크다는것은 자식노드로 합격이란 소리로 바로 while문 탈출
			if (comp.compareTo((E) parentVal) >= 0) {
				break;
			}

			// if문을 타지 못했다면?
			// 삽입시도 노드가 더 작다는 이야기로 <=>명심해라 2진트리의 약속임 부모의 노드값은 자식의 노드값보다 작아야한다!!.
			// 즉 배재치를 요한다.

			// 따라서 삽입시도 인덱스 idx 노드에 원래의 부모값을 넣어 위치를 내려준다.
			array[idx] = parentVal;

			// 그다음 while문을 타야 함으로 기존 부모노드 인덱스로 바꿔치기한다.
			idx = parent;
			// 다시 while문을 탄다.

		}
		// 반복문 탈출후 재배치가 된것으로 이제 삽입한다.
		array[idx] = comp;
	}

//[remove 메소드 구현]
	// 주의해라 모델 자체가
//애초에 최상위 루투를 삭제한뒤
// 제일큰 노드를 가져와서 계속 재배열을 해나가는 것이다. 
	// 모델 대로 만들어야한다..!!
	public E remove() {
		if (array[1] == null) {
			// 만약 root가 비어있을경우 예외를 던지도록 함
			throw new NoSuchElementException();
		}
		// 최상위 노드 즉 삭제된 요소를 반환하기 위한 임시 변수
		// 또 주의하라. 애초에 이번 모델 자체가 1번방부터 데이터를 넣는 방식이다. 즉 그래서 최상위 노드값 인덱스가 1 이다.
		E result = (E) array[1];

		System.out.println("(E) array[0]: "+(E) array[0]+"그리고  (E) array[1]"+(E) array[1]);
		
		// 타겟이될요소: 최상위 노드 삭제후, 재배치에 기준이될 제일큰 노드
		E target;
		if (size == 1) {
			target = null;
		} else {
			target = (E) array[size];
		}

		array[size] = null; // 타겟 노드를 비운다.

		// 삭제할 노드의 인덱스와 이후 재배치 할 타겟 노드를 넘겨준다.
		//System.out.println("target: "+target);
		siftDown(1, target); // 루트 노드가 삭제되므로 1을 넘겨준다.

		return result;

	}

	/**
	 * @param idx    삭제할 노드의 인덱스
	 * @param target 재배치 할 노드
	 */
	private void siftDown(int idx, E target) {
		// comparator가 존재할 경우 comparator 을 인자로 넘겨준다.
		if (comparator != null) {
			siftDownComparator(idx, target, comparator);
		} else {
			//siftDownComparable(idx, target);
			change(idx,target);
		}
	}

	// Comparator을 이용한 sift-down
	@SuppressWarnings("unchecked")
	private void siftDownComparator(int idx, E target, Comparator<? super E> comp) {

		array[idx] = null; // 삭제 할 인덱스의 노드를 삭제
		size--;

		int parent = idx; // 삭제노드부터 시작 할 부모를 가리키는 변수
		int child; // 교환 될 자식을 가리키는 변수

		// 왼쪽 자식 노드의 인덱스가 요소의 개수보다 작을 때 까지 반복
		while ((child = getLeftChild(parent)) <= size) {

			int right = getRightChild(parent); // 오른쪽 자식 인덱스

			Object childVal = array[child]; // 왼쪽 자식의 값 (교환 될 값)

			/*
			 * 오른쪽 자식 인덱스가 size를 넘지 않으면서 왼쪽 자식이 오른쪽 자식보다 큰 경우 재배치 할 노드는 작은 자식과 비교해야하므로
			 * child와 childVal을 오른쪽 자식으로 바꿔준다.
			 */
			if (right <= size && comp.compare((E) childVal, (E) array[right]) > 0) {
				child = right;
				childVal = array[child];
			}

			// 재배치 할 노드가 자식 노드보다 작을경우 반복문을 종료한다.
			if (comp.compare(target, (E) childVal) <= 0) {
				break;
			}

			/*
			 * 현재 부모 인덱스에 자식 노드 값을 대체해주고 부모 인덱스를 자식 인덱스로 교체
			 */
			array[parent] = childVal;
			parent = child;
		}

		// 최종적으로 재배치 되는 위치에 타겟이 된 값을 넣어준다.
		array[parent] = target;

		/*
		 * 용적의 사이즈가 최소 용적보다는 크면서 요소의 개수가 전체 용적의 1/4일경우 용적을 반으로 줄임(단, 최소용적보단 커야함)
		 */
		if (array.length > DEFAULT_CAPACITY && size < array.length / 4) {
			resize(Math.max(DEFAULT_CAPACITY, array.length / 2));
		}

	}

	// Comparable을 이용한 sift-down
	@SuppressWarnings("unchecked")
	private void siftDownComparable(int idx, E target) {

		Comparable<? super E> comp = (Comparable<? super E>) target;

		array[idx] = null;
		size--;

		// 매개변수로 넘어온 초기값 idx=1 임에 명심하자.
		int parent = idx;

		// 제일왼쪽노드 의 인덱스 담을 변수
		int child;

		// 차일드값을 while 조건문에서 초기화 하고있음을 명심
		while ((child = getLeftChild(parent)) <= size) {

			int right = getRightChild(parent);

			
			System.out.println("왼쪽: "+child+" 오른쩍: "+right);
			
			// 왼쪽노드이다.
			Object childVal = array[child];
			System.out.println("초기화전 childVal: "+childVal);
			// 자식의 대소 비교도 중요하다.
			// 즉 자식으 13 56 이라 해보자.
			// 그다음 target 노드가 100이라 해보자.
			// 만약 자식노드 비교없이 그저 100과 56을 바꾸면 부모노드가 56 이 되고
			// 자식노드가 13 100으로 교체 되는데 왼쪽 노드가13 으로 이는 부모노드가 더 크게되어 위배된다.
			// 따라서 먼저 자식노드에서 왼쪽에 작은걸 더 넣으도록 재배치 한다.
			if (right <= size && ((Comparable<? super E>) childVal).compareTo((E) array[right]) > 0) {

				child = right;
				childVal = array[child];
			}

			System.out.println("초기화후 childVal: "+childVal);
			
			// 위 if문에서 자식노드가 작은순으로 배치되었다.
			// 그다음 바꿀 타겟과 그 작은 노드를 비교한다.
			if (comp.compareTo((E) childVal) <= 0) {
				// 참이라면 와일문을 탈출한다.
				break;
			}

			// 위 if문을 타지 못한경우로
			// 다시 작은순으로 재배열된 왼쪽과 타겟노드 위아래를 바꾸어준다. 또한 인덱스도 부모워 원래인덱스를 자식의 인덱스로 바꾼다,
			array[parent] = childVal;
			parent = child;

		}

		// 와일문 탈출후 타겟을 넣어준다.
		array[parent] = comp;

	}

	// Comparable을 이용한 sift-down
	
	/**
	 * @param targetindex 해당 배열의 사이즈 인덱스값으로
	 * 맨위에서 아래로 내려 비교하며 최하단으로 내릴 인덱스임
	 * 
	 * @param target 호출시 해당 배열의 size갑에 해당하는 값으로 비교대강 값이다.
	 * 역시 맨위에서 최하단 으로 다시 내릴 값이다.
	 * */
	
	@SuppressWarnings("unchecked")
	private void change(int targetindex, E target) {

		Comparable<? super E> comp = (Comparable<? super E>) target;

		System.out.println("comp: "+comp);
		
		
		array[targetindex] = null;
		size--;

		int leftchild ;
		int rightchild;
		
		while ((leftchild = getLeftChild(targetindex)) <= size) {	
			
			//초기값 targetindex 는 1 임을 명심하자.
			//만약 while 문을 탈출하지 못했다면 targetindex 는 다음레벨의 첫 인덱스를 가르킨다 즉 2^n꼴이다.
			rightchild=getRightChild(targetindex);
			
			System.out.println("leftchild: "+leftchild+" rightchild: "+rightchild);
			
			Object leftChildVal=(E) array[leftchild];
			
			System.out.println("초기화전 leftChildVal: "+leftChildVal);
			
			
			//먼저 좌우를 비교한다.
			// 받은 target 값이 130 이고 
			//  다음 레프트:120  롸이트:80 이라 해보자.
			//만약 130과 120을 바꾼다면?
			//  120
			// 130 80 으로 이는 2진트리에 위반한다 항상 부모는 자식보다 커야한다.
			//따라서 편의상 미리 좌 우 값을 비교해서 다시 leftChildVal에 대입한다.
			
			if(leftchild<=size && ((Comparable<? super E>)leftChildVal).compareTo((E)array[rightchild])>0) {
				leftchild=rightchild;
				leftChildVal=array[leftchild];
			}
			
			System.out.println("초기화후 leftChildVal: "+leftChildVal);
			// 이제 좌우 대소 비교가 끝난 leftChild 값과 target을 비교한다.
			//또 명심 부모는 더 작아야한다. 따라서 if문이 옳다면 break이다.
			if(comp.compareTo((E) leftChildVal)<0) {
				break;
			}				
			// 또 얼타지마라 array[targetindex]=null로 세팅되어있다.
			//만약 위 if문을 타지 못했다면 아직 target값이 더 크단소리이다.
			//따라서  더작은값 array[targetindex]=leftChildVal; 넣어준다.
			array[targetindex]=leftChildVal;
			//그다음 targetindex를 자식 인덱스를 넣어준다.
			// 즉 다음 레벨의 첫 인덱스이다.
			targetindex=leftchild;		
			
		}

		// 와일문 탈출후 타겟을 넣어준다.
				array[targetindex] = comp;
	}

}
