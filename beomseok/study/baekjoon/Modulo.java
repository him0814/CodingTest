package baekjoon;
//나머지 백준 3052

//수 10개를 입력받은 뒤, 이를 42로 나눈 나머지를 구함.
//서로 다른 값이 몇 개 있는지 출력
import java.util.*;
import java.io.*;

public class Modulo {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Set<Integer> set = new HashSet<>();
		
		for(int i=0; i<10; i++) {
			int num = Integer.parseInt(br.readLine());
			set.add( num % 42);
		}
		System.out.println(set.size());
	}
}
