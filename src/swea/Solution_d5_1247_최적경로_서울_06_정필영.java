package swea;

import java.io.*;
import java.util.*;

public class Solution_d5_1247_최적경로_서울_06_정필영 {
	public static int N, count, move, result;
	public static int[] permArr, permCheck;
	
	public static Address company, house;
	public static Address[] customer;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d5_1247.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc=1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine());
			permArr = new int[N];
			permCheck = new int[N];
			
			st = new StringTokenizer(br.readLine());
			
			
			company = new Address(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			house = new Address(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			customer = new Address[N];
			result = Integer.MAX_VALUE;
			
			for (int i=0; i<N; i++) {
				customer[i] = new Address(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			
			count = 0;
			perm(0);
			System.out.println("#" + tc + " " + result);
//			System.out.println(count);
		}
		
	}
	
	public static void perm(int cnt) {
		if (cnt==N) {
			count++;
			move = 0;
			move();
//			System.out.println(Arrays.toString(permArr));
			return;
		}
		
		for (int i=0; i<N; i++) {
			if (permCheck[i]==0) {
				permCheck[i] = 1;
				permArr[cnt] = i;
				perm(cnt+1);
				permCheck[i] = 0;
			}
			
		}
	}
	
	public static void move() {
		int y = company.y;
		int x = company.x;
		
		for (int i=0; i<N; i++) {
			move = move + Math.abs(y - customer[permArr[i]].y) + Math.abs(x - customer[permArr[i]].x);
			
			y = customer[permArr[i]].y;
			x = customer[permArr[i]].x;
		}
		
		move = move + Math.abs(y - house.y) + Math.abs(x - house.x);
		
		result = Math.min(result, move);
	}
	
	static class Address {
		int y;
		int x;
		
		Address(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	
	
}
