package Day01.Quiz02;

public abstract class Content {
    public String title;
    public int price;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Content(){}
    public Content(String title) {
        this.title = title;
    }

    public abstract void totalPrice();
    public void show() {
        System.out.println(getTitle() + " 비디오의 가격은 " + getPrice() + "원입니다");
    }

}
