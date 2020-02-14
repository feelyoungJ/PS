package boj;

import java.util.*;
import java.io.*;

public class Main_bj_17136_색종이붙이기 {
	public static final int SIZE = 10;
	public static int[][] board;
	public static int[] paper;
	public static int result, cnt;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_boj_17136.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		paper = new int[] {0, 5, 5, 5, 5, 5};
		board = new int[SIZE][SIZE];
		result = Integer.MAX_VALUE;
		cnt = 0;
		for (int i=0;i<SIZE; i++) {
			st = new StringTokenizer(br.readLine());
			int j = 0;
			while (st.hasMoreTokens()) {
				
				board[i][j++] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0,0);
		if (result==Integer.MAX_VALUE) {
			System.out.println(-1);
		} 
		else {
			System.out.println(result);
			}
		
		
	}
	
	public static void dfs(int idy, int idx) {
		if (idx==SIZE) {
			dfs(idy+1, 0);
			return;
		}
		
		if (idy==SIZE) {
			result = Math.min(result, cnt);
			return;
		}
		
		if (board[idy][idx]==0) {
			dfs(idy, idx+1);
			return;
		}
		
		
		for (int len=5; len>=1; len--) {
			if (paper[len]==0 || idy+len>SIZE || idx+len>SIZE) {
				continue;
			}
			boolean flag = true;
			for (int i=0; i<len; i++) {
				for (int j=0; j<len; j++) {
					if (board[idy+i][idx+j]==0) {
						flag = false;
						break;
					}
					if (!flag) break;
				}
			}
			if (!flag) continue;
			
			for (int i=0; i<len; i++) {
				for (int j=0; j<len; j++) {
					board[idy+i][idx+j] = 0;
				}
			}
			paper[len]--;
			cnt++;
			dfs(idy, idx+len);
			for (int i=0; i<len; i++) {
				for (int j=0; j<len; j++) {
					board[idy+i][idx+j] = 1;
				}
			}
			paper[len]++;
			cnt--;
		}
	}
	
	
	
}
