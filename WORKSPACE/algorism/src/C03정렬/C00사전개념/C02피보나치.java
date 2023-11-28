package C03정렬.C00사전개념;

public class C02피보나치 {
	public static void main(String[] args) {
		
		for (int i = 1; i < 15; i++)
			System.out.printf("%d ", Fibo(i)); //Fibo(1) , Fibo(2), Fibo(3), .....Fibo(14)..
		
	}
	
	//--------------------------------
	//피보나치
	//--------------------------------
	////0 1 2 3 5 8 13 21 ...
	
	static int Fibo(int n)
	{
		if (n == 1)						//만약 n이 1이라면
			return 0;					//0 을 리턴
		if (n == 2)						//만약 n이 2이라면
			return 1;					//1 을 리턴
		if (n > 2)							//만약 n>2이라면
			return Fibo(n - 2) + Fibo(n - 1);	//Fibo(n-2) + Fibo(n-1)을 리턴
		
		return 0;//의미없음
	}
	
}
