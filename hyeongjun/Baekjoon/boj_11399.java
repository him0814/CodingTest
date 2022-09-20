package BOJ;

/*
���� #11399 ATM
�ð����� : 1��
N (1~1000) / Pi (1~1000)
�������� ���� �� ���� ���� ���� �� �ϸ� �� �� ����
 */

import java.io.*;
import java.util.*;

public class boj_11399 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int people = Integer.parseInt(br.readLine());
		int[] time = new int[people];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for(int i = 0; i < people; i++) {
			int num = Integer.parseInt(st.nextToken());
			time[i] = num;
		}
		
		// time �迭 �������� ����
		Arrays.sort(time);
		
		int answer = 0;
		int total = 0;
		
		for(int i = 0; i < time.length; i++) {
			total += time[i];
			answer += total;
		}
		System.out.println(answer);
	}
}
