package bj;

import java.util.*;
import java.io.*;

public class Main_bj_17136_색종이붙이기_fail {
	public static final int SIZE = 10;
	public static int[][] board;
	public static int[] numPaper, checkSize;
	public static int usedPaper, num;
	public static ArrayList<int []> paper;
	public static int result;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_boj_17136.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		board = new int[SIZE][SIZE];
		result = Integer.MAX_VALUE;
		
		int restPlace = 0;
		for (int i=0;i<SIZE; i++) {
			st = new StringTokenizer(br.readLine());
			int j = 0;
			while (st.hasMoreTokens()) {
				
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j]==1) restPlace++;
				j++;
			}
		}
		
		usedPaper = 0;
		paper = new ArrayList<>();
		
		checkSize= new int[5];
		
		for (int p=4; p>=1; p--) {
			checkSize[p] = paper.size();
			for (int i=0; i<SIZE-p; i++) {
				for (int j=0; j<SIZE-p; j++) {
//			for (int i=SIZE-p-1; i>=0; i--) {
//				for (int j=SIZE-p-1; j>=0; j--) {
					boolean flag = true;
					GOTO: for (int y=i; y<i+p+1; y++) {
							for (int x=j; x<j+p+1; x++) {
								if (board[y][x]==0) {
									flag = false;
									break GOTO; 
								}
							}
					}

					if (flag) {
						paper.add(new int[] {i, j, p+1});
					}
				}
			}
		}
		
		num = paper.size();
		numPaper = new int[5];
		
		
		backTracking(0, restPlace, 0);
		System.out.println(result);
		
	}
	
//	public static void dfs(int idx, int idy) {
//		
//		for(int i = idx; i < n; i++) {
//			for(int j= idy; j < n; j++) {
//				
//				//
//				
//				dfs(i, j + 1);
//				
//			}
//			idy = 0;
//		}
//	}
	
	
	public static void backTracking(int cnt, int restPlace, int pNum) {
		if (pNum>result) {
			return;
		}
		
		if (usedPaper==20 || cnt==num || (0<=restPlace && restPlace<=3)) {
			if (restPlace<=5) {
				int sum = 0;
//				for (int i:numPaper) sum += i;
//				if (result>sum + restPlace) result = sum + restPlace;
//				System.out.println(sum + restPlace);
				if (result>pNum + restPlace) result = pNum + restPlace;
				System.out.println(pNum + restPlace);
//				System.out.println(result);
			}
			return;
		}
		
		int[] p = paper.get(cnt);
		
		if (!checkPaperSize(p[2]) || numPaper[p[2]-1]==5) {
			cnt = checkSize[p[2]-1];
			p = paper.get(cnt);
		}
		
		if (numPaper[p[2]-1]<5 && checkCover(p)) {
			usedPaper++;
			numPaper[p[2]-1]++;
			backTracking(cnt+1, restPlace-p[2]*p[2], pNum + 1);
			recovery(p);
			numPaper[p[2]-1]--;
			usedPaper--;
		}
		
		if (numPaper[p[2]-1]<5) backTracking(cnt+1, restPlace, pNum);
		
	}
	
	public static boolean checkPaperSize(int p) {
		for (int i=0; i<SIZE-p+1; i++) {
			for (int j=0; j<SIZE-p+1; j++) {
				
				for (int y=i; y<i+p; y++) {
					for (int x=j; x<j+p; x++) {
						if (board[y][x]==0) {
							return true;
						} 
					}
				}
				
			}
		}
		
		return false;
	}
	
	public static boolean checkCover(int[] coveredPlace) {
		for (int i=0; i<coveredPlace[2]; i++) {
			for (int j=0; j<coveredPlace[2]; j++) {
				if (board[coveredPlace[0]+i][coveredPlace[1]+j]==0) {
					return false;
				}
			}
		}
		
		for (int i=0; i<coveredPlace[2]; i++) {
			for (int j=0; j<coveredPlace[2]; j++) {
				board[coveredPlace[0]+i][coveredPlace[1]+j] = 0;
				}
			}
		
		return true;
	}
	
	public static void recovery(int[] coveredPlace) {
		for (int i=0; i<coveredPlace[2]; i++) {
			for (int j=0; j<coveredPlace[2]; j++) {
				board[coveredPlace[0]+i][coveredPlace[1]+j] = 1;
			}
		}
	}
}
