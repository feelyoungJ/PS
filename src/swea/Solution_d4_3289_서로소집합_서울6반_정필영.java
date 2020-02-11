package swea;

import java.util.*;
import java.io.*;

public class Solution_d4_3289_서로소집합_서울6반_정필영 {
	public static int[] unionFind;
	public static int find(int n) {
		if (unionFind[n]==-1) {
			return n;
		}
		else {
			return unionFind[n] = find(unionFind[n]);
		}
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_3289.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		StringBuffer sb; 
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc=1; tc<T+1; tc++) {
			st = new StringTokenizer(br.readLine());
			sb = new StringBuffer();
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			int[] arr = new int[n+1];
			for (int i=0; i<n+1; i++) {
				arr[i] = i;
			}
			
			unionFind = new int[n+1];
			for (int i=0; i<n+1; i++) {
				unionFind[i] = -1;
			}
			
			for (int i=0; i<m; i++) {
				st = new StringTokenizer(br.readLine());
				String s = st.nextToken();
				if (s.equals("0")) {
					int a = Integer.parseInt(st.nextToken());
					int b = Integer.parseInt(st.nextToken());
					
//					int min = Math.min(a, b);
//					int max = Math.max(a, b);
//					max = Math.max(unionFind[min], max);
//					unionFind[min] = max;
					
					int aa = find(a);
					int bb = find(b);
					if (aa!=bb) {
						unionFind[aa] = bb;
					}
					
					
				} else {
					int a = Integer.parseInt(st.nextToken());
					int b = Integer.parseInt(st.nextToken());
					
					a = find(a);
					b = find(b);
					
//					while (true) {
//						if (unionFind[a]==-1) break;
//						a = unionFind[a];
//					}
//					while (true) {
//						if (unionFind[b]==-1) break;
//						b = unionFind[b];
//					}
//					
					if (a==b) {
						sb.append(1);
					} else {
						sb.append(0);
					}
				}
			}
			System.out.println("#" + tc + " " + sb);
		}
	}
}
