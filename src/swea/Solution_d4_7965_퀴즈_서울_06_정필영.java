package swea;

import java.io.*;
import java.util.Scanner;

public class Solution_d4_7965_퀴즈_서울_06_정필영 {
	public static final long MAX = 1000000007;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int tc=1; tc<T+1; tc++) {
			int N = sc.nextInt();
			
			long sum = 1;
//			long pow = 1;
			for (long i=2; i<=N; i++) {
				long pow = pow(i, i);
				pow = pow % MAX;
//				System.out.println(pow);
//				System.out.println(pow);
				sum += pow;
			}
			
			long a = sum % 1000000007;
			System.out.println("#" + tc + " " + a);
		}

	}
	
	public static long pow(long n, long e) {
		if (e==1) return n;
		else if (e==2) return n*n;
		else {
			if (e%2==0) {
				long p = pow(n, e/2)%MAX;
//				return (pow(n, e/2))%MAX * (pow(n, e/2))%MAX;
				return (p*p)%MAX;
			} else {
				long p = pow(n, e/2)%MAX;
//				return n * (pow(n, e/2))%MAX * (pow(n, e/2))%MAX;
				return (n*((p*p)%MAX))%MAX;
			}
		}
	}
}
