package baekjoon;

// ���� �ּ�,�ִ� 10818
// ���� N��. �ּ�,�ִ밪 ���ϱ�
//--------�Է� ����-------
// ù°�� ������ ����  N (1 �� N �� 1,000,000)
// ��°�� N���� ���� �������� ���� 

import java.io.*;
import java.util.*;

public class MinMax {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		System.out.println(arr[0] + " " +arr[n-1]);
		
//		int min = arr[0];
//		int max = arr[0];
//		
//		for(int i=0; i<n; i++) {
//			if(min > arr[i]) {
//				min = arr[i];
//			}
//			if(max < arr[i]) {
//				max = arr[i];
//			}
//		}
//		
//		System.out.println(min + " " + max);
	}
}
