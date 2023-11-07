package C02자료구조.C02구간합;

import java.io.IOException;

import java.util.Scanner;
public class C03_P10986_나머지합 {
  public static void main(String[] args) throws IOException {
    
	Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();		//수열의 개수 
    int M = sc.nextInt();		//나누는 수	 
    long[] S = new long[N];		//구간합 배열
    long[] C = new long[M];		//같은 나머지 카운트 배열  
    long answer = 0;			//
    S[0] = sc.nextInt();		//첫번째 데이터 받기 A[0] == S[0]
    
    //구간합 저장
    for (int i = 1; i < N; i++) {  
      S[i] = S[i - 1] + sc.nextInt();
    }
    
    //각 구간합/M 를 다시 저장
    for (int i = 0; i < N; i++) {  
      int remainder = (int) (S[i] % M);
      
      if (remainder == 0)	//나누어떨어지는 구간합이라면
        answer++;			//카운트 증가
      
      C[remainder]++; 		//해당 나머지를 가지는 요소의 카운트 증가
    }
    
    
    for (int i = 0; i < M; i++) {
      if (C[i] > 1) // 적어도 같은 나머지값을 가지는 구간합이 2개이상 있으면
      {
        answer = answer + (C[i] * (C[i] - 1) / 2);	//경우의 수 answer에 누적하기  
      }	
    }
    
    System.out.println(answer);
  }
}