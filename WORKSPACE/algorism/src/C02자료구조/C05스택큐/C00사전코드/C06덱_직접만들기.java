package C02자료구조.C05스택큐.C00사전코드;


class DeqNode{
	int data;
	DeqNode next;
	DeqNode prev;
};
class DeqPointer
{
	DeqNode head;
	DeqNode tail;
};

public class C06덱_직접만들기 {

	public static void main(String[] args) {
		// Deque의 생성 및 초기화 ///////
		DeqPointer deq = new DeqPointer();
		DequeInit(deq);

		// 데이터 넣기 1차 ///////
		DQAddFirst(deq, 3);
		DQAddFirst(deq, 2);
		DQAddFirst(deq, 1);

		DQAddLast(deq, 4);
		DQAddLast(deq, 5);
		DQAddLast(deq, 6);


		// 전체 데이터 확인 //
		DeqNode Front = deq.head;
		System.out.printf("전체 저장 데이터 출력 : ");
		while (Front!=null)
		{
			System.out.printf("%d ", Front.data);
			Front = Front.next;
		}
		System.out.printf("\n");


		// 앞에서 데이터 꺼내기 ///////
		System.out.printf("앞에서부터 데이터 꺼내기 : ");
		while (!DQIsEmpty(deq))
			System.out.printf("%d ", DQRemoveFirst(deq));

		System.out.printf("\n");


		// 데이터 넣기 2차 ///////
		DQAddFirst(deq, 3);
		DQAddFirst(deq, 2);
		DQAddFirst(deq, 1);

		DQAddLast(deq, 4);
		DQAddLast(deq, 5);
		DQAddLast(deq, 6);

		// 전체 데이터 확인 //
		Front = deq.head;
		
		System.out.printf("전체 저장 데이터 출력 : ");
		while (Front !=null)
		{
			System.out.printf("%d ", Front.data);
			Front = Front.next;
		}

		System.out.printf("\n");



		// 끝에서 데이터 꺼내기 ///////
		System.out.printf("끝에서부터 데이터 꺼내기 : ");
		while (!DQIsEmpty(deq))
			System.out.printf("%d ", DQRemoveLast(deq));
		
	}
	
	//포인터 초기화 
	static void DequeInit(DeqPointer pdeq)
	{
		pdeq.head = null;
		pdeq.tail = null;
	}
	//텅빈상태 확인 함수
	static boolean DQIsEmpty(DeqPointer pdeq)
	{
		if (pdeq.head == null)
			return true;
		else
			return false;
	}
	// 첫노드에 삽입
	static void DQAddFirst(DeqPointer pdeq, int data)
	{
		//동적할당 + 데이터삽입 + 링크주소 NULL초기화
		DeqNode newNode = new DeqNode();
		newNode.data=data;
		newNode.next=null;
		newNode.prev=null;
				

		//노드 하나도 없을 경우
		if (pdeq.head == null)
		{
			pdeq.head = newNode;
			pdeq.tail = newNode;
		}
		//노드 하나이상 있을 경우
		else
		{
			newNode.next = pdeq.head;
			pdeq.head.prev = newNode;
			pdeq.head = newNode;
		}

	}

	//마지막 노드에 삽입
	static void DQAddLast(DeqPointer pdeq, int data)
	{

		//동적할당 + 데이터삽입 + 링크주소 NULL초기화
		DeqNode newNode = new DeqNode();
		newNode.data=data;
		newNode.next=null;
		newNode.prev=null;

		//노드 하나도 없을 경우
		if (pdeq.tail == null)
		{
			pdeq.head = newNode;
			pdeq.tail = newNode;
		}
		//노드 하나이상 있을 경우
		else
		{
			pdeq.tail.next = newNode;
			newNode.prev = pdeq.tail;
			pdeq.tail = newNode;
		}
	}


	//첫번째 노드 삭제
	static int DQRemoveFirst(DeqPointer pdeq)
	{

		//노드가 하나도 없다면 종료
		if(pdeq.head==null&&pdeq.tail==null)
			return 0;

		//반환용 변수,삭제할 구조체 포인터 하나 생성
		int rdata=pdeq.head.data;
		DeqNode rNode = pdeq.head;

		// 헤드를 다음 노드로 이동 
		//pdeq.head = pdeq.head.next;
		
		
		if(pdeq.head==pdeq.tail)//노드가 하나만 있다면
		{
			pdeq.head=null;
			pdeq.tail=null;
		}
		else//노드가 하나이상 있는 경우 
		{
			pdeq.head=pdeq.head.next;
			pdeq.head.prev = null;
		}
		
	

		return rdata;
	}


	//마지막 노드 삭제
	static int DQRemoveLast(DeqPointer pdeq)
	{
		
		//노드가 하나도 없다면 종료
		if(pdeq.head==null || pdeq.tail==null)
			return 0;
		
		//반환용 변수,삭제할 구조체 포인터 하나 생성
		int rData = pdeq.tail.data;


		
		if(pdeq.head==pdeq.tail) //노드가 하나밖에 없는경우
		{
			pdeq.tail=null;
			pdeq.head=null;
		}
		else	//노드가 하나이상 있는경우
		{
			//꼬리를 이전 노드로 이동
			pdeq.tail = pdeq.tail.prev;
			pdeq.tail.next=null;
		}

		
		//삭제할 데이터 Return
		return rData;

	}


	//첫번째 노드 값 리턴
	static int DQGetFirst(DeqPointer pdeq)
	{
		if (DQIsEmpty(pdeq))
		{
			System.out.printf("Deque Memory Error!");
			System.exit(-1);
		}

		return pdeq.head.data;
	}

	//마지막 노드 값 리턴
	static int DQGetLast(DeqPointer pdeq)
	{
		if (DQIsEmpty(pdeq))
		{
			System.out.printf("Deque Memory Error!");
			System.exit(-1);
		}

		return pdeq.tail.data;
	}


}
