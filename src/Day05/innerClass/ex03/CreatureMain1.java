package Day05.innerClass.ex03;

import Day05.innerClass.ex02.A;

class Creature1 {
    int life;

    class Animal1{

    }

    public void method1(){
        Animal1 a = new Animal1();
    }
}

public class CreatureMain1 {
    public static void main(String[] args) {
        Creature1 c = new Creature1();
        c.method1();
    }
}
