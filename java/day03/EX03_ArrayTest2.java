package day03;

import java.util.Scanner;

public class EX03_ArrayTest2 {
    public static void main(String[] args) {
        /* 3명의 국어 성적을 입력받아 저장한 후, 3명의 국어성적 평균울 구하는 코드를 작성하세요.
         * */
        int[] scores = new int[3];
        int sum = 0;
        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < scores.length; i++) {
            System.out.print(i + 1 + "번째 국어성적을 입력하세요: ");
            scores[i] = scan.nextInt();
            sum += scores[i];
        }

        double avgScore = sum / (double)scores.length;
        System.out.println("3명 국어성적의 평균값은: " + avgScore);
    }
}
