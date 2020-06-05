package bj;

import java.io.*;
import java.util.*;

public class Main_bj_1062_가르침 {
	public static boolean[] alpha;
	public static String[] arr;
	public static int N, K, result;
// a n t i c
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		arr = new String[N];
		
		for (int i=0; i<N; i++) {
			arr[i] = br.readLine();
		}
		alpha = new boolean[26];
		alpha[0] = true;
		alpha[2] = true;
		alpha[8] = true;
		alpha[13] = true;
		alpha[19] = true;
		result = 0;		
		combination(0, 5);
		
		System.out.println(result);
	}

	
	public static void combination(int start, int cnt) {
		if (cnt==K) {
			check();
			
		}
		
		for (int i=start; i<26; i++) {
			if (!alpha[i]) {
				alpha[i] = true;
				combination(i, cnt+1);
				alpha[i] = false;
			}
		}
	}
	public static void check() {
		int count = 0;
		for (int i=0; i<N; i++) {
			boolean flag = true;
			for (int j=4; j<arr[i].length()-4; j++) {
				if (!alpha[arr[i].charAt(j)-'a']) {
					flag = false;
					break;
				}
			}
//			System.out.println(flag);
			if (flag) {
//				System.out.println(Arrays.toString(alpha));
				count++;
			}
		}
		result = Math.max(result, count);
	}
}
