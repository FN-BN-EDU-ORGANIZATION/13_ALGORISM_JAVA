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

public class C06덱_직접만들기{

	public static void main(String[] args) {
		
		DeqPointer deq = new DeqPointer();
		DequeInit(deq);

		
		DQAddFirst(deq, 3);
		DQAddFirst(deq, 2);
		DQAddFirst(deq, 1);

		DQAddLast(deq, 4);
		DQAddLast(deq, 5);
		DQAddLast(deq, 6);


		// ��ü ������ Ȯ�� //
		DeqNode Front = deq.head;
		System.out.printf("��ü ���� ������ ��� : ");
		while (Front!=null)
		{
			System.out.printf("%d ", Front.data);
			Front = Front.next;
		}
		System.out.printf("\n");


		// �տ��� ������ ������ ///////
		System.out.printf("�տ������� ������ ������ : ");
		while (!DQIsEmpty(deq))
			System.out.printf("%d ", DQRemoveFirst(deq));

		System.out.printf("\n");


		// ������ �ֱ� 2�� ///////
		DQAddFirst(deq, 3);
		DQAddFirst(deq, 2);
		DQAddFirst(deq, 1);

		DQAddLast(deq, 4);
		DQAddLast(deq, 5);
		DQAddLast(deq, 6);

		// ��ü ������ Ȯ�� //
		Front = deq.head;
		
		System.out.printf("��ü ���� ������ ��� : ");
		while (Front !=null)
		{
			System.out.printf("%d ", Front.data);
			Front = Front.next;
		}

		System.out.printf("\n");



		// ������ ������ ������ ///////
		System.out.printf("���������� ������ ������ : ");
		while (!DQIsEmpty(deq))
			System.out.printf("%d ", DQRemoveLast(deq));
		
	}
	
	//������ �ʱ�ȭ 
	static void DequeInit(DeqPointer pdeq)
	{
		pdeq.head = null;
		pdeq.tail = null;
	}
	//�ֺ���� Ȯ�� �Լ�
	static boolean DQIsEmpty(DeqPointer pdeq)
	{
		if (pdeq.head == null)
			return true;
		else
			return false;
	}
	// ù��忡 ����
	static void DQAddFirst(DeqPointer pdeq, int data)
	{
		//�����Ҵ� + �����ͻ��� + ��ũ�ּ� NULL�ʱ�ȭ
		DeqNode newNode = new DeqNode();
		newNode.data=data;
		newNode.next=null;
		newNode.prev=null;
				

		//��� �ϳ��� ���� ���
		if (pdeq.head == null)
		{
			pdeq.head = newNode;
			pdeq.tail = newNode;
		}
		//��� �ϳ��̻� ���� ���
		else
		{
			newNode.next = pdeq.head;
			pdeq.head.prev = newNode;
			pdeq.head = newNode;
		}

	}

	//������ ��忡 ����
	static void DQAddLast(DeqPointer pdeq, int data)
	{

		//�����Ҵ� + �����ͻ��� + ��ũ�ּ� NULL�ʱ�ȭ
		DeqNode newNode = new DeqNode();
		newNode.data=data;
		newNode.next=null;
		newNode.prev=null;

		//��� �ϳ��� ���� ���
		if (pdeq.tail == null)
		{
			pdeq.head = newNode;
			pdeq.tail = newNode;
		}
		//��� �ϳ��̻� ���� ���
		else
		{
			pdeq.tail.next = newNode;
			newNode.prev = pdeq.tail;
			pdeq.tail = newNode;
		}
	}


	//ù��° ��� ����
	static int DQRemoveFirst(DeqPointer pdeq)
	{

		//��尡 �ϳ��� ���ٸ� ����
		if(pdeq.head==null&&pdeq.tail==null)
			return 0;

		//��ȯ�� ����,������ ����ü ������ �ϳ� ����
		int rdata=pdeq.head.data;
		DeqNode rNode = pdeq.head;

		// ��带 ���� ���� �̵� 
		//pdeq.head = pdeq.head.next;
		
		
		if(pdeq.head==pdeq.tail)//��尡 �ϳ��� �ִٸ�
		{
			pdeq.head=null;
			pdeq.tail=null;
		}
		else//��尡 �ϳ��̻� �ִ� ��� 
		{
			pdeq.head=pdeq.head.next;
			pdeq.head.prev = null;
		}
		
	

		return rdata;
	}


	//������ ��� ����
	static int DQRemoveLast(DeqPointer pdeq)
	{
		
		//��尡 �ϳ��� ���ٸ� ����
		if(pdeq.head==null || pdeq.tail==null)
			return 0;
		
		//��ȯ�� ����,������ ����ü ������ �ϳ� ����
		int rData = pdeq.tail.data;


		
		if(pdeq.head==pdeq.tail) //��尡 �ϳ��ۿ� ���°��
		{
			pdeq.tail=null;
			pdeq.head=null;
		}
		else	//��尡 �ϳ��̻� �ִ°��
		{
			//������ ���� ���� �̵�
			pdeq.tail = pdeq.tail.prev;
			pdeq.tail.next=null;
		}

		
		//������ ������ Return
		return rData;

	}


	//ù��° ��� �� ����
	static int DQGetFirst(DeqPointer pdeq)
	{
		if (DQIsEmpty(pdeq))
		{
			System.out.printf("Deque Memory Error!");
			System.exit(-1);
		}

		return pdeq.head.data;
	}

	//������ ��� �� ����
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
