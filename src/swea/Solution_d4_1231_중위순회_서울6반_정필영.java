package swea;

import java.io.*;
import java.util.*;

public class Solution_d4_1231_중위순회_서울6반_정필영 {
	public static int N;
	public static ArrayList<Character>[] tree;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_1231.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for (int tc=1; tc<11; tc++) {
			N = Integer.parseInt(br.readLine());
			
			tree = new ArrayList[N+1];
			
			for (int i=1; i<N+1; i++) {
				tree[i] = new ArrayList<>();
				st = new StringTokenizer(br.readLine());
				while (st.hasMoreTokens()) {
					tree[i].add(st.nextToken().charAt(0));
				}
			}
			System.out.print("#" + tc + " ");
			inorder(1);
			System.out.println();
		}
	}
	
	public static void inorder(int i) {
		if (N>=i) {
			inorder(i*2);
			System.out.print(tree[i].get(1));
			inorder(i*2+1);
		}
	}
}



