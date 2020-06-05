package swea;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Solution_d3_5607_조합_서울_06_정필영 {
	final static BigInteger modB = new BigInteger("1234567891");
	final static int MOD = 1234567891;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			
			long a = factorial(N);
			long b = factorial(R); 
			long c = factorial(N-R);
			
			b = pow(b, MOD-2);
			c = pow(c, MOD-2);
			
			System.out.println("#" + tc + " " + (((a*b)%MOD)*c)%MOD);
		}
	}
	
	public static long factorial(int n) {
		long result = 1;
		for (int i=2; i<=n; i++) {
			result *= i;
			result %= MOD;
		}
		return result;
		
	}
	
	public static long pow(long a, long b) {
		if (b == 0) return 1;
		if (b % 2 > 0) return (pow(a, b - 1) * a) % MOD;
		long half = pow(a, b / 2) % MOD;
		return (half * half) % MOD;
	}
}
