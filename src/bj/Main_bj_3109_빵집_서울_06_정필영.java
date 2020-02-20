package bj;

import java.util.*;
import java.io.*;

public class Main_bj_3109_빵집_서울_06_정필영 {
	public static final int[] dy = {-1, 0, 1};
	
	public static int R, C, cnt, max, check;
	public static char board[][];
	public static String[] s;
	
	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("res/input.txt"));
		
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
		
		for (int i=0; i<R; i++) {
			check = 0;
			dfs(i, 0);
		}
//		for (char[] b:board) System.out.println(Arrays.toString(b));
		System.out.println(cnt);
		
	}
	
	public static void dfs(int y, int x) {
		int nx = x + 1;
		if (nx==C-1) {
			if (board[y][nx]=='.') {
				check = 1;
				board[y][nx] = 'O';
				cnt++;
			}
			return;
		}
		
		for (int i=0; i<3; i++) {
			int ny = y + dy[i];
			if (0<=ny && ny<R && board[ny][nx]=='.' && check==0) {
				board[ny][nx] = 'O';
				dfs(ny, nx);
//				if (check==0) {
//					board[ny][nx] = '.';
//				} else {
//					return;
//				}
				if (check==1) return;
				
			}
		}	
	}
}