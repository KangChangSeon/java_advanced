package Day08.collection.listEx.sorting.comparable;

import java.util.*;

public class ProductTest {
    public static void main(String[] args) {
        Product p1 = new Product("갤럭시S25",1200000);
        Product p2 = new Product("아이폰15Pro",13700000);
        Product p3 = new Product("LG폰",1000000);
        Product p4 = new Product("갤럭시S25(중고)",700000);
        Product p5 = new Product("아이폰15Pro(중고)",900000);
        Product p6 = new Product("LG폰(중고)",10000);

        // List 사용
        List<Product> list = new ArrayList<>();
        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);
        list.add(p5);
        list.add(p6);
        System.out.println("List 정렬 전");
        list.forEach(s -> System.out.println(s));

        Collections.sort(list);
        System.out.println("List 정렬 후");
        list.forEach(s -> System.out.println(s));

        //배열[] 사용
        Product[] products = {p1,p2,p3,p4,p5,p6};
        System.out.println("배열 정렬 전");
        Arrays.stream(products).forEach(System.out::println);

        Arrays.sort(products);
        System.out.println("배열 정렬 후");
        Arrays.stream(products).forEach(System.out::println);
    }
}
