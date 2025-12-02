package day02;

public class HW02_Star {
    public static void main(String[] args) {
        /* 다음 샘플코드를 참고하여 아래와 같이 출력 되도록 코드를 작성하세요. */
        int rows = 5, cols = 5;
        /* *****
         * *****
         * *****
         * *****
         * *****
         */
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        /*  *     i = 1 *=1개
         *  **    i = 2 *=2개
         *  ***   i = 3 *=3개
         *  ****  i = 4 *=4개
         *  ***** i = 5 *=5개
         *              *=?
         */
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print('*');
            }
            System.out.println();
        }
         /*     *  i = 1, 공백=4 *=1
          *    **  i = 2, 공백=3 *=2
          *   ***  i = 3, 공백=2 *=3
          *  ****  i = 4, 공백=1 *=4
          * *****  i = 5, 공백=0 *=5
          */

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols-i; j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= i; k++) {
                System.out.print("*");
            }
            System.out.println();
        }

         /*     *
          *    ***
          *   *****
          *  *******
          * *********
          */
        for (int i = 1; i <= rows; i++) {
            for (int j = i; j < rows; j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= (2 * i - 1); k++) {
                System.out.print("*");
            }
            System.out.println();
        }



    }
}
