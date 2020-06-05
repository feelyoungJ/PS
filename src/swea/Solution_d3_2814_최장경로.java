package swea;

import java.io.*;
import java.util.*;

public class Solution_d3_2814_최장경로 {
	static int[][] board;
	static int[] visited;
	static int N, M, result, cnt;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			result = 1;
			
			board = new int[N][N];
			visited = new int[N];
			
			for (int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken())-1;
				int b = Integer.parseInt(st.nextToken())-1;
				board[a][b] = 1;
				board[b][a] = 1;
			}

			for (int i=0; i<N; i++) {
				visited[i] = 1;
				dfs(i, 1);
				visited[i] = 0;
			}
			System.out.println("#" + tc + " " + result);
			

		}

	}
	
	static void dfs(int v, int cnt) {
		result = Math.max(result, cnt);
		
		for (int i=0; i<N; i++) {
			if (board[v][i]==1 && visited[i]==0) {
				visited[i] = 1;
				dfs(i, cnt+1);
				visited[i] = 0;
			}
		}
	}

}
