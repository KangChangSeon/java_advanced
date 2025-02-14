package Day10.lambda.Ex01;

public class ButtonEx {
    public static void main(String[] args) {
        Button button = new Button();

        //버튼을 누르면 "버튼이 클릭되었습니다."
        button.setClickListener(()-> System.out.println("버튼이 클릭되었습니다."));
        button.click();

        Button canclebutton = new Button();
        canclebutton.setClickListener(()-> System.out.println("취소 버튼이 클릭되었습니다."));
        canclebutton.click();
    }
}
