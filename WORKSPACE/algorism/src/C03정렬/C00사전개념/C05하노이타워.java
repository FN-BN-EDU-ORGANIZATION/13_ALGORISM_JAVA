package C03정렬.C00사전개념;

public class C05하노이타워 {
	public static void main(String[] args) {
		// 막대A의 원반 3개를 막대B를 경유하여 막대C로 옮기기
		Hanoi(2, 'A', 'B', 'C');
	}
	static void Hanoi(int num, char from, char by, char to)//원반개수,현재기둥,경유기둥,옮길기둥
	{
		if (num > 0)
		{
			Hanoi(num - 1, from, to, by);				 //Hanoi 재귀호출 num-1 를 A->B 이동
			System.out.printf("%c에 있는 %d번째 원반을 %c로 옮김\n",from, num, to); //printf 마지막 원반을 C로 이동
			Hanoi(num - 1, by, from, to);				 //Hanoi 재귀호출 num-1 를 B->C 이동
		}
	}
	
}
