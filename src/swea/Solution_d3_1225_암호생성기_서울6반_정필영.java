package swea;

import java.util.*;
import java.io.*;

public class Solution_d3_1225_암호생성기_서울6반_정필영 {
	public static final int INPUT_SIZE = 8;
	public static final int ENCODE_SIZE = 5;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d3_1225.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for (int tc=1; tc<11; tc++) {
			br.readLine();
			st = new StringTokenizer(br.readLine());
			ArrayList<Integer> password = new ArrayList<>();
			
			for (int i=0; i<INPUT_SIZE; i++) {
				password.add(Integer.parseInt(st.nextToken()));
			}
			
			int encodeVariable = ENCODE_SIZE;
			boolean flag = false;
			
			while (true) {
				// int[] encodeArr = new int[ENCODE_SIZE];
				
				for (int i=0; i<ENCODE_SIZE; i++) {
					password.set(i, Math.max(password.get(i)-(i+1), 0));
//					encodeArr[i] = password[i] - (i+1);
					if (password.get(i)<=0) {
						encodeVariable = i + 1;
						flag = true;
						break;
					}
				}
				
				ArrayList<Integer> frontEncode = new ArrayList<>(password.subList(encodeVariable, INPUT_SIZE));
				ArrayList<Integer> rearEncode = new ArrayList<>(password.subList(0, encodeVariable));
				
				password = new ArrayList<>();
				password.addAll(frontEncode);
				password.addAll(rearEncode);
//				System.out.println(password.toString());
				
				if (flag) break;
				
				
//				password.subList(ENCODE_SIZE, INPUT_SIZE).addAll(password.subList(ENCODE_SIZE, INPUT_SIZE));
			}
			System.out.print("#" + tc + " ");
			for (int i=0; i<INPUT_SIZE; i++) {
				System.out.print(password.get(i) + " ");
			}
			System.out.println();
//			System.out.println(password.toString());
			
		}
		

	}

}
