package swea;

import java.util.*;
import java.io.*;

public class Solution_d4_3234_준환이의양팔저울 {
	public static int N, result, cnt, sum;
	public static int[] weights, visit;
	

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for (int tc=1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine());
			weights = new int[N];
			visit = new int[N];
			result = 0;
			cnt = 0;
			sum = 0;
			st = new StringTokenizer(br.readLine());
			for (int i=0; i<N; i++) {
				weights[i] = Integer.parseInt(st.nextToken());
				sum += weights[i]; 
			}
			sum /= 2;
//			Arrays.sort(weights);
			permutation(0, 0, 0);
			System.out.println("#" + tc + " " + result);
		}
	}
	
	public static void permutation(int cnt, int left, int right) {
		if (cnt==N) {
			if (left>=right) {
				result++;
			}
			return;
		}
		
		if (left>sum) {
			result += (int) (factorinal(N-cnt)*Math.pow(2, N-cnt));
			return;
		}
		
		for (int i=0; i<N; i++) {
			if (visit[i]==0) {
				visit[i] = 1;
				permutation(cnt+1, left+weights[i], right);
				if (left>=right+weights[i]) { 
					permutation(cnt+1, left, right+weights[i]);
				}
				visit[i] = 0;
			}
		}
		
	}
	
	public static int factorinal(int n) {
		int facto = 1;
		for (int i=1; i<=n; i++) {
			facto *= i;
		}
		return facto;
	}

}
