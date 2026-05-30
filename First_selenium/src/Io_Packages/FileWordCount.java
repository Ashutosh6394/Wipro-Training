package Io_Packages;
import java.io.*;

public class FileWordCount {
    public static void main(String[] args) throws IOException {

        File file = new File("data.txt");
        file.createNewFile();

        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        bw.write("Java is easy to learn");
        bw.newLine();
        bw.write("File handling is important");
        bw.close();

        BufferedReader br = new BufferedReader(new FileReader(file));

        int wordCount = 0;
        String line;

        while ((line = br.readLine()) != null) {
            String[] words = line.trim().split("\\s+");
            if (line.trim().length() != 0) {
                wordCount += words.length;
            }
        }

        br.close();

        System.out.println("Total words: " + wordCount);
    }
}