package bj;

import java.util.*;
import java.io.*;

public class Main_bj_2580_스도쿠_서울_06_정필영 {
	public static final int SIZE = 9;
	public static int[][] board;
	public static int[][] result;
	public static int checkResult;

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input_boj_2239.txt"));
		
		board = new int[SIZE][SIZE];
		result = new int[SIZE][SIZE];
		checkResult = 0;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int i=0; i<SIZE; i++) {
//			String[] t = br.readLine().split("");
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<SIZE; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				result[i][j] = 9;
			}
		}
		
		dfs(0,0);
		
//		for (int i=0; i<SIZE; i++) {
//			for (int j=0; j<SIZE; j++) {
//				System.out.print(result[i][j]);
//			}
//			System.out.println();
//		}
	}
	
	public static void dfs(int y, int x) {
		if (x==SIZE) {
			dfs(y+1, 0);
			return;
		}
		
		if (y==SIZE) {
			for (int i=0; i<SIZE; i++) {
				for (int j=0; j<SIZE; j++) {
					for (int a=0; a<SIZE; a++) {
						for (int b=0; b<SIZE; b++) {
							System.out.print(board[a][b]+" ");
						}
						System.out.println();
					}
					System.exit(0);
//					if (board[i][j]<result[i][j]) {
//						for (int a=0; a<SIZE; a++) {
//							for (int b=0; b<SIZE; b++) {
//								result[a][b] = board[a][b];
//							}
//						}
//						return;
//						
//					} if (board[i][j]>result[i][j]) {
//						return;
//					} 
					
				}
			}
			return;
		}
		
		if (board[y][x]!=0) {
			dfs(y, x+1);
			return;
		}
		
		for (int i=1; i<10; i++) {
			boolean flag = true;
			for (int j=0; j<SIZE; j++) {
				if (board[y][j]==i) {
					flag = false;
					break;
				}
			}
			
			if (flag) {
				for (int j=0; j<SIZE; j++) {
					if (board[j][x]==i) {
						flag = false;
						break;
					}
				}
			}
			
			int ny = y/3*3;
			int nx = x/3*3;
			for (int dy=ny; dy<ny+3; dy++) {
				for (int dx=nx; dx<nx+3; dx++) {
					if (board[dy][dx]==i) {
						flag = false;
						break;
					}
				}
			}
			
			if (!flag) continue;
			board[y][x] = i;
			dfs(y, x+1);
			board[y][x] = 0;
		}
	}
}
