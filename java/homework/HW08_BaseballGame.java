package homework;

import java.util.Scanner;

public class HW08_BaseballGame {

	public static void main(String[] args) {
		/* 1~9사이의 중복되지 않은 3개의 수를생성해서 맞추는 게임
		 * 규칙
		 * S : 숫자가 있고 위치가 같음
		 * B : 숫자가 있고 위치가 다름
		 * O : 일치하는 숫자가 하나도 없음
		 * 
		 * 예시
		 * 랜덤수 : 1 5 4
		 * 입력 : 1 2 3
		 * 1S
		 * 입력 : 4 5 6
		 * 1S 1B
		 * 입력 : 7 8 9
		 * O
		 * 입력 : 1 4 5
		 * 1S 2B
		 * 입력 : 1 5 4
		 * 정답입니다.
		 * */
        // 답 생성
        int [] answer = generateAnswer();
        Scanner scan = new Scanner(System.in);
        while (true) {
            int [] userChoice = getUserChoice(scan);
            int [] ballCount = ballCheck(answer, userChoice);
            if (isStrikeOut(ballCount)) { break; }
        }
	}

    public static int[] getUserChoice(Scanner scan) {
        int [] userChoice = new int[3];
        System.out.print("세개의 답을 입력해주세요: ");
        for (int i = 0; i < 3; i++) {
            userChoice[i] = scan.nextInt();
        }
        return userChoice;
    }
    public static int[] generateAnswer() {
        int [] answer = new int[3];
        for (int i = 0; i < 3; i++) {
            answer[i] = (int) (Math.random() * 9 + 1);
        }
        return answer;
    }
    public static int[] ballCheck(int [] answer, int [] userChoice) {
        int strike = 0;
        int ball = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (answer[i] == userChoice[j]) {
                    if (i == j) { strike++; }
                    else { ball++; }
                }
            }
        }
        return new int[]{ strike, ball };
    }

    public static boolean isStrikeOut(int [] ballCount) {
        int strike = ballCount[0];
        int ball = ballCount[1];

        if (strike == 3) {
            System.out.println("정답입니다!");
            return true;
        } else {
            System.out.println(strike + "S " + ball + "B 입니다.");
            return false;
        }
    }
}
