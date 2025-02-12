package Day08.collection.listEx.sorting.comparable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product implements Comparable<Product> {
    private String p_name;
    private int p_price;


    @Override
    public int compareTo(Product o) {
        // return 값이 양수면 자리교환 O, 0이거나 음수면 자리교환 X
        // 제품의 이름순으로 내림차순 < , 오름차순 >
//        return this.p_name.charAt(0) > o.p_name.charAt(0) ? 1: -1;
        // 전체 문자열 비교 (전체 정렬)
//        return this.p_name.compareTo(o.p_name);

        if(this.p_name.charAt(0) > o.p_name.charAt(0)){
            return 1;
        }else if(this.p_name.charAt(0) == o.p_name.charAt(0)){
            if(this.p_price > o.p_price){
                return 1;
            }else{
                return -1;
            }
        } else{
            return -1;
        }

    }
}
