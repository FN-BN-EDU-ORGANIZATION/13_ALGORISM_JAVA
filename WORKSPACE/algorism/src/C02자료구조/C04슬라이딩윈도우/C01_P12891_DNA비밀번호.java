package C02�ڷᱸ��.C04�����̵�������;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class C01_P12891_DNA��й�ȣ {
  static int checkArr[];
  static int myArr[];
  static int checkSecret;

  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(bf.readLine());
    int S = Integer.parseInt(st.nextToken());	//DNA ���ڿ�����
    int P = Integer.parseInt(st.nextToken());	//������ ũ��
    int Result = 0;								//Ȯ��
    char A[] = new char[S];						//DNA ���ڿ� ���� �迭
    checkArr = new int[4];						//��й�ȣ üũ�迭(A,C,G,T) �� �ּ� ��� ���� ����
    myArr = new int[4];							//�����Է��� DNA���ڿ��� ���� üũ�迭�� �󸶳� �����ϴ����� ����
    checkSecret = 0;							//��й�ȣ ��ġ���� Ȯ�� ī����
    A = bf.readLine().toCharArray();			//DNA ���ڿ� ���� �ޱ�
    st = new StringTokenizer(bf.readLine());
    //
    for (int i = 0; i < 4; i++) {
      checkArr[i] = Integer.parseInt(st.nextToken());
      if (checkArr[i] == 0)	//���ʿ� �ش� ����(A,G,C,T)�߿� 0 �̶�¸��� ��ġ�� �ʿ���ٴ°�
        checkSecret++;
    }
    //�߰�
    for (int i = 0; i < P; i++)	//������ ũ�⸸ŭ �ݺ��ϸ鼭 
    {  
      Add(A[i]);		//�߰�
    }
    //
    if (checkSecret == 4)
      Result++;
    //�����̵� ������(�ٽɷ���)
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
