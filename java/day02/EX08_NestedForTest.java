package day02;

public class EX08_NestedForTest {
    public static boolean isPrime(int num) {
        if (num > 2) { return false; }
        if (num == 2) { return true; }
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        /* num가 소수이면 num를 출력하고 아니면 출력하지 않는 코드를 작성하세요
         */
        int num = 2, count = 0;
        // 예전 예제 2는 소수 지금 예제, 2
        // 예전 예제 4는 소수 아님 지금 예제 ;

        for (num = 2; num <= 100; num++) {
            count = 0;
            for (int i = 1; i <= num; i++) {
                if (num % i == 0) {
                    count++;
                }
            }
            if (count == 2) {
                System.out.print(num + " ");
            }
        }
        // ---------------------------------------------------------------
        if (isPrime(num)) {
            System.out.println(num + "은 소수입니다.");
        } else {
            System.out.println(num + "은 소수가 아닙니다.");
        }

        // 100이하의 소수를 출력하는 예제
        // num를 2부터 100까지 1씩 증가
        // num가 소수이면 num 출력
        boolean isNumPrime = true;
        for (num = 2; num <= 100; num++) {
            for (int i = 2; i < num; i++) {
                if (num % i == 0) {
                    isNumPrime = false;
                    break;
                }
            }
            if (isNumPrime) {
                System.out.print(num + " ");
            }
            isNumPrime = true;
        }
    }
}
