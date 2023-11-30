package C03정렬.C00사전개념;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class C08퀵정렬 {

	
	public static void main(String[] args) { 
	    
   
	    int[] A = {42,32,24,60,15,5,90,45};
	    quickSort(A, 0, A.length-1);	//배열 , 시작idx, 끝idx 
	    
	    for(int i : A) {
	    	System.out.print(i + " ");
	    }
	}
	  
		
	  public static void quickSort(int[] A, int S, int E) 
	  {
	      
		  if(S<=E)
		  {
		      int pivot = partition(A, S, E);	//파티션 나누기 + pivot idx가져오기
		      quickSort(A, S, pivot - 1); 		//왼쪽 정렬
		      quickSort(A, pivot+1, E);			//오른쪽 정렬
		 
	      }
	  }
	  

	  private static int partition(int[] A, int S, int E){
 		 
	    int pivot = A[S];		// 시작 위치의 값을 피벗으로 잡고(제일왼쪽을피벗으로)
	    int i = S+1;			// i는 시작위치다음
	    int j = E;				//j는 마지막위치
	    
	    while (i <= j)	//교차되기 전까지 반복 
	    {
	        while (pivot < A[j] && j > 0 )	//A[j]가 더 크면 j를 감소(왼쪽으로 이동)
	        {   
	            j--;    
	        }
	        while (pivot > A[i]  && i <A.length-1)	//A[i]가 피벗보다 작으면 i++(오른쪽이동)
	        {   
	               i++;  
	        }
	        if (i <= j) 	//i가 j보다 작거나 같으면
	        {
	            swap (A, i++, j--);   // i번째값 , j번쨰 값 Swap이후 i 는1증가 j는 1감소
	        }
	    }
	    
	    swap(A,S,j); // 피벗의값과 j의 값 Swap
	    return j; // 옮겨진 피벗의 idx 반환
	}
	  
	  
	  
	  public static void swap(int[] A, int i, int j) {
	    int temp = A[i];
	    A[i] = A[j];
	    A[j] = temp;
	  }
	  

}
