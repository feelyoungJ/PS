package swea;

import java.util.*;
import java.io.*;

public class Solution_d3_1230_암호문3_서울6반_정필영 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d3_1230.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for (int tc=1; tc<11; tc++) {
			int cryptogramLength = Integer.parseInt(br.readLine());
			ArrayList<Integer> cryptogram = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			for (int i=0; i<cryptogramLength; i++) {
				cryptogram.add(Integer.parseInt(st.nextToken()));
			}
			int functionLength = Integer.parseInt(br.readLine());
			int[] function = new int[functionLength];
			
			st = new StringTokenizer(br.readLine());
			
			while (st.hasMoreElements()) {
				String op = st.nextToken(); 
				
				if (op.equals("I")) {
					int x = Integer.parseInt(st.nextToken());
					int y = Integer.parseInt(st.nextToken());
					for (int j=0; j<y; j++) {
						cryptogram.add(x, Integer.parseInt(st.nextToken()));
						x += 1;
					}
				} else if (op.equals("D")) {
					int x = Integer.parseInt(st.nextToken());
					int y = Integer.parseInt(st.nextToken());
					for (int j=0; j<y; j++) {
						cryptogram.remove(x);
					}
					
				} else if (op.equals("A")) {
					int y = Integer.parseInt(st.nextToken());
					for (int j=0; j<y; j++) {
						cryptogram.add(Integer.parseInt(st.nextToken()));
					}
				}
			}
			
			System.out.print("#" + tc + " ");
			for (int i=0; i<10; i++) {
				System.out.print(cryptogram.get(i) + " ");
			}
			System.out.println();
		}

	}

}
