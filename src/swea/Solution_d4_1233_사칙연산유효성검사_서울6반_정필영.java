package swea;

import java.util.*;
import java.io.*;

public class Solution_d4_1233_사칙연산유효성검사_서울6반_정필영 {
	public static int N, result;
	public static ArrayList<String>[] tree;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_1233.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for (int tc=1; tc<11; tc++) {
			N = Integer.parseInt(br.readLine());
			
			tree = new ArrayList[N];
			result = 0;
			
			for (int i=0; i<N; i++) {
				tree[i] = new ArrayList<>();
				st = new StringTokenizer(br.readLine());
				while (st.hasMoreTokens()) {
					tree[i].add(st.nextToken());
				}
			}
			
			boolean flag = true;
			for (int i=0; i<N; i++) {
				//String s = tree[i].get(1);
					
				if (check(tree[i].get(1))) {
					if (tree[i].size()!=4 || check(tree[i].get(2)) || check(tree[i].get(3))) {
						flag = false;
						break;
					}
				} else {
					if (tree[i].size()!=2) {
						flag = false;
						break;
					}
				}
			}
			
			if (flag) System.out.println("#" + tc + " " + 1);
			else System.out.println("#" + tc + " " + 0);
		}
	}
	
	public static boolean check(String s) {
		return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
	}
}
