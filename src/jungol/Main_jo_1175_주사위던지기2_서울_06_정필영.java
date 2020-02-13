package jungol;

import java.util.Arrays;
import java.util.Scanner;

public class Main_jo_1175_주사위던지기2_서울_06_정필영 {
	public static int N, M;
	public static int[] dice = {1, 2, 3, 4, 5, 6};
	public static int[] list;
	
	public static boolean permutation(int cnt) {
		
		if (cnt==N) {
			int sum = 0;
			for (int n:list) sum += n;
			// System.out.println(Arrays.toString(list));
			if (sum==M) {
				for (int i=0; i<N; i++) {
					System.out.print(list[i] + " ");
				}
				System.out.println();
			}
			return false;
			
		}
		
		for (int i=0; i<dice.length; i++) {
			list[cnt] = dice[i];
			permutation(cnt+1);
		}
		
		return false;
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		list = new int[N];
		
		permutation(0);
		sc.close();
	}
}
