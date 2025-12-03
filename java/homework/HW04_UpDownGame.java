package homework;

import java.util.Scanner;
import java.util.Random;

public class HW04_UpDownGame {
    public static void main(String[] args) {
        /* 1~100 사이의 랜덤한 수를 생성해서 맞추는 게임
         *  랜덤한 수 : 33 // 안보여야 함
         *  정수 입력 : 50
         *  DOWN
         *  정수 입력 : 25
         *  UP
         *  정수 입력 : 30
         *  UP
         *  정수 입력 : 33
         *  정답입니다!
         */
        int answer = (int) (Math.random() * 100 + 1);
        Scanner input = new Scanner(System.in);
        System.out.println("정답 : " + answer);
        while (true) {
            System.out.print("정수 입력 : ");

            int choice = input.nextInt();
            if (choice > answer) {
                System.out.println("DOWN");
            } else if (choice < answer) {
                System.out.println("UP");
            } else {
                System.out.println("정답입니다!");
            }
        }
    }
}
