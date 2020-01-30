package swea;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_d3_2817_부분수열의합_서울6반_정필영 {
	public static int N, K, result;
	public static int[] sequence;
	public static int[] list;
	
	
	public static void permutation(int cnt) {
		if (cnt==N) {
			int sum = 0;
			for (int i=0; i<N; i++) {
				if (list[i]==1) {
					sum += sequence[i];
				}
			}
			if (sum==K) result += 1;
			//System.out.println(Arrays.toString(list));

			return;
		}
		
		list[cnt] = 0; // d[0]
		permutation(cnt+1);
		list[cnt] = 1; // d[1]
		permutation(cnt+1);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int tc=1; tc<T+1; tc++) {
			N = sc.nextInt();
			K = sc.nextInt();
			
			result = 0;
			sequence = new int[N];
			list = new int[N];
			
			for (int i=0; i<N; i++) {
				sequence[i] = sc.nextInt();
			}
			permutation(0);
			System.out.println("#" + tc + " " + result);
		}
		
		sc.close();

	}

}
