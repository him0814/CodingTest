package Summary;
//스트링 사전순 비교
//str1.compareTo(str2) > 0 
//str2 가 사전 순 앞에있음
//
//str1.compareTo(str2) < 0
//str1이 사전 순 앞에 있음 
//
//str1.compareTo(str2) == 0
//str1과 str2가 사전 순으로 같음

import java.util.Comparator;
import java.util.PriorityQueue;

public class sort {
	PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {
		@Override
		public int compare(Integer o1, Integer o2) {				
			if(Math.abs(o1) > Math.abs(o2)) {
				return 1;	// 바꿈 			
			}else if(Math.abs(o1) < Math.abs(o2)) {
				return -1; // 그대로냅둔다
			}else {
				if (o1 > o2) {
					return 1; // 바꿈
				} 
				else if (o1 < o2) {
					return -1; 	// 그대로 냅둔다
				} 
				else {
					return 0; //바꾸지않음
				}
			}
		}
	});
}
