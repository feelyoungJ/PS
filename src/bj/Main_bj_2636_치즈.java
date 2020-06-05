package bj;

import java.io.*;
import java.util.*;

public class Main_bj_2636_치즈 {
	static final int dy[] = {1, -1, 0, 0};
	static final int dx[] = {0, 0, 1, -1};
	
	static int[][] board, air;
	static int N, M, num;
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		board = new int[N][M];
		
		num = 0;
		
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				board[i][j] = sc.nextInt();
				if (board[i][j] == 1) num++;
			}
		}
		
		int result = 0;
		int last_cheese = 0;
		while (num!=0) {
			last_cheese = num;
			result++;
			air = new int[N][M];
			dfs_air(0, 0);
			List<int[]> removed_cheese = new ArrayList<>();
			for (int y=1; y<N-1; y++) {
				for (int x=1; x<M-1; x++) {
					if (board[y][x]==1) {
						for (int i=0; i<4; i++) {
							int ny = y + dy[i];
							int nx = x + dx[i];
							
							if (0<=ny && ny<N && 0<=nx && nx<M && air[ny][nx]==1) {
								removed_cheese.add(new int[] {y, x});
								num--;
								break;
							}
						}
					}
				}
			}
			for (int[] r:removed_cheese) {
				board[r[0]][r[1]] = 0; 
			}
			
////			System.out.println(num);
////			for (int[] r:air) {System.out.println(Arrays.toString(r));}
////			System.out.println();
////			for (int[] r:board) {System.out.println(Arrays.toString(r));}
////			break;
		}
		
		System.out.println(result);
		System.out.println(last_cheese);
		
		
		
	}
	
	static void dfs_air(int y, int x) {
		
		for (int i=0; i<4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			
			if (0<=ny && ny<N && 0<=nx && nx<M && board[ny][nx]==0 && air[ny][nx]==0) {
				air[ny][nx] = 1;
				dfs_air(ny, nx);
			}
		}
		
	}
}
