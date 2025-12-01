package day01;

import java.util.Scanner;

public class EX14_Switch2 {
    public static void main(String[] args) {
        /*
        * 월을 입력받아 일렵받은 월의 마지막 일을 출력하는 코드르르 작성하세요.
        * 31 : 1, 3, 5, 7, 8, 10, 12
        * 30 : 4, 6, 9, 11
        * 28 : 2
        *
        * 예시
        * 월 입력: 3
        * 3월은 31일까지 있습니다.
        * 예시2
        * 월 입력: 13
        * 13월은 없는 달입니다.
        *
        * */
        System.out.print("월 입력: ");
        Scanner scanner = new Scanner(System.in);
        int month = scanner.nextInt();
        switch(month) {
            // JDK 8 이상 부터 가능한 문법
            case 1, 3, 5, 7, 8, 10, 12:
                System.out.println(month + "월은 31일까지 있습니다");
                break;
            case 4, 6, 9, 11:
                System.out.println(month + "월은 30일까지 있습니다");
                break;
            case 2:
                System.out.println(month + "월은 28일까지 있습니다");
                break;
            default:
                System.out.println(month + "월은 없는 달입니다");
        }
    }
}
