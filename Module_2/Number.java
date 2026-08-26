import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
class Number {
    public static void main (String[] args){
        String filename = "numbers.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))){
            String line;
            while ((line = reader.readLine()) != null){
                long val = Long.parseLong(line);
                System.out.println(val*2);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("could not read file");
        }
    }
}