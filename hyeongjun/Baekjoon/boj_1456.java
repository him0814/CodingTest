package BOJ;

/*
���� #1456 ���� �Ҽ�

� ���� �Ҽ��� n���� (n>=2) -> ���� �Ҽ�

1 <= a <= b <= 10^14
b = 10^7 �� ��, b^2 = 10^14 �̹Ƿ� 10^7������ ������
 */

import java.io.*;
import java.util.*;

public class boj_1456 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int max = 10000000;
		
		boolean[] prime = new boolean[max+1];
		
		for(int i = 2; i <= max; i++) {
			for(int j = 2; j <= max; j += i) {
				prime[j] = true;
			}
		}
		
	}
}
