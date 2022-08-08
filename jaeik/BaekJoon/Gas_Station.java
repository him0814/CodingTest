package BaekJoon;

// N개의 도시 일직선 제일 왼쪽에서 오른쪽 인접한 두 도시 길이 다를 수 있다. 단위 km
// 처음 출발 기름 넣어야 함 
// 기름통 무제한 1km 마다 1리터 기름
// 2 ≤ N ≤ 1,000 거리 최대 10000, 가격 최대 10000
// 둘째줄 도시간 길이, 셋째줄 도시 기름 가격

import java.io.*;
import java.util.*;

public class Gas_Station {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		Long[] km = new Long[N - 1];
		
		for(int i = 0; i < N-1; i++) {
			km[i] = Long.parseLong(st.nextToken());
		}
		
		Long[] l = new Long[N];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			l[i] = Long.parseLong(st.nextToken());
		}
		
		Long result = l[0] * km [0];
		Long cheap = l[0];
		
		for(int i = 1; i < N -1; i++) {
			if(l[i] < cheap) {
				cheap = l[i];
			}
			result += cheap * km[i];
		}
		
		System.out.println(result);
	}
}
