package interfaceEx.homework.Prob3_Cafe.interfaceType;

public class OrderCafe_Rest {
    public static void main(String[] args) {
        CafeOwner cafeowner = new CafeOwner();

        cafeowner.giveItem(new CafeCustomerA());
        cafeowner.giveItem(new CafeCustomerB());
    }
}
