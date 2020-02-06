package swea;

import java.io.*;
import java.util.*;

public class Solution_d3_1217_거듭제곱_서울6반_정필영 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d3_1217.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		StringTokenizer st;
		
		int N = 0;
		int M = 0;;
		
		for (int tc=1; tc<11; tc++) {
			br.readLine();
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			System.out.println("#" + tc + " " + power(N, M));
		}
		
		
	}
	
	public static int power(int N, int M) {
		if (M==0) {
			return 1;
		} else if (M==1) {
			return N;
		}
		
		if (M%2==0) {
			return power(N, M/2)*power(N, M/2);
		} else {
			return N*power(N, (M-1)/2)*power(N, (M-1)/2);
		}
	}
}
