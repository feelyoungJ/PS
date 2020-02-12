package swea;

import java.util.*;
import java.io.*;

public class Solution_d3_1873_상호의배틀필드_서울6반_정필영 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d3_1873.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for (int tc=1; tc<T+1; tc++) {
			st = new StringTokenizer(br.readLine());
			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			
			char[][] board = new char[H][W];

			int y = -1;
			int x = -1;
			
			for (int i=0; i<H; i++) {
				String[] s = br.readLine().split("");
				for (int j=0; j<W; j++) {
					board[i][j] = s[j].charAt(0);
					if (board[i][j]=='^' || board[i][j]=='v' || board[i][j]=='<' || board[i][j]=='>') {
						y = i;
						x = j;
					}
					
				}
			}
			
			int N = Integer.parseInt(br.readLine());
			
			String[] funcS = br.readLine().split("");
			char[] func = new char[N];
			
			for (int i=0; i<N; i++) {
				func[i] = funcS[i].charAt(0);
			}
			
//			for (char[] b:board) System.out.println(Arrays.toString(b));
//			System.out.println(Arrays.toString(func));
//			System.out.println(y + " " + x);
//			System.out.println();
			
		}

	}

}
