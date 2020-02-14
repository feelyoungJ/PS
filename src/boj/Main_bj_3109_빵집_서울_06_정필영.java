package boj;

import java.util.*;
import java.io.*;

public class Main_bj_3109_빵집_서울_06_정필영 {
	public static final int[] dy = {-1, 0, 1};
	
	public static int R, C, cnt, max, check;
	public static char board[][];
	public static String[] s;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		s = br.readLine().split(" ");
		R = Integer.parseInt(s[0]);
		C = Integer.parseInt(s[1]);
		board = new char[R][C];
		for (int i=0; i<R; i++) {
			s = br.readLine().split("");
			for (int j=0; j<C; j++) {
				board[i][j] = s[j].charAt(0);
			}
		}
		cnt = 0;
		max = 0;
		check = 0;
		dfs(0, 0, 0);
	}
	
	public static void dfs(int y, int x, int start) {
//		if (start==R-1 && ((x+1<C && board[y][x+1]!='.') || (y-1>0 && x+1<C && board[y-1][x+1]!='.'))) {
		if (y==R-1) {
//			for (char[] b:board) System.out.println(Arrays.toString(b));
			check = 1;
			int sum = 0;
			for (int i=0; i<R; i++) {
				if (board[i][C-1] == 'O') sum+=1;
			}
			System.out.println(sum);
//			System.out.println(cnt);
			//System.exit(0);
		}
		
		if (x==C-1) {
			cnt++;
			if (start+1<R && check==0) dfs(start+1, 0, start+1);
			return;
		}
		
		boolean flag = true;
		for (int i=0; i<3; i++) {
			int ny = y + dy[i];
			int nx = x + 1;
			
			if (0<=ny && ny<R && nx<C && board[ny][nx]=='.' && check==0) {
				board[ny][nx] = 'O';
				dfs(ny, nx, start);
				board[ny][nx] = '.';
				flag = false;
			}
		}
		
		if (flag && start+1<R && check==0) dfs(start+1, 0, start+1);
		
	}
}