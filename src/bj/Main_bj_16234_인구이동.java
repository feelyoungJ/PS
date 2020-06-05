package bj;

import java.util.*;
import java.io.*;

public class Main_bj_16234_인구이동 {
	final static int[] dy = {0, 1, 0, -1};
	final static int[] dx = {1, 0, -1, 0};
	
	static int[][] board;
	static int[][] union;
	static int N, L, R, U;
	static ArrayList<int[]> sumPopul;
	static ArrayList<Integer> movePopul;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		board = new int[N][N];

		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int result = 0;
		while(true) {
			union = new int[N][N];
			sumPopul = new ArrayList<>();
			sumPopul.add(new int[] {0, 0});
			U = 1;
			for (int i=0; i<N; i++) {
				for (int j=0; j<N; j++) {
					if (union[i][j]==0) {
						sumPopul.add(new int[] {board[i][j], 1});
						union[i][j] = U;
						dfs(i, j);
						U++;
					}
				}
			}
			
			if (U>N*N) {
				break;
			}
			result += 1;
			move();
			
			for (int i=0; i<N; i++) {
				for (int j=0; j<N; j++) {
					board[i][j] = movePopul.get(union[i][j]);
				}
			}
			
//			for (int m : movePopul) System.out.println(m);
//			for (int[] b : board) System.out.println(Arrays.toString(b));
//			for (int[] u : union) System.out.println(Arrays.toString(u));
//			System.out.println();
			
			


		}
		
//		for (int[] u : union) System.out.println(Arrays.toString(u));
//		for (int[] s : sumPopul) System.out.println(Arrays.toString(s));
//		for (int m : movePopul) System.out.println(m);
//		for (int[] b : board) System.out.println(Arrays.toString(b));
		System.out.println(result);
		
	}
	
	public static void dfs(int y, int x) {
		for (int i=0; i<4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			
			if (0<= ny && ny<N && 0<= nx && nx<N) {
				int gap = Math.abs(board[y][x] - board[ny][nx]);
				if(L<=gap && gap<=R && union[ny][nx]==0) {
					union[ny][nx] = U;
					sumPopul.set(U, new int[] {sumPopul.get(U)[0] + board[ny][nx], sumPopul.get(U)[1]+1});
					dfs(ny, nx);
				}
			}
		}
	}
	
	public static void move() {
		movePopul = new ArrayList<>();
		movePopul.add(0);
		
		for (int i=1; i<U; i++) {
			movePopul.add(sumPopul.get(i)[0]/sumPopul.get(i)[1]);
		}
	}
}
