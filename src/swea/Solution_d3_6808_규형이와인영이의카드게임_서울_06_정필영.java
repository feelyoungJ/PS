package swea;

import java.io.*;
import java.util.*;

public class Solution_d3_6808_규형이와인영이의카드게임_서울_06_정필영 {
	public static final int SIZE = 9;
	public static int n;
	public static int victory;
	public static int defeat;
	public static int[] gyuYoung, inYoung, checkList, recuArr;
	
	public static void permutation(int count) {
		if (count==SIZE) {
			int mVictory = 0;
			int mDefeat = 0;
			for (int i=0; i<SIZE; i++) {
				if (gyuYoung[i]>recuArr[i]) mVictory = mVictory + (gyuYoung[i]+recuArr[i]); 
				else mDefeat = mDefeat + (recuArr[i]+gyuYoung[i]);
			}
			
			if (mVictory>mDefeat) victory += 1;
			else defeat += 1;
			return;
		}
		
		for (int i=0; i<SIZE; i++) {
			if (checkList[i]==0) {
				checkList[i] = 1;
				recuArr[count] = inYoung[i];
				permutation(count+1);
				checkList[i] = 0;
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d3_6808.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc=1; tc<T+1; tc++) {
			gyuYoung = new int[SIZE];
			inYoung = new int[SIZE];
			checkList = new int[SIZE];
			recuArr = new int[SIZE];
			n = 0;
			victory = 0;
			defeat = 0;
			
			st = new StringTokenizer(br.readLine());
			
			for (int i=0; i<SIZE; i++) {
				gyuYoung[i] = Integer.parseInt(st.nextToken());
			}
			
			int index = 0;
			for (int i=1; i<19; i++) {
				boolean flag = true;
				for (int j=0; j<9; j++) {
					if (i==gyuYoung[j]) {
						flag = false;
						break;
					}
				}
				if (flag) {
					inYoung[index] = i;
					index += 1;
				} 
			}
			

			
			permutation(0);
			
			System.out.println("#" + tc + " " + victory + " " + defeat);
		}

	}

}

