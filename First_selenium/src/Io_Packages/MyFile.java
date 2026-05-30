package Io_Packages;

import java.io.*;

public class MyFile {
    public static void main(String[] args) {

        try {
            // create file
            File file = new File("myfile.txt");
            if (file.createNewFile()) {
                System.out.println("File created");
            } else {
                System.out.println("File already exists");
            }

            // write using BufferedWriter
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            bw.write("Hello Java");
            bw.newLine();
            bw.write("This is file handling using BufferedWriter");
            bw.close();

            System.out.println("Data written successfully");

            // read using BufferedReader
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;

            System.out.println("\nReading file content:");
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();

        } catch (IOException e) {
            System.out.println("Error occurred");
        }
    }
}