package innerClass.ex03;

class Creature1{
      int life;

      class Animal1{

      }

      public void method(){
          Animal1 animal1 = new Animal1();
      }
}

public class CreatureMain1 {
    public static void main(String[] args) {
        Creature1 creature1 = new Creature1();
        creature1.method();
    }

}
