package study1;

// ���� #1081
// N�� ���� �� �ּڰ�, �ִ� ���ϱ�
// ù° �ٿ� ���� N(1<=N<=1,000,000)
// ��° �� N���� ������ �������� �����ؼ� �־���
// ù° �ٿ� �־��� ���� N���� �ּڰ�, �ִ� ����ϱ�

import java.io.*;
import java.util.*;

public class boj_10818 {

	public static void main(String[] args) throws IOException {
		
		// BufferedReader -> �Է��� �� �� ����
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// ���ڿ� ��ġ��
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine()); // br.readLine() br�� ����� �� ���� �о��
		
		// ���ڿ��� ���� �������� �ڸ�
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int[] arr = new int[n];
		
		for(int i = 0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken()); //
		}
		
		
		Arrays.sort(arr);  // �迭 �������� ����
		
//		���ڿ��� ���� �������� �߷ȴ��� Ȯ���ϱ� ����		
//		for(int i = 0; i<n; i++) {
//			System.out.println(arr[i]);
//		}
//		
//		System.out.println(arr[0] + " " + arr[n-1]); 
		
		
		int min = arr[0]; // int max = Integer.MIN_VALUE; 
		int max = arr[0]; // int min = Integer.MAX_VALUE;
		
		for(int i = 1; i<n; i++) {
			if(arr[i] > max)
				max = arr[i];
			if(arr[i] < min)
				min = arr[i];
		}
		
		// StringBuilder�� ���ڿ� ��ħ
		sb.append(arr[0] + " " + arr[n-1]); // 7 35
		System.out.println(sb.toString());  // ���
		
	}
	
}
