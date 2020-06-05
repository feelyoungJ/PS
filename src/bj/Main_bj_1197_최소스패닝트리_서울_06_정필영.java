package bj;

import java.io.*;
import java.util.*;

public class Main_bj_1197_최소스패닝트리_서울_06_정필영 {
	public static int[] p;
	
	public static int findSet(int x) {
		if (x==p[x]) {
			return x;
		}
		else return p[x] = findSet(p[x]);
	}
	
	public static void union(int x, int y) {
		x = findSet(x);
		y = findSet(y);
		if (x<y) p[y] = x;
		else p[x] = y;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int V = sc.nextInt();
		int E = sc.nextInt();
		
		PriorityQueue<long[]> pq = new PriorityQueue<>(new Comparator<long[]>() {
			@Override
			public int compare(long[] o1, long[] o2) {
				return Long.compare(o1[2], o2[2]);
			}
		});
		
		p = new int[V];
		for (int i=0; i<V; i++) {
			p[i] = i;
		}
		
		for (int i=0; i<E; i++) {
			long[] input = new long[] {sc.nextLong()-1, sc.nextLong()-1, sc.nextLong()};
			pq.offer(input);
		}
		
		double sum = 0;
		int cnt = 0;
		while (!pq.isEmpty()) {
			long[] e = pq.poll();
			if (findSet((int)e[0])!=findSet((int)e[1])) {
				sum +=  e[2];
				if (++cnt==E-1) break;
				union((int)e[0], (int)e[1]);
			}
		}
		
		System.out.println((int)sum);

	}

}
