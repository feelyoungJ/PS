package swea;

import java.util.Scanner;

public class Solution_d2_5356_의석이의세로로말해요_서울6반_정필영 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc=1; tc<T+1; tc++) {
			String[] voca = new String[5];
			int[] vocaLen = new int[5];
			
			int maxVocaLen = 0;
			for (int i=0; i<5; i++) {
				voca[i] = sc.next();
				vocaLen[i] = voca[i].length();
				maxVocaLen = (maxVocaLen>=vocaLen[i]?maxVocaLen:vocaLen[i]);
			}
			
			
			System.out.print("#" + tc + " ");
			for (int j=0; j<maxVocaLen; j++) {
				for (int i=0; i<5; i++) {
					if (vocaLen[i]>j) {
						System.out.print(voca[i].charAt(j));
					}
				}
				
			}
			System.out.println();
			
		}

	}

}
//#1 Aa0FfBb1GgCc2HhDd3IiEe4Jj
//   Aa0FfBb1GgCc2HhDd3IiEe4Jj
//   Aa0aPAf985Bz1EhCz2W3D1gkD6x
//#2 Aa0aPAf985Bz1EhCz2W3D1gkD6x