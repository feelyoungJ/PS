package bj;

import java.io.*;
import java.util.*;

public class Main_bj_6987_월드컵 {
	public static int[] result, answer;
	public static int[][] input;

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		result = new int[18];
		input = new int[4][18];
		answer = new int[4];
		
		for (int i=0; i<4; i++) {
			for (int j=0; j<18; j++) {
				input[i][j] = sc.nextInt();
			}
		}
		
		dfs(0, 1);
		for (int i=0; i<4; i++) {
			System.out.print(answer[i] + " ");
		}
	}
	
	public static void dfs(int a, int b) {
		result[a*3] += 1;
		result[b*3+2] += 1;
		if (a==4) {
			check();
		} else if (b==5) {
			dfs(a+1, a+2);
		} else {
			dfs(a, b+1);
		}
		
		result[a*3] -= 1;
		result[b*3+2] -= 1;
		result[a*3+2] += 1;
		result[b*3] += 1;
		if (a==4) {
			check();
		} else if (b==5) {
			dfs(a+1, a+2);
		} else {
			dfs(a, b+1);
		}
		
		result[a*3+2] -= 1;
		result[b*3] -= 1;
		result[a*3+1] += 1;
		result[b*3+1] += 1;
		if (a==4) {
			check();
		} else if (b==5) {
			dfs(a+1, a+2);
		} else {
			dfs(a, b+1);
		}
		result[a*3+1] -= 1;
		result[b*3+1] -= 1;
	}
	
	public static void check() {
		for (int i=0; i<4; i++) {
			if (Arrays.equals(input[i], result)) {
				answer[i] = 1;
			}
		}
	}
}
