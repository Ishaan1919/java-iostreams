package streams;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ReadWriteTextFile {
    public static void main(String[] args) {
        try(FileInputStream fr = new FileInputStream("streams/input.txt");
            FileOutputStream fw = new FileOutputStream("streams/output.txt",true)){
                int data;
                while((data=fr.read())!=-1){
                    fw.write(data);
                }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}




//package streams;
//
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.io.IOException;
//
//public class ReadWriteTextFile {
//    public static void main(String[] args) {
//
//        try(FileInputStream input = new FileInputStream("streams/input.txt");
//            FileOutputStream output = new FileOutputStream("streams/output.txt")){
//
//            int byteData;
//            while((byteData = input.read()) != -1){
//                output.write(byteData);
//            }
//            System.out.println("File copied Successfully");
//        }
//        catch (IOException e){
//            System.out.println("Some Error occured");
//            e.printStackTrace();
//        }
//
//    }
//}
