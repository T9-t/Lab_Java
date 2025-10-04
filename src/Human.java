
public class Human implements Comparable<Human>{

    String name;
    String lastName;
    int age;

    public Human(String name, String lastName, int age) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }
    @Override
    public int compareTo(Human o) {
        return this.name.compareTo(o.name);
    }
    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }
}