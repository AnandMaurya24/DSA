package Corejava;
import java.io.*;

class Person implements Serializable {
    private static final long serialVersionUID = 1L; // Recommended for Serializable classes
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + "}";
    }
}