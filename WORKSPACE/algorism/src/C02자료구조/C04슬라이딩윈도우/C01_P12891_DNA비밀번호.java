package C02자료구조.C04슬라이딩윈도우;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class C01_P12891_DNA비밀번호 {
  static int checkArr[];
  static int myArr[];
  static int checkSecret;

  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(bf.readLine());
    int S = Integer.parseInt(st.nextToken());	//DNA 문자열길이
    int P = Integer.parseInt(st.nextToken());	//윈도우 크기
    int Result = 0;								//확인
    char A[] = new char[S];						//DNA 문자열 들어가는 배열
    checkArr = new int[4];						//비밀번호 체크배열(A,C,G,T) 에 최소 허용 개수 저장
    myArr = new int[4];							//내가입력한 DNA문자열에 위의 체크배열을 얼마나 충족하는지를 저장
    checkSecret = 0;							//비밀번호 일치여부 확인 카운터
    A = bf.readLine().toCharArray();			//DNA 문자열 길이 받기
    st = new StringTokenizer(bf.readLine());
    //
    for (int i = 0; i < 4; i++) {
      checkArr[i] = Integer.parseInt(st.nextToken());
      if (checkArr[i] == 0)	//애초에 해당 문자(A,G,C,T)중에 0 이라는말은 일치할 필요없다는거
        checkSecret++;
    }
    //추가
    for (int i = 0; i < P; i++)	//윈도우 크기만큼 반복하면서 
    {  
      Add(A[i]);		//추가
    }
    //
    if (checkSecret == 4)
      Result++;
    //슬라이딩 윈도우(핵심로직)
    for (int i = P; i < S; i++) {
      int j = i - P;
      Add(A[i]);
      Remove(A[j]);
      if (checkSecret == 4)   
        Result++;
    }
    System.out.println(Result);
    bf.close();
  }
  //
  private static void Add(char c) {  
    switch (c) {
    case 'A':
      myArr[0]++;
      if (myArr[0] == checkArr[0])
        checkSecret++;
      break;
    case 'C':
      myArr[1]++;
      if (myArr[1] == checkArr[1])
        checkSecret++;
      break;
    case 'G':
      myArr[2]++;
      if (myArr[2] == checkArr[2])
        checkSecret++;
      break;
    case 'T':
      myArr[3]++;
      if (myArr[3] == checkArr[3])
        checkSecret++;
      break;
    }
  }
  //
  private static void Remove(char c) {  
    switch (c) {
    case 'A':
      if (myArr[0] == checkArr[0])
        checkSecret--;
      myArr[0]--;
      break;
    case 'C':
      if (myArr[1] == checkArr[1])
        checkSecret--;
      myArr[1]--;
      break;
    case 'G':
      if (myArr[2] == checkArr[2])
        checkSecret--;
      myArr[2]--;
      break;
    case 'T':
      if (myArr[3] == checkArr[3])
        checkSecret--;
      myArr[3]--;
      break;
    }
  }
  
}
