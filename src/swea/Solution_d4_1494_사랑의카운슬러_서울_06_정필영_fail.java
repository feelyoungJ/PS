package swea;

import java.io.*;
import java.util.*;

public class Solution_d4_1494_사랑의카운슬러_서울_06_정필영_fail {
	public static ArrayList<int[]> compList;
	public static int[][] worm, bit;
	public static int[] compArr, checkArr, permArr;
	public static int N, powN, compSize, count;
	public static long result;
	
	public static int[] comp2Arr, comp2Check;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_1494.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
//		T = 2;
		for (int tc=1; tc<=T; tc++) {
			result = Long.MAX_VALUE;
			N = Integer.parseInt(br.readLine());
			powN = (int) Math.pow(2, N/2);
			
			compList = new ArrayList<>();
			compArr = new int[2];
			checkArr = new int[N];
			
			permArr = new int[N];
			Arrays.fill(permArr, -1);
			
			worm = new int[N][2];
			
			
			for (int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				worm[i][0] = Integer.parseInt(st.nextToken());
				worm[i][1] = Integer.parseInt(st.nextToken());
			}

			
//			count = 0;
//			comp2Arr = new int[N];
//			comp2Check = new int[N];
//			comp2(0, 0);
//			System.out.println(count);
			
			comp(0, 0);
			System.out.println(count);
			compSize = compList.size();
//			bit = new int[(int) (Math.pow(2, N/2))][N/2];
//			
//			String d = "%0" + N/2 + "d";
//			for (int i=0; i<powN; i++) {
//				String b = String.format(d, Integer.parseInt(Integer.toBinaryString(i)));
//				for (int j=0; j<N/2; j++) {
//					bit[i][j] = b.charAt(j) - '0';
//					if (bit[i][j]==0) bit[i][j] = -1;
//				}
//			}
//			
//			
			count = 0;
			comb(0, 0);
			System.out.println(N +" "+ compSize + " " + count);
			
//			System.out.println(result);
		}

	}
	
	public static void comp2(int cnt, int start) {
		if (cnt==N/2) {
			count++;
//			compList.add(compArr.clone());
			System.out.println(Arrays.toString(comp2Arr));
			return;
		}
		
		for (int i=start; i<N; i++) {
			if (comp2Check[i]==0) {
				comp2Check[i] = 1;
				comp2Arr[cnt*2] = i;
				for (int j=i+1; j<N; j++) {
					if (comp2Check[j]==0) {
						comp2Check[j] = 1;
						comp2Arr[cnt*2+1] = j;
						comp2(cnt+1, i+1);
						comp2Check[j] = 0;
					}
				}
				comp2Check[i] = 0;
			}
			
		}
	}
	
	public static void comp(int cnt, int start) {
		if (cnt==2) {
			count++;
			compList.add(compArr.clone());
//			System.out.println(Arrays.toString(compArr));
			return;
		}
		
		for (int i=start; i<N; i++) {
			if (checkArr[i]==0) {
				checkArr[i] = 1;
				compArr[cnt] = i;
				comp(cnt+1, i);
				checkArr[i] = 0;
				
			}
		}
	}
	
	public static void comb(int cnt, int start) {
		if (cnt==N/2) {
//			System.out.println(Arrays.toString(permArr));
//			cal();
			count++;
			return;
		}
		
		for (int i=start; i<compSize; i++) {
			boolean check = true;
			for (int j=0; j<N; j++) {
				if (permArr[j]==compList.get(i)[0] || permArr[j]==compList.get(i)[1]) {
					check = false;
					break;
				}
			}
			
			if (check) {
				permArr[cnt*2] = compList.get(i)[0];
				permArr[cnt*2+1] = compList.get(i)[1];
				comb(cnt+1, i);
				permArr[cnt*2] = -1;
				permArr[cnt*2+1] = -1;
			}
		}
	}
	
	public static void cal() {
		long[] calArr = new long[N/2];
		
		for (int i=0; i<N/2; i++) {
			int x1 = worm[permArr[i*2]][0];
			int y1 = worm[permArr[i*2]][1];
			int x2 = worm[permArr[i*2+1]][0];
			int y2 = worm[permArr[i*2+1]][1];
			
			calArr[i] = (long) (Math.pow(x1-x2, 2) + Math.pow(y1-y2, 2));
		}

//		System.out.println(Arrays.toString(calArr));
		for (int i=0; i<powN; i++) {
			long sum = 0;
			for (int j=0; j<N/2; j++) {
				sum += bit[i][j] * calArr[j];
			}
//			System.out.println(sum);
//			System.out.println(sum);
			result = Math.min(result, Math.abs(sum));
		}
	}
}
