package IO.Reader;

import java.io.Serializable;

public class User implements Serializable {
    private String id;
    private String passwd;
    private transient int age;
    private String name;

    public User(String id, String passwd, int age, String name) {
        this.id = id;
        this.passwd = passwd;
        this.age = age;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", passwd='" + passwd + '\'' +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
