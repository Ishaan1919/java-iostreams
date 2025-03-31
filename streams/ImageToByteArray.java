package streams;

import java.io.*;

public class ImageToByteArray {
    public static void main(String[] args) {
        String inputImagePath = "C:\\Users\\dell\\Desktop\\bridgelabz-workspace\\java-iostreams\\testImage.png";
        String outputImagePath = "C:\\Users\\dell\\Desktop\\bridgelabz-workspace\\java-iostreams\\testOutputImage.png";

        try (FileInputStream fileInputStream = new FileInputStream(inputImagePath);
             ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {

            // Read file into byte array using while loop
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fileInputStream.read(buffer)) != -1) {
                byteArrayOutputStream.write(buffer, 0, bytesRead);
            }

            byte[] imageBytes = byteArrayOutputStream.toByteArray();

            // Write byte array to new image file
            try (ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(imageBytes);
                 FileOutputStream fileOutputStream = new FileOutputStream(outputImagePath)) {

                while ((bytesRead = byteArrayInputStream.read(buffer)) != -1) {
                    fileOutputStream.write(buffer, 0, bytesRead);
                }
            }

            System.out.println("Image conversion successful! Check " + outputImagePath);
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
