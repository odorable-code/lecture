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
        Scanner scan = new Scanner(System.in);
        int choice = 0;
        do {
            System.out.println("메뉴");
            System.out.println("1. 플레이");
            System.out.println("2. 기록확인");
            System.out.println("3. 종료");
            System.out.print("메뉴 선택: ");

            choice = scan.nextInt();
            switch (choice) {
                case 1:
                    BaseballGame baseballGame = new BaseballGame();
                    baseballGame.play();
                    break;
                case 2:
                    Ranking.show();
                    break;
                case 3:
                    System.out.println("종료합니다.");
                    break;
                default:
                    System.out.println("잘못 입력했습니다.");
            }
        } while(choice != 3);
    }
}

class BaseballGame {
   void play() {
        System.out.println("플레이볼!");
        int[] answer = Answer.generateAnswer();
        int numOfAttempts = 0;
        while (true) {
            numOfAttempts++;
            System.out.print("정답을 입력하세요: ");
            int[] choice = Player.getChoice();
            BallCount ballCount = GameLogic.checkBallCount(answer, choice);
            if (ballCount.strike == 3) {
                System.out.println("정답입니다.");
                break;
            } else {
                System.out.printf("%dS %dB입니다.\n", ballCount.strike, ballCount.ball);
            }
        }

        System.out.println("시도횟수는 " + numOfAttempts + "회");
        int rank = Ranking.isRankingOn(numOfAttempts);
        if (rank > -1) {
            System.out.println(rank + "등 안에 들었습니다.");
            System.out.print("이니셜을 남겨주세요: ");
            char[] playerName = Player.getName();
            Ranking.add(playerName, numOfAttempts);
            Ranking.show();
        }
    }
}

class Ranking {
    static Record[] records = new Record[5];
    static int add(char[] playerName, int numOfAttempts) {
        Record newRecord = new Record(playerName, numOfAttempts);
        int rank = 0;
        for (int i = 0; i < records.length; i++) {
            Record record = records[i];
            if (record == null || newRecord.numOfAttempts <= record.numOfAttempts) {
                rank = i;
                break;
            }
        }

        for (int i = records.length-2; i >= rank; i--) {
            records[i+1] = records[i];
        }

        records[rank] = newRecord;
        return rank+1;
    }
    static int isRankingOn(int numOfAttempts) {
        int prevNumOfAttempts = 0;
        int rank = 0;
        for (int i = 0; i < records.length; i++) {
            Record record = records[i];
            if (record == null || numOfAttempts <= record.numOfAttempts) {
                return rank+1;
            }
            if (prevNumOfAttempts != record.numOfAttempts) {
                rank++;
            }
            prevNumOfAttempts = record.numOfAttempts;
        }
        return -1;
    }

    static void show() {
        System.out.println("=========== 순위 ============");
        int rank = 0;
        int prevNumOfAttempts = 0;
        for (int i = 0; i < records.length; i++) {
            Record r = records[i];
            if (r == null) {
                if (i == 0) {
                    System.out.println("기록이 존재하지 않습니다.");
                    break;
                }
                continue;
            }
            if (prevNumOfAttempts != r.numOfAttempts) {
                rank++;
            }
            System.out.printf("%d. %c%c%c - %d회\n",
                rank, r.playerName[0], r.playerName[1], r.playerName[2], r.numOfAttempts);
            prevNumOfAttempts = r.numOfAttempts;
        }
        System.out.println("============================");
    }
}

class GameLogic {
    static BallCount checkBallCount(int[] answer, int[] playerChoice) {
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < answer.length; i++) {
            for (int j = 0; j < playerChoice.length; j++) {
                if (answer[i] == playerChoice[j]) {
                    if (i == j) { strike++; }
                    else        { ball++;   }
                }
            }
        }
        return new BallCount(strike, ball);
    }
}

class BallCount {
     int strike;
     int ball;

    public BallCount(int strike, int ball) {
        this.ball = ball;
        this.strike = strike;
    }
}

class Player {
    public static int[] getChoice() {
        int[] choice = new int[3];
        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < choice.length; i++) {
            choice[i] = scan.nextInt();
        }
        return choice;
    }
    public static char[] getName() {
        char[] name;
        Scanner scan = new Scanner(System.in);
        String read = "";
        do {
            String r = scan.next().trim();
            read += r.replaceAll(" ", "");
        } while (read.length() < 3);
        name = read.substring(0, 3).toCharArray();
        return name;
    }
}

class Answer {
    public static int[] generateAnswer() {
        int[] answer = new int[3];
        int random = 0;
        for (int i = 0; i < answer.length; i++) {
            outer: do {
                random = (int) (Math.random() * 9 + 1);
                for (int j = 0; j < i; j++) {
                    if (answer[j] == random) {
                        continue outer;
                    }
                }
                break;
            } while (true);
            answer[i] = random;
        }
        return answer;
    }
}

class Record {
    int numOfAttempts;
    char[] playerName;

    public Record(char[] playerName, int numOfAttempts) {
        this.playerName = playerName;
        this.numOfAttempts = numOfAttempts;
    }
}