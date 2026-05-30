package Wipro_assingment;

public class Arrayclass{
    public static void main(String[] args) {

        int n = 4;
        int[][] arr = new int[n][n];

        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j <= i; j++) {
                arr[i][j] = j + 1;
            }
        }

  
        for(int i = 0; i < n; i++) {
            for(int j = 0; j <= i; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}