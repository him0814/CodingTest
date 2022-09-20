//연구실에 있는 총 N 마리의 폰켓몬 중에서 N/2마리를 가져갈 수 있음.
//폰켓몬은 종류에 따라 번호를 붙여 구분, 같은 종류의 폰켓몬은 같은 번호를 가지고 있음.

//1 <= nums의 길이(N) <= 10,000, 항상 짝수
//1 <= 폰켓몬의 종류 번호 <= 200000

//hashmap 사용
//hashmap에 nums의 종류 저장
//hashmap의 사이즈와 nums 길이의 절반을 비교해 값이 작은 것을 출력.

import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
//         HashMap<Integer, Integer> hm = new HashMap<>();
        
//         for(int n: nums){
//             hm.put(n, hm.getOrDefault(n, 0) + 1);
//         }
        
//         answer = Math.min(hm.size(), nums.length/2); -> 해쉬맵 풀이
        
        Set<Integer> set = new HashSet<>();
        
        for(int n: nums) {
            set.add(n);
         }
        answer = Math.min(set.size(), nums.length/2); 
        return answer;
    }
}