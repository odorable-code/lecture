package day02;

public class EX04_WhileTest {
    public static void main(String[] args) {
        // Hello, World! 5번 출력 예제
        int i = 5;
        while (i-- > 0) {
            // 조건식에서 i가 5이면 여기 실행문에서는 i가 4
            System.out.println("Hello, World!");
        }
        // 2단 구구단 출력 예제
        i = 1; int end = 9;
        while (i <= end) {
            System.out.println("2 * " + i + " = " + 2 * i++);
        }
    }
}
