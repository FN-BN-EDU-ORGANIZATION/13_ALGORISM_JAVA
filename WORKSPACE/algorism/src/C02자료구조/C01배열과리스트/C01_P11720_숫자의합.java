package C02�ڷᱸ��.C01�迭������Ʈ;

import java.util.Scanner;

public class C01_P11720_�������� {
	
	
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    int N = sc.nextInt();
	    // String ������ �޾� �迭 ������ ��ȯ�ϱ�
	    String sNum = sc.next();
	    char[] cNum = sNum.toCharArray();
	    int sum = 0;
	    for (int i = 0; i < cNum.length; i++) {
	      sum += cNum[i] - '0'; // ���� ���� ���� ������ ��ȯ�Ͽ� �����ֱ�
	    }
	    System.out.print(sum);
	}
}

// �ð����⵵ : O(N)
