package swea;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_d3_2805_농작물수확하기_서울_06_정필영 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int tc=1; tc<T+1; tc++) {
			int N = sc.nextInt();
			
			int[][] farm = new int[N][N];
			
			for (int i=0; i<N; i++) {
				String row = sc.next();
				for (int j=0; j<N; j++) {
					farm[i][j] = row.charAt(j)-'0';
				}
			}
			
//			for (int[] f :farm) {
//				System.out.println(Arrays.toString(f));
//			}
		
		
			int centerNumber = (N-1)/2;
			
			int result = 0;
			
			for (int i=-centerNumber; i<centerNumber+1; i++) {
				for (int j=-centerNumber; j<centerNumber+1; j++) {
					if (Math.abs(i)+Math.abs(j)<=centerNumber) {
						result += farm[centerNumber+i][centerNumber+j];
						// System.out.print(farm[centerNumber+i][centerNumber+j]);
					}
				}
			}
			
			System.out.println("#" + tc + " " + result);
			
			
		}
		
		
		sc.close();
		

	}
	

}
