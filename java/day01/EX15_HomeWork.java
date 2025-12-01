package day01;

import java.util.Scanner;

public class EX15_HomeWork {
    public static void main(String[] args) {
        /*
         * 성적을 입력받아 성적에 맞는 학점을 출력하는 코드를 작성하세요 switch문을 이용하여 작성
         * A : 90 ~ 109
         * B : 80 ~ 89
         * C : 70 ~ 79
         * D : 60 ~ 69
         * F : -9 ~ 59
         * 잘못된 성적: -9 미만, 110 이상
         */

        Scanner scan = new Scanner(System.in);
        System.out.print("성적을 입력하세요: ");
        int score = scan.nextInt();

        switch(score / 10) {
            case 9, 10:
                if (score > 109) {
                    System.out.println(score + "(은/는) 잘못된 학점입니다.");
                    break;
                }
                System.out.println(score + "(은/는) A학점입니다.");
                break;
            case 8:
                System.out.println(score + "(은/는) B학점입니다.");
                break;
            case 7:
                System.out.println(score + "(은/는) C학점입니다.");
                break;
            case 6:
                System.out.println(score + "(은/는) D학점입니다.");
                break;
            case 5, 4, 3, 2, 1, 0:
                if (score < -9) {
                    System.out.println(score + "(은/는) 잘못된 학점입니다.");
                    break;
                }

                System.out.println(score + "(은/는) F학점입니다.");
                break;
            default:
                System.out.println(score + "(은/는) 잘못된 학점입니다.");

        }
    }
}
