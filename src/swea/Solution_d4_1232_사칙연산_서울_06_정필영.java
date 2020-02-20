package swea;

import java.util.*;
import java.io.*;

public class Solution_d4_1232_사칙연산_서울_06_정필영 {
	public static int N, result;
	public static ArrayList<String>[] tree;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_1232.txt"));
		
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
			int result = (int) inorder(1);
//			System.out.println(Arrays.toString(tree));
//			System.out.println(tree.length);
			System.out.println("#" + tc + " " + result);
			
			
			
		}
	}
	
	public static double inorder(int i) {
		String s = tree[i].get(1);
		
		if (s.equals("+")) {
			return inorder(Integer.parseInt(tree[i].get(2))) + inorder(Integer.parseInt(tree[i].get(3)));
		} else if (s.equals("-")) {
			return inorder(Integer.parseInt(tree[i].get(2))) - inorder(Integer.parseInt(tree[i].get(3)));
		} else if (s.equals("*")) {
			return inorder(Integer.parseInt(tree[i].get(2))) * inorder(Integer.parseInt(tree[i].get(3)));
		} else if (s.equals("/")) {
			return inorder(Integer.parseInt(tree[i].get(2))) / inorder(Integer.parseInt(tree[i].get(3)));
		} else {
			return Double.parseDouble(tree[i].get(1));
		}
		
		
//		if (N>=i) {

			
			
			
//			inorder(i*2);
//			inorder(i*2+1);
//			queue.add(tree[i].get(1));
//			System.out.print(tree[i].get(1));
//			if (tree[i].size()==4) {
//				ArrayList<String> al = tree[i];
//				String s = al.get(1);
//				String left = tree[Integer.parseInt(al.get(2))].get(1);
//				String right = tree[Integer.parseInt(al.get(3))].get(1);
//				
//				double c = 0;
//				if (s.equals("+")) {
//					c = Double.parseDouble(left) + Double.parseDouble(right); 
//				} else if (s.equals("-")) {
//					c = Double.parseDouble(left) - Double.parseDouble(right);
//				} else if (s.equals("*")) {
//					System.out.println(left);
//					System.out.println(right);
//					System.out.println();
//					c = Double.parseDouble(left) * Double.parseDouble(right);
//				} else if (s.equals("/")) {
//					c = Double.parseDouble(left) / Double.parseDouble(right);
//				}
//				
//				ArrayList<String> cc = new ArrayList<>();
//				cc.add(String.valueOf(i));
//				cc.add(String.valueOf(c));
//				tree[i] = cc;
//			}
//		}
	}

}
