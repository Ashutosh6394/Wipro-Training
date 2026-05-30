package Io_Packages;
import java.io.*;

public class CopyFile {
    public static void main(String[] args) throws IOException {

        File source = new File("input.txt");
        File destination = new File("output.txt");

        BufferedReader br = new BufferedReader(new FileReader(source));
        BufferedWriter bw = new BufferedWriter(new FileWriter(destination));

        String line;

        while ((line = br.readLine()) != null) {
            bw.write(line);
            bw.newLine();
        }

        br.close();
        bw.close();

        System.out.println("File copied successfully");
    }
}