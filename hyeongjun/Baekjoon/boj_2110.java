package BOJ;

/*
���� #2110 ������ ��ġ

i) �ִ�Ÿ� 1
1 2 4 8 9
v v v v v

ii) �ִ�Ÿ� 2
1 2 4 8 9 
  v v v

iii) �ִ�Ÿ� 3
1 2 4 8 9
v   v v

iv) �ִ�Ÿ� 4
1 2 4 8 9
v     v
 */

import java.io.*;
import java.util.*;

public class boj_2110 {
	
	static int[] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		map = new int[n];
		
		for(int i = 0; i < n; i++) {
			map[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(map);
		
		// ������ ���� �Ÿ�
		int start = 1; // �ּڰ�
		int end = map[n-1] - map[0]; // �ִ�
		int distance = 0;
		
		while(start <= end) {
			int mid = (start + end) / 2;
			int now = map[0] + mid;
			int cnt = 1; // ������ ��ġ ����
			
			for(int i = 0; i < n; i++) {
				if(now <= map[i]) {
					now = map[i] + mid;
					cnt++;
				}
			}
			
			if(cnt >= m) {
				distance = Math.max(distance, mid);
				start = mid + 1;
			} else { // cnt < m
				end = mid - 1;
			}
		}
		
		System.out.println(distance);
	}
}
