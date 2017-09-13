import java.io.*;
import java.util.*;

public class Search {
    public static void main(String[] args) {
        Scanner fin = null;
        try {
            fin = new Scanner(new File("wordSearch1.txt"));
        } catch (FileNotFoundException x) {
            System.out.println("File open failed.");
            x.printStackTrace();
            System.exit(0);
        }

        Puzzle p = new Puzzle();
        p.Read(fin);
        p.Find();

        System.exit(0);
    }
}
