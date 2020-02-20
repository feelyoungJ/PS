package bj;

import java.util.*;
import java.io.*;

public class Main_bj_17135_캐슬디펜스_서울_06_정필영 {
	public static final int numArcher = 3;
	
	public static int board[][], copyBoard[][];
	public static int archer[], visit[];
	public static int N, M, D, sum, max;
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for (int tc=0; tc<1; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			D = Integer.parseInt(st.nextToken());
			
			board = new int[N][M];
			visit = new int[M];
			archer = new int[3];
			max = 0;
			
			for (int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j=0; j<M; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			bit(0, 0);
			System.out.println(max);
		}
	}
	
	public static void bit(int cnt, int start) {
		if (cnt==numArcher) {
//			System.out.println(Arrays.toString(archer));
			sum = 0;
			copyBoard = new int[N][M];
			for (int i=0; i<N; i++) {
				for (int j=0; j<M; j++) {
					copyBoard[i][j] = board[i][j];
				}
			}
			
			for (int i=0; i<N; i++) {
				search(new int[] {archer[0], archer[1], archer[2]});
			}
//			System.exit(0);
			max = Math.max(max, sum);
			return;
		}
		
		for (int i=start; i<M; i++) {
			if (visit[i]==0) {
				visit[i] = 1;
				archer[cnt] = i;
				bit(cnt+1, i);
				visit[i] = 0;
			}
		}
	}
	
	public static void search(int copyArcher[]) {
		ArrayList<int[]> died = new ArrayList<>();
		
		for (int k=0; k<3; k++) {
			int flag = 0;
			for (int d=0; d<D; d++) {
				if (flag==1) break;
				for (int j=-d; j<=d; j++) {
					int i = d - Math.abs(j);
					
					int y = N - 1 - i;
					int x = j + copyArcher[k];
					
					
					if (0<=y && y<N && 0<=x && x<M && copyBoard[y][x]==1) {
						died.add(new int[] {y, x});
						flag = 1;
						break;
					}
				}
			}
			
		}
		
		for (int[] d:died) {
			if (copyBoard[d[0]][d[1]]==1) {
				copyBoard[d[0]][d[1]] = 0;
				sum++;
			}
			
//			System.out.println(Arrays.toString(d));
		}
		
		for (int i=N-2; i>=0; i--) {
			for (int j=0; j<M; j++) {
				copyBoard[i+1][j] = copyBoard[i][j];
			}
		}
		
		for (int j=0; j<M; j++) {
			copyBoard[0][j] = 0;
		}
		
//		for (int[] c:copyBoard) System.out.println(Arrays.toString(c));
//		System.out.println();
	}
}
