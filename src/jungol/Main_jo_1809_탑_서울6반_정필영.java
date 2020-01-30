package jungol;

import java.io.*;
import java.util.*;

public class Main_jo_1809_탑_서울6반_정필영 {

	public static void main(String[] args) throws Exception {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 
		 Stack<Integer[]> stk = new Stack<>();
//		 Stack<Integer> tmpTower = new Stack<>();
//		 Queue tower = new LinkedList();
		 
		 int N = Integer.parseInt(br.readLine());
		 int[] tower = new int[N];
		 int[] result = new int[N];
		 StringTokenizer st = new StringTokenizer(br.readLine());
		 
		 int stIndex = 0;
		 while (st.hasMoreTokens()) {
			 tower[stIndex++] = Integer.parseInt(st.nextToken());
		 }
		 
		 
		 for (int i=0; i<N; i++) {
//			 for (Integer[] s:stk) {
//				 System.out.print(Arrays.toString(s));
//			 }
//			 System.out.println();

			 while (!stk.isEmpty()) {
				 Integer[] next = stk.pop();
				 if (next[0]>=tower[i]) {
					 result[i] = next[1];
					 stk.push(next);
					 break;
				 }
			 }
			 

			 
			 if (stk.isEmpty()) {
				 result[i] = 0;
			 }
			 Integer[] saved = {tower[i], i+1};
			 stk.push(saved);
		 }
		 
		 for (int r:result) System.out.print(r + " ");
		 br.close();

		 
		 
//		 while (st.hasMoreTokens()) {
//			 tmpTower.push(Integer.parseInt(st.nextToken()));
////			 tower.add(Integer.parseInt(st.nextToken()));
//		 }
//		 
//		 while (!tmpTower.isEmpty()) {
//			 tower.push(tmpTower.pop());
//		 }
//		 
//		 
//		 while (!tower.isEmpty()) {
//			 System.out.println(tower.poll());
//		 }
		 
		 
		 
//		for (int i=0; i<N; i++) {
//			Stack<Integer> copyTower;
//			
//			// int height = Integer.parseInt(st.nextToken());
//			int height = sc.nextInt();
//			// int j = copyTower.size();
//			while (!copyTower.isEmpty()) {
//				
//			}
//			
//			
//			tower.push(height);
//		}
		
		
		
		
		
		
		

	}

}
