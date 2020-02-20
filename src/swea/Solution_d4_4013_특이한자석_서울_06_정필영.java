package swea;

import java.util.*;
import java.io.*;

public class Solution_d4_4013_특이한자석_서울_06_정필영 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_4013.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc=1; tc<T+1; tc++) {
			int K;
			int[][] magnetics = new int[4][8];
			K = Integer.parseInt(br.readLine());
			
			for (int i=0; i<4; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j=0; j<8; j++) {
					magnetics[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int k=0; k<K; k++) {
				st = new StringTokenizer(br.readLine());
				int numMagnetic = Integer.parseInt(st.nextToken()) - 1;
				int dir = Integer.parseInt(st.nextToken());
				int numRot[] = new int[4];
				
				numRot[numMagnetic] = dir;
				
				int nDir = dir;
				for (int i=numMagnetic; i>0; i--) {
					if (magnetics[i][6]!=magnetics[i-1][2]) {
						numRot[i-1] = -nDir;
						nDir = -nDir;
					} else {
						break;
					}
				}
				
				nDir = dir;
				for (int i=numMagnetic; i<3; i++) {
					if (magnetics[i][2]!=magnetics[i+1][6]) {
						numRot[i+1] = -nDir;
						nDir = -nDir;
					} else {
						break;
					}
				}
				
				for (int i=0; i<4; i++) {
					if (numRot[i]==1) {
						int t = magnetics[i][7]; 
						for (int j=7; j>0; j--) {
							magnetics[i][j] = magnetics[i][j-1];
						}
						magnetics[i][0] = t;
						
					} else if (numRot[i]==-1) {
						int t = magnetics[i][0]; 
						for (int j=0; j<7; j++) {
							magnetics[i][j] = magnetics[i][j+1];
						}
						magnetics[i][7] = t;
					}
				}
				//for (int[] m:magnetics) System.out.println(Arrays.toString(m));
				// System.out.println();
			}
			
			//for (int[] m:magnetics) System.out.println(Arrays.toString(m));
			
			int result = 0;
			for (int i=0; i<4; i++) {
				if (magnetics[i][0]==1) result += Math.pow(2, i);
			}
			
			System.out.println("#" + tc + " " + result);
		}
	}
}
