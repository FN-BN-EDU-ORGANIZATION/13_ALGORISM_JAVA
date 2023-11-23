package C02자료구조.C05스택큐.C00사전코드;

import java.util.Comparator;
import java.util.PriorityQueue;

public class C08힙_우선순위큐 {

	public static void main(String[] args) {
		  
		//01 기본 우선순위큐(오름차순) 
        // 정수를 저장하는 우선순위 큐 생성 (기본은 작은 값이 높은 우선순위)
//        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
//
//        // 우선순위 큐에 요소 추가
//        priorityQueue.add(5);
//        priorityQueue.add(3);
//        priorityQueue.add(8);
//        priorityQueue.add(1);
//
//        // 우선순위 큐에서 요소 꺼내기
//        while (!priorityQueue.isEmpty()) {
//            int element = priorityQueue.poll();
//            System.out.println("꺼낸 요소: " + element);
//        }
//		
		//02 기본 우선순위큐(내림차순)
        // 큰 값이 높은 우선순위를 갖는 우선순위 큐 생성
//        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
//
//        // 우선순위 큐에 요소 추가
//        priorityQueue.add(5);
//        priorityQueue.add(3);
//        priorityQueue.add(8);
//        priorityQueue.add(1);
//
//        // 우선순위 큐에서 요소 꺼내기
//        while (!priorityQueue.isEmpty()) {
//            int element = priorityQueue.poll();
//            System.out.println("꺼낸 요소: " + element);
//        }
        
		
//		03 우선순위 로직전달(절대값 기준 오름차순)
		PriorityQueue<Integer> MyQueue = new PriorityQueue<>( (o1, o2) -> {
		      int first_abs = Math.abs(o1);
		      int second_abs = Math.abs(o2);
		      
		      // 만약 두 정수의 절대값이 같다면
		      if (first_abs == second_abs)
		    	// 원래 값에 따라 오름차순으로 정렬
		        return o1 > o2 ? 1 : -1; 	// 절대값(-값 -> +값) 만들기
		      else // 절대값이 다르다면
		    	// 두 정수의 절대값을 비교하여 큰 값이 우선순위를 가지도록 함
		        return first_abs - second_abs; 	//오름차순
			  });
      // 우선순위 큐에 요소 추가
		MyQueue.add(-5);
		MyQueue.add(3);
		MyQueue.add(-8);
		MyQueue.add(1);

      // 우선순위 큐에서 요소 꺼내기
      while (!MyQueue.isEmpty()) {
          int element = MyQueue.poll();
          System.out.println("꺼낸 요소: " + element);
      }
		
		
	}
	
}
