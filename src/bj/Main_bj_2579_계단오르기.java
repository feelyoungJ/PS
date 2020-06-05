package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_bj_2579_계단오르기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] stair = new int[N];
		for (int i=0; i<N; i++) {
			stair[i] = Integer.parseInt(br.readLine());
		}
		
		if (N>3) {
			int[] point = new int[N];
			point[0] = stair[0];
			point[1] = stair[0] + stair[1];
			point[2] = Math.max(stair[1]+stair[2], stair[0]+stair[2]);
			
			
			for (int i=3; i<N; i++) {
				point[i] = Math.max(point[i-3]+stair[i-1]+stair[i], point[i-2]+stair[i]);
			}
			
			System.out.println(point[N-1]);
		} else {
			int point = 0;
			for (int i=0; i<N; i++) {
				point += stair[i];
				
			}
			System.out.println(point);
		}
		
	}
}
