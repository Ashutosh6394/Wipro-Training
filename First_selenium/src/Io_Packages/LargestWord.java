package Io_Packages;

import java.io.*;

public class LargestWord {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter a line:");
        String line = br.readLine();

        String[] words = line.split("\\s+");
        String largest = "";

        for (String word : words) {
            if (word.length() > largest.length()) {
                largest = word;
            }
        }

        System.out.println("Largest word: " + largest);
    }
}