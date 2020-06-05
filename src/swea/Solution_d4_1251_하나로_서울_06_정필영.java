package swea;

import java.util.*;
import java.io.*;

public class Solution_d4_1251_하나로_서울_06_정필영 {
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
		
		int T = sc.nextInt();
		
		for (int tc=1; tc<=T; tc++) {
			int N = sc.nextInt();
			
			int[] axisX = new int[N];
			int[] axisY = new int[N];
			
			int maxAxis = 0;
			
			for (int i=0; i<N; i++) {
				axisX[i] = sc.nextInt();
				maxAxis = Math.max(maxAxis, axisX[i]);
			}
			
			for (int i=0; i<N; i++) {
				axisY[i] = sc.nextInt();
				maxAxis = Math.max(maxAxis, axisY[i]);
			}
			
			double E = sc.nextDouble();
			
			Long[][] graph = new Long[N][N];
			
			for (int i=0; i<N-1; i++) {
				for (int j=i+1; j<N; j++) {
					Long length = (long) (Math.pow(axisX[i]-axisX[j], 2) +  Math.pow(axisY[i]-axisY[j], 2));
					graph[i][j] = length;
					graph[j][i] = length;
				}
			}
			
			PriorityQueue<long[]> pq = new PriorityQueue<>(new Comparator<long[]>() {
				@Override
				public int compare(long[] o1, long[] o2) {
					return Long.compare(o1[0], o2[0]);
				}
			});
			
			p = new int[N];
			for (int i=0; i<N; i++) p[i] = i;
			
			for (int i=0; i<N-1; i++) {
				for (int j=i+1; j<N; j++) {
					pq.offer(new long[] {graph[i][j], i, j});
				}
			}
			
			double sum = 0;
			int cnt = 0;
			while (!pq.isEmpty()) {
				long[] e = pq.poll();
				
				if (findSet((int)e[1])!=findSet((int)e[2])) {
					sum +=  e[0];
					if (++cnt==N-1) break;
					union((int)e[1], (int)e[2]);
				}
			}
			
			System.out.println("#" + tc + " " + Math.round(sum * E));
			
		}

	}

}
