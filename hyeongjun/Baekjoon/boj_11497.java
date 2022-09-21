package BOJ;

/*
백준 #11497 통나무 건너뛰기
시간 제한: 1초 -> 10억

가장 큰 수 양 옆을 2,3번째로 큰 수를 두고 그 옆은 4,5번째 큰 수를 두고..

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
			
			int[] arr = new int[tree_cnt]; // 통나무 갯수
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
			for(int j = 0; j < tree_cnt; j++) {
				int now = Integer.parseInt(st.nextToken());
				arr[j] = now; // arr 배열에 처음 주어진 통나무 높이 삽입
			}
			
			Arrays.sort(arr); // arr 배열 정렬
			
			int[] tmp = new int[tree_cnt]; 
			
			tmp[tree_cnt/2] = arr[tree_cnt-1]; // tmp 배열 가운데에 최댓값 넣어줌
			int right = tree_cnt/2 + 1; // 인덱스를 가운데에서 오른쪽으로 
			int left = tree_cnt/2 - 1;  // 인덱스를 가운데에서 왼쪽으로
			int count = 1; // 가운데에 최댓값 넣어줬기 때문에 1 // while문 빠져나오기 위함
			
			while(count < tmp.length) {
				if(right < tree_cnt) { // 가운데 기준 오른쪽부터
					tmp[right] = arr[tree_cnt-1-count];
					count++;
					right++;
				}
				if(left >= 0) { // 가운데 기준 왼쪽부터
					tmp[left] = arr[tree_cnt-1-count];
					count++;
					left--;
				}
			}
			
//			for(int z: tmp) {
//				System.out.println(z);
//			}
			
			// math.abs(i) i의 절대값
			int max = Math.abs(tmp[0] - tmp[tree_cnt-1]); // 첫번째 값과 마지막 값의 차의 절대값
			
			for(int k = 0; k < tree_cnt-1; k++) {
				if(max < Math.abs(tmp[k] - tmp[k+1])) {
					max = Math.abs(tmp[k] - tmp[k+1]);
				}
			}
			
			System.out.println(max);
		}
	}
}
