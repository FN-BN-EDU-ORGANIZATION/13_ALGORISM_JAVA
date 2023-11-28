package C03정렬.C00사전개념;

public class C03팩토리얼 {
	
	public static void main(String[] args) {
		
		System.out.println(factorial(3));
	}

	static int factorial(int n) {
		if(n==1)
			return 1;
		return n*factorial(n-1);
	}
		
}
