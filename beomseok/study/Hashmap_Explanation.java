import java.util.*;
import java.io.*;
// containskey, put, get, foreach(keyset)

public class Hashmap_Explanation {
    public static void main(String[] args) throws IOException{
        HashMap<String, Integer> hm = new HashMap<>();
        // 데이터 삽입
        hm.put("신범석", 1);
//        hm.put(100, 1);
        hm.put("정유성", 1);
        hm.put("정유성", 2);
        hm.put("정유성", hm.getOrDefault("정유성", 0) + 1); // get한 값이 있으면 가져온 값 + 1, 아니면 0 + 1
        hm.put("정재헌", 4);

        // 데이터 출력
        System.out.println(hm.get("정유성"));
        System.out.println(hm.size());

        // 데이터 포함 확인 -> containsKey -> true false
        if(!hm.containsKey("이재익")) {
            System.out.println(hm.containsKey("이재익"));
        }

//        for(String str : hm.size()) {
//
//        }

        for(String str : hm.keySet()) {
            if(hm.get("정유성") == 3) {
                System.out.println("맞았습니다");
                System.out.println(hm.keySet());
            }
        }

        // 
    }
}