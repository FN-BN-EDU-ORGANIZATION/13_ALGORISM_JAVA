package C02자료구조.C05스택큐.C00사전코드;

class ListNode{
	String data;
	ListNode link;
}

public class C01리스트 {
	private static ListNode L;
	
	public static void main(String[] args) {
		L = null;
		// ---------------------------------------------
		// 데이터 삽입(첫노드)
		// ---------------------------------------------
		System.out.println("----------(1) 첫노드에 삽입 [월][수] ----------");
		insertFirstNode("수");
		insertFirstNode("월");
		PrintList();
		// ---------------------------------------------
		// 데이터 삽입(끝노드)
		// ---------------------------------------------
		System.out.printf("\n----------(2) 마지막 노드에 삽입 [목][토][일] ----------\n");
		insertLastNode("목");
		insertLastNode("토");
		insertLastNode("일");
		PrintList();
		// ---------------------------------------------
		// 데이터 탐색
		// ---------------------------------------------
		ListNode p;
		System.out.printf("\n----------(4) 리스트에서 [금] 노드 탐색하기!----------\n");
		p = searchNode("금");
		if (p == null)
			System.out.printf("찾는 데이터가 없습니다.\n");
		else
			System.out.printf("[%s]를 찾았습니다.\n", p.data);

		System.out.printf("\n----------(3) 리스트에서 [목] 노드 탐색하기! ----------\n");
		p = searchNode("목");
		if (p == null)
			System.out.printf("찾는 데이터가 없습니다.\n");
		else
			System.out.printf("[%s]를 찾았습니다.\n", p.data);		
		
		// ---------------------------------------------
		// 데이터 삽입 (중간 노드)
		// ---------------------------------------------
		System.out.printf("\n----------(5) 리스트의 [목] 뒤에 [금] 노드 삽입하기!----------\n");
		insertMiddleNode(p, "금");
		PrintList();
		// ---------------------------------------------
		// 데이터 삭제
		// ---------------------------------------------
		System.out.printf("\n----------(6) 리스트에서 [일]노드 삭제하기!----------\n");
		p = searchNode("일");		// 삭제할 노드 위치 p를 찾음
		deleteNode(p);				// 포인터 p 노드 삭제
		PrintList();

		System.out.printf("\n----------(7) 리스트에서 [월]노드 삭제하기!----------\n");
		p = searchNode("월");
		deleteNode(p);
		PrintList();

		System.out.printf("\n----------(8) 리스트에서 [목]노드 삭제하기!----------\n");
		p = searchNode("목");
		deleteNode(p);
		PrintList();
 		
	}
	
	
	//리스트 순서대로 출력
	static void PrintList() {
		ListNode cur = L;
		while(cur!=null) {
			System.out.printf("%s",cur.data);
			cur=cur.link;
			if(cur!=null)
				System.out.printf(", ");
		}
	}
	
	//-----------------------------------
	//첫번째 노드 삽입
	//-----------------------------------
	static void insertFirstNode(String x) {
		//노드 생성
		ListNode newNode = new ListNode();
		//데이터 값 삽입
		newNode.data = x;
		//링크 NULL 초기화
		newNode.link = null;		
		//노드가 하나도 없는경우 -> 전역L포인터에 노드 바로연결 
		//노드가 하나이상 있는경우 -> 처음위치에 연결
		if(L==null)
			L=newNode;
		else{
			newNode.link=L;
			L=newNode;
		}

	}
	//-----------------------------------
	//마지막 노드삽입
	//-----------------------------------
	static void insertLastNode(String x) {
		//노드 생성
		ListNode newNode = new ListNode();
		//데이터 값 삽입
		newNode.data = x;
		//링크 NULL 초기화
		newNode.link = null;		
		//4-1 노드가 하나도 없는경우 -> 전역L포인터에 노드 바로연결 
		//4-2 노드가 하나이상 있는경우 -> 마지막 위치에 연결 코드 작성 

		//5 tmp 포인터를 만들어서 각 노드를 순회(tmp=tmp->link)하면서 마지막위치(link가 NULL) 인지 확인
		//6 마지막위치에서 새노드를 연결
 

		ListNode end;
		if (L == null)
		{
			L = newNode;
		}
		else
		{
			end = L;
			while (end.link != null)
				end = end.link;

			end.link = newNode;
		}

	}
	// ---------------------------------------------
	// 데이터 탐색
	// ---------------------------------------------
	// 리스트에서 x 노드를 탐색하는 연산
	static ListNode searchNode(String x) {

		//1 탐색용 구조체 포인터(tmp) 생성
		//2 노드의 시작주소를 tmp포인터에 저장
		//3 각노드를 순회(tmp=tmp->link)하면서 찾을 문자열과 일치하는 문자열 확인(strcmp(주소1,주소2))
		//4-1 찾으면 해당 노드의 주소를 리턴 
		//4-2 tmp==NULL(tmp가 전체노드를 순회) 이라면 NULL을 리턴
		ListNode tmp;
		tmp = L;
		while (tmp != null)
		{
			if (tmp.data.equals(x))
				return tmp;
			else
				tmp = tmp.link;
		}
		return tmp;
	}
	//-----------------------------------
	//중간노드 삽입
	//-----------------------------------
	static void insertMiddleNode(ListNode pre, String x) {
		//노드 생성
		ListNode newNode = new ListNode();
		//데이터 값 삽입
		newNode.data = x;
		//링크 NULL 초기화
		newNode.link = null;	
		
		//4-1 pre 가 NULL 인 경우(pre.link 에 new 노드 연결)
		//4-2 pre 가 NULL 이 아닌경우(pre.link 값을 new.link 에저장 // pre.link에 new노드주소를 저장)
		if (pre == null) {
			newNode.link = L;
			L = newNode;
		}
		else
		{
			newNode.link = pre.link;
			pre.link = newNode;
		}
	}
	
	//-----------------------------------
	//삭제
	//-----------------------------------
	// 리스트에서 노드 p를 삭제하는 연산
	static void deleteNode(ListNode p) {
		//1 삭제전 해당 데이터 존재유무 조회
		//2 삭제 전노드의 위치 탐색 
		//2 삭제 위치가 처음인경우
		//3 삭제 위치가 처음이아닌경우(마지막이거나 중간노드인경우)
		//3-1 삭제 위치가 마지막인경우(삭제 이전노드의 link에 NULL 대입 후 삭제노드 free)
		//3-2 삭제 위치가 중간노드인경우(삭제 이전노드의 link에 삭제할 노드의 link값 저장 후 삭제노드 free)

		
		//1 삭제전 해당 데이터 존재유무 조회
		if (p == null)
			return;


		//2 삭제 전노드의 위치 탐색 
		ListNode pre = null;
		ListNode cur = L;
		
		while (cur != null)
		{
			if(cur==p) // cur가 삭제위치라면
			{
				break;
			}
			else //cur가 삭제 위치가 아니라면  
			{
				pre = cur;			//pre에 cur대입 
				cur = cur.link;	//다음노드로 이동
			}
		}

		//노드가 하나도 없는 경우
		if (cur == null) 
			return;
		
		//2 삭제 위치가 처음인경우
		if (pre == null)
		{
			L = p.link;
		}
		//3 삭제 위치가 처음이아닌경우(마지막이거나 중간노드인경우)
		else
		{
			//3-1 마지막인경우
			if (p.link == null)
			{
				pre.link = null;	
			}
			//3-2 중간인경우
			else
			{
				pre.link = cur.link;
			}
		}
	}
	
	
	
	
	
}


