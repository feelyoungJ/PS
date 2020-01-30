package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution_d4_1224_계산기3_서울6반_정필영 {
	public static Stack<Character> stk;
	

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		for (int tc=1; tc<11; tc++) {
			StringBuilder sb = new StringBuilder();
			
			stk = new Stack<>();
			
			int length = Integer.parseInt(br.readLine());
			char[] formula = br.readLine().toCharArray();
			
			for (char f:formula) {
				if (Character.isDigit(f)) {
					sb.append(f);
				} else if (f==')') {
					while ((f=stk.pop())!='(') {
						sb.append(f);
					}
				} else {
					while (getIcp(f)<=getIsp()) {
						sb.append(stk.pop());
					}
					stk.push(f);
				}
			}
			while (!stk.empty()) {
				sb.append(stk.pop());
			}
			
			Stack<Integer> calcStk = new Stack<>();
			
			for (int i=0; i<sb.length(); i++) {
				char c = sb.charAt(i);
				if (Character.isDigit(c)) {
					calcStk.push(c-'0');
				} else {
					int n2 = calcStk.pop();
					int n1 = calcStk.pop();
					int nn = 0;
					switch(c) {
						case '+': nn = n1+n2; break;
						case '-': nn = n1-n2; break;
						case '*': nn = n1*n2; break;
						case '/': nn = n1/n2; break;
					}
					calcStk.push(nn);
				}
			}
			System.out.println("#" + tc + " " + calcStk.pop());
			
		}

	}
	public static int getIcp(char c) {
		switch(c) {
			case '+':
			case '-': return 1;
			case '*': 
			case '/': return 2;
			case '(': return 3;
			default: return 0;
		}
	}
	
	public static int getIsp() {
		char c = stk.empty()? ' ' : stk.peek();
		switch(c) {
			case '+':
			case '-': return 1;
			case '*': 
			case '/': return 2;
			case '(': return 0;
			default: return 0;
		}
	}

}
