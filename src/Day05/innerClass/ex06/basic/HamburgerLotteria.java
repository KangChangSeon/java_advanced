package Day05.innerClass.ex06.basic;

public class HamburgerLotteria {
    public static void main(String[] args) {
        Hamburger customer1 = new Hamburger(2,1,2,4,6,8);
        Hamburger customer2 = new Hamburger(3,1,2);
        Hamburger customer3 = new Hamburger(4,1,2,4,7, 3);
    }
}

// 생성자 만으로는 필드를 선택적으로 생략할 수 없는 방식
// 타입이 다양할수록 생성자 메서드 수가 늘어나기 때문에 가독성이나 유지보수 측면에서 활용적이지 못하다.