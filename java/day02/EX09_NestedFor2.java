package day02;


public class EX09_NestedFor2 {
    public static void main(String[] args) {
        /* 다음과 같이 되도록 코드를 작성하세요
         * 1 2 3 4
         * 5 6 7 8
         * 9 10 11 12
         * 13 14 15 16
         */
        // 방법1.
        int div = 4;
        for (int i = 1; i <= div * div; i++) {
            System.out.print(i + " ");
            if (i % div == 0) {
                System.out.println();
            }
        }
        // 방법2. 중첩 for문 이용
        int num = 1;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(num + " ");
                num++;
            }
            System.out.println();
        }

        int line = 1;
        for (line = 1; line <= div; line++) {
            num = div * line - (div-1);
            for (int i = num; i < num+div; i++) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
