package C02자료구조.C02구간합;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class C02_P11660_구간합구하기2 {
  public static void main(String[] args) throws Exception {
    
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    
    int N = Integer.parseInt(st.nextToken());	//배열크기
    int M = Integer.parseInt(st.nextToken());	//질의 개수
    int A[][] = new int[N + 1][N + 1];			//0,0은 사용안함
    
    
    //2차원 배열에 저장
    for (int i = 1; i <= N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 1; j <= N; j++) {
        A[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    
    //구간합 저장
    int D[][] = new int[N + 1][N + 1];
    for (int i = 1; i <= N; i++) {
      for (int j = 1; j <= N; j++) {
        D[i][j] = D[i][j - 1] + D[i - 1][j] - D[i - 1][j - 1] + A[i][j];	//https://buk.io/@kc7525/48
      }
    }

    //구간합 확인
    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      //구간 범위 받기
      int x1 = Integer.parseInt(st.nextToken());
      int y1 = Integer.parseInt(st.nextToken());
      int x2 = Integer.parseInt(st.nextToken());
      int y2 = Integer.parseInt(st.nextToken());
       
      //구간합 계산
      int result = D[x2][y2] - D[x1 - 1][y2] - D[x2][y1 - 1] + D[x1 - 1][y1 - 1];
      System.out.println(result);
    }
    
    
  }
}
