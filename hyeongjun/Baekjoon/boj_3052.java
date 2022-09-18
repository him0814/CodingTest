package study1;

// 백준 #3052
// 두 자연수 A,B가 있다
// 수 10개를 입력 받은 뒤, 42로 나눈 나머지를 구한다.
// 서로 다른 값이 몇개 있는지 출력하라
// 첫번째 줄부터 열번째 줄까지 숫자가 한줄에 하나씩 주어진다. 이 숫자는 1000보다 작거나 같고 음이 아닌 정수


import java.io.*;
import java.util.*;

public class boj_3052 {
	public static void main(String[] args) throws IOException {
			
		//arraylist 사용
		
//			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//			ArrayList<Integer> al = new ArrayList<>();
//			
//			for(int i = 0; i < 10; i++) {
//				// int n = Integer.parseInt(br.readLine());
//				// al.add(i) = n % 42; 왜 안되는지.. ->    al.add(i % 42);
//				int n = Integer.parseInt(br.readLine()) % 42;
//				// arraylist에 n이 있지 않으면
//				// contains() 자주쓰임
//				if(!al.contains(n))
//					al.add(n);				
//			} 
//			
//			System.out.println(al.size());
		
		
		// hashset 사용
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Set<Integer> hs = new HashSet<>();
		
		for(int i = 0; i < 10; i++) {
			int num = Integer.parseInt(br.readLine()) % 42;
			hs.add(num);
		}
		
		System.out.println(hs.size());
	}
}
