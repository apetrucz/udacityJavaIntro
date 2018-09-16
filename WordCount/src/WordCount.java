
import java.util.Scanner;
import java.io.File;

public class WordCount {

    public static void main(String [] args) throws Exception{
        File file = new File("wordcount.txt");
        Scanner scanner = new Scanner(file);
        int count = 0;
        while(scanner.hasNextLine()){
            String line = scanner.nextLine();
            count += line.split(" ").length;

        }
        System.out.println(count);

    }
}
