package swea;

import java.util.*;
import java.io.*;

public class Solution_d3_1873_상호의배틀필드_서울_06_정필영 {
	public static final int[] dy = {-1, 1, 0, 0};
	public static final int[] dx = {0, 0, -1, 1};
//	public static final char[] dir = {'^', 'v', '<', '>'};
	public static HashMap<Character, Integer> dir = new HashMap<>();
	
	public static void setDir() {
		dir.put('^', 0);
		dir.put('v', 1);
		dir.put('<', 2);
		dir.put('>', 3);
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d3_1873.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb;
		int T = Integer.parseInt(br.readLine());
		
		setDir();

		for (int tc=1; tc<T+1; tc++) {
			st = new StringTokenizer(br.readLine());
			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			
			char[][] board = new char[H][W];

			int y = -1;
			int x = -1;
			
			for (int i=0; i<H; i++) {
				String[] s = br.readLine().split("");
				for (int j=0; j<W; j++) {
					board[i][j] = s[j].charAt(0);
					if (board[i][j]=='^' || board[i][j]=='v' || board[i][j]=='<' || board[i][j]=='>') {
						y = i;
						x = j;
					}
					
				}
			}
			
			int N = Integer.parseInt(br.readLine());
			
			String[] funcS = br.readLine().split("");
			char[] func = new char[N];
			
			for (int i=0; i<N; i++) {
				
//				for (char[] b:board) System.out.println(Arrays.toString(b));
//				System.out.println();
				
				func[i] = funcS[i].charAt(0);
				
				int ny = y;
				int nx = x;
				
				if (funcS[i].equals("U")) {
					ny -= 1;
					ny = Math.max(0, ny);
					if (board[ny][nx]=='.') {
						board[ny][nx] = '^';
						board[y][x] = '.';
						y = ny;
					} else {
						board[y][x] = '^';
					}
					
				} else if (funcS[i].equals("D")) {
					ny += 1;
					ny = Math.min(H-1, ny);
					if (board[ny][nx]=='.') {
						board[ny][nx] = 'v';
						board[y][x] = '.';
						y = ny;
					} else {
						board[y][x] = 'v';
					}
					
				} else if (funcS[i].equals("L")) {
					nx -= 1;
					nx = Math.max(0, nx);
					if (board[ny][nx]=='.') {
						board[ny][nx] = '<';
						board[y][x] = '.';
						x = nx;
					} else {
						board[y][x] = '<';
					}
					
				} else if (funcS[i].equals("R")) {
					nx += 1;
					nx = Math.min(W-1, nx);
					if (board[ny][nx]=='.') {
						board[ny][nx] = '>';
						board[y][x] = '.';
						x = nx;
					} else {
						board[y][x] = '>';
					}
					
				} else if (funcS[i].equals("S")) {
					int d = dir.get(board[y][x]);
					ny += dy[d];
					nx += dx[d];
					while (0<=ny && ny<H && 0<=nx && nx<W) {
						if (board[ny][nx]=='.' || board[ny][nx]=='*' || board[ny][nx]=='-') {
							if (board[ny][nx]=='*') {
								board[ny][nx] = '.';
								break;
							}
							
							ny += dy[d];
							nx += dx[d];
						} else {
							break;
						}
					}
					
				}
				
			}
			
			sb = new StringBuilder();
			
			for (char[] b:board) {
				for (char c:b) {
					sb.append(c);
				}
				sb.append('\n');
			}
			
			System.out.print("#" + tc + " " + sb);
			
//			for (char[] b:board) System.out.println(Arrays.toString(b));
			
			
//			System.out.println(Arrays.toString(func));
//			System.out.println(y + " " + x);
//			System.out.println();
			
		}

	}

}
