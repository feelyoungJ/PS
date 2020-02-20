package swea;

import java.io.*;
import java.util.*;


public class Solution_d4_1227_미로2_bfs_서울_06_정필영 {
	public static final int SIZE = 100;
	public static int[][] board;
	public static int[] dx = {1, 0, -1, 0};
	public static int[] dy = {0, 1, 0, -1};
	public static int[] start;
	public static int[] end;
	public static boolean flag;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_1227.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int tc=1; tc<=10; tc++) {
			
			board = new int[SIZE][SIZE];
			start = new int[2];
			end = new int[2];
			flag = false;
			Queue<int[]> queue = new LinkedList<>();
			
			br.readLine();
			
			for (int i=0; i<SIZE; i++) {
				String[] row = br.readLine().split("");
				for (int j=0; j<SIZE; j++) {
					board[i][j] = Integer.parseInt(row[j]);
					if (board[i][j]==2) {
						start[0] = i;
						start[1] = j;
					}
				}
			}
			
			queue.offer(start);
			
			while (!queue.isEmpty()) {
				int[] q = queue.poll();
				
				int y = q[0];
				int x = q[1];
				
				for (int i=0; i<4; i++) {
					int ny = y + dy[i];
					int nx = x + dx[i];
					if (!flag && 0<=ny && ny<SIZE && 0<=nx && nx<SIZE && (board[ny][nx]==0 || board[ny][nx]==3)) {
						if (board[ny][nx]==3) {
							flag = true;
						} else {
							board[ny][nx] = 1;
							queue.offer(new int[] {ny, nx});
						}
					}
				}
			}
			
			if (flag) System.out.println("#" + tc + " 1" );
			else System.out.println("#" + tc + " 0" );
			
		}
		
	}
}
