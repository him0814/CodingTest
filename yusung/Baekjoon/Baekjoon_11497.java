package Baekjoon;

import java.io.*;
import java.util.*;

//백준 11497번 통나무 건너뛰기
//1. 배열을 재정렬
//-> 난이도가 최소가되게
//-> 인접한 두 통나무의 높이의 차의 최대값이 난이도인데
//이 난이도 중에서 최소가 되게 배열을 재정렬해야함
//근데 첫값과 끝값은 연결되어있음 -> 이말은 무엇이냐
//1. 가운데에다가 가장 높은 기둥을 박음
//x x 9 x x
//2. 그다음으로 높은 기둥을 9오른쪽에 박아
//x x 9 7 x
//3. 그 다음으로 높은 기둥을 9왼쪽에 박아
//x 5 9 7 x
//4. 그 다음으로 높은 기둥을 9오른쪽(7오른쪽)에 박아
//x 5 9 7 4
//5. 그 다음 으로 높은 기둥을 9왼쪽(5왼쪽)에 박아

public class Baekjoon_11497 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int tree[] = new int[N];
			for (int j = 0; j < N; j++) {
				tree[j] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(tree);
			int answer[] = new int[N];
			answer[N/2] = tree[N-1]; // 중앙에 정렬한 tree의 최대값을 박음
			int count = 1; // 중앙에 최대값을 박았으니까 count를 1로 초기화
			int left = N/2-1; // left를 중앙-1로 초기화
			int right = N/2+1;// right를 중앙+1로 초기화
			while(count<answer.length) { // count가 answer배열의 크기보다 같거나 커지면 while문 종료
				if(right <N) {//right가 배열의 길이보다 작을 때
					answer[right] = tree[N-1-count]; // answer배열의 right인덱스에 tree의 마지막인덱스에서 카운트만큼 뺀값을 넣음 -> 이게 최대값이니까
					right++;
					count++;
				}
				if(left >= 0) {// left가 0보다 같거나 클때
					answer[left] = tree[N-1-count]; // answer배열의 left 인덱스에 tree의 마지막인덱스에서 카운트만큼 뺀값을 넣음 -> 이게 최대값이니까
					left--;
					count++;
				}				
			}
			
//			int count = 0;
//			int lcnt = 0;
//			int rcnt = N-1;			
//					
//			while(count < answer.length) {
//				if(lcnt < N/2) {
//					answer[lcnt] = tree[count];	
//					lcnt++;
//					count++;					
//				}
//				if(rcnt >= N/2) {
//					answer[rcnt] = tree[count];		
//					rcnt--;
//					count++;
//				}
//			}
			
			int max = Math.abs(answer[answer.length-1]-answer[0]); // max를 배열 인덱스의 0번과 마지막 인덱스를 뺸값의 절대값으로 초기화
			for(int k=0; k<answer.length-1; k++) {//배열 인덱스 0 번부터 마지막인덱스 직전 즉 4/ 3번순회
				max = Math.max(max,Math.abs(answer[k]-answer[k+1]));
				// 맥스값을 갱신함, 2 5 9 7 4
				//max = 2
				//2 5 max 3 갱신
				//5 9 max 4 갱신
				//9 7 max 2 갱신X
				//7 4 max 3 갱신 X
				//따라서 max 4
			}
			sb.append(max+"\n");			
		}
		System.out.println(sb.toString());
	}
}
