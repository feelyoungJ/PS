package swea;

import java.util.*;
import java.io.*;

public class Solution_d4_2105_디저트카페 {
	public static final int[] dy = {1, 1, -1, -1};
	public static final int[] dx = {-1, 1, 1, -1};
	public static int[] move;
	public static int[][] board;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_2105.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc=1; tc<T+1; tc++) {
			int N = Integer.parseInt(br.readLine());
			board = new int[N][N];
			
			move = new int[] {0, 0, 0, 0};
			
			for (int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j=0; j<N; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int result = -1;
			
			EXIT: for (int n=N-1; n>=2; n--) {
//				System.out.println(n);
				for (int i=1; i<n;i++) {
					int j = n-i;
//					System.out.println(i + " " + j);
					
					for (int ny=0; ny<N-n; ny++) {
						for (int nx=i; nx<N-j; nx++) {
//							System.out.println("dydx=" + dy+ " " + dx);
							ArrayList<Integer> checkList = new ArrayList<>();
							int y = ny;
							int x = nx;
							
							boolean flag = true;
							
							if (flag) {
								for (int k=0; k<i; k++) {
									y = y + dy[0];
									x = x + dx[0];
									if (checkList.contains(board[y][x])) {
										flag = false;
										break;
									}
									checkList.add(board[y][x]);
								}
							}
							
							if (flag) {
								for (int k=0; k<j; k++) {
									y = y + dy[1];
									x = x + dx[1];
									if (checkList.contains(board[y][x])) {
										flag = false;
										break;
									}
									checkList.add(board[y][x]);
								}
							}

							if (flag) {
								for (int k=0; k<i; k++) {
									y = y + dy[2];
									x = x + dx[2];
									if (checkList.contains(board[y][x])) {
										flag = false;
										break;
									}
									checkList.add(board[y][x]);
								}
							}
							
							
							if (flag) {
								for (int k=0; k<j; k++) {
									y = y + dy[3];
									x = x + dx[3];
									if (checkList.contains(board[y][x])) {
										flag = false;
										break;
									}
									checkList.add(board[y][x]);
								}
							}
							
							if (flag) {
								result = checkList.size();
								break EXIT;
							}
						}
					}
				}
			}
			System.out.println("#" + tc + " " + result);
		}
	}
}
