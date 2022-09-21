package BOJ;

/*
���� #11497 �볪�� �ǳʶٱ�
�ð� ����: 1�� -> 10��

���� ū �� �� ���� 2,3��°�� ū ���� �ΰ� �� ���� 4,5��° ū ���� �ΰ�..

left            right
 0  1  2  3  4  5  6
10 10 11 11 12 12 13

 */

import java.io.*;
import java.util.*;

public class boj_11497 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				
		int test_cnt = Integer.parseInt(br.readLine()); //3
		
		for(int i = 0; i < test_cnt; i++) {
			int tree_cnt = Integer.parseInt(br.readLine());
			
			int[] arr = new int[tree_cnt]; // �볪�� ����
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
			for(int j = 0; j < tree_cnt; j++) {
				int now = Integer.parseInt(st.nextToken());
				arr[j] = now; // arr �迭�� ó�� �־��� �볪�� ���� ����
			}
			
			Arrays.sort(arr); // arr �迭 ����
			
			int[] tmp = new int[tree_cnt]; 
			
			tmp[tree_cnt/2] = arr[tree_cnt-1]; // tmp �迭 ����� �ִ� �־���
			int right = tree_cnt/2 + 1; // �ε����� ������� ���������� 
			int left = tree_cnt/2 - 1;  // �ε����� ������� ��������
			int count = 1; // ����� �ִ� �־���� ������ 1 // while�� ���������� ����
			
			while(count < tmp.length) {
				if(right < tree_cnt) { // ��� ���� �����ʺ���
					tmp[right] = arr[tree_cnt-1-count];
					count++;
					right++;
				}
				if(left >= 0) { // ��� ���� ���ʺ���
					tmp[left] = arr[tree_cnt-1-count];
					count++;
					left--;
				}
			}
			
//			for(int z: tmp) {
//				System.out.println(z);
//			}
			
			// math.abs(i) i�� ���밪
			int max = Math.abs(tmp[0] - tmp[tree_cnt-1]); // ù��° ���� ������ ���� ���� ���밪
			
			for(int k = 0; k < tree_cnt-1; k++) {
				if(max < Math.abs(tmp[k] - tmp[k+1])) {
					max = Math.abs(tmp[k] - tmp[k+1]);
				}
			}
			
			System.out.println(max);
		}
	}
}
