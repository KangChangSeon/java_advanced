package Day03.InterfaceEx.Ex02;

public class Cat extends Tail implements Animal,Pet {

    public Cat() {}

    @Override
    public void cry() {
        System.out.println("야옹");
    }

    @Override
    public void play() {
        System.out.println("고양이는 잘 논다");
    }


}
