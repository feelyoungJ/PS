package swea;

import java.io.*;
import java.util.*;

public class Solution_d3_6808_규형이와인영이의카드게임STACK_서울6반_정필영 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d3_6808.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc=1; tc<T+1; tc++) {
			int[] gyuYoung = new int[9];
			int[] inYoung = new int[9];
			
			st = new StringTokenizer(br.readLine());
			
			for (int i=0; i<9; i++) {
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
			
			Stack<ArrayList<Integer>> stack = new Stack<>();
			for (int i=0; i<9; i++) {
				ArrayList<Integer> stk = new ArrayList<>();
				stk.add(i);
				stack.push(stk);
			}
			
			int victory = 0;
			int defeat = 0;
			
			while (!stack.isEmpty()) {
				ArrayList<Integer> a = stack.pop();
				
				if (a.size()==9) {
					int mVictory = 0;
					int mDefeat = 0;
					for (int i=0; i<9; i++) {
						if (gyuYoung[i]>inYoung[a.get(i)]) mVictory = mVictory + (gyuYoung[i]+inYoung[a.get(i)]); 
						else mDefeat = mDefeat + (inYoung[a.get(i)]+gyuYoung[i]);
					}
					
					if (mVictory>mDefeat) victory += 1;
					else defeat += 1;
					continue;
				}
				
				int[] checkList = new int[9];
				for (int i:a) {
					checkList[i] = 1;
				}
				
				for (int i=0; i<9; i++) {
					if (checkList[i]==0) {
						ArrayList<Integer> na = (ArrayList<Integer>) a.clone();
						na.add(i);
						stack.push(na);
					}
				}
			}
			System.out.println("#" + tc + " " + victory + " " + defeat);
		}

	}

}

