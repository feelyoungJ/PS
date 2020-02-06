package swea;

import java.io.*;
import java.util.*;

public class Solution_d4_5644_무선충전_서울6반_정필영 {
	public static int M, A;
	public static int[] aInfo, bInfo;
	public static int[][] AP;
	public static final int SIZE = 10;
	public static final int[] dirY = {0, -1, 0, 1, 0};
	public static final int[] dirX = {0, 0, 1, 0, -1};
	public static ArrayList<Integer>[][] board;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_5644.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc=1; tc<T+1; tc++) {
			st = new StringTokenizer(br.readLine());
			
			M = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());
			aInfo = new int[M];
			bInfo = new int[M];
			AP = new int[A][4];
			board = new ArrayList[SIZE][SIZE];
			
			for (int i=0; i<SIZE; i++) {
				for (int j=0; j<SIZE; j++) {
					board[i][j] = new ArrayList<>();
				}
			}
			
			
			st = new StringTokenizer(br.readLine());
			for (int i=0; i<M; i++) {
				aInfo[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			for (int i=0; i<M; i++) {
				bInfo[i] = Integer.parseInt(st.nextToken());
			}
			
			for (int i=0; i<A; i++) {
				st = new StringTokenizer(br.readLine());
				AP[i][1] = Integer.parseInt(st.nextToken());
				AP[i][0] = Integer.parseInt(st.nextToken());
				for (int j=2; j<4; j++) {
					AP[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int i=0; i<A; i++) {
				for (int dy=-AP[i][2]; dy<AP[i][2]+1; dy++) {
					for (int dx=-AP[i][2]; dx<AP[i][2]+1; dx++) {
						
						if (Math.abs(dy)+Math.abs(dx)<=AP[i][2]) {
							// -, + 상관 없을듯
							int ny = AP[i][0]-1-dy;
							int nx = AP[i][1]-1-dx;
							if (0<=ny && ny<SIZE && 0<=nx && nx<SIZE)
								board[ny][nx].add(i);
						}
					}
				}
			}
			
			int ay = 0;
			int ax = 0;
			int by = 9;
			int bx = 9;
			
			int result = 0;
			
			result += getPoint(ay, ax, by, bx);
			for (int i=0; i<M; i++) {
				ay += dirY[aInfo[i]];
				ax += dirX[aInfo[i]];
				by += dirY[bInfo[i]];
				bx += dirX[bInfo[i]];
				
				int point = getPoint(ay, ax, by, bx); 
				result += point;
			}
			
			System.out.println("#" + tc + " " + result);
		}
	}
	public static int getPoint(int ay, int ax, int by, int bx) {

		int maxAIndex = -1;
		int maxBIndex = -1;
		int elec = 0;
		
		if (board[ay][ax].size()==1 && board[by][bx].size()==1) {
			maxAIndex = board[ay][ax].get(0);
			maxBIndex = board[by][bx].get(0);
			if (maxAIndex==maxBIndex) {
				elec = AP[maxAIndex][3];
			} else {
				elec = AP[maxAIndex][3]+AP[maxBIndex][3];
			}
			
			return elec;
		} else {
			int maxA = 0;
			
			for (int i=0; i<board[ay][ax].size(); i++) {
				if (maxA<AP[board[ay][ax].get(i)][3]) {
					maxA = AP[board[ay][ax].get(i)][3];
					maxAIndex = board[ay][ax].get(i);
				} 
			}
			
			int maxB = 0;
			
			for (int i=0; i<board[by][bx].size(); i++) {
				if (maxB<AP[board[by][bx].get(i)][3]) {
					maxB = AP[board[by][bx].get(i)][3];
					maxBIndex = board[by][bx].get(i);
				} 
			}
			
			if (maxAIndex==maxBIndex && maxAIndex!=-1) {
				int maxOverlap = 0;
				
				for (int i=0; i<board[ay][ax].size(); i++) {
					if (maxOverlap<AP[board[ay][ax].get(i)][3] && board[ay][ax].get(i)!=maxAIndex) {
						maxOverlap = AP[board[ay][ax].get(i)][3];
					} 
				}
				
				for (int i=0; i<board[by][bx].size(); i++) {
					if (maxOverlap<AP[board[by][bx].get(i)][3] && board[by][bx].get(i)!=maxBIndex) {
						maxOverlap = AP[board[by][bx].get(i)][3];
					} 
				}
				return maxA + maxOverlap;
			} else {
				return maxA + maxB;
			}
			
		}
	}
}



