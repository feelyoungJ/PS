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
			
			tree = new ArrayList[N+1];
			result = 0;
			
			for (int i=1; i<N+1; i++) {
				tree[i] = new ArrayList<>();
				st = new StringTokenizer(br.readLine());
				while (st.hasMoreTokens()) {
					tree[i].add(st.nextToken());
				}
			}
//			System.out.println(Arrays.toString(tree));
			inorder(1);
			System.out.println();
//			System.out.println(Arrays.toString(tree));
//			System.out.println(tree.length);
//			System.out.println("#" + tc + " " + result);
		}
	}
	public static boolean inorder(int i) {
//		if (N>=i) {
			String s = tree[i].get(1);
			if (tree[i].size()==4) {
				inorder(i*2);
				inorder(i*2+1);
			} else if (tree[i].size()==2 && !s.equals("+") && !s.equals("-") && !s.equals("*") && !s.equals("/")){
				return true;
			} 
			return false;
			
			
//			System.out.print(tree[i].get(1));
			
			
			
			
//		}
//		return true;
		
//		String s = tree[i].get(1);
//		
//		if (s.equals("+")) {
//			return inorder(Integer.parseInt(tree[i].get(2))) + inorder(Integer.parseInt(tree[i].get(3)));
//		} else if (s.equals("-")) {
//			return inorder(Integer.parseInt(tree[i].get(2))) - inorder(Integer.parseInt(tree[i].get(3)));
//		} else if (s.equals("*")) {
//			return inorder(Integer.parseInt(tree[i].get(2))) * inorder(Integer.parseInt(tree[i].get(3)));
//		} else if (s.equals("/")) {
//			return inorder(Integer.parseInt(tree[i].get(2))) / inorder(Integer.parseInt(tree[i].get(3)));
//		} else {
//			return Double.parseDouble(tree[i].get(1));
//		}
	}
}
