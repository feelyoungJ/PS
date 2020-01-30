package swea;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Solution_d3_9229_한빈이와SpotMart_서울6반_정필영 {
	public static ArrayList<Integer> snacks;
	public static int[] arr = new int[2];
	public static int[] vct;
	public static int N, M, result;
	
	public static boolean combination(int start, int cnt) {
		if (cnt==2) {
			int sum = 0;
			for (int w:arr) {
				sum += w;
			}
			
			if (sum>result && sum<=M) result = sum;
			
			return false;
		}
		
		for (int i=start; i<snacks.size(); i++) {
			if (vct[i]==0) {
				vct[i] = 1;
				arr[cnt] = snacks.get(i);
				combination(i, cnt+1);
				vct[i] = 0;
			}
		}
		return true;
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int tc=1; tc<T+1; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			result = -1;
			
			snacks = new ArrayList<>();
			
			for (int i=0; i<N; i++) {
				snacks.add(sc.nextInt());
			}
			vct = new int[snacks.size()];
			
			combination(0, 0);
			System.out.println("#" + tc + " " + result);
		}
	}
}
