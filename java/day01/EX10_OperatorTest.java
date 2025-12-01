package day01;

import java.util.Scanner;

public class EX10_OperatorTest {
    public static void main(String[] args) {
        /* 두 정수를 입력받아 합을 구하는 코드를 작성하세요 */
        Scanner scanner = new Scanner(System.in);
        System.out.print("정수를 입력하시오: ");
        int num1 = scanner.nextInt();
        System.out.print("다음 정수를 입력하시오: ");
        int num2 = scanner.nextInt();

        System.out.printf("%d + %d = %d\n", num1, num2, num1 + num2);
    }
}
