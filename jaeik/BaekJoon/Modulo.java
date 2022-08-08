package BaekJoon;
// 숫자 10개 입력
// 42로 나눴을때 중복없는 나머지 개수
import java.io.*;
import java.util.*;
public class Modulo {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Set<Integer> hs = new HashSet<>();
		
		for(int i = 0; i < 10; i++) {
			int n = Integer.parseInt(br.readLine()) % 42;
			hs.add(n);
		}
		System.out.print(hs.size());
	}
}
