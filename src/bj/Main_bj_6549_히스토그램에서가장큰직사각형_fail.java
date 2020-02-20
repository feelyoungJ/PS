package bj;

import java.util.*;
import java.io.*;

public class Main_bj_6549_히스토그램에서가장큰직사각형_fail {
	public static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while (true) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			
			if (N==0) break;
			
			int[] board = new int[N];
			HashSet<Integer> hs = new HashSet<>();
			
			for (int n=0; n<N; n++) {
				board[n] = Integer.parseInt(st.nextToken());
				hs.add(board[n]);
			}
			
			int[] dp = new int[hs.size()];
			int[] hsArr = new int[hs.size()+1];
			HashMap<Integer, Integer> hm = new HashMap<>();
			HashMap<Integer, Integer> lastIndex = new HashMap<>();
			
			int idx = 1;
			for (int h:hs) {
				hm.put(h, idx++);
				hsArr[idx-2] = h;
			}
			
			int max = 0;
			for (int j=0; j<N; j++) {
				lastIndex.put(board[j], j);
				
//				int m = (j-lastIndex.get(hsArr[board[j]-1])) * hsArr[board[j]-1];
				
				for (int k=0; k<hm.get(board[j]); k++) {
//					System.out.println(k);
					dp[k]++;
					max = Math.max(max, dp[k] * hsArr[k]);
				}
				Arrays.fill(dp, hm.get(board[j]), hs.size(), 0);
//				System.out.println(Arrays.toString(dp));
			}
			
//			System.out.println(hm);
			System.out.println(max);
		}
		
	}
	
	class Area {
		int height;
		int width;
		int volume;
		
		Area(int height, int width)  {
			this.height = height;
			this.width = width;
			this.volume = height * width;
		}
	}
}

