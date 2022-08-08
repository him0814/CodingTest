package baekjoon;
//수리공 항승 백준 1449

//파이프에서 물이 새는 곳은 신기하게도 가장 왼쪽에서 정수만큼 떨어진 거리만 물이 샘.(N)
//길이가 L인 테이프가 무한개
//물을 막을 때, 적어도 그 위치의 좌우 0.5만큼 간격을 줘야 물이 다시는 안 샘.
//항승이가 필요한 테이프의 최소 개수 출력

import java.io.*;
import java.util.*;

public class Repairman_hangseung {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		List<Integer> pipe = new ArrayList<>(); 
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			pipe.add(Integer.parseInt(st.nextToken()));
		}
		Collections.sort(pipe); // 어차피 위치이기 때문에 비교를 하려면 정렬
			 
		int firstHole = pipe.get(0);
		int tape = firstHole - 1;
		int cnt = 1; 
		for(int p: pipe) {
			if(tape + l < p) {
				cnt++;
				tape = p - 1;
			}
		}
		System.out.println(cnt);		
	}
}
