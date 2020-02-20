package swea;

import java.util.Scanner;

public class Solution_d2_2007_패턴마디의길이_서울_06_정필영 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int tc=1; tc<T+1; tc++) {
			String str = sc.next();
			
			int result = 0;
			for (int i=1; i<11; i++) {
				if (str.substring(0, i).equals(str.substring(i, i*2))) {
					result = i;
					break;
				}
				
			}
			
			System.out.println("#" + tc + " " + result);
		}

	}

}
