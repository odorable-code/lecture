package day02;

public class EX02_ForTest {
    public static void main(String[] args) {
        // 구구단 2단 출력하는 코드를 작성하세요
        for (int i = 1; i <= 9; i++) {
           System.out.println("2 * " + i + " = " + 2*i);
        }
        int i = 1;
        for (; i <= 9; ) {
            System.out.println("2 * " + i + " = " + 2*i);
            i++;
        }
        System.out.println("------------------------");
        // a에서 z까지 룰력하는 코드를 작성하세요
        // 문자 a는 유니코드표에서 십진수 97이다. z는 122이다.
        for (char c = 'a'; c <= 'z'; c++) {
            System.out.print(c);
        }
        System.out.println();
        for (int j = 97; j <= 122; j++) {
            System.out.print((char)j);
        }
        System.out.println();
        for (int j = 0; j < 26; j++) {
            System.out.print((char) ('a' + j));
        }
        System.out.println();

        System.out.println("--------------------");
        /* 1부터 10까지 합을 구하는 코드를 작성하세요.
         *
         * sum = 0
         * i = 1, sum = 0 + 1
         * i = 2, sum = 0 + 1 + 2
         * i = 3, sum = 0 + 1 + 2 + 3
         * ...
         * i = 9, sum = 0 + 1 + 2 + 3 + ... + 9
         * i = 10, sum = 0 + 1 + 2 + 3 + ... + 9 + 10
         *
         * 원래 sum인데 초기 sum을 이해를 위해 sum0로 표시
         * sum0 = 0
         * i = 1, sum1 = sum0 + 1
         * i = 2, sum2 = sum1 + 2
         * i = 3, sum3 = sum2 + 3
         * ...
         * i = 9, sum9 = sum8 + 9
         * i = 10, sum10 = sum9 + 10
         *         sum = sum + 1
        */
        int sum = 0;
        for (int j = 1; j <= 10; j++) {
            sum += j;
        }
        System.out.println("sum = " + sum);
    }
}
