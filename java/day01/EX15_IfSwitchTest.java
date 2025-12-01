package day01;

import java.util.Scanner;

public class EX15_IfSwitchTest {
    public static void main(String[] args) {
        /*
        *  두 정수와 산술연산자를 입력받아 산술 연산 결과를 출력하는 코드를 작성하세요.
        *  예시
        *  두 정수와 연산자 입력(예: 1 + 2) : 1 / 2
        *  1 / 2 = 0.5
        *  예시
        *  두 정수와 연산자 입력(예: 1 + 2) : 1 ? 2
        *  ?는 산술 연산자가 아닙니다.
        * */

        System.out.print("두 정수와 연산자 입력(예: 1 + 2) : ");
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        char operator = scan.next().charAt(0);
        int num2 = scan.nextInt();


        // if문으로 작성
        if (operator == '+') {
            System.out.println(num + " + " + num2 + " = " + (num + num2));
        } else if (operator == '-') {
            System.out.println(num + " - " + num2 + " = " + (num - num2));
        } else if (operator == '*') {
            System.out.println(num + " * " + num2 + " = " + (num * num2));
        } else if (operator == '/') {
            if (num == 0 || num2 == 0) {
                System.out.println("0은 나눌 수 없습니다.");
            }
            System.out.println(num + " / " + num2 + " = " + (num / (double)num2));
        }

        // switch문으로 작성
        switch(operator) {
            case '+':
                System.out.println(num + " + " + num2 + " = " + (num + num2));
                break;
            case '-':
                System.out.println(num + " - " + num2 + " = " + (num - num2));
                break;
            case '*':
                System.out.println(num + " * " + num2 + " = " + (num * num2));
                break;
            case '/':
                if (num == 0 || num2 == 0) {
                    System.out.println("0은 나눌 수 없습니다.");
                }
                System.out.println(num + " / " + num2 + " = " + (num / (double)num2));
                break;
            default:
                System.out.println(operator + "는 연산자가 아닙니다");
        }
    }
}
