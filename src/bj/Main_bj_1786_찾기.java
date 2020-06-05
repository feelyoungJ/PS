package bj;

import java.util.Scanner;

public class Main_bj_1786_찾기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String T = sc.nextLine();
		String P = sc.nextLine();
		
		int n = T.length();
		int m = P.length();
		
		int[] checkList = new int[m]; 
		
		int j = 0;
		for (int i=1; i<m; i++) {
			while (j>0 && P.charAt(i)!=P.charAt(j)) {
				j = checkList[j-1];
			}
			
			if (P.charAt(i)==P.charAt(j)) {
				j++;
				checkList[i] = j;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		int result = 0;
		j = 0;
		for (int i=0; i<n; i++) {
			while(j>0 && T.charAt(i)!=P.charAt(j)) {
				j = checkList[j-1];
			}
			
			if (T.charAt(i)==P.charAt(j)) {
				if (j==m-1) {
					result++;
					sb.append(i-j+1);
					sb.append("\n");
					j = checkList[j];
				} else {
					j++;
				}
			}
		}
		System.out.println(result);
		System.out.println(sb);
		
		

	}

}
