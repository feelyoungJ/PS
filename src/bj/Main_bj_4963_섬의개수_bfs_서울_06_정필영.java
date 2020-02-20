package bj;

import java.io.*;
import java.util.*;

public class Main_bj_4963_섬의개수_bfs_서울_06_정필영 {
	public static final int[] dy = {-1, -1, -1, 0, 1, 1, 1, 0};
	public static final int[] dx = {-1, 0, 1, 1, 1, 0, -1, -1};
	public static int[][] board;
	public static int W, H;
	
	
	public static void main(String[] args) {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st;
		Scanner sc = new Scanner(System.in);
		
		while (sc.hasNext()) {
			W = sc.nextInt();
			H = sc.nextInt();
			if (!sc.hasNext()) break;
			board = new int[H][W];
			
			for (int i=0; i<H; i++) {
				for (int j=0; j<W; j++) {
					board[i][j] = sc.nextInt();
				}
			}
			
			int cnt = 0;
			Queue<int[]> queue = new LinkedList<>();
			
			for (int i=0; i<H; i++) {
				for (int j=0; j<W; j++) {
					if (board[i][j]==1) {
						queue.add(new int[] {i, j});
						cnt++;
						board[i][j] = 0;
						
						while (!queue.isEmpty()) {
							int[] q = queue.poll();
							
							for (int k=0; k<8; k++) {
								int ny = q[0] + dy[k];
								int nx = q[1] + dx[k];
								
								if (0<=ny && ny<H && 0<=nx && nx<W && board[ny][nx]==1) {
									queue.add(new int[] {ny, nx});
									board[ny][nx] = 0;
								}
							}
						}
//						for (int[] b:board) System.out.println(Arrays.toString(b));
//						System.out.println();
							
					}
				}
			}
			System.out.println(cnt);
		}
	}
}


