package innerClass.ex03;
class Creature {
     int life;

     Creature(Animal animal){
          Animal animal1 = animal;
     }
     public void method1(){
         //Animal animal = new Animal();
     }
}

class Animal{}

public class CreatureMain {
    Animal animal = new Animal();
    Creature creature = new Creature(animal);

}
