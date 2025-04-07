package streams;

import java.io.*;

public class StoreRetrievePrimitiveData {
    public static void main(String[] args) {
        try(FileOutputStream fos = new FileOutputStream("students.dat");
            DataOutputStream dos = new DataOutputStream(fos)){
                dos.writeInt(19);
                dos.writeUTF("Ishaan");
                dos.writeDouble(9.19);

                dos.writeInt(9);
                dos.writeUTF("Nash");
                dos.writeDouble(9.91);

                try(FileInputStream fis = new FileInputStream("students.dat");
                    DataInputStream dis = new DataInputStream(fis)){
                        while(dis.available()>0){
                            int roll = dis.readInt();
                            String name = dis.readUTF();
                            double gpa = dis.readDouble();
                            System.out.printf("Roll Number: %d, Name: %s, Gpa: %.2f%n", roll,name,gpa);
                        }
                }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}




//package streams;
//
//import java.io.*;
//
//public class StoreRetrievePrimitiveData {
//    public static void main(String[] args) {
//        String fileName = "students.dat";
//
//        // Writing student data to file
//        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileName))) {
//            dos.writeInt(101); // Roll Number
//            dos.writeUTF("Alice"); // Name
//            dos.writeDouble(3.8); // GPA
//
//            dos.writeInt(102);
//            dos.writeUTF("Bob");
//            dos.writeDouble(3.6);
//
//            System.out.println("Student data written successfully.");
//        } catch (IOException e) {
//            System.err.println("Error writing to file: " + e.getMessage());
//        }
//
//        // Reading student data from file
//        try (DataInputStream dis = new DataInputStream(new FileInputStream(fileName))) {
//            while (dis.available() > 0) {
//                int rollNumber = dis.readInt();
//                String name = dis.readUTF();
//                double gpa = dis.readDouble();
//                System.out.println("Roll No: " + rollNumber + ", Name: " + name + ", GPA: " + gpa);
//            }
//        } catch (IOException e) {
//            System.err.println("Error reading from file: " + e.getMessage());
//        }
//    }
//}
//
