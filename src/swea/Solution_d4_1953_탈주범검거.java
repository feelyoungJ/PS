package swea;

import java.util.*;
import java.io.*;

public class Solution_d4_1953_탈주범검거 {
	public static int[][] board;
	public static int[] dy = {-1, 1, 0, 0};
	public static int[] dx = {0, 0, -1, 1};
	public static int result, N, M, R, C, L;
	public static HashMap<Coord, Integer> resultHm;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc=1; tc<T+1; tc++) {
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			
			board = new int[N][M];
			result = 0;
			resultHm = new HashMap<>();
			int cnt = 0;
			
			for (int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j=0; j<M; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
//			for (int[] b:board) System.out.println(Arrays.toString(b));
//			board[R][C] = 0;
			dfs(cnt, R, C, -2, -2);
//			for (Coord c:resultHm.keySet()) System.out.println(c);
//			System.out.println(result);
			System.out.println("#" + tc + " " + resultHm.size());
			
//			for (int[] b:board) System.out.println(Arrays.toString(b));
		}
	}
	
	public static void dfs(int cnt, int y, int x, int pre_y, int pre_x) {
//		for (int[] b:board) System.out.println(Arrays.toString(b));
		
		if (cnt==L) {
			return;
		}
		
//		System.out.println(y + " " + x);
		result += 1;
		resultHm.put(new Coord(y, x), 1);
//		System.out.println(resultHm.get(new Coord(y, x)));

//		for (Coord c:resultHm.keySet()) System.out.println(c);
		
//		Coord c1 = new Coord(y, x);
//		Coord c2 = new Coord(y, x);
//		System.out.println(c1.equals(c2));
		
		//System.exit(0);
		
		
		
		if (board[y][x]==1) {
//			board[y][x] = 0;
			if (up(y, x) && (pre_y!=y-1)) dfs(cnt+1, y-1, x, y, x);
			if (down(y, x) && (pre_y!=y+1)) dfs(cnt+1, y+1, x, y, x);
			if (left(y, x) && (pre_x!=x-1)) dfs(cnt+1, y, x-1, y, x);
			if (right(y, x) && (pre_x!=x+1)) dfs(cnt+1, y, x+1, y, x);
		} else if (board[y][x]==2) {
//			board[y][x] = 0;
			if (up(y, x) && (pre_y!=y-1)) dfs(cnt+1, y-1, x, y, x);
			if (down(y, x) && (pre_y!=y+1)) dfs(cnt+1, y+1, x, y, x);
		} else if (board[y][x]==3) {
//			board[y][x] = 0;
			if (left(y, x) && (pre_x!=x-1)) dfs(cnt+1, y, x-1, y, x);
			if (right(y, x) && (pre_x!=x+1)) dfs(cnt+1, y, x+1, y, x);
		} else if (board[y][x]==4) {
//			board[y][x] = 0;
			if (up(y, x) && (pre_y!=y-1)) dfs(cnt+1, y-1, x, y, x);
			if (right(y, x) && (pre_x!=x+1)) dfs(cnt+1, y, x+1, y, x);
		} else if (board[y][x]==5) {
//			board[y][x] = 0;
			if (down(y, x) && (pre_y!=y+1)) dfs(cnt+1, y+1, x, y, x);
			if (right(y, x) && (pre_x!=x+1)) dfs(cnt+1, y, x+1, y, x);		
		} else if (board[y][x]==6) {
//			board[y][x] = 0;
			if (down(y, x) && (pre_y!=y+1)) dfs(cnt+1, y+1, x, y, x);
			if (left(y, x) && (pre_x!=x-1)) dfs(cnt+1, y, x-1, y, x);
		} else if (board[y][x]==7) {
//			board[y][x] = 0;
			if (up(y, x) && (pre_y!=y-1)) dfs(cnt+1, y-1, x, y, x);
			if (left(y, x) && (pre_x!=x-1)) dfs(cnt+1, y, x-1, y, x);
		}
//		else {
//			board[y][x] = 0;
//		}
	}
	
	public static boolean up(int y, int x) {
		y -= 1;
		if (0<=y && y<N && 0<=x && x<M && (board[y][x]==1 || board[y][x]==2 || board[y][x]==5 || board[y][x]==6)) {
//			System.out.println(y + " " + x);
			return true;
		}
		return false;
	}
	
	public static boolean down(int y, int x) {
		y += 1;
		if (0<=y && y<N && 0<=x && x<M && (board[y][x]==1 || board[y][x]==2 || board[y][x]==4 || board[y][x]==7)) {
//			System.out.println(y + " " + x);
			return true;
		}
		return false;
	}
	
	public static boolean left(int y, int x) {
		x -= 1;
		if (0<=y && y<N && 0<=x && x<M && (board[y][x]==1 || board[y][x]==3 || board[y][x]==4 || board[y][x]==5)) {
//			System.out.println(y + " " + x);
			return true;
		}
		return false;
	}
	
	public static boolean right(int y, int x) {
		x += 1;
		if (0<=y && y<N && 0<=x && x<M && (board[y][x]==1 || board[y][x]==3 || board[y][x]==6 || board[y][x]==7)) {
//			System.out.println(y + " " + x);
			return true;
		}
		return false;
	}

}

class Coord{
	int y;
	int x;
	public Coord(int y, int x) {
		this.y = y;
		this.x = x;
	}
	
	@Override
	public boolean equals(Object obj) {
		Coord coord = (Coord) obj;
		
		if (y==coord.y && x==coord.x) return true;
		return false;
	}

	@Override
	public int hashCode() {
		 return Objects.hash(y, x);
	}

	@Override
	public String toString() {
		return "Coord [y=" + y + ", x=" + x + "]";
	}
}
