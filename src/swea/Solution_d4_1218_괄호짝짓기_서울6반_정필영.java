package swea;

import java.io.*;
import java.util.*;

public class Solution_d4_1218_괄호짝짓기_서울6반_정필영 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringTokenizer st;
		
		for (int tc=1; tc<11; tc++) {
			Stack<String> stk = new Stack<>();
			int N = Integer.parseInt(br.readLine());
			boolean flag = true;
			// st = new StringTokenizer(br.readLine(), "");
			
			for (String s:br.readLine().split("")) {
				if (!flag) break;

				
				if (s.equals("<") || s.equals("(") || s.equals("{") || s.equals("[")) {
					stk.push(s);
				} else if (!stk.isEmpty() && s.equals(">") && "<".equals(stk.peek())) {
					stk.pop();
				} else if (!stk.isEmpty() && s.equals(")") && "(".equals(stk.peek())) {
					stk.pop();
				} else if (!stk.isEmpty() && s.equals("}") && "{".equals(stk.peek())) {
					stk.pop();
				} else if (!stk.isEmpty() && s.equals("]") && "[".equals(stk.peek())) {
					stk.pop();
				} else {
					flag = false;
					break;
				}
				
			}
			if (flag) System.out.println("#" + tc + " " + 1);
			else System.out.println("#" + tc + " " + 0);
		}
	}

}
