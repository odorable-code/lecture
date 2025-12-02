package day02;

public class EX05_DoWhile {
    public static void main(String[] args) {
        /* do-while문에서 문
         * - 무조건 하번 실행
         * - 실행후 조건을 조사
         * - while()옆에 ;을 반드시 붙여야 됨
         * 문법
         * do {
         *    실행문;
         * while(조건식);
         */

        int num = 10;
        do {
            System.out.println(num + "는 0보다 작습니다.");
            num--;
        } while (num < 0);
        ///  while은 조건식을
        num = 10;
        while (num < 0) {
            System.out.println(num + "는 0보다 작습니다 (while)");
        }
    }
}
