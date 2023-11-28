package C03정렬.C00사전개념;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class C07병합정렬 {
	
	 public static int[] A= {0,42,32,24,60,15,5,90,45};
	 public static int[] tmp = new int[9];
	  public static void main(String[] args) throws IOException {
	    	  
	    int N = 8;	//총배열개수
	    int K = 3;	//
	    
	    //
	    System.out.printf("정렬 전 : " );
		    for(int i=1 ;i <= N;i++) {
		    	System.out.printf(A[i] + " ");
		}
		System.out.println();
		
		//정렬 
	    merget_sort(1, N);
	    
	    System.out.println(K+" 번째 수 : " + A[K]);
	    
	    //
	    System.out.printf("정렬 후 : " );
	    for(int i=1 ;i <= N;i++) {
	    	System.out.printf(A[i] + " ");
	    }
	    
	  }
	  
	  private static void merget_sort(int s, int e) {
	    if (e - s < 1) {	//더이상 나눌수 없다면{
	    	System.out.println("return S : " + s + " ,E : " + e);
	      return;	//바로 위로 리턴(2개이상의 블럭그룹부터 시작)
	    }
	    int m = s + (e - s) / 2;	//절반으로 나눔 
	   
	    System.out.println("S : "  + s + " , E: " + e);
	    //-------------------------
	    //분할작업
	    //-------------------------
	    merget_sort(s, m);	//계속 들어감 왼쪽
	    merget_sort(m + 1, e);	//계속들어감 오른쪽
	    
	   
	    
	    //나눌수 없는 구간의 바로위(2개이상)로 올라옴
	    for (int i = s; i <= e; i++) {
	      tmp[i] = A[i];	//s idx 값부터 e idx 값까지 임시 배열에 저장
	    }
	    
	    
	    //-------------------------
	    //나눠진 블럭당 오름차순 정렬
	    //-------------------------

	    int k = s;		//시작 idx를 k에 저장(A에 저장할 용도) 위의 대문자K와는 별개..
	    int index1 = s;	//시작 idx를 index1에 저장
	    int index2 = m + 1;	//중간idx + 1 을 index2에 저장
	    
	    //오름차순 기준으로 tmp에 들어있는 두 idx를 A배열에 재정렬하기
	    while (index1 <= m && index2 <= e) 		//index1이 중간인덱스보다 작거나 같고
	    										//index2가 마지막인덱스보다 작거나 같다면 
	    {  
	      if (tmp[index1] > tmp[index2])	//index1의값의 index2의 값보다 크다면  
	      {
	        A[k] = tmp[index2];	//더 작은값을 A[k] 번째에 넣기 
	        k++;				//k 1증가(다음위치로)
	        index2++;			//index2 1증가(다음위치로)
	      } 
	      else 
	      {
	        A[k] = tmp[index1];	
	        k++;
	        index1++;
	      }
	    }
	    
	    //위 반복문에서 내려왔을때는 
	    //index1>m && index2<=m 이거나 
	    //index1<=m && index2>m 이거나
	    //index1<=m && index2<=m 
	    
	    // index1이 아직 차마 다 못돌아갔을때
	    while (index1 <= m)	//중간 idx보다 index1이 작거나 같다면  
	    {
	      A[k] = tmp[index1];
	      k++;
	      index1++;
	    }
	    //index2가 차마 못돌아 갔을때 
	    while (index2 <= e) 
	    {
	      A[k] = tmp[index2];
	      k++;
	      index2++;
	    }

	  }
	
}
