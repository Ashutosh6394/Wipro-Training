package Io_Packages;

import java.io.*;

public class Replaceinfile {
    public static void main(String[] args) throws IOException {

        File file = new File("input.txt");
        file.createNewFile();

        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        bw.write("java is easy\n");
        bw.write("i love java programming");
        bw.close();

        BufferedReader br = new BufferedReader(new FileReader(file));
        StringBuilder content = new StringBuilder();
        String line;

        while ((line = br.readLine()) != null) {
            content.append(line).append("\n");
        }
        br.close();

        String updated = content.toString().replace("java", "python");

        BufferedWriter bw2 = new BufferedWriter(new FileWriter(file));
        bw2.write(updated);
        bw2.close();

        System.out.println(updated);
    }
}