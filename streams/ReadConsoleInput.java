package streams;

import java.io.*;

public class ReadConsoleInput {
    public static void main(String[] args) {

        String name;
        int age;
        String favoriteProgrammingLanguage;

        try(BufferedReader bs = new BufferedReader(new InputStreamReader(System.in));
            FileWriter fw = new FileWriter("streams/output.txt")){
            name = bs.readLine();
            age = Integer.parseInt(bs.readLine());
            favoriteProgrammingLanguage = bs.readLine();
            fw.write("Name: " + name + "\n");
            fw.write("Age: " + age + "\n");
            fw.write("FavoriteProgrammingLanguage: " + favoriteProgrammingLanguage + "\n");
            System.out.println("File Writing successfully done");

        }
        catch (IOException e){
            e.printStackTrace();
        }

    }
}
