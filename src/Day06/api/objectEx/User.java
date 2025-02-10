package Day06.api.objectEx;

// 객체 복사 메서드를 사용하기 위해서는 Cloneable 인터페이스를 구현하여 clone() 재정의하여 사용한다.
public class User implements Cloneable{
    private int id;
    private String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
        public void setName(String name) {
        this.name = name;
    }

    public Object clone() throws CloneNotSupportedException {
        return (User) super.clone();
    }
}
