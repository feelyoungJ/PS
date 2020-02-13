package jungol;

import java.util.*;
import java.io.*;

public class Main_jo_1828_냉장고_서울_06_정필영 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());

		Temp[] tempArr = new Temp[N];
		
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			tempArr[i] = new Temp(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		Arrays.sort(tempArr);
		
		int result = 1;
		boolean flag = false;
		int max = tempArr[0].max;
		
		for (int i=1; i<tempArr.length; i++) {
			if (flag) {
				
				flag = false;
			} 
			
			if (!flag) {
				if (max<tempArr[i].min) {
					result++;
					max = tempArr[i].max;
					flag = true;
				}
			}
		
		}
		System.out.println(result);
	}

}


class Temp implements Comparable<Temp> {
	int min;
	int max;
	
	Temp(int min, int max) {
		this.min = min;
		this.max = max;
	}

	@Override
	public int compareTo(Temp o) {
		return Integer.compare(this.max, o.max);
	}

	@Override
	public String toString() {
		return "Temp [temperature=" + min + ", oc=" + max + "]";
	}
	
}
