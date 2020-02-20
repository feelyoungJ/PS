package swea;

import java.util.*;
import java.io.*;

public class Solution_d3_1240_단순2진암호코드_서울_06_정필영 {
	public static String[] pattern = new String[] {"0001101", "0011001", "0010011", "0111101", "0100011", "0110001", "0101111", "0111011", "0110111", "0001011"};
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d3_1240.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc=1; tc<T+1; tc++) {
			 st = new StringTokenizer(br.readLine());
			 int N = Integer.parseInt(st.nextToken());
			 int M = Integer.parseInt(st.nextToken());
			
			 char[][] password = new char[N][M];
			 
			 boolean flag = true;
			 int iIndex = -1;
			 int jIndex = -1;
			 for (int i=0; i<N; i++) {
				 String[] line = br.readLine().split("");
				 
				 for (int j=0; j<M; j++) {
					 password[i][j] = line[j].charAt(0);
					 if (flag && password[i][j]=='1') {
						 iIndex = i;
						 jIndex = j;
						 flag = false;
					 }
					 
				 }
			 }
			 
			 int sIndex = Math.max(jIndex-55, 0);
			 int eIndex = Math.min(jIndex, M-55);
			 
			 for (int i=sIndex; i<=eIndex; i++) {
//				 System.out.println(String.valueOf(Arrays.copyOfRange(password[iIndex], i, i+56)));
				 int odd = 0;
				 int even = 0;
				 int code = 0;
				 
				 flag = true;
				 
				 for (int j=0; j<8; j++) {
					 char[] na = Arrays.copyOfRange(password[iIndex], i+(j*7), i+(j*7)+7);
					 String naS = String.valueOf(na);
					 int naI = -1;
					 
					 if(naS.equals(pattern[0])) naI = 0;
					 else if(naS.equals(pattern[1])) naI = 1;
					 else if(naS.equals(pattern[2])) naI = 2;
					 else if(naS.equals(pattern[3])) naI = 3;
					 else if(naS.equals(pattern[4])) naI = 4;
					 else if(naS.equals(pattern[5])) naI = 5;
					 else if(naS.equals(pattern[6])) naI = 6;
					 else if(naS.equals(pattern[7])) naI = 7;
					 else if(naS.equals(pattern[8])) naI = 8;
					 else if(naS.equals(pattern[9])) naI = 9;
					 
					 if(naI==-1) {
						 flag = false;
						 break;
					 }
					 
//					 System.out.println(naI);
					 if (j==7) {
						 code = naI;
					 }
					 else if (j%2==0) {
						 odd += naI;
					 } else {
						 even += naI;
					 }
				 }
				 
				 if (flag) {
					 int check = odd*3 + even + code;
					 if (check%10==0)  System.out.println("#" + tc + " " + (odd+even+code));
					 else System.out.println("#" + tc + " " + 0);
					 break;
				 }
			 }
		}
	}

}
