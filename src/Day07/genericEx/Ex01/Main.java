package Day07.genericEx.Ex01;

public class Main {
    public static void main(String[] args) {
        Box<String> stringBox = new Box<>();
        stringBox.setItem("인형");
        System.out.println(stringBox.getItemName());
        stringBox.setItem("기차장난감");
        System.out.println(stringBox.getItemName());
        stringBox.setItem("곰돌이인형");
        System.out.println(stringBox.getItemName());

        System.out.println(stringBox.getCount());
    }
}
