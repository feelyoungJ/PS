package swea;

import java.util.*;
import java.io.*;

public class Solution_d4_4366_정식이의은행업무 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int tc=1; tc<=T; tc++) {
			String binary = sc.next();
			String tenary = sc.next();
			
			
			int[] bArr = new int[binary.length()];
			int[] tArr = new int[2 * tenary.length()];
			
			String aa = "111";
			
			for (int i=0; i<binary.length(); i++) {
				if (binary.charAt(i)=='0') {
					String b = binary.substring(0, i) + "1" + binary.substring(i+1, binary.length());
					bArr[i] = Integer.parseInt(b, 2);
				} else {
					String b = binary.substring(0, i) + "0" + binary.substring(i+1, binary.length());
					bArr[i] = Integer.parseInt(b, 2);
				}
				
			}
			
			for (int i=0; i<tenary.length(); i++) {
				if (tenary.charAt(i)=='0') {
					String c = tenary.substring(0, i) + "1" + tenary.substring(i+1, tenary.length());
					tArr[i*2] = Integer.parseInt(c, 3);
					c = tenary.substring(0, i) + "2" + tenary.substring(i+1, tenary.length());
					tArr[i*2+1] = Integer.parseInt(c, 3);
				} else if (tenary.charAt(i)=='1') {
					String c = tenary.substring(0, i) + "2" + tenary.substring(i+1, tenary.length());
					tArr[i*2] = Integer.parseInt(c, 3);
					c = tenary.substring(0, i) + "0" + tenary.substring(i+1, tenary.length());
					tArr[i*2+1] = Integer.parseInt(c, 3);
				} else {
					String c = tenary.substring(0, i) + "0" + tenary.substring(i+1, tenary.length());
					tArr[i*2] = Integer.parseInt(c, 3);
					c = tenary.substring(0, i) + "1" + tenary.substring(i+1, tenary.length());
					tArr[i*2+1] = Integer.parseInt(c, 3);
				}
			}
			
			A: for (int i=0; i<binary.length(); i++) {
				for (int j=0; j<tenary.length()*2; j++) {
					if (bArr[i]==tArr[j]) {
						System.out.println("#" + tc + " " + bArr[i]);
						break A;
					}
				}
			}
			
			
		}
		
	}

}
