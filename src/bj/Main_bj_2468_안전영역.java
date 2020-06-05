package bj;

import java.util.*;
import java.io.*;

public class Main_bj_2468_안전영역 {
	static int[][] board, visit;
	static final int[] dy = {1, -1, 0, 0};
	static final int[] dx = {0, 0, 1, -1};
	static int N, area;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		board = new int[N][N];
		
		int max_height = 0;
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				max_height = Math.max(max_height, board[i][j]);
			}
		}
		
		int result = 1;
		for (int m=1; m<max_height; m++) {
			visit = new int[N][N];
			rain_drop();
			area = 0;
			for (int i=0; i<N; i++) {
				for (int j=0; j<N; j++) {
					if (board[i][j]>0 && visit[i][j]==0) {
						visit[i][j] = 1;
						dfs(i, j);
						area++;
					}
				}
			}
			result = Math.max(result, area);
		}
		System.out.println(result);

	}
	
	static void dfs(int y, int x) {
		
		for (int i=0; i<4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			
			if (0<=ny && ny<N && 0<=nx && nx<N && board[ny][nx]>0 && visit[ny][nx]==0) {
				visit[ny][nx] = 1;
				dfs(ny, nx);
			}
		}
		
	}
	
	static void rain_drop() {
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				board[i][j] -= 1;
			}
		}
	}

}
