package C02자료구조.C05스택큐.C00사전코드;

import java.util.LinkedList;
import java.util.Queue;

public class C05큐_제공되는클래스사용하기{
	
	//MAIN
	public static void main(String[] args) {
		//-----------------------------------------
		// Queue�� ���� �� �ʱ�ȭ ///////
		//-----------------------------------------
		Queue<Integer> myQueue = new LinkedList<>();
		
		//-----------------------------------------
		// ������ �ֱ� ///////
		//-----------------------------------------
		myQueue.add(1); 
		myQueue.add(2); 
		myQueue.add(3);  
		myQueue.add(4);  
		myQueue.add(5);  
		System.out.println();
		
		System.out.print("��ü : ");
		myQueue.stream().forEach(node->System.out.print(node+" ") );
		System.out.println();
		System.out.println("PEEK : " + myQueue.peek()); 
		

		//-----------------------------------------
		// ������ ������ ///////
		//-----------------------------------------
		System.out.println("������ ���� : " + myQueue.poll());
		System.out.println("������ ���� : " + myQueue.poll());
		System.out.println("������ ���� : " + myQueue.poll());
		System.out.println("������ ���� : " + myQueue.poll());
		System.out.println("������ ���� : " + myQueue.poll());
		System.out.println("������ ���� : " + myQueue.poll());
		
		 
	}


	
}
