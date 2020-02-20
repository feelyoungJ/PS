package bj;

import java.util.*;
import java.io.*;

public class Main_bj_2630_색종이만들기_서울_06_정필영 {
	public static int[][] board;
	public static int num0, num1;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		board = new int[N][N];
		num0 = 0;
		num1 = 0;
		
		
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dnc(N, 0, 0);
		System.out.println(num0);
		System.out.println(num1);
	}
	
	public static int dnc(int n, int y, int x) {
		if (n==1) {
			if (board[y][x]==1) return 1;
			else return 0;
		}
		
		int mid = n / 2;
		int quadrant1 = dnc(mid, y, x);
		int quadrant2 = dnc(mid, y+mid, x);
		int quadrant3 = dnc(mid, y, x+mid);
		int quadrant4 = dnc(mid, y+mid, x+mid);
		
		if (quadrant1==quadrant2 && quadrant1==quadrant3 && quadrant1==quadrant4) {
			return quadrant1;
		} else {
			if (quadrant1==1) num1++;
			else if (quadrant1==0) num0++;
			if (quadrant2==1) num1++;
			else if (quadrant2==0) num0++;
			if (quadrant3==1) num1++;
			else if (quadrant3==0) num0++;
			if (quadrant4==1) num1++;
			else if (quadrant4==0) num0++;
			
			return 3;
		}
		
		
	}
}
