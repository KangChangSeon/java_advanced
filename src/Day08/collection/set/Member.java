package Day08.collection.set;

public class Member {
    String name;
    int age;

    public Member(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        // name과 age가 같다면 true 리턴
        if(obj instanceof Member target) {
            return target.name.equals(name) && (target.age == age);
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        // name과 age 값이 같으면 동일한 hashCode 리턴하겠다.
        return name.hashCode() + age;
    }

}
