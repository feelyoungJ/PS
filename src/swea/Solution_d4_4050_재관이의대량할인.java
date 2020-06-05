package swea;

import java.io.*;
import java.util.*;

public class Solution_d4_4050_재관이의대량할인 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int tc=1; tc<=T; tc++) {
			int N = sc.nextInt();
			
			ArrayList<Integer> clothes = new ArrayList<>();
			for (int i=0; i<N; i++) {
				clothes.add(sc.nextInt());
			}

			Collections.sort(clothes);
			Collections.reverse(clothes);
			
			int c = N/3;
			int dis = 0;
			for(int i=0;i<N;i++) {
				if((i+1)%3 != 0) { 
					dis += clothes.get(i);
				}
			}
			
			System.out.println("#" + tc + " " + dis);
		}
	}
}
