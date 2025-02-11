package Day07.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class PersonMain {
    public static void main(String[] args) throws Exception {
        // 클래스 객체 가져오기 - Class.forName() 메소드 방식
        Class<Person> personClass = (Class<Person>) Class.forName("Day07.reflection.Person");
        // 생성자 가져오기 - Person(String name, int age)
        Constructor<Person> personConstructor = personClass.getConstructor(String.class, int.class);
        // 가져온 생성자로 인스턴스 만들기
        Person p1 = personConstructor.newInstance("신세계",30);
        // 동적으로 메서드 가져와서 실행
        p1.getFields(); // invoke()
        // 접근 제한자 public, public static, private Methods

        // 특정 public 메서드를 가져와 실행
        Method total = personClass.getMethod("total", int.class, int.class);
        int result1 = (int) total.invoke(new Person(), 10,20);
        System.out.println("result1 : " + result1);

        // 특정 static 메서드를 가져와 실행
        Method staticTotal = personClass.getMethod("staticTotal", int.class, int.class);
        int result2 = (int) staticTotal.invoke(null, 10,30);
        System.out.println("result2 : " + result2);

        // 특정 private 메서드를 가져와 실행
        Method privateTotal = personClass.getDeclaredMethod("privateTotal", int.class, int.class);
        privateTotal.setAccessible(true);
        int privateResult = (int) privateTotal.invoke(new Person(), 10,40);
        System.out.println("privateTotal : " + privateResult);
    }
}
