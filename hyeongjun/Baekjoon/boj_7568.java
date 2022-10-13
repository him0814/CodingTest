package BOJ;

/*
�ð�����: 1�� -> 10��
n -> 50
x -> 200 / y -> 200

1. ������ �迭 {Ű, ������} ����
2. ���� for������ ù��° ��Ҹ� ������ ��ҿ� ���Ͽ� ������ ����+1
 */

import java.io.*;
import java.util.*;

public class boj_7568 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[N][2]; // {Ű, ������}
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < arr.length; i++) {
			
			int rank = 1;
			
			for(int j = 0; j < arr.length; j++) {
				if(i == j) { // ���� ��� �� �� 
					continue;
				}
				
				if(arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]) {
					rank++;
				}
			}
			System.out.println(rank);
		}
	}
}
