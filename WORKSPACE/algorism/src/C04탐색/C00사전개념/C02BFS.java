package C04탐색.C00사전개념;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class C02BFS {
   
   static ArrayList<Integer>[] A;
   static boolean visited[];
   
   public static void main(String[] args) {

   
      
       int n = 6;   //노드의 개수
       int m = 8;   //에지의 개수
       A = new ArrayList[n + 1];               //인접리스트 배열 크기 지정(index는 1부터)
       visited = new boolean[n + 1];            //방문여부 배열 크기지정(index는 1부터)
       
      //
       for (int i = 1; i < n + 1; i++) {  
         A[i] = new ArrayList<Integer>();         //인접리스트 i번째마다 ArrayList객체로 초기화
       }
       

       // 6 5   // 노드개수 , 에지 개수
       // 1 2
       // 2 5
       // 5 1
       // 3 4
       // 4 6
        // 5 4
        // 2 4
        // 2 3 
       A[1].add(2); A[2].add(1);
       A[2].add(5); A[5].add(2);
       A[5].add(1); A[1].add(5);
       A[3].add(4); A[4].add(3);
       A[4].add(6); A[6].add(4);
       A[5].add(4); A[4].add(5);
       A[2].add(4); A[4].add(2);
       A[2].add(3); A[3].add(2);   
       
       
       //
//       BFS(1);
       
       BFS(3);

      

       
   
   }
   
   //---------------------------------  
   //BFS (Deque이용)
   //---------------------------------
   private static void BFS(int v) {
      Queue<Integer> queue = new LinkedList<Integer>();
      visited[v] = true; 
      queue.add(v);

      while(queue.size() != 0) { 
         v = queue.poll(); 
         System.out.print(v + " ");   
         
         for(int i:A[v]) { 
            if(!visited[i]) { 
               visited[i] = true; 
               queue.add(i); 
            } 
         }
      }
      
   }
   
   
   
}