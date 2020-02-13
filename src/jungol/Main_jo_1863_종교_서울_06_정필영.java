package jungol;

import java.util.*;
import java.io.*;

public class Main_jo_1863_종교_서울_06_정필영 {
	public static int[] arr;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		arr = new int[N+1];
		Arrays.fill(arr, -1);
		
		for (int n=0; n<M; n++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			a = find(a);
			b = find(b);
			
			if (a!=b) {
				arr[b] = a;
//				int sumAB = arr[a] + arr[b];
//				if (a>b) {
//					arr[a] = b;
//					arr[b] = sumAB;
//				}
//				else {
//					arr[a] = sumAB;
//					arr[b] = a;
//				}
			}
		}
//		System.out.println(Arrays.toString(arr));
		
		int result = 0;
		for (int i=1; i<N+1; i++) {
			if (arr[i]==-1) result++;
		}
		System.out.println(result);
	}
	
	public static int find(int x) {
		if (arr[x]<=-1) return x;
		return arr[x] = find(arr[x]);
	}
}
