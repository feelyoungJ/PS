package swea;

import java.util.*;
import java.io.*;

public class Solution_d5_7793_오나의여신님 {
	static int[][] map = new int[3][3];
	static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	
	final static int[] dy = {-1, 1, 0, 0};
	final static int[] dx = {0, 0, -1, 1};
	
	static char[][] board;
	static boolean[][] visited;

	public static void main(String[] args) throws Exception {
//		bfs1();
//		bfs3();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for (int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			int startY = -1;
			int startX = -1;
			
			board = new char[N][M];
			visited = new boolean[N][M];

			Queue<int[]> devil = new LinkedList<>();
			
			// br.readLine().toCharArray();
			for (int i=0; i<N; i++) {
				String s = br.readLine();
				for (int j=0; j<M; j++) {
					board[i][j] = s.charAt(j);
					if (board[i][j] == 'S') {
						startY = i;
						startX = j;
						visited[i][j] = true;
					} else if (board[i][j] == '*') {
						visited[i][j] = true;
						devil.offer(new int[] {i, j});
					} else if (board[i][j] == 'X') visited[i][j] = true;
				}
			}
			
			Queue<int[]> queue = new LinkedList<>();
			
			queue.offer(new int[] {startY, startX});
			
			int count = 0;
			while (!queue.isEmpty()) {
				count++;
				Queue<int[]> nextDevil = new LinkedList<>();
				while (!devil.isEmpty()) {
					int[] d = devil.poll();
					for (int i=0; i<4; i++) {
						int ny = d[0] + dy[i];
						int nx = d[1] + dx[i];
						
						if (0<=ny && ny<N && 0<=nx && nx<M && board[ny][nx]=='.') {
							visited[ny][nx] = true;
							board[ny][nx] = '*';
							nextDevil.offer(new int[] {ny, nx});
						}
					}
				}
				devil = nextDevil;
				
				Queue<int[]> nextQueue = new LinkedList<>();
				while (!queue.isEmpty()) {
					int[] q = queue.poll();
					
					boolean flag = true;
					for (int i=0; i<4; i++) {
						int ny = q[0] + dy[i];
						int nx = q[1] + dx[i];
						
						
						if (0<=ny && ny<N && 0<=nx && nx<M && !visited[ny][nx]) {
							flag = false;
							visited[ny][nx] = true;
							
							if (board[ny][nx]=='D') {
								nextQueue = new LinkedList<>();
								queue = nextQueue;
								System.out.println("#" + tc + " " + count);
								break;
							}
							nextQueue.offer(new int[] {ny, nx});
						}
					}
					if (flag) {
						System.out.println("#" + tc + " " + "GAME OVER");
						queue = new LinkedList<>();
						break;
						
					}
					
				}
				queue = nextQueue;
			}
		}
	}
	
	
	
	static void bfs1() {
		// 0, 0 ~ 2, 2로 이동하는 최단 거리를 찾아보자
		// 방문했던 곳은 더 이상 가지 말자
		boolean[][] visited = new boolean[3][3];
		
		// 두개 이상의 정보를 담기
		// 배열 : int[] pair = {0, 0} : index가 의미를 갖는다 (헷갈림), 동일한 데이터 타입만 처리, 출력이 번거롭다
		//							    속도가 빠르고 가볍다
		// 사용자 정의 클래스
		
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(0, 0, 0));
		visited[0][0] = true;
		
		// 현재 큐에 담겨있는 것들까지만 하고 새로 들어온 것들은 나중에
		while (!q.isEmpty()) {
			Point front = q.poll();
			// 사용
			System.out.println(front);
			
			// 자식 탐색
			for (int d=0; d<dirs.length; d++) {
				int nr = front.row + dirs[d][0];
				int nc = front.col + dirs[d][1];
				
				if (isIn(nr, nc)) {
					if(!visited[nr][nc]) {
						visited[nr][nc] = true;
						q.offer(new Point(nr, nc, front.depth+1));
					}
				}
			}
		}
	}
	
	static void bfs3() {
		// 0, 0 ~ 2, 2로 이동하는 최단 거리를 찾아보자
		// 방문했던 곳은 더 이상 가지 말자
		boolean[][] visited = new boolean[3][3];
		
		// 두개 이상의 정보를 담기
		// 배열 : int[] pair = {0, 0} : index가 의미를 갖는다 (헷갈림), 동일한 데이터 타입만 처리, 출력이 번거롭다
		//							    속도가 빠르고 가볍다
		// 사용자 정의 클래스
		
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(0, 0, 0));
		visited[0][0] = true;
		
		// 현재 큐에 담겨있는 것들까지만 하고 새로 들어온 것들은 나중에
		int size = q.size();
		while (size-->0) {
			Point front = q.poll();
			// 사용
			System.out.println(front);
			
			// 자식 탐색
			for (int d=0; d<dirs.length; d++) {
				int nr = front.row + dirs[d][0];
				int nc = front.col + dirs[d][1];
				
				if (isIn(nr, nc)) {
					if(!visited[nr][nc]) {
						visited[nr][nc] = true;
						q.offer(new Point(nr, nc, front.depth+1));
					}
				}
			}
		}
		System.out.println("턴은 종료 되었고, 현재 남은 것은 " + q);
	}
	
	static boolean isIn(int r, int c) {
		
		return 0<=r && 0<=c && r<3 && c<3;
	}
	
	static class Point{
		int row, col, depth; // 행, 열, 깊이(단계)

		public Point(int row, int col, int depth) {
			super();
			this.row = row;
			this.col = col;
			this.depth = depth;
		}

		@Override
		public String toString() {
			return "Point [row=" + row + ", col=" + col + ", depth=" + depth + "]";
		}
		
		
	}
}