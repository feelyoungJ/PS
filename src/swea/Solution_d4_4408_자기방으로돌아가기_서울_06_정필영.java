package swea;

import java.util.*;
import java.io.*;

public class Solution_d4_4408_자기방으로돌아가기_서울_06_정필영 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_4408.txt"));
		
		// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		
//		int T = Integer.parseInt(br.readLine());
		int T = sc.nextInt();
		
		for (int tc=1; tc<T+1; tc++) {
//			int N = Integer.parseInt(br.readLine());
			int N = sc.nextInt();
			
			Move[] students = new Move[N*2];
			
			for (int i=0; i<N; i++) {
//				String[] c = br.readLine().split(" ");
//				students[i*2] = new Move(Integer.parseInt(c[0]), 0);
//				students[i*2+1] = new Move(Integer.parseInt(c[1]), 1);
				
				int a = (sc.nextInt()-1)/2;
				int b = (sc.nextInt()-1)/2;
				
				int min = Math.min(a, b);
				int max = Math.max(a, b);
				
				students[i*2] = new Move(min, 0);
				students[i*2+1] = new Move(max, 1);
				
			}
			
			Arrays.sort(students);
			
			int stack = 0;
			int result = 0;
			for (int i=0; i<N*2; i++) {
				if (students[i].type==0) stack++;
				else stack--;
//				System.out.println(stack);
				result = Math.max(result, stack);
			}
			

			
//			for (Move s:students) System.out.println(s.room + " " + s.type + " ");
//			System.out.println();
			System.out.println("#" + tc + " " + result);
			
			
		}
		
	}
}

class Move implements Comparable<Move> {
	int room;
	int type;
	
	Move(int room, int type) {
		this.room = room;
		this.type = type;
	}

	@Override
	public int compareTo(Move o) {
		if (this.room==o.room) {
			return Integer.compare(this.type, o.type);
		} 
		
		return Integer.compare(this.room, o.room);
	}
}

//int max;
//boolean flag = true;
//for (int i=0; i<N; i++) {
//	if (flag) {
//		max = students[i].end;
//		flag = false;
//	} else {
//		if 
//	}
//	
//}

//class Move implements Comparable<Move> {
//int start;
//int end;
//
//Move(int start, int end) {
//	this.start = start;
//	this.end = end;
//}
//
//@Override
//public int compareTo(Move o) {
//	return Integer.compare(this.end, o.end);
//}
//}

