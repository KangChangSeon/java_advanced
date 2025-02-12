package Day08.collection.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HahsMapEx {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        //객체 저장
        map.put("강감찬",100);
        map.put("이순신",100);
        map.put("강이식",100);
        System.out.println(map.size());

        // 키로 값을 얻기
        String key = "이순신";
        int value = map.get(key);
        System.out.println();

        // 키 Set 컬렉션을 얻고, 반복해서 값을 얻기
        Set<String> keySet = map.keySet();
        Iterator<String> keyiter = keySet.iterator();
        while(keyiter.hasNext()) {
            String k = keyiter.next();
            Integer v = map.get(k);
            System.out.println("key : " + k + " value : " + v);
//            String value1 = String.valueOf(map.remove(k));
//            System.out.println("map에서 " + value1 + "삭제하였습니다");
        }

    }
}
