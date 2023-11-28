package C03정렬.C00사전개념;


//재귀함수?
//별찍기
//팩토리얼 / 
//병합정렬 기본
//병합정렬 응용
//스택
//큐
//덱

//-----------------------------
//재귀함수
//-----------------------------
//스스로를 반복적으로 호출하는 형태의 코드를 포함하는 함수


public class C01재귀함수 {
	public static void main(String[] args) {
		//01 
		//Recursive(3);

		//02
		//Recursive2(3);
		
		//03
		//Recursive3(3);
		
		//04
//		int total = recursive4(10);
//		System.out.printf("합계 : %d\n", total);
		
		//05
//		int total = recursive(10);
//		System.out.printf("합계 : %d\n", total);
		
		//06
		//star1(5);
		
		//07
		//star2(5);
		
		//08
		star3(4);
		
		
	}
	//-------------------------------
	//1) 재귀함수 기본
	//-------------------------------
	static void Recursive(int num)
	{
		if (num > 0)
		{
			System.out.printf("Recursive call!!: %d\n", num);
			Recursive(num - 1);		//자신을 호출 
		}
	}
	//-------------------------------
	//2) 재귀함수 기본
	//-------------------------------
	static void Recursive2(int num)
	{
		if (num > 0)
		{
			Recursive2(num - 1);		
			System.out.printf("Recursive call!!: %d\n", num);
			//자신을 호출 
		}
	}
	//-------------------------------
	//3) 재귀함수 기본
	//-------------------------------
	static void Recursive3(int num)
	{
		if (num > 0)
		{
			System.out.printf("Recursive call!!: %d\n", num); //3 -> 2 -> 1
			Recursive3(num - 1);		//자신을 호출 
			System.out.printf("Recursive call!!: %d\n", num); //1 -> 2 -> 3
	
		}
	}
	//-------------------------------
	//4) 재귀함수를 이용해서 1부터 10까지의 합 구하기
	//-------------------------------
	static int recursive4(int num)
	{
		int sum = 0;
		if (num > 0)
		{
			sum = recursive4(num - 1) + num; //재귀함수 호출 시점 
			System.out.printf("num %d를 더한 sum의 값 : %d\n", num, sum);
			return sum;
		}
		return 0;
	}
	//-------------------------------
	//5) 1부터 10까지의 수중의 3의 배수의합 만 출력(수 %3 == 0 ) 
	//-------------------------------
	static int recursive(int num)
	{
		int sum = 0;
		//전달받은 인자가 3의 배수가 될때까지 num 값 감소
		while (num % 3 != 0)	//3의 배수가 될때까지
		{	
			num--;	//num을 1 감소
		}
		//while을 빠져나올때 9,6,3,0	
		if (num > 0)
		{
			sum = recursive(num - 1) + num; //재귀함수 호출 시점 
			System.out.printf("num %d를 더한 sum의 값 : %d\n", num, sum);
			return sum;
		}
		return 0;
	}
	//--------------------------------
	//6) 재귀함수로 별찍기
	//--------------------------------
	//*
	//**
	//***
	//****


	static void star1(int n)
	{
		if(n>0)
		{
			star1(n - 1); // 3 -> 2 -> 1 -> 0
			for (int i = 0; i < n; i++)
				System.out.printf("*");
			System.out.printf("\n");
		}
	}
	//--------------------------------
	//7) 재귀함수로 별찍기
	//--------------------------------
	//****
	//***
	//**
	//*
	static void star2(int n)
	{
		if(n>0)
		{
			for (int i = 0; i < n; i++)
				System.out.printf("*");
			System.out.printf("\n");
			star2(n - 1);
		}
	}
	
	//--------------------------------
	//문제
	//--------------------------------
	//   *
	//  ***
	// *****
	//*******
	//--------------
	//i		j		k
	//0		0-2		0-0
	//1		0-1		0-2
	//2		0-0		0-4
	//3		X		0-6
	static void star3(int n)
	{
		if(n>0)
		{
			//처리되는 부분
			star3(n - 1);
			//공백찍기 반복
			for (int i = 0; i <= 3 - n ; i++)
			{
				System.out.printf(" ");	//공백(n==1) :3 ,
										//공백(n==2) :2 ,
										//공백(n==3) :1 ,
										//공백(n==4) :x 
			}
			//별찍기 반복
			for (int i = 0; i <= (n - 1) * 2; i++)
			{
				System.out.printf("*");	//별찍기(n==1) : 1
										//별찍기(n==2) : 3
										//별찍기(n==3) : 5
										//별찍기(n==4) : 7
			}
			System.out.printf("\n");
		}
	}
	
	//--------------------------------
	//
	//--------------------------------

	
}




//--------------------------------------------------------------------------------
//
//--------------------------------------------------------------------------------














