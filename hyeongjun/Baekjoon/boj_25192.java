package BOJ;

/*
백준 #25192
ENTER 입력시 사람 들어옴을 의미
새로운 닉네임 들어오면 곰곰이 이모티콘 사용
기존 닉네임이 또 입력되면 곰곰이 이모티콘 사용 안함
곰곰이 이모티콘 사용 횟수 출력
 */

import java.util.*;
import java.io.*;

public class boj_25192 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int test_cnt = Integer.parseInt(br.readLine());
		Set<String> hs = new HashSet<>();
		
		int count = 0 ;
		
		for(int i = 0; i < test_cnt; i++) {
			String str = br.readLine();
			
			// String 값끼리 비교할 때는 equals 
			// == 주소끼리 비교
			if(str.equals("ENTER")) { // ENTER 입력시 set 초기화
				count += hs.size();
				hs = new HashSet<>();
			} else {
				hs.add(str);
			}
		}
		System.out.println(count + hs.size());
	}
}
