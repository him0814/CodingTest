package BOJ;

/*
백준 #13164

1   3   5   6   10
  2   2   1   4
  
정렬 - > 1 2 2 4

1 -> n-1
2 -> n-2
k -> n-k
  
  
  
1 3 5 -> 5-1 = 5-3 + 3-1


 */

import java.io.*;
import java.util.*;

public class boj_13164 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		ArrayList<Integer> student = new ArrayList<>();
		ArrayList<Integer> gap = new ArrayList<>();
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int answer = 0;
		
		st = new StringTokenizer(br.readLine(), " ");
		
		for(int i = 0; i < n; i++) {
			student.add(Integer.parseInt(st.nextToken()));
		}
		
		for(int i = 0; i < student.size()-1; i++) {
			gap.add(student.get(i+1) - student.get(i));
		}
		
		Collections.sort(gap);
		
		for(int i = 0; i < n-k; i++) {
			answer += gap.get(i);
		}
		
		System.out.println(answer);
	}
}
