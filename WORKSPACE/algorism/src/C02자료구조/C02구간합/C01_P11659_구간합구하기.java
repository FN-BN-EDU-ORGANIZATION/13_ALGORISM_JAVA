package C02자료구조.C02구간합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class C01_P11659_구간합구하기 {
	
	//구간합 공식 : S[i] = S[i-1] + A[i]
	public static void main(String[] args) throws IOException {
	    
		//입력 스트림 생성
		BufferedReader bufferedReader  = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer stringTokenizer  = new StringTokenizer(bufferedReader.readLine());
	    
	    //입력 받기
	    int suNo = Integer.parseInt(stringTokenizer.nextToken());	//데이터 개수
	    int quizNo = Integer.parseInt(stringTokenizer.nextToken());	//질의 개수
	    
	    //구간합배열 생성
	    long[] S = new long[suNo + 1];	//Index 를 1부터 사용하기 위함
	    stringTokenizer = new StringTokenizer(bufferedReader.readLine());	//데이터 입력
	    
	    //구간합 저장
	    for (int i = 1; i <= suNo; i++) {
	      S[i] = S[i - 1] + Integer.parseInt(stringTokenizer.nextToken());
	    }
	    
	    //질의하기
	    for (int q = 0; q < quizNo; q++) {
	      stringTokenizer = new StringTokenizer(bufferedReader.readLine());	//질의값 입력
	      int i = Integer.parseInt(stringTokenizer.nextToken());	//시작 구간
	      int j = Integer.parseInt(stringTokenizer.nextToken());	//끝 구간
	      System.out.println(S[j] - S[i - 1]);	//구간합 출력
	    }
	    
	    
	}
	
}
