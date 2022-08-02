package Baekjoon;

import java.util.*;
import java.io.*;

//백준 3052번 나머지
//입력값은 10줄, 입력값을 42로 나누었을때 다른 나머지가 몇개있는지 출력하기
// 입력숫자는 1000보다 작거나 같고, 음이아닌 정수이다.

public class Baekjoon_3052 {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Set<Integer> hs = new HashSet<>();
		
		for(int i = 0; i<10 ; i++) {
			int n = Integer.parseInt(br.readLine())%42;
			hs.add(n);
		}
		System.out.println(hs.size());
	}
}
