package boj;

import java.util.*;
import java.io.*;

public class Main_bj_1687_행렬찾기_서울_06_정필영 {
	public static int N;
	public static int M;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int[][] board = new int[N][M];
		
		for (int n=0; n<N; n++) {
			String[] c = br.readLine().split("");
			for (int m=0; m<M; m++) {
				board[n][m] = (Integer.parseInt(c[m])+1) % 2;
			}
		}
		
//		for (int[] b:board) System.out.println(Arrays.toString(b));
		
		dfs(0, 0);
	}
	
	
	public static void dfs(int y, int x) {
		
		
		for (int i=0; i<N-y; i++) {
			
		}
	}
}
