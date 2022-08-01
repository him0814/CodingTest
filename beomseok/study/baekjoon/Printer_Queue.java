package baekjoon;
//프린터 큐 백준 1966

//큐 가장 앞에 있는 문서 중요도 확인
//나머지 문서들 중 현재 문서 보다 중요도가 높은 문서는 가장 뒤로 재배치

//첫 줄: 테스트케이스 수
//테스트케이스 첫 줄: 문서의 개수 N(1 ≤ N ≤ 100),
//몇 번째에 놓여 있는지 보여주는 정수 M(0 ≤ M < N)
//테스트케이스 두번쨰 줄: 1 <= N개 문서의 중요도 <= 9
//중요도 중복 가능

import java.io.*;
import java.util.*;

public class Printer_Queue {
public static void main(String[] args) throws IOException {
//   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//   int testCase = Integer.parseInt(br.readLine());
//   for (int i = 0; i < testCase; i++) {
//      PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
//      StringTokenizer st = new StringTokenizer(br.readLine());
//      int n = Integer.parseInt(st.nextToken()); // 문서의 개수
//      int m = Integer.parseInt(st.nextToken()); // 몇번째로 인쇄되었는지 궁금한 문서가 현재 queue의 몇번째에 놓여있는지
//
//      int[] arr = new int[n];
//      
//      // "1" 1 9 1 1 1
//
//      // 1 9 1 1 1 "1"
//      // 9 1 1 1 "1" 1 -> 1번째로 9인쇄
//      // 1 1 1 "1" 1 -> 2번째로 1인쇄
//      // 1 1 "1" 1 -> 3번째로 1인쇄
//      // 1 "1" 1 -> 4번째로 1인쇄
//      // "1" 1 -> 5번째로 "1"인쇄
//
//      st = new StringTokenizer(br.readLine());
//      for (int j = 0; j < n; j++) {
//         int num = Integer.parseInt(st.nextToken());
//         pq.offer(num); // 9 1 1 1 1 1
//         arr[j] = num;  // 1 1 9 1 1 1
//      }
//
//      int answer = 0;
//      int idx = 0;
//      
//      while (pq.size() > 0) {
//         int target = pq.poll();
//         while (arr[idx] != target) {
//            idx++;
//            if (idx == n) {
//               idx = 0;
//            }
//         }
//         if (arr[idx] == target) {
//            answer++;
//            if (idx == m) {
//               break;
//            }
//            idx++;
//            if (idx == n) {
//               idx = 0;
//            }
//         }
//      }
//      System.out.println(answer);
//   }
   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
   int testCase = Integer.parseInt(br.readLine());
   for (int i = 0; i < testCase; i++) {
      Deque<Integer> dq = new ArrayDeque<>();
      Deque<Integer> idxq = new ArrayDeque<>();
      
      StringTokenizer st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken()); // 문서의 개수
      int m = Integer.parseInt(st.nextToken()); // 몇번째로 인쇄되었는지 궁금한 문서가 현재 queue의 몇번째에 놓여있는지

      st = new StringTokenizer(br.readLine());
   
      for(int j = 0; j < n; j++) {
         dq.offer(Integer.parseInt(st.nextToken()));
         idxq.offer(j);
      }
      
      int cnt = 1;
      
      // "1" 1 9 1 1 1
//      // 1 9 1 1 1 "1"
//      // 9 1 1 1 "1" 1 -> 1번째로 9인쇄
//      // 1 1 1 "1" 1 -> 2번째로 1인쇄
//      // 1 1 "1" 1 -> 3번째로 1인쇄
//      // 1 "1" 1 -> 4번째로 1인쇄
//      // "1" 1 -> 5번째로 "1"인쇄
      
      while(!dq.isEmpty()) {
         int now = Collections.max(dq);
         int target = dq.poll();
         int targetIdx = idxq.poll();
         if(now == target) {
            if(targetIdx == m) {
               System.out.print("\n" + cnt);
               break;
            }
            cnt++;
         } else {
            dq.offer(target);
            idxq.offer(targetIdx);
         }
      }
   }
}
}