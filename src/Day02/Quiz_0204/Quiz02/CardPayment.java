package Day02.Quiz_0204.Quiz02;

public class CardPayment extends Payment{
    private String cardNumber;
    private String cardPassword;
    private int monthlyInstallment;

    public CardPayment(String shopName, String productName, long productPrice, String cardNumber, String cardPassword, int monthlyInstallment) {
        super(shopName, productName, productPrice);
        this.cardNumber = cardNumber;
        this.cardPassword = cardPassword;
        this.monthlyInstallment = monthlyInstallment;
    }

    public String toString(){
        String payInfo = "[  신용카드 결제 정보  ]\n" +
                "상점명 : " + super.shopName + "\n" +
                "상품명 : " + super.productName + "\n" +
                "상품가격 : " + super.productPrice + "원\n" +
                "신용카드번호 : " + cardNumber + "\n" +
                "할부개월 : " + monthlyInstallment;
        return payInfo;
    }

    @Override
    public void pay() throws PayException {
        if(super.productPrice <= 0 || monthlyInstallment < 0){
            throw new PayException("가격이나 할부개월수가 잘못되었습니다.");
        }
        System.out.println("신용카드가 정상적으로 지불되었습니다.");
    }
}
