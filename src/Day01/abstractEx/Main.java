package Day01.abstractEx;

public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Cat cat = new Cat();

        dog.sound();
        cat.sound();
        animalSound(dog); // 자동 타입 변환
        animalSound(cat);
    }

    public static void animalSound(Animal animal) {
        if (animal instanceof Cat cat) {
            animal.sound(); // <--- 재정의 된 메서드 호출
        }
    }
}
