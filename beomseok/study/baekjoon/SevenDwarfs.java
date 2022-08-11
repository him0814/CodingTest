package baekjoon;
//일곱난쟁이 백준 2309

//일곱 난쟁이의 키의 합 100
//키는 100을 넘지 않는 자연수
//아홉 난쟁이의 키는 모두 다르며, 가능한 정답이 여러 가지인 경우에는 아무거나 출력

import java.io.*;
import java.util.*;

public class SevenDwarfs {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] sd = new int[9];
		int sum = 0;
		for(int i=0; i<sd.length; i++) {
			sd[i] = Integer.parseInt(br.readLine());
			sum += sd[i];
		}
		Arrays.sort(sd);
		int noDwarf1 = 0;
		int noDwarf2 = 0;
		for(int j=0; j<8; j++) {
			for(int k=j+1; k<9; k++) {
				if(sum - sd[j] - sd[k] == 100) {
//					sd[j] = 0;
//					sd[k] = 0;
					noDwarf1 = j;
					noDwarf2 = k;
				}
			}
		}
//		Arrays.sort(sd);
		for(int a=0; a<9; a++) {
			if(a == noDwarf1 || a == noDwarf2) {
				continue;
			}
			System.out.println(sd[a]);
		}
		
	}
}
