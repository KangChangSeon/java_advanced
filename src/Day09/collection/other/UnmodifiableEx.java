package Day09.collection.other;

import java.util.*;

public class UnmodifiableEx {
    public static void main(String[] args) {
        // 수정할 수 없는 컬렉션 만드는 방법
        // 1. of()
        List<String> immutableList = List.of("a", "b", "c");
//        immutableList.add("d"); //추가 자체가 안됨

        Set<String> immutableSet = Set.of("a", "b", "c");
//        immutableSet.remove("c");

        Map<Integer, String> immutableMap = Map.of(1, "a", 2, "b", 3, "c");
//        immutableMap.put(4, "d");

        // List 컬렉션을 불변 컬렉션으로 복사
        List<String> list2 = new ArrayList<>();
        list2.add("e");
        list2.add("f");
        list2.add("g");
        List<String> immutableList2 = List.copyOf(list2);

        // 배열로부터 List 불변 컬렉션으로 생성
        String array[] = new String[5];
        array[3] = "D";
        array[4] = "E";
        for (String s : array) {
            System.out.print(s + " ");
        }
        List<String> immutString3 = Arrays.asList(array);
    }
}
