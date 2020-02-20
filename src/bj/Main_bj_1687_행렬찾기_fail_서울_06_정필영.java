package bj;

import java.util.*;
import java.io.*;

public class Main_bj_1687_행렬찾기_fail_서울_06_정필영 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] board = new int[N][M];
		
		for (int n=0; n<N; n++) {
			String[] c = br.readLine().split("");
			for (int m=0; m<M; m++) {
				board[n][m] = (Integer.parseInt(c[m])+1) % 2;
			}
		}
		
//		for (int[] b:board) System.out.println(Arrays.toString(b));
		
		int max = 0;
		
		for (int k=N-2; k>=0; k--) {
			for (int i=k; i>=0; i--) {
				for (int l=N-k-1; l>=1; l--) {
					if (board[i][k]>=1 && board[i+1][k]>=l && board[i][k+1]>=l && board[i+1][k+1]>=l) {
						board[i][k] = l + 1;
						max = Math.max(max, l+1);
						break;
					}
				}
				
			}
			for (int j=k; j>=0; j--) {
				for (int l=N-k-1; l>=1; l--) {
					if (board[k][j]>=1 && board[k+1][j]>=l && board[k][j+1]>=l && board[k+1][j+1]>=l) {
						board[k][j] = l + 1;
						max = Math.max(max, l+1);
						break;
					}
				}
			}
		}
//		System.out.println();
		for (int[] b:board) System.out.println(Arrays.toString(b));
		System.out.println(max*max);
		
	}
	
	

	
	
	

}
