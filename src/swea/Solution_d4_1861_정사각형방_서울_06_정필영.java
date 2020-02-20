package swea;

import java.util.*;
import java.io.*;

public class Solution_d4_1861_정사각형방_서울_06_정필영 {
	public static final int[] dy = {-1, 1, 0, 0};
	public static final int[] dx = {0, 0, -1, 1};
	
	public static int[][] board;
	public static int[][] cache;
	public static int N, result;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_1861.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc=1; tc<T+1; tc++) {
			N = Integer.parseInt(br.readLine());
			board = new int[N][N];
			cache = new int[N][N];
			
			
			for (int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j=0; j<N; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int max = 0;
			int room = Integer.MAX_VALUE;
			for (int i=0; i<N; i++) {
				for (int j=0; j<N; j++) {
					if (cache[i][j]==0) {
						result = 0;
						dfs(i, j);
						
						 //&& room>board[i][j]
						if (result+1>max) {
							max = result + 1;
							room = board[i][j];
						} else if (result+1==max && room>board[i][j]) {
							room = board[i][j];
						}
					}
				}
			}
			System.out.println("#" + tc + " " + room + " " + max);
			
		}

	}
	
	
	public static void dfs(int y, int x) {
		for (int i=0; i<4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if (0<=ny && ny<N && 0<=nx && nx<N) {
				if (board[y][x]+1==board[ny][nx]) {
					cache[ny][nx] = 1;
					result++;
					dfs(ny, nx);
					break;
				}
			}
		}
	}
}
