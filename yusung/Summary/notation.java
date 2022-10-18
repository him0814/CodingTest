package Summary;

import java.io.*;
import java.util.*;

//진법 변환

public class notation {
	public static void main(String[] args) throws IOException {
		int num = 20;

		// 10진법 -> 2진법
		System.out.println(Integer.toBinaryString(num));
		System.out.println(Integer.toString(num, 2)); //앞이 바꿀문자, 뒤가 진법
		System.out.println(Integer.toString(num, 3));
		System.out.println(Integer.toString(num, 4));
		System.out.println(Integer.toString(num, 7));
		
		// n진법 -> 10진법
		String str = "1101";
		System.out.println(Integer.parseInt(str, 2)); // 앞이 바꿀문자, 뒤가 현재표시되어있는 진법
	}
}
