package Io_Packages;
import java.io.*;


public class CountLines {
    public static void main(String[] args) throws IOException {

        File file = new File("data.txt");
        file.createNewFile();

        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        bw.write("Java is easy");
        bw.newLine();
        bw.write("File handling is important");
        bw.newLine();
        bw.write("Practice daily");
        bw.close();

        BufferedReader br = new BufferedReader(new FileReader(file));

        int lineCount = 0;
        String line;

        while ((line = br.readLine()) != null) {
            lineCount++;
        }

        br.close();

        System.out.println("Total lines: " + lineCount);
    }
}