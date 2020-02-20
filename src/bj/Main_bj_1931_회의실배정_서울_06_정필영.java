package bj;

import java.util.*;
import java.io.*;

public class Main_bj_1931_회의실배정_서울_06_정필영 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		time[] timeArr = new time[N];
		for (int n=0; n<N; n++) {
			st = new StringTokenizer(br.readLine());
			timeArr[n] = new time(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(timeArr);
		
		int[][] ld = new int[10][2];
		Arrays.sort(ld, (o1, o2)->Integer.compare(o1[0], o2[0]));
		
		int continueTime = 1;
		int endTime = timeArr[0].end;
		
		for (int n=1; n<N; n++) {
			if (timeArr[n].start>=endTime) {
				continueTime++;
				endTime = timeArr[n].end;
			}
		}
		System.out.println(continueTime);
		
	}
	
	static class time implements Comparable<time>{
		int start;
		int end;
		time(int start, int end) {
			this.start = start;
			this.end = end;
		}
		@Override
		public int compareTo(time o) {
			if (this.end==o.end) return Integer.compare(this.start, o.start); 
			else return Integer.compare(this.end, o.end);
		}
	}
}
