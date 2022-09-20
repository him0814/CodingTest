package BOJ;

/*
���� #11497 �볪�� �ǳʶٱ�
�ð� ����: 1�� -> 10��

���� ū �� �� ���� 2,3��°�� ū ���� �ΰ� �� ���� 4,5��° ū ���� �ΰ�..

 */

import java.io.*;
import java.util.*;

public class boj_11497 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				
		int test_cnt = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < test_cnt; i++) {
			int tree_cnt = Integer.parseInt(br.readLine());
			
			int[] arr = new int[tree_cnt];
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
			for(int j = 0; j < tree_cnt; j++) {
				int now = Integer.parseInt(st.nextToken());
				arr[j] = now;
			}
			
			Arrays.sort(arr); // ����
			
			int idx = tree_cnt - 1;
			int max = 0;
			int[] sort_arr = new int[tree_cnt];
			
			for(int k = 0; k < tree_cnt; k++) {
				max = arr[idx];
				if(idx < tree_cnt-1) {
					if(max < arr[idx+1]) {
						if(sort_arr[tree_cnt/2 - 1] != 0) {
							sort_arr[tree_cnt/2 + 1] = max;
						}
						sort_arr[tree_cnt/2 - 1] = max;
					}
				} else {
					sort_arr[tree_cnt/2] = max;
				}
				idx--;
			}
			
			for(int z: sort_arr) {
				System.out.println(z);
			}
			
		}
	}
}
