package interfaceEx.homework.Prob3_Cafe.interfaceType;

public class CafeOwner {
    public void giveItem(Customer customer) {
        System.out.println("Item : " + customer.getOrder());
    }

}


//class 타입에서 구현했던 방식은 단골손님 A,B 처리가 가능한 코드
//손님의 수에 따라 구현 해야 했던 메서드의 수가 하나로 처리가 가능한 코드
//앞으로 손님이 늘더라도 CafeOwner 는 Customer 타입을 매개 변수로 받기 때문에
//손님에 맞추어서 타입을 수정하지 않아도 (손님의 주문에 맞추어) 된다.

//개별 단골 손님들이 주문한 내용을 다루기 위해 getOrder() 추상메소드를
//Customer 인터페이스에 추가하여 각 주문에 대해서는 단골손님들이 주문을 넣는 형태로 구현

// 중요 정리 : 단순해졌을뿐만 아니라  더 이상 단골 손님의 수에 의존하는 클래스가 아닌 독립적인 클래스가 됨

