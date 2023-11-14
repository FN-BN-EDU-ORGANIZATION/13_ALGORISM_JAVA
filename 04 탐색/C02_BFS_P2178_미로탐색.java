package C04탐색;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class C02_BFS_P2178_미로탐색{
	
	
	static int[] dx = { 0, 1, 0, -1 }; 	//	  
	static int[] dy = { 1, 0, -1, 0 };	//	
	//dx[0],dy[0] : 0,1		아래로 이동
	//dx[1],dy[1] : 1,0		오른쪽 이동
	//dx[2],dy[2] : 0,-1	위로 이동
	//dx[3],dy[3] : -1,0	왼쪽 이동
	
	//방문 기록 배열
	static boolean[][] visited;
  
	static int[][] A;
	static int N, M;//행(N)  열(M)
  
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    
    A = new int[N][M];
    
    visited = new boolean[N][M];
    
    //데이터 받아서 A배열에 저장
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      String line = st.nextToken();	//한줄 받기
      
      for (int j = 0; j < M; j++) {
        A[i][j] = Integer.parseInt(line.substring(j, j + 1));
      }
    }

    //BFS 실행
    BFS(0, 0);
    //?
    System.out.println(A[N - 1][M - 1]);	//BFS가 끝나고 나서 해당좌표를 찍으면 DepthLevel값이 확인
  }

  //
  public static void BFS(int i, int j) {
		
	  	//큐
	    Queue<int[]> queue = new LinkedList<>();
	    queue.offer(new int[] { i, j });
	    while (!queue.isEmpty()) {
	    	//현재 위치 확인
	    	int now[] = queue.poll();
	    	//방문 기록 남기기
	    	visited[i][j] = true;
	    	
	    	//k 가 4이하인이유는 상하좌우 탐색위함
	    	for (int k = 0; k < 4; k++) {
		        int x = now[0] + dx[k];//현재x좌표에서 k만큼이동
		        int y = now[1] + dy[k];//현재y좌표에서 k만큼이동
		        
		        if (x >= 0 && y >= 0 && x < N && y < M)	//배열 범위를 벗어나는지 확인  
		        { 	
		          if (A[x][y] != 0 && !visited[x][y]) // A[x][y] != 0 이면 안되고 방문했던 배열이면 안된다
		          { 	
		        	  //안으로 들어왔다면 이동가능한 곳이다!
		        	  visited[x][y] = true;				//방문기록 남김
		        	  A[x][y] = A[now[0]][now[1]] + 1; 	//방문한자리A[x][y]에 DepthLevel값(0,1,2..)를 넣음   	
		        	  queue.add(new int[] { x, y });	//queue에 현재 방문한 위치 넣음
		          }
		        }
		        
	    	}
	    }
  }
}
