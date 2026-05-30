package Wipro_assingment;

//public class Triangle {
//    public static void main(String[] args) {
//
////        int n = 5; 
////
////        for (int i = 1; i <= n; i++) {
////            for (int j = 1; j <= i; j++) {
////                System.out.print("* ");
////            }
////            System.out.println();
//        }
//    }
//}

//public class Triangle {
//    public static void main(String[] args) {
//
//        int n = 5;
//
//        for (int i = 1; i <= n; i++) {
//
//            for (int j = 1; j <= n - i; j++) {
//                System.out.print(" ");
//            }
//
//            for (int j = 1; j <= i; j++) {
//                System.out.print("* ");
//            }
//
//            System.out.println();
//        }
//    }
//}




public class Triangle {
    public static void main(String[] args) {

        int n = 5;

        // Upper Pyramid
        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }

            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }

            System.out.println();
        }

        // Lower Pyramid
        for (int i = n - 1; i >= 1; i--) {

            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }

            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }

            System.out.println();
        }
    }
}