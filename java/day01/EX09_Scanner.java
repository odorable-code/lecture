package day01;

import java.util.Scanner;

public class EX09_Scanner {
    public static void main(String[] args) {
        /*
        * 자바 콘솔창에서 입력을 받는 방법
        * Scanner 사용하기
        *   - Scanner를 이용하여 정수, 실수, 문자열을 입력받을 수 있음
        *   - 정수를 입력받으려면 nextInt()
        *   - 실수를 입력받으려면 nextDouble(), nextFloat()
        *   - 문자열: next(), nextLine()
        *   - 문자 : next().charAt(0)
        *
        *   - println() : 안에 있는 내용을 콘솔에 출력하고 엔터
        *   - print() : 안에 있는 내용을 콘솔에 출력
         */
        //
        Scanner scanner = new Scanner(System.in);
        System.out.print("정수 입력: ");
        int num = scanner.nextInt();
        System.out.println("입력된 정수: " + num);

        System.out.print("실수 입력: ");
        double num2 = scanner.nextDouble();
        System.out.println("입력된 실수: " + num2);

        // next() : 공백을 제거한 문자열로 단어를 입력받음
        System.out.print("문자열 입력: ");
        String str1 = scanner.next();
        System.out.println(str1);
        // nextLine() : 공백을 포함한 문자열 한 줄을 입력받음. 엔터 입력 주의
        System.out.print("문자열 입력: ");
        scanner.nextLine(); // 위에서 입력한 엔터를 비우기 위해서
        String str2 = scanner.nextLine();
        System.out.println(str2);

        System.out.print("문자 입력: ");
        char ch = scanner.next().charAt(0); // 문자열에서 0번째 글자부터 문자를 가져옴P
        System.out.println("입력한 문자 : " + ch);
    }
}
