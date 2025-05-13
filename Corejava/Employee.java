package Corejava;

import java.io.Serializable;

public class Employee implements Serializable {
    private static final long serialVersionUID = 1L;
    String name;
    NonSerializableClass nonSerializableField; // Marked as transient

    public Employee(String name, NonSerializableClass nonSerializableField) {
        this.name = name;
        this.nonSerializableField = nonSerializableField;
    }

    @Override
    public String toString() {
        return "Employee{name='" + name + "', nonSerializableField=" + (nonSerializableField != null ? nonSerializableField.data : "null") + "}";
    }
}
