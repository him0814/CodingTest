package Baekjoon;

import java.util.*;
import java.io.*;

//백준 1541번 잃어버린 괄호
//-를 기준으로 나눈것과 +는한번에 더해서 al저장
//이후 첫번째 인덱스 -> 무조건 양수 에서 하나씩 뺌

public class Baekjoon_1541 {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = new StringTokenizer(br.readLine(), "-");
		
		ArrayList<Integer> al = new ArrayList<>();
		
		while(st1.hasMoreTokens()) {
			int sum = 0;
			StringTokenizer st2 = new StringTokenizer(st1.nextToken(), "+");
			while(st2.hasMoreTokens()) {
				int idx = Integer.parseInt(st2.nextToken());
				sum += idx;
			}
			
			al.add(sum);
		}
		int firstIdx = al.get(0);
		for(int i=1; i<al.size(); i++) {
			firstIdx -= al.get(i);
		}
		System.out.println(firstIdx);
	}
}
