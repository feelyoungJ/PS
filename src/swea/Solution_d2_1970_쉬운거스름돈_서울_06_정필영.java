package swea;

import java.io.*;
import java.util.*;

public class Solution_d2_1970_쉬운거스름돈_서울_06_정필영 {
	public static final int money[] = {50000, 10000, 5000, 1000, 500, 100, 50, 10};

	public static void main(String[] args) throws Exception {
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		
//		int T = Integer.parseInt(br.readLine());
		int T = sc.nextInt();
		
		for (int tc=1; tc<T+1; tc++) {
//			int won = Integer.parseInt(br.readLine());
			int won = sc.nextInt();
			int[] n = new int[8];
			
			System.out.println("#" + tc);
			for (int i=0; i<8; i++) {
				int num = won / money[i];
				won = won - num * money[i];
				System.out.print(num + " ");
				//n[i] = won;
			}
			System.out.println();
			
			
		}
		
		

	}

}
