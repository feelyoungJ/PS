package bj;

import java.util.*;
import java.io.*;

public class Main_bj_7569_토마토_서울_06_정필영 {
	public static final int[] dz = {0, 0, 0, 0, 1, -1};
	public static final int[] dy = {1, -1, 0, 0, 0, 0};
	public static final int[] dx = {0, 0, 1, -1, 0, 0};
	

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		
		
		int[][][] board = new int[H][N][M];
		
		Queue<int[]> queue = new LinkedList<>();
		
		int ripeTomato = 0;
		int unripeTomato = 0;
		
		for (int h=0; h<H; h++) {
			for (int n=0; n<N; n++) {
				st = new StringTokenizer(br.readLine()); //
				for (int m=0; m<M; m++) {
					board[h][n][m] = Integer.parseInt(st.nextToken());
					if (board[h][n][m]==1) {
						board[h][n][m] = 2;
						queue.add(new int[] {h, n, m, 0});
						ripeTomato++;
					} if (board[h][n][m]==0) {
						unripeTomato++;
					}
				}
			}
		}
		
		
		int timeCount = 0;
		int tomatoCount = 0;
		while (!queue.isEmpty()) {
			
			int[] q = queue.poll();
			int z = q[0];
			int y = q[1];
			int x = q[2];
			timeCount = q[3];
			
			
			

			for (int i=0; i<6; i++) {
				int nz = z + dz[i];
				int ny = y + dy[i];
				int nx = x + dx[i];
				
				if (0<=ny && ny<N && 0<=nx && nx<M && 0<=nz && nz<H && board[nz][ny][nx]==0) {
					tomatoCount++;
					board[nz][ny][nx] = 2;
					queue.add(new int[] {nz, ny, nx, q[3]+1});
				}
			}
		}
		if (unripeTomato==tomatoCount) System.out.println(timeCount);
		else System.out.println(-1);

	}

}
