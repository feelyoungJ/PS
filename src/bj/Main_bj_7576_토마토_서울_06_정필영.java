package bj;

import java.util.*;
import java.io.*;

public class Main_bj_7576_토마토_서울_06_정필영 {
	public static final int[] dy = {1, -1, 0, 0};
	public static final int[] dx = {0, 0, 1, -1};
	

	public static void main(String[] args) throws Exception {
//		Scanner sc = new Scanner(System.in);
//		int M = sc.nextInt();
//		int N = sc.nextInt();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		
		int[][] board = new int[N][M];
		
		Queue<int[]> queue = new LinkedList<>();
		
		int ripeTomato = 0;
		int unripeTomato = 0;
		
		for (int n=0; n<N; n++) {
			st = new StringTokenizer(br.readLine()); //
			for (int m=0; m<M; m++) {
//				board[n][m] = sc.nextInt();
				board[n][m] = Integer.parseInt(st.nextToken());
				if (board[n][m]==1) {
					board[n][m] = 2;
					queue.add(new int[] {n, m, 0});
					ripeTomato++;
				} if (board[n][m]==0) {
					unripeTomato++;
				}
			}
		}
		
//		for (int[] b:board) System.out.println(Arrays.toString(b));
		
		int timeCount = 0;
		int tomatoCount = 0;
		while (!queue.isEmpty()) {
//			if (unripeTomato==tomatoCount) {
//				break;
//			}
			
			int[] q = queue.poll();
			int y = q[0];
			int x = q[1];
			timeCount = q[2];
			
			
			

			for (int i=0; i<4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				
				if (0<=ny && ny<N && 0<=nx && nx<M && board[ny][nx]==0) {
					tomatoCount++;
					board[ny][nx] = 2;
					queue.add(new int[] {ny, nx, q[2]+1});
				}
			}
		}
//		System.out.println(unripeTomato);
//		System.out.println(tomatoCount);
//		
		if (unripeTomato==tomatoCount) System.out.println(timeCount);
		else System.out.println(-1);

	}

}
