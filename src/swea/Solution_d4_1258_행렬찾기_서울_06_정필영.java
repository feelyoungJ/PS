package swea;

import java.util.*;
import java.io.*;

public class Solution_d4_1258_행렬찾기_서울_06_정필영 {
	public static final int dy[] = {-1, 1, 0, 0};
	public static final int dx[] = {0, 0, -1, 1};
	public static int[][] board;
	public static int N, my, mx;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_1258.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
//		StringBuilder sb;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc=1; tc<=T; tc++) {
//			sb = new StringBuilder();
			N = Integer.parseInt(br.readLine());
			board = new int[N][N];
			 
			
			ArrayList<Answer> answer = new ArrayList<>();
			
			for (int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j=0; j<N; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int result = 0;
			for (int i=0; i<N; i++) {
				for (int j=0; j<N; j++) {
					if (board[i][j]>0) {
						my = i;
						mx = j;
						dfs(i, j);
						result++;
						answer.add(new Answer(my-i+1, mx-j+1));
					}
				}
			}
			
			
			Collections.sort(answer);
//			for (Answer a:answer) System.out.println(a);
			
			System.out.print("#" + tc + " " + result);
			for (Answer a:answer) System.out.print(a);
			System.out.println();
			
			
		}
	}
	
	public static void dfs(int y, int x) {
		
		board[y][x] = 0;
		
		for (int i=0; i<4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			
			if (0<=ny && ny<N && 0<=nx && nx<N && board[ny][nx]>0) {
				my = Math.max(my, ny);
				mx = Math.max(mx, nx);
				dfs(ny, nx);
			}
		}
	}
	
}
class Answer implements Comparable<Answer>{
	int row;
	int col;
	int volume;
	
	Answer(int row, int col) {
		this.row = row;
		this.col = col;
		this.volume = row*col;
	}

	@Override
	public int compareTo(Answer o) {
		if (this.volume==o.volume) {
			if (this.row==o.row) return Integer.compare(this.col, this.col);
			return Integer.compare(this.row, o.row);
		}
		return Integer.compare(this.volume, o.volume);
	}

	@Override
	public String toString() {
		return " " + row + " " + col;
	}
	
	
	
	
}
