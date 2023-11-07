package C02�ڷᱸ��.C03��������;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class C03_P1253_������ {
  public static void main(String[] args) throws NumberFormatException, IOException {
   
	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(bf.readLine());
    int Result = 0;
    
    long A[] = new long[N];
    StringTokenizer st = new StringTokenizer(bf.readLine());
    for (int i = 0; i < N; i++) {
      A[i] = Long.parseLong(st.nextToken());
    }
    
    //����
    Arrays.sort(A);
    
    for (int k = 0; k < N; k++) {
      long find = A[k];	//
      int i = 0;			//���� 	idx
      int j = N - 1;		//������ 	idx
      while (i < j) {   
        if (A[i] + A[j] == find)	//��ġ�ϴ� ��(������)ã�� 
        {
          if (i != k && j != k)	// 
          {
            Result++;
            break;
          } 
          else if (i == k)	// A[i]==A[k] && A[j]==0 �ΰ�츦 ��� 
          {
            i++;
          } 
          else if (j == k) 	// A[j]==A[k] && A[i]==0 �ΰ�츦 ���
          {
            j--;
          }
        } else if (A[i] + A[j] < find) {
          i++;
        } else {
          j--;
        }
      }
    }
    System.out.println(Result);
    bf.close();
  }
}