package swea;

import java.util.*;
import java.io.*;

public class Solution_d4_5653_줄기세포배양 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			int[][] arr = new int[N][M];
			for (int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j=0; j<M; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int[][] cont = new int[N+300][M+300];
			int[][] state = new int[N+300][M+300];
			
			for (int i=0; i<N; i++) {
				for (int j=0; j<M; j++) {
					cont[i+150][j+150] = arr[i][j];
					state[i+150][j+150] = arr[i][j];
				}
			}
			
			N += 300;
			M += 300;
			
			for (int k=0; k<K; k++) {
				for (int i=0; i<N; i++) {
					for (int j=0; j<M; j++) {
						state[i][j] -= 1;
					}
				}
				
				for (int i=0; i<N; i++) {
					for (int j=0; j<M; j++) {
						if(state[i][j]==-1 && cont[i][j]!=0) {
							if (cont[i-1][j]==0 || (cont[i-1][j]==state[i-1][j] && cont[i][j]>cont[i-1][j])) {
								cont[i-1][j] = cont[i][j];
								state[i-1][j] = cont[i][j];
							}
							if (cont[i+1][j]==0 || (cont[i+1][j]==state[i+1][j] && cont[i][j]>cont[i+1][j])) {
								cont[i+1][j] = cont[i][j];
								state[i+1][j] = cont[i][j];
							}
							if (cont[i][j-1]==0 || (cont[i][j-1]==state[i][j-1] && cont[i][j]>cont[i][j-1])) {
								cont[i][j-1] = cont[i][j];
								state[i][j-1] = cont[i][j];
							}
							if (cont[i][j+1]==0 || (cont[i][j+1]==state[i][j+1] && cont[i][j]>cont[i][j+1])) {
								cont[i][j+1] = cont[i][j];
								state[i][j+1] = cont[i][j];
							}
						}
					}
				}
			}
			
			int cnt = 0;
			for (int i=0; i<N; i++) {
				for (int j=0; j<M; j++) {
					if (-cont[i][j]<state[i][j]) {
						cnt += 1;
					}
				}
			}
			
			System.out.println("#" + tc + " " + cnt);
			
		}
		
	}

}
