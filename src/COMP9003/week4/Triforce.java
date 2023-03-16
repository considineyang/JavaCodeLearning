package COMP9003.week4;

import java.util.Scanner;

public class Triforce {
    public static void main(String[] args) {
        System.out.print("Enter height: ");
        Scanner input = new Scanner(System.in);
        try {
            int height = input.nextInt();
            if (height < 2 || height > 20) {
                System.out.println();
                System.out.println("Invalid height.");
                return;
            }
            System.out.println();

            for (int i = 0; i < height; i++) {
                for (int j = 0; j < 2 * height - i - 1; j++) {
                    System.out.print(" ");
                }
                System.out.print("/");
                for (int j = 0; j < 2 * i; j++) {
                    if (i < height - 1) {
                        System.out.print(" ");
                    } else {
                        System.out.print("_");
                    }
                }
                System.out.print("\\");
                System.out.println();
            }
            for (int i = 0; i < height; i++) {
                for (int k = 0; k < 2; k++) {
                    for (int j = 0; j <  height - i - 1; j++) {
                        System.out.print(" ");
                        if (k ==1){
                            System.out.print(" ");
                        }
                    }
                    System.out.print("/");

                    for (int j = 0; j < 2 * i; j++) {
                        if (i < height - 1) {
                            System.out.print(" ");
                        } else {
                            System.out.print("_");
                        }
                    }
                    System.out.print("\\");
                }
                System.out.println();
            }
        } catch (Exception e) {
            System.out.println();
            System.out.println("Invalid height.");
            return;
        }
    }
}

//   /\
//  /__\
// /\  /\
///__\/__\
//         /\
//        /  \
//       /    \
//      /      \
//     /________\
//    /\        /\
//   /  \      /  \
//  /    \    /    \
// /      \  /      \
///________\/________\
//                   /\
//                  /  \
//                 /    \
//                /______\
//               /\      /\
//              /  \    /  \
//             /    \  /    \
//            /______\/______\
//           /\      /\      /\
//          /  \    /  \    /  \
//         /    \  /    \  /    \
//        /______\/______\/______\
//       /\      /\      /\      /\
//      /  \    /  \    /  \    /  \
//     /    \  /    \  /    \  /    \
//    /______\/______\/______\/______\
//   /\      /\      /\      /\      /\
//  /  \    /  \    /  \    /  \    /  \
// /    \  /    \  /    \  /    \  /    \
///______\/______\/______\/______\/______\