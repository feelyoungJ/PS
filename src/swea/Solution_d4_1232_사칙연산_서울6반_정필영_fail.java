package swea;

import java.util.*;

import java.io.*;

class Node {
	char data;
	Node left;
	Node right;
}

public class Solution_d4_1232_사칙연산_서울6반_정필영_fail {
	static class Tree {
		Node root;

		public Node makeTree(Node left, char data, Node right) {
			Node node = new Node();
			node.data = data;
			node.left = left;
			node.right = right;
			
			return node;
		}
		
	}
	

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_1232.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for (int tc=1; tc<11; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			
			Tree t = new Tree();
			
			ArrayList<Node> node = new ArrayList<>();
			node.add(new Node());
			
			System.exit(0);
			for (int i=1; i<N+1; i++) {
				st = new StringTokenizer(br.readLine());
				
				int index = Integer.parseInt(st.nextToken());
				char data = st.nextToken().charAt(0);
				
				
				if (st.hasMoreTokens()) {
					Node left = tree[Integer.parseInt(st.nextToken())];
				} else {
					Node left = null;
				}
				
				if (st.hasMoreTokens()) {
					Node right = tree[Integer.parseInt(st.nextToken())];
				} else {
					Node right = null;
				}
				
//				Node tree[i] = makeTree(left, data, right);
				
				 
				
				
			}
		}

	}

}
