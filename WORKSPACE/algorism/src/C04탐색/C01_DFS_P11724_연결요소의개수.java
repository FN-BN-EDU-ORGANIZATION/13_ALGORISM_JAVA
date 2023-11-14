package C04탐색;
import java.io.*;


import java.util.*;
public class C01_DFS_P11724_연결요소의개수{
  static ArrayList<Integer>[] A;
  static boolean visited[];
  public static void main(String[] args) throws IOException {
	 
	  //
	 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	 StringTokenizer st = new StringTokenizer(br.readLine());
	 
	 int n = Integer.parseInt(st.nextToken());	//노드의 개수
	 int m = Integer.parseInt(st.nextToken());	//에지의 개수
	 A = new ArrayList[n + 1];					//인접리스트 배열 크기 지정(index는 1부터)
	 visited = new boolean[n + 1];				//방문여부 배열 크기지정(index는 1부터)
    
    for (int i = 1; i < n + 1; i++) {  
      A[i] = new ArrayList<Integer>();			//인접리스트 i번째마다 ArrayList객체로 초기화
    }
    
    
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int s = Integer.parseInt(st.nextToken());	//시작노드
      int e = Integer.parseInt(st.nextToken());	//시작노드로부터 연결되는 노드
      A[s].add(e);  //연결하기
      A[e].add(s);	//연결하기
    }
    
    int count = 0;
    
    for (int i = 1; i < n + 1; i++) {
      if (!visited[i])	//방문하지 않았다면 
      {  
        count++;	//연결요소개수 Count증가
        DFS(i);		//DFS호출
      }
    }
    
    System.out.println(count);
  }

  //---------------------------------  
  static void DFS(int v) {
    if (visited[v]) {
      return;
    }
    visited[v] = true;
    for (int i : A[v]) {
      if (visited[i] == false) { 
        DFS(i);
      }
    }
    
  }
  //---------------------------------
  
}
