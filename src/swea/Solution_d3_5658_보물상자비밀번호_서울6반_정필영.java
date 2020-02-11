package swea;

import java.util.*;
import java.io.*;

public class Solution_d3_5658_보물상자비밀번호_서울6반_정필영 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_5658.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc=1; tc<T+1; tc++) {
			
			HashSet<Integer> hs = new HashSet<>();
//			HashSet<String> hs = new HashSet<>();
			
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			String locker = br.readLine();
			char arr[] = new char[N];
			for (int i=0; i<N; i++) {
				arr[i] = locker.charAt(i);
			}
			
			
			
			
			for (int i=0; i<N/4; i++) {
				for (int j=0; j<4; j++) {
					hs.add(Integer.parseInt(String.valueOf(arr, j*N/4, N/4), 16));
//					hs.add(String.valueOf(arr, j*N/4, N/4));
				}
				
				char t = arr[0];
				for (int j=0; j<N-1; j++) {
					arr[j] = arr[j+1];
				}
				arr[N-1] = t;
			}
			
			
			List<Integer> result = new ArrayList(hs);
			Collections.sort(result);
//			System.out.println(result.get(0));
//			System.out.println(Integer.toHexString(result.get(0)));
			
//			Integer.toHexString(result.get(K))
//			Integer.toBinaryString(1);
			System.out.println("#" + tc + " " + result.get(result.size()-K));
//			System.out.println(Integer.toHexString(result.get(K)));
			
		}

	}

}
