package Wipro_assingment;

import java.util.Scanner;

public class Firstclass {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double a = sc.nextDouble();
        double b = sc.nextDouble();
        String op = sc.next();   

        switch (op) {
            case "+":
                System.out.println(a + b);
                break;

            case "-":
                System.out.println(a - b);
                break;

            case "*":
                System.out.println(a * b);
                break;

            case "/":
                if (b != 0) {
                    System.out.println(a / b);
                } else {
                    System.out.println("division are not allowed");
                }
                break;

            default:
                System.out.println("invalid operator");
        }
    }
}