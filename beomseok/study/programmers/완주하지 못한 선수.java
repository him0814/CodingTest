//한 명의 선수를 제외하고는 모든 선수가 마라톤을 완주 -> 완주하지 못한 선수 이름 출력
//participant: 마라톤에 참여한 선수들의 이름이 담긴 배열
//completion: 완주한 선수들의 이름이 담긴 배열

//1 <= 마라톤 경기에 참여한 선수의 수 <= 100000
//completion의 길이 = participant의 길이 - 1
//1 <= 참가자의 이름 <=20, 알파벳 소문자, 동명이인 가능

import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> hm = new HashMap<>();
        
        for(String p: participant){
            hm.put(p, hm.getOrDefault(p, 0) + 1);
        }
        for(String c: completion){
            hm.put(c, (hm.get(c)) - 1);
        }
        for(String k : hm.keySet()){
            if(hm.get(k) != 0){
                answer = k;   
            }
        }
        return answer;
    }
}