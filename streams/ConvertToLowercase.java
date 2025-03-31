package streams;

import javax.imageio.IIOException;
import java.io.*;

public class ConvertToLowercase {
    public static void main(String[] args) {
//        try(FileReader fr = new FileReader("streams/input.txt");
//            FileWriter fw = new FileWriter("streams/output.txt")){
//            int c;
//            while((c = fr.read())!=-1){
//                fw.write(Character.toLowerCase(c));
//            }
//        }

        try(BufferedReader br = new BufferedReader(new FileReader("streams/input.txt"));
            BufferedWriter bw = new BufferedWriter(new FileWriter("streams/output.txt"))){

            String line;
            while((line = br.readLine())!=null){
                bw.write(line.toLowerCase() + "\n");
            }
            System.out.println("FIle copied and converted to lowercase successfully");
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
