package baekjoon;
// 잃어버린 괄호 백준 1541

// 첫째 줄에 수식, '0’~‘9’, ‘+’, 그리고 ‘-’만으로 이루어짐.
// 연속해서 두 개 이상의 연산자가 나타나지 않고, 5자리보다 많이 연속되는 숫자는 없음.

import java.io.*;
import java.util.*;

public class Lost_Parenthesis {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st2 = new StringTokenizer(br.readLine(),"-");
		
		ArrayList<Integer> al = new ArrayList<>(); 
		
		while(st2.hasMoreTokens()) {
			int sum =0;
			StringTokenizer st1 = new StringTokenizer(st2.nextToken(),"+");
			while(st1.hasMoreTokens()) {
				int idx = Integer.parseInt(st1.nextToken());
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
