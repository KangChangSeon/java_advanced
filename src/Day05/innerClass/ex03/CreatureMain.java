package Day05.innerClass.ex03;

import javax.print.attribute.standard.PrinterMoreInfoManufacturer;

class Creature {
    int life;

    Creature(Animal a) {
        Animal a1 = a;
    }
    public void method1(){
//        Animal animal = new Animal();
    }
}

class Animal{}

public class CreatureMain {
    Animal a = new Animal();
    Creature c = new Creature(a);
}
