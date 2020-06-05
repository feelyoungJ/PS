package bj;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_bj_2252_줄세우기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		ArrayList<Integer>[] line = new ArrayList[N+1];
		for (int i=0; i<=N; i++) {
			line[i] = new ArrayList<Integer>();
		}
		
		int[] in_degree = new int[N+1];
		
		for (int i=0; i<M; i++) {
			int y = sc.nextInt();
			int x = sc.nextInt();
			
			line[x].add(y);
			in_degree[y]++;
		}
		
		Queue<Integer> q = new LinkedList<>(); 
		for(int i = 1; i<=N; i++) { 
			if (in_degree[i] == 0) { 
				q.add(i); 
			} 
		}
		
		ArrayList<Integer> result = new ArrayList<Integer>();
		while(!q.isEmpty()) {
			int current = q.poll();
			result.add(current);
			for(int i = 0 ; i < line[current].size(); i++) {
				int temp = line[current].get(i);
				in_degree[temp]--;
				if(in_degree[temp] ==0) {
					q.add(temp);
				}
			}
		}
		
		for (int i=result.size()-1; i>=0; i--) {
			System.out.print(result.get(i) + " ");
		}

	}

}
