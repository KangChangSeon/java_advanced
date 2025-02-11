package Day07.genericEx.practice;

//어떤 타입의 객체든 저장할 수 있는 제너릭 클래스 Box. 객체를 설정하고 가져오는 메소드를 구현하세요
public class Box<T> {

    public T item;

    public T item() {
        return this.item;
    }
    public void setItem(T item) {
        this.item = item;
    }
    public T getItem() {
        return this.item;
    }

    public boolean isOfType(Class<?> clazz){
        return clazz.isInstance(item);
    }

    public static void main(String[] args) {
        Box<String> box = new Box<>();
        box.setItem("아무거나");
        System.out.println(box.getItem());
        System.out.println(box.isOfType(String.class));

        Box<Integer> intbox = new Box<>();
        intbox.setItem(123);
        System.out.println(intbox.getItem());
    }
}
