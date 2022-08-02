import java.util.*;
import java.io.*;
import java.util.Map.Entry;


public class Set_Explanation {
    public static void main(String[] args) throws IOException{
        // 1. 선언
        Set<String> hs = new HashSet<>(); // 중복을 허용하지 않고 순서를 보장하지 않는다.
        Map<String, Integer> hm = new HashMap<>();
        hm.put("정유성", 1);
        hm.put("정유성1", 2);
        hm.put("정유성2", 3);
        for(Entry<String, Integer> entryHm : hm.entrySet()) {
            System.out.println(entryHm.getKey() + " : " + entryHm.getValue());
        }

        // 2. 삽입
        hs.add("이재익");
        hs.add("이재익");
        hs.add("정유성");
        hs.add("신범석");
        hs.add("홍길동");
        hs.add("이현구");

        // 3. 삭제
        hs.remove("이현구");

        // 4. 출력
        System.out.println(hs.toString());

        Iterator<String> it = hs.iterator();
        while(it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();

        for(String str : hs) {
            System.out.print(str + " ");
        }
        System.out.println();

        // 정렬하고 싶을 때
        ArrayList<String> al = new ArrayList<>(hs);
        Collections.sort(al);
        for(String str : al) {
            System.out.print(str + " ");
        }
        System.out.println();

        // 5. 값 포함 유무
        System.out.println(hs.contains("이현구"));
        System.out.println(hs.contains("정유성"));

        // 6. 값 존재 유무
        System.out.println(hs.isEmpty());

        // 7. 데이터 크기
        System.out.println(hs.size());
    }
}