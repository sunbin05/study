package poolable;

public class User {
    //����
    private String name;
    //����
    private int age;
    //���
    private String height;

    public User(String name, int age, String height) {
        super();
        this.name = name;
        this.age = age;
        this.height = height;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder(super.toString());
        str.append(" ");
        str.append("name:" + name);
        str.append(",age:" + age);
        str.append(",height:" + height);
        return str.toString();
    }

}