package bj;

import java.util.*;
import java.io.*;

public class Main_bj_17471_게리맨더링_서울_06_정필영 {
	public static int result;
	public static int N;
	public static int[] arr, unionFind, weight;
	public static int[][] map;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_boj_17471.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for (int tc=0; tc<1; tc++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N];
			weight = new int[N];
			result = Integer.MAX_VALUE;
			
			st = new StringTokenizer(br.readLine());
			for (int i=0; i<N; i++) {
				weight[i] = Integer.parseInt(st.nextToken()); 
			}
			
			map = new int[N][N];
			for (int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				int J = Integer.parseInt(st.nextToken());
				for (int j=0; j<J; j++) {
					int y = Integer.parseInt(st.nextToken()) - 1;
					map[i][y] = 1;
				}
			}
			
			powerSet(0);
			
			if (result==Integer.MAX_VALUE) System.out.println(-1);
			else System.out.println(result);
			
		}
	}
	
	public static int find(int x) {
		if (unionFind[x]==-1) {
			return x;
		}
		
		return unionFind[x] = find(unionFind[x]);
	}
	
	public static void powerSet(int cnt) {
		if (cnt==N) {
			int numZone = N;
			unionFind = new int[N];
			Arrays.fill(unionFind, -1);
			for (int i=0; i<N; i++) {
				for (int j=0; j<N; j++) {
					if (arr[i]==arr[j] && map[i][j]==1) {
						int a = find(i);
						int b = find(j);
						
						if (a!=b) {
							unionFind[a] = b;
							numZone--;
						}
					} 
				}
			}
			int zone1 = 0;
			int zone2 = 0;
			if (numZone==2) {
				for (int i=0; i<N; i++) {
					if (arr[i]==0) zone1 += weight[i];
					else zone2 += weight[i];
				}
				result = Math.min(result, Math.abs(zone1-zone2));
			}
			return;
		}
		
		arr[cnt] = 0;
		powerSet(cnt+1);
		arr[cnt] = 1;
		powerSet(cnt+1);
	}

}
