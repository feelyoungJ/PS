package bj;

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
		int[] maxArr = new int[N];
		
		for (int n=0; n<N; n++) {
			int max = 0;
			String[] c = br.readLine().split("");
			if (n==0) {
				for (int m=0; m<M; m++) {
					board[n][m] = (Integer.parseInt(c[m])+1) % 2;
					max = Math.max(board[n][m], max);
				}
			} else {
				for (int m=0; m<M; m++) {
					int i = (Integer.parseInt(c[m])+1) % 2;
					if (i==0) board[n][m] = i;
					else board[n][m] = ((Integer.parseInt(c[m])+1) % 2) + board[n-1][m];
					max = Math.max(board[n][m], max);
				}
			}
			maxArr[n] = max+1;
			
		}
		
//		for (int[] b:board) System.out.println(Arrays.toString(b));

		int max = 0;
		for (int i=0; i<N; i++) {
			int[] dp = new int[maxArr[i]];
			for (int j=0; j<M; j++) {
				for (int k=1; k<board[i][j]+1; k++) {
					dp[k]++;
					max = Math.max(max, k*dp[k]);
				}
				Arrays.fill(dp, board[i][j]+1, maxArr[i], 0);
//				System.out.println(Arrays.toString(dp));
				
			}
		}
		System.out.println(max);
		
	}
}

class Area {
	int height;
	int width;
	int volume;
	
	Area(int height, int width)  {
		this.height = height;
		this.width = width;
		this.volume = height * width;
	}
}