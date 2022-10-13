package BOJ;

/*
���� #11501 �ֽ�
�ð�����: 5�� -> 50��
N <= 1,000,000
�ְ� <= 10,000


1. �ֽ��� ������ ���� ��� ���� ���� -> max��� �ϰ���
2. max���� ���� �����϶� ���� ��
3. max�� �� �ֽ� �� �ȱ�
4. max ���� ������ �ٽ� max�� ����
5. �ݺ�

 */

import java.io.*;
import java.util.*;

public class boj_11501 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int test_cnt = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < test_cnt; i++) {
			int day = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			// arr�迭�� �ֽ��� ���� ����
			int[] arr = new int[day];
			for(int j = 0; j < day; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			
			int max = Integer.MIN_VALUE;
			long profit = 0;
			
			for(int j = day - 1; j >= 0; j--) {
				if(max < arr[j]) {
					max = arr[j];
				} else {
					profit += max - arr[j];
				}
			}
			sb.append(profit+"\n");
		}
		
		System.out.println(sb.toString());
	}
}