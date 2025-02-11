package Day07.genericEx.Ex01;

import lombok.Getter;

// T는 Box의 인스턴스를 생성할때(new) 어떤 참조타입으로 대체될 수 있는 타입매개변수
public class Box<T> {
    private T item;
    @Getter private int count = 0; // item의 수를 추적하는 필드

    public T getItem() {
        return item;
    }

    public T getItemName(){
        return this.item;
    }

    public void setItem(T item) {
        this.item = item;
        this.count++;
    }

}
