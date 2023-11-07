package C02�ڷᱸ��.C02������;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class C01_P11659_�����ձ��ϱ� {
	
	//������ ���� : S[i] = S[i-1] + A[i]
	public static void main(String[] args) throws IOException {
	    
		//�Է� ��Ʈ�� ����
		BufferedReader bufferedReader  = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer stringTokenizer  = new StringTokenizer(bufferedReader.readLine());
	    
	    //�Է� �ޱ�
	    int suNo = Integer.parseInt(stringTokenizer.nextToken());	//������ ����
	    int quizNo = Integer.parseInt(stringTokenizer.nextToken());	//���� ����
	    
	    //�����չ迭 ����
	    long[] S = new long[suNo + 1];	//Index �� 1���� ����ϱ� ����
	    stringTokenizer = new StringTokenizer(bufferedReader.readLine());	//������ �Է�
	    
	    //������ ����
	    for (int i = 1; i <= suNo; i++) {
	      S[i] = S[i - 1] + Integer.parseInt(stringTokenizer.nextToken());
	    }
	    
	    //�����ϱ�
	    for (int q = 0; q < quizNo; q++) {
	      stringTokenizer = new StringTokenizer(bufferedReader.readLine());	//���ǰ� �Է�
	      int i = Integer.parseInt(stringTokenizer.nextToken());	//���� ����
	      int j = Integer.parseInt(stringTokenizer.nextToken());	//�� ����
	      System.out.println(S[j] - S[i - 1]);	//������ ���
	    }
	    
	    
	}
	
}
