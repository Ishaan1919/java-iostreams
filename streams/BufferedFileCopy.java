package streams;

import java.io.*;

public class BufferedFileCopy {
    public static void main(String[] args) {
        try(BufferedInputStream br = new BufferedInputStream(new FileInputStream("streams/input.txt"));
            BufferedOutputStream bw = new BufferedOutputStream(new FileOutputStream("streams/output.txt",true))){
                byte[] arr = new byte[4096];
                int data;
                while((data=br.read(arr))!=-1){
                    bw.write(arr,1,data);
                }
            System.out.println("Ctrl+c & Ctrl+v completed successfully");
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}




//package streams;
//
//import java.io.*;
//
//public class BufferedFileCopy {
//    public static void main(String[] args) {
//        String sourceFile = "streams/input.txt";
//        String destFileBuffered = "copy_buffered.txt";
//        String destFileUnbuffered = "copy_unbuffered.txt";
//
//        // Copy using Buffered Streams
//        long startBuffered = System.nanoTime();
//        copyWithBufferedStreams(sourceFile, destFileBuffered);
//        long endBuffered = System.nanoTime();
//        System.out.println("Buffered Stream Copy Time: " + (endBuffered - startBuffered) / 1_000_000 + " ms");
//
//        // Copy using Unbuffered Streams
//        long startUnbuffered = System.nanoTime();
//        copyWithUnbufferedStreams(sourceFile, destFileUnbuffered);
//        long endUnbuffered = System.nanoTime();
//        System.out.println("Unbuffered Stream Copy Time: " + (endUnbuffered - startUnbuffered) / 1_000_000 + " ms");
//    }
//
//    private static void copyWithBufferedStreams(String source, String destination) {
//        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(source));
//             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destination))) {
//
//            byte[] buffer = new byte[4096];
//            int bytesRead;
//            while ((bytesRead = bis.read(buffer)) != -1) {
//                bos.write(buffer, 0, bytesRead);
//            }
//            System.out.println("Buffered copy completed.");
//        } catch (IOException e) {
//            System.err.println("Error: " + e.getMessage());
//        }
//    }
//
//    private static void copyWithUnbufferedStreams(String source, String destination) {
//        try (FileInputStream fis = new FileInputStream(source);
//             FileOutputStream fos = new FileOutputStream(destination)) {
//
//            int byteData;
//            while ((byteData = fis.read()) != -1) {
//                fos.write(byteData);
//            }
//            System.out.println("Unbuffered copy completed.");
//        } catch (IOException e) {
//            System.err.println("Error: " + e.getMessage());
//        }
//    }
//}
