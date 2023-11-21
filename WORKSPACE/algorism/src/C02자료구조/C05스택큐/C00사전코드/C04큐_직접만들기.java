package C02자료구조.C05스택큐.C00사전코드;


class QNode{
	int data;
	QNode next;
}
class QPointer{
	QNode front;
	QNode rear;
}
public class C04큐_직접만들기{
	
	//MAIN
	public static void main(String[] args) {
		//-----------------------------------------
		// Queue�� ���� �� �ʱ�ȭ ///////
		//-----------------------------------------
		QPointer q = new QPointer();
		Init(q);

		//-----------------------------------------
		// ������ �ֱ� ///////
		//-----------------------------------------
		Enq(q, 1);  Enq(q, 2);
		Enq(q, 3);  Enq(q, 4);
		Enq(q, 5);
		PrintQ(q);

		//-----------------------------------------
		// ������ ������ ///////
		//-----------------------------------------
		System.out.printf("Deq() 1ȸ : "); Deq(q); PrintQ(q);
		System.out.printf("Deq() 2ȸ : "); Deq(q); PrintQ(q);
		System.out.printf("Deq() 3ȸ : "); Deq(q); PrintQ(q);
		System.out.printf("Deq() 4ȸ : "); Deq(q); PrintQ(q);
		System.out.printf("Deq() 5ȸ : "); Deq(q); PrintQ(q);
		 
	}

	//
	static void Init(QPointer pq)
	{
		pq.front = null;
		pq.rear = null;
	}
	//
	static boolean Empty(QPointer pq) {
		if (pq.front == null)
			return true;
		else
			return false;
	}
	//
	static int QPeek(QPointer pq)
	{
		if (Empty(pq))
		{
			System.out.printf("Queue Memory Error!");
			System.exit(-1);
		}
		return pq.front.data;
	}
	//
	static void PrintQ(QPointer pq)
	{
		QNode cur = pq.front;
		
		while (cur!=null)
		{
			System.out.printf("%d ", cur.data);
			cur = cur.next;
		}
		System.out.printf("\n");
	}
	//
	static void Enq(QPointer pq, int data)
	{
	
		QNode newNode = new QNode();
		if (newNode == null)
			System.exit(1);

		newNode.data = data;
		newNode.next = null;

		if (pq.front == null)
		{
			pq.front = newNode;
			pq.rear = newNode;
		}
		else
		{
			pq.rear.next = newNode;
			pq.rear = newNode;
		}
		
	}
	//
	static void Deq(QPointer pq)
	{
		

		if (pq.front == null)
			return ;
		
		QNode del = pq.front;
		pq.front = pq.front.next;
	}
	
}
