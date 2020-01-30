package swea;

import java.util.Scanner;

public class Solution_d2_1954_달팽이숫자_서울6반_정필영 {
	public static int[] dx = {1, 0, -1, 0};
	public static int[] dy = {0, 1, 0, -1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		for (int tc=1; tc<t+1; tc++) {
			int n = sc.nextInt();
			int x = 0;
			int y = 0;
			int i = 0;
			int[][] arr = new int[n][n];
			// arr[y][x] = 1;
			
			
			
			for (int num=1;num<n*n+1;num++) {
				arr[y][x] = num;
				if (x+dx[i]<0 || x+dx[i]>n-1 || y+dy[i]<0 || y+dy[i]>n-1 || arr[y+dy[i]][x+dx[i]]!=0) {
					i = (i+1) % 4;
				}
				y += dy[i];
				x += dx[i];
				
			}
			
			System.out.println("#" + tc);
			
			for (int a=0; a<n; a++) {
				for (int b=0; b<n; b++) {
					System.out.print(arr[a][b] + " ");
				}
				System.out.println();
			}
		}
		
		sc.close();
		
		

	}

}
