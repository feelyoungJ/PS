package swea;

import java.io.*;
import java.util.*;

public class Solution_d3_1244_최대상금_서울_06_정필영 {
	public static String N;
	public static char[] number, copyNumber;
	public static int size, count, max;
	public static int[] combArr, permArr, v;
	public static ArrayList<int[]> combList;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d3_1244.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int tc=1; tc<T+1; tc++) {
			st = new StringTokenizer(br.readLine());
			
			N = st.nextToken();
			size = N.length();
			
			String[] nS = N.split("");
			number = new char[size];
			

			for (int i=0; i<size; i++) {
				number[i] = nS[i].charAt(0);
			}
			
			combArr = new int[2];
			combList = new ArrayList<>();
			v = new int[N.length()];
			
			count = Integer.parseInt(st.nextToken());
			permArr = new int[count];
			max = 0;
			
			if (size-1<=count) {
				if (Math.abs(count-size)%2==0) {
					StringBuilder sb = new StringBuilder();
					Arrays.sort(number);
					
					for (int i=size-1; i>=2; i--) {
						sb.append(number[i]);
					}
					sb.append(number[0]);
					sb.append(number[1]);
					
					System.out.println("#" + tc + " " + sb);
					
				} else {
					StringBuilder sb = new StringBuilder();
					Arrays.sort(number);
					
					for (int i=size-1; i>=0; i--) {
						sb.append(number[i]);
					}
					System.out.println("#" + tc + " " + sb);
				}
				
			} else {
				comb(0, 0);
				perm(0);
				System.out.println("#" + tc + " " + max);
			}
			
			
			
			
//			for (int[] a:combList) System.out.println(Arrays.toString(a));
//			for (ArrayList<Integer> h:hm.values()) System.out.println(h);
			
		}
	}
	
	public static void comb(int cnt, int start) {
		if (cnt==2) {
//			System.out.println(Arrays.toString(combArr));
			int[] add = new int[2];
			add = combArr.clone();
			combList.add(add);
			return;
		}
		
		for (int i=start; i<size; i++) {
			if (v[i]==0) {
				v[i] = 1;
				combArr[cnt] = i;
				comb(cnt+1, i);
				v[i] = 0;
			}
		}
	}
	
	public static void perm(int cnt) {
		if (cnt==count) {
//			System.out.println(Arrays.toString(permArr));
			copyNumber = new char[size];
			
			for (int i=0; i<size; i++) {
				copyNumber[i] = number[i];
			}
			
			
			for (int i=0; i<cnt; i++) {
				int[] swapArr = combList.get(permArr[i]);
				swap(swapArr[0], swapArr[1]);
			}
			
			max = Math.max(max, Integer.parseInt(String.valueOf(copyNumber)));
			return;
			
		}
		
		for (int i=0; i<combList.size(); i++) {
			permArr[cnt] = i;
			perm(cnt+1);
		}
	}
	
	public static void swap(int i, int j) {
		char T = copyNumber[i];
		copyNumber[i] = copyNumber[j];
		copyNumber[j] = T;
	}
}
