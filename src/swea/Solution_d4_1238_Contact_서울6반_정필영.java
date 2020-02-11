package swea;

import java.io.*;
import java.util.*;
 
public class Solution_d4_1238_Contact_서울6반_정필영 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_1238.txt"));
		
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		int tc = 1;
		
		while (sc.hasNext()) {
			int N = sc.nextInt();
			
			int[][] graph = new int[100][100];
			int index = sc.nextInt() - 1;
			
			int maxIndex = index;
			
			for (int i=0; i<N/2; i++) {
				int start = sc.nextInt() - 1;
				maxIndex = Math.max(maxIndex, start);
				int end = sc.nextInt() - 1;
				maxIndex = Math.max(maxIndex, end);
				graph[start][end] = 1;
			}
			
			
			Queue<int[]> queue = new LinkedList<>();
			queue.add(new int[] {index, 0});
			
			int[] result = new int[2]; 
			result[0] = -1;
			result[1] = 0;
			while (!queue.isEmpty()) {
//				for (int[] q:queue) System.out.print(Arrays.toString(q));
				
				int[] q = queue.poll();
//				System.out.println();
//				System.out.println(Arrays.toString(q));
//				System.out.println(Arrays.toString(result));
//				System.out.println(q[1]);
//				System.out.println(result[1]);
//				System.out.println(q[0]);
//				System.out.println(result[0]);
				
				
				for (int i=0; i<maxIndex; i++) {
					graph[i][q[0]] = 0;
				}
				
				if (q[1]>result[1]) {
					result[0] = q[0];
					result[1] = q[1];
				} else if (q[1]==result[1] && q[0]>result[0]) {
					result[0] = q[0];
					result[1] = q[1];
				}
				
				for (int j=0; j<maxIndex; j++) {
					if (graph[q[0]][j]==1) {
						queue.add(new int[] {j, q[1]+1});
						graph[q[0]][j] = 0;
						graph[j][q[0]] = 0;
					}
				}
//				System.out.println("====");
				if (queue.isEmpty()) result[0] += 1;
			}
			System.out.println("#" + tc++ + " " + result[0]);
			
		}
		
		

	}

}
