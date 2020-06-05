package swea;

import java.util.*;
import java.io.*;

public class Solution_d4_9659_다항식계산_서울_06_정필영 {
	static final long MOD = 998244353;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc=1; tc<=T; tc++) {
			int N = Integer.parseInt(br.readLine());
			long[] result = new long[N+1];
			result[0] = 1;
			
			int[][] tab = new int[N+1][3];
			
			for (int i=2; i<=N; i++) {
				st = new StringTokenizer(br.readLine());
				tab[i][0] = Integer.parseInt(st.nextToken());
				tab[i][1] = Integer.parseInt(st.nextToken());
				tab[i][2] = Integer.parseInt(st.nextToken());
			}
			
			int M = Integer.parseInt(br.readLine());
			int[] m = new int[M];
			
			st = new StringTokenizer(br.readLine());
			for (int i=0; i<M; i++) {
				m[i] = Integer.parseInt(st.nextToken());
			}
			
			System.out.print("#" + tc + " ");
			for (int i=0; i<M; i++) {
				result[1] = m[i];
				for (int j=2; j<=N; j++) {
					if (tab[j][0]==1) {
						result[j] = (result[tab[j][1]] + result[tab[j][2]]) % MOD;
					}
					else if (tab[j][0]==2) {
						result[j] = (tab[j][1] * result[tab[j][2]]) % MOD;
					}
					else if (tab[j][0]==3) {
						result[j] = (result[tab[j][1]] * result[tab[j][2]]) % MOD;
					}
				}
				System.out.print(result[N] + " ");
			}
			System.out.println();
		}
	}
}
