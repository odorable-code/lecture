package day02;

import java.util.Scanner;

public class EX11_BreakTest {
    public static void main(String[] args) {
        /* 문자를 입력받아 입력받은 문자를 출력하는 코드를 작성하세요. */
        /* 문자를 입력 받아 입력받은 문자가 q이면 종료. 아니면 계속 입력을 받는 코드를 작성하시오 */
        Scanner scanner = new Scanner(System.in);
        char ch;

        for (ch = 'a'; ch != 'q'; ) {
            System.out.print("문자를 입력하세요: ");
            ch = scanner.next().charAt(0);
            System.out.println("입력 문자: " + ch);
        }
        System.out.println("종료합니다.");

        for ( ; ; ) {
            System.out.print("문자를 입력하세요: ");
            ch = scanner.next().charAt(0);
            System.out.println("입력 문자: " + ch);
            if (ch == 'q') {
                break;
            }
        }
        System.out.println("종료합니다.");

        do {
            System.out.print("문자를 입력하세요: ");
            ch = scanner.next().charAt(0);
            System.out.println("입력 문자: " + ch);
        } while (ch != 'q');
        System.out.println("종료합니다.");

        while (true) {
            System.out.print("문자를 입력하세요: ");
            ch = scanner.next().charAt(0);
            if (ch == 'q') {
                System.out.println("종료합니다.");
                break;
            }
            System.out.println("입력 문자: " + ch);
        }
    }
}
