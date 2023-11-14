package C02자료구조.C03투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
public class C03_P1253_좋은수 {
  public static void main(String[] args) throws NumberFormatException, IOException {
   
	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(bf.readLine());
    int Result = 0;
    
    long A[] = new long[N];
    StringTokenizer st = new StringTokenizer(bf.readLine());
    for (int i = 0; i < N; i++) {
      A[i] = Long.parseLong(st.nextToken());
    }
    
    //정렬
    Arrays.sort(A); //nlogn 최악은 n^2
    
    
    for (int k = 0; k < N; k++) {
      long find = A[k];	//
      int i = 0;			//시작 	idx
      int j = N - 1;		//마지막 	idx
      
      while (i < j) {   
        if (A[i] + A[j] == find)	//일치하는 수(좋은수)찾음 
        {
          if (i != k && j != k)	// i가 k번째가 아니고 j도 k번째가 아니라면 
          {
            Result++;	//결과Count증가
            break;		//종료
          } 
          else if (i == k)	// A[i]==A[k] && A[j]==0 인경우를 고려 
          {
            i++;
          } 
          else if (j == k) 	// A[j]==A[k] && A[i]==0 인경우를 고려
          {
            j--;
          }
        } 
        else if (A[i] + A[j] < find) 
        {
          i++;
        } 
        else {
          j--;
        }
      }
      
    }
    System.out.println(Result);
    bf.close();
  }
}