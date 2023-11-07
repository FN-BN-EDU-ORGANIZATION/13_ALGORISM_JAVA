package C02�ڷᱸ��.C02������;

import java.io.IOException;

import java.util.Scanner;
public class C03_P10986_�������� {
  public static void main(String[] args) throws IOException {
    
	Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();		//������ ���� 
    int M = sc.nextInt();		//������ ��	 
    long[] S = new long[N];		//������ �迭
    long[] C = new long[M];		//���� ������ ī��Ʈ �迭  
    long answer = 0;			//
    S[0] = sc.nextInt();		//ù��° ������ �ޱ� A[0] == S[0]
    
    //������ ����
    for (int i = 1; i < N; i++) {  
      S[i] = S[i - 1] + sc.nextInt();
    }
    
    //�� ������/M �� �ٽ� ����
    for (int i = 0; i < N; i++) {  
      int remainder = (int) (S[i] % M);
      
      if (remainder == 0)	//����������� �������̶��
        answer++;			//ī��Ʈ ����
      
      C[remainder]++; 		//�ش� �������� ������ ����� ī��Ʈ ����
    }
    
    
    for (int i = 0; i < M; i++) {
      if (C[i] > 1) // ��� ���� ���������� ������ �������� 2���̻� ������
      {
        answer = answer + (C[i] * (C[i] - 1) / 2);	//����� �� answer�� �����ϱ�  
      }	
    }
    
    System.out.println(answer);
  }
}