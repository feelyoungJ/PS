package swea;

import java.util.*;
import java.io.*;

public class Solution_d3_5215_햄버거다이어트_서울_06_정필영 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());
			
			int[][] materials = new int[N+1][2];
			
			for (int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				materials[i][0] = Integer.parseInt(st.nextToken());
				materials[i][1] = Integer.parseInt(st.nextToken());
			}
			
			int[][] values = new int[N+1][L+1];
			for (int i=1; i<=N; i++) {
				values[0][i] = 0;
			}
			
			for (int i=0; i<=N; i++) {
				for (int j=0; j<=L; j++) {
					if (materials[i][1] > j) {
						values[i][j] = values[i-1][j];
					} else {
						
					}
				}
			}
			
//			Value[] values = new Value[N+1];
//			for (int i=0; i<N; i++) {
//				values[i] = new Value(materials[i][0] / (float) materials[i][1], i);
//			}
//			Arrays.sort(values);
//			int result = 0;
//			for (Value v:values) {
//				if (result+materials[v.i][1] <= L) {
//					result += materials[v.i][0];
//				} 
//			}
//			System.out.println("#" + tc + " " + result);
		}
	}
}

class Value implements Comparable<Value> {
	float v;
	int i;
	Value(float v, int i) {
		this.v = v;
		this.i = i;
	}
	@Override
	public String toString() {
		return "Value [v=" + v + ", i=" + i + "]";
	}
	@Override
	public int compareTo(Value o) {
		// TODO Auto-generated method stub
		return -Float.compare(this.v, o.v);
	}
}
