package streams;

import java.io.*;
import java.net.Inet4Address;
import java.util.ArrayDeque;
import java.util.Deque;

class Employee implements Serializable{
    String id;
    String name;
    String department;
    String salary;

    public Employee(String id, String name, String department, String salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }
}

public class SaveRetrieveObject {
    public static void main(String[] args) {
        Employee emp = new Employee("1","Ishaan","Software Developer","90000");

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("ChatGPT Image Mar 29, 2025, 11_34_03 PM.png"))) {
            oos.writeObject(emp);
            System.out.println("Object serialized successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("ChatGPT Image Mar 29, 2025, 11_34_03 PM.png"))) {
            Employee deserializedPerson = (Employee) ois.readObject();
            System.out.println("Deserialized object: " + deserializedPerson);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
