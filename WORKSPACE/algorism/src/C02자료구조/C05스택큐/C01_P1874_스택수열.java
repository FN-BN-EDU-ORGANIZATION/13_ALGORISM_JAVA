package C02자료구조.C05스택큐;

import java.util.Scanner;
import java.util.Stack;
public class C01_P1874_스택수열{
  public static void main(String[] args) {
   
	  
	  Scanner sc = new Scanner(System.in);
	  int N = sc.nextInt();
	  int[]A = new int[N];
	  
	  for (int i = 0; i < N; i++) {
	      A[i] = sc.nextInt();
	  }
	  
    Stack<Integer> stack = new Stack<>();
    StringBuffer bf = new StringBuffer();	// +, - 를 저장
    
    int num = 1; 
    
    boolean result = true;	// +,-를 표시할지 여부를 정하는 기준
   
    for (int i = 0; i < A.length; i++) {
      
    	int su = A[i];  
      if (su >= num) {  
        
    	  //스택에 오름차순으로 데이터를 넣음 num부터 su까지
    	while (su >= num) { // push()
          stack.push(num++);
          bf.append("+\n");
        }
        stack.pop();
        bf.append("-\n");
      }
      else {   
        int n = stack.pop();
         
        if (n > su) {
          System.out.println("NO");
          result = false;
          break;
        } //
        else {
          bf.append("-\n");
        }
      }
      
    }
    
    if (result) System.out.println(bf.toString());
  }
}
