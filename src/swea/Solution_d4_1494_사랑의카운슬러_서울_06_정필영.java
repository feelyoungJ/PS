package swea;

import java.io.*;
import java.util.*;

public class Solution_d4_1494_사랑의카운슬러_서울_06_정필영 {
	public static ArrayList<int[]> compList;
	public static int[][] worm;
	public static int[] combArr, checkArr;
	public static int N, count;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_1494.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
//		T = 2;
		for (int tc=1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine());
			
			compList = new ArrayList<>();
			combArr = new int[N/2];
			checkArr = new int[N];
			
			worm = new int[N][2];
			
			
			for (int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				worm[i][0] = Integer.parseInt(st.nextToken());
				worm[i][1] = Integer.parseInt(st.nextToken());
			}
			
			count = 0;
			comb(0, 0);
			System.out.println(count);

		
		}

	}
	
	
	public static void comb(int cnt, int start) {
		if (cnt==N/2) {
			cal();
			count++;
			return;
		}
		
		for (int i=start; i<N; i++) {
			if (checkArr[i]==0) {
				checkArr[i] = 1;
				combArr[cnt] = i;
				comb(cnt+1, i);
				checkArr[i] = 0;
			}
		}
	}
	
	public static int cal() {
		System.out.println(Arrays.toString(combArr));
		int moveX = 0;
		int moveY = 0;
		for (int i=0; i<N; i++) {
			
				
		}

		return 0;
	}
}
