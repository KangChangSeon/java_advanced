package Day02.Quiz_0204.Quiz02;

public class CashPayment extends Payment{
    private String cashReceiptNumber;

    public CashPayment(String shopName, String productName, long productPrice, String cashReceiptNumber) {
        super(shopName, productName, productPrice);
        this.cashReceiptNumber = cashReceiptNumber;
    }

    public String toString(){
        String payInfo = "[  신용카드 결제 정보  ]\n" +
                "상점명 : " + super.shopName + "\n" +
                "상품명 : " + super.productName + "\n" +
                "상품가격 : " + super.productPrice + "원\n" +
                "현금영수증번호 : " + cashReceiptNumber;
        return payInfo;
    }

    @Override
    public void pay() throws PayException {
        if(super.productPrice <= 0){
            throw new PayException("가격이 잘못되었습니다.");
        }
        System.out.println("현금이 정상적으로 지불되었습니다.");
    }
}
