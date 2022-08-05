package Baekjoon;

import java.io.*;
import java.util.*;

//백준 1946번 신입사원
//첫째줄 테스트 케이스 수 T (1~20)
//테스트케이스의 첫째줄에 지원자의 수 N
//테이스트케이스 두번째 줄 부터 지원자의 서류심사 성적, 면접성적의 순위가 공백을 사이에 두고 한줄씩 주어짐
//동일한 석차 없음
//테스트케이스 별로 선발할 수 있는 신입사원의 최대인원수를 한줄에 하나씩 출력
//시간제한 2초 -> 이중for문 한번

//해쉬맵에 키/밸류로 값을 넣는다
//키부터 min값을 정해서 본다
//min보다 크면 밸류를 본다?

public class Baekjoon_1946 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());//2
	
		
		for(int i = 0; i<T; i++) {//0~1
			int N = Integer.parseInt(br.readLine());//5
			int grade[] = new int[N+1]; // 0번째인덱스를 더미값으로 쓰기위해 N+1만큼의 크기로 선언
			for(int j=1; j<=N; j++) {//0~4				
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");// 3 2		
				int idx = Integer.parseInt(st.nextToken());
				int value = Integer.parseInt(st.nextToken());
				grade[0] = 0; // 1부터 들어오니까 0번쨰 인덱스를 0으로 더미값을 넣어줌
				grade[idx-1] = value ; // 앞에들어오는 서류심사 성적을 idx로/면접성적을 값으로 넣어줌
			}
			int max = grade[1]; //첫번째 인덱스의 밸류 맥스에 넣고
			int count = 1; // 카운트를 1로 초기화 -> 처음 인덱스는 뽑혔으니까
			for(int k=1; k<= grade.length-1;k++) { // k=1번 인덱스부터 max랑 비교 배열의 크기가 N+1이므로 포문돌떄는 length-1만큼 돌아야댐
				if(max>grade[k]) {//맥스값이 현재인덱스의 밸류보다 크면 카운트 늘리고 맥스에 현재 밸류값을 넣음
					count++;
					max = grade[k];
				}
			}
			sb.append(count+"\n");
		}		
		System.out.println(sb.toString());
	}
}
