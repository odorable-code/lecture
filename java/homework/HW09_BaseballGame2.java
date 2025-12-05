package homework;

import java.util.Scanner;

public class HW09_BaseballGame2 {
    public static void main(String[] args) {
        /* 기본 게임 방식은 HW08과 같음 기록관리를 추가
         * 관리할 기록은 횟수와 입력한 이니셜
         * 메뉴
         * 1. 플레이
         * 2. 기록확인
         * 3. 종료
         * 메뉴 선택: 1
         * // HW08에서 했던 야구 게임이 진행
         * // 정답을 맞추면 맞은 횟수를 출력
         * 정답입니다.
         * 시도횟수는 4회
         * 5등안에 들었습니다.
         * 이니셜을 남겨주세요: JIK
         * 메뉴 다시 출력
         * 메뉴
         * 1. 플레이
         * 2. 기록확인
         * 3. 종료
         * 메뉴 선택: 2
         * 1. JIK - 4회
         * 메뉴
         * 1. 플레이
         * 2. 기록확인
         * 3. 종료
         * 메뉴 선택: 1
         */
        int [] answer = generateAnswer();
        GameRecord [] records = new GameRecord[5];
        Scanner scan = new Scanner(System.in);
        int tryingCount = 0;
        while (true) {
            tryingCount++;
            int [] userChoice = getUserChoice(scan);
            int [] ballCount = ballCheck(answer, userChoice);
            if (isStrikeOut(ballCount)) {
                if (isRankingOn()) {
                    char [] playerName = getPlayerName(scan);
                    addRecord(records, playerName, tryingCout);
                }
                break;
            }
        }
    }

    public static char[] getPlayerName(Scanner scan) {
        System.out.println("이름을 입력해주세요: ");
        char [] playerName = new char[3];
        for (int i = 0; i < 3; i++) {
            playerName[i] = scan.next().charAt(0);
        }
        return playerName;
    }
    public static void addRecord(Record [] records, char [] playerName, int tryingCout) {

    }

    class GameRecord {
        char[] playerName;
        int tryingCount;
        int rank;
        Record(char [] playerName, int tryingCount, int rank) {
            this.playerName = playerName;
            this.tryingCount = tryingCount;
            this.rank = rank;
        }
        void print() {
            System.out.println(rank + ". " + playerName + " - " + tryingCount + "회");
        }
    }

    public static boolean isRankingOn(int tryingCount) {

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
