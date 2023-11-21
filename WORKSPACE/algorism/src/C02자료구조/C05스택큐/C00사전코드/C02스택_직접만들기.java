package C02자료구조.C05스택큐.C00사전코드;



class Node{
	int data;
	Node next;
}

public class C02스택_직접만들기 {

	//Top Pointer
	static Node Top;
	
	//main method
	public static void main(String[] args) {
		//--------------------------------------------------
		// Stack�� ���� �� �ʱ�ȭ ///////
		//--------------------------------------------------
		StackInit();

		//--------------------------------------------------
		// ������ �ֱ� ///////
		//--------------------------------------------------
		System.out.printf("---------------(1) PUSH() ----------------\n");
		SPush(1);  SPush(2);
		SPush(3);  SPush(4);
		SPush(5);
		PrintStack();
		//--------------------------------------------------
		// ������ ������ Ȯ�� ///////
		//--------------------------------------------------
		System.out.printf("---------------(2) PEEK() ----------------\n");
		System.out.printf("������ ������ : %d\n", SPeek());
		//--------------------------------------------------
		// ������ ������ ///////
		//--------------------------------------------------
		System.out.printf("---------------(3) PEEK() ----------------\n");
		System.out.printf("1ȸ POP()! :"); SPop();
		PrintStack();
		System.out.printf("2ȸ POP()! :"); SPop();
		PrintStack();
		System.out.printf("3ȸ POP()! :"); SPop();
		PrintStack();
		System.out.printf("4ȸ POP()! :"); SPop();
		PrintStack();
		System.out.printf("5ȸ POP()! :"); SPop();
		PrintStack();
		System.out.printf("6ȸ POP()! :"); SPop();
		PrintStack();
		 
	}
	
	//Stack Init
	static void StackInit(){
		Top = null;
	}
	// ��ũ Null Ȯ�� �Լ�
	static boolean IsEmpty()
	{
		if (Top == null)
			return true;
		else
			return false;
	}
	
	// ������(Top) ������ Ȯ�� �Լ�
	static int SPeek()
	{
		if (IsEmpty()) {
			System.out.printf("Stack Memory Error!");
			System.exit(-1);
		}
		return Top.data;
	}
	static void PrintStack()
	{
		Node cur = Top;
		while (cur!=null)
		{
			System.out.printf("%d ",cur.data);
			cur = cur.next;
		}
		System.out.printf("\n");

	}
	// PUSH �Լ� 
	static void SPush(int data)
	{
		// 1 ������
		// 2 ���ֱ�
		// 3 ��ũ NULL
		// 4 ��尡 �ϳ��� ������
		// 5 ��尡 �ϳ��̻� ������
		// 5-1 new�� next�� top ����
		// 5-2 top �� new ���� 

		Node newNode = new Node();
		if (newNode == null)
		{
			System.out.printf("OverFlow!\n");
			System.exit(1);
		}
		newNode.data = data;
		newNode.next = null;

		if (Top == null){
			Top = newNode;
		}
		else{
			newNode.next = Top;
			Top = newNode;
		}	

	}

	// POP �Լ� 
	static void SPop()
	{

		// 1 ��� �ϳ��� ������
		// 2 ��� ������
		// 2-1 Top ��ġ�� del�� ����
		// 2-2 Top �� ���� ��ġ�� �̵�
		// 2-3 del �� free() �� ���� 

		if (Top == null){
			System.out.printf("UnderFlow!\n");
			return;
		}
		else
		{
			Node del = Top;
			Top = Top.next;
		}
	}

	
	
	
	
	
	
}
