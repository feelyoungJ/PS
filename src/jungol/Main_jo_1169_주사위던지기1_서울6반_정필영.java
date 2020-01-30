package jungol;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main_jo_1169_주사위던지기1_서울6반_정필영 {
	public static int N, M;
	public static int dice[] = {1, 2, 3, 4, 5, 6};
	public static int set[];
	public static int subArr[];
	
	

	public static void product(int cnt) {
		if (cnt==N) {
			for (int e:subArr) {
				System.out.print(e + " ");
			}
			System.out.println();
			return;
		}
		
		for (int i=0; i<dice.length; i++) {
			subArr[cnt] = dice[i];
			product(cnt+1);
		}
	}
	
	public static void combination(int start, int cnt) {
		if (cnt==N) {
			for (int e:subArr) {
				System.out.print(e + " ");
			}
			System.out.println();
			return;
		}
		
		for (int i=start; i<dice.length; i++) {
			subArr[cnt] = dice[i];
			combination(i, cnt+1);
		}
	}
	
	public static void permutation(int cnt) {
		
		if (cnt==N) {
			for (int e:subArr) {
				System.out.print(e + " ");
			}
			System.out.println();
			return;
		} 
		
		for (int i=0; i<dice.length; i++) {
			if (set[i]==0) {
				set[i] = 1;
				subArr[cnt] = dice[i];
				permutation(cnt+1);
				set[i] = 0;
			}
		}
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		subArr = new int[N];
		set = new int[dice.length];
		
		if (M==1) product(0);
		else if (M==2) combination(0, 0); 
		else if (M==3) permutation(0);
		
		sc.close();

	}

}
