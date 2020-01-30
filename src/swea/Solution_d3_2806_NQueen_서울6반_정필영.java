package swea;

import java.util.Scanner;

public class Solution_d3_2806_NQueen_서울6반_정필영 {
	public static int N, answer;
	public static int[] col;

	public static boolean promising(int i) {
		for (int j=0; j<i; j++) {
			if (col[j]==col[i] || Math.abs(col[i]-col[j])==(i-j)) return false;
		}
		
		return true;
	}
	public static void nqueen(int i) {
		if (i==N) {
			answer += 1;
			return;
		}
		
		for (int j=0; j<N; j++) {
			col[i] = j;
			if(promising(i)) nqueen(i+1);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int tc=1; tc<T+1; tc++) {
			N = sc.nextInt();
			answer = 0;
			col = new int[N];
			nqueen(0);
			System.out.println("#" + tc + " " + answer);
		}

	}

}
