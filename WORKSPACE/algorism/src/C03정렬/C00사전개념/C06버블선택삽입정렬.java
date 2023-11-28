package C03정렬.C00사전개념;

public class C06버블선택삽입정렬 {
	

	
	public static void main(String[] args) {
		//--------------------------------------
		//1 버블정렬
		//--------------------------------------

		//n==4
		//i			j
		//0(1회차)	0-2 (3회)
		//1(2회차)	0-1	(2회)
		//2(3회차)	0-0	(1회)


//			int arr[] = { 3, 2, 4, 1 };
//			int i;
//		
//			BubbleSort(arr, arr.length);
//		
//			for (i = 0; i < 4; i++)
//				System.out.printf("%d ", arr[i]);
//		
//			System.out.printf("\n");
			

		//--------------------------------------
		//2 선택정렬
		//--------------------------------------

		//n==4
		//
		//i		j 
		//0		1-3(3회)
		//1		2-3(2회)
		//2		3-3(1회)
		//#include <stdio.h>
		//

//			int arr[] = { 3, 4, 2, 1 };
//			int i;
//		
//			SelectedSort(arr, arr.length);
//		
//			for (i = 0; i < 4; i++)
//				System.out.printf("%d ", arr[i]);
//		
//			System.out.printf("\n");
			


		//--------------------------------------
		//3 삽입정렬
		//--------------------------------------
		// n=5;
		// i		j
		// 1		0-0
		// 2		1-0
		// 3		2-0
		// 4		3-0



			int arr[] = { 5, 3, 2, 4, 1 };
			int i;
		
			InserSort(arr, arr.length);
		
			for (i = 0; i < 5; i++)
				System.out.printf("%d ", arr[i]);
		
			System.out.printf("\n");
	


	}
	
	//버블정렬
	static void BubbleSort(int arr[], int n)
	{
		int tmp = 0;
		for (int i = 0; i < n - 1; i++)
		{
			for (int j = 0; j < n-1-i; j++)
			{
				if (arr[j] > arr[j + 1])
				{
					tmp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = tmp;
				}
			}
		}
	}
	
	//선택 정렬
	static void SelectedSort(int arr[], int n)
	{
		int tmp = 0;
		for (int i = 0; i < n - 1; i++)
		{
			for (int j = i + 1; j < n; j++)
			{
				if (arr[i] > arr[j])
				{
					tmp = arr[i];
					arr[i] = arr[j];
					arr[j] = tmp;
				}
			}
	
		}
		
	}
	//삽입 정렬
	static void InserSort(int arr[], int n)
	{
		int tmp = 0;
		int i,j;
		for (i = 1; i < n; i++)
		{
			tmp = arr[i];
			for (j = i - 1; j >= 0; j--)
			{		
				if (tmp < arr[j])
				{
					arr[j + 1] = arr[j];
				}
				else
					break;			
			}
			arr[j+1] = tmp;
	
		}
	
	}
	
	
}
