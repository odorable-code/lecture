package day03;

import java.util.Scanner;

public class EX15_Student {
    final static int MAX_COUNT = 3;
    public static void main(String[] args) {
        /* 프로그램 기능
         * 1. 학생 추가
         * 2. 학생 성적 수정
         * 3. 학생 삭제
         * 4. 종료
         */
        MyStudent stds[] = new MyStudent[MAX_COUNT];
        // 현재 저장된 학생 수 => 학생을 배열에 추가할 때 사용
        Scanner sc = new Scanner(System.in);
        int count = 0;
        char menu;
        do {
            // 메뉴 출력
            printMenu();
            // 메뉴 입력
            menu = sc.next().charAt(0);
            // 선택한 메뉴에 맞는 기능 실행
            switch (menu) {
                case '1':
                    // 학생 배열과 학생수를 알려주면 학생정보를 추가하여
                    // 추가된 학생수를 새로 저장
                    count = addStudent(stds, count, sc);
                    break;
                case '2':
                    System.out.println("학생 성적 수정 기능 구현 예정");
                    break;
                case '3':
                    System.out.println("학생 정보 삭제 기능 구현 예정");
                    break;
                case '4':
                    System.out.println("프로그램을 종료합니다.");
                    break;
                default:
                    System.out.println("잘못된 메뉴입니다.");
            }
        } while (menu != '4');
    }
    public static void printMenu() {
        System.out.println("메뉴");
        System.out.println("---------------");
        System.out.println("1. 학생 추가");
        System.out.println("2. 학생 성적 수정");
        System.out.println("3. 학생 삭제");
        System.out.println("4. 종료");
        System.out.print("메뉴 입력: ");
    }
    /* 기능: 학생 정보를 입력받아 학생 배열에 추가하는 메서드
     * 매개변수: 학생 배열, 현재 저장된 학생 수
     *   => MyStudnet [] stds, int count, Scanner scan
     * 리턴타입: 저장된 학생 수
     * 매서드명: addStudent
     */
    public static int addStudent(MyStudent [] stds, int count, Scanner sc) {
        // 배열이 다 차있으면 못하겠다고 출력
        if (count == MAX_COUNT) {
            System.out.println("더 이상 학생을 추가할 수 없습니다.");
            return count;
        }
        // 학생의학년, 반, 번호, 이름을 입력
        System.out.println("학년, 반, 번호, 이름순으로 입력하세요.");
        int grade = sc.nextInt();
        int classNum = sc.nextInt();
        int num = sc.nextInt();
        String name = sc.next();
        // 객체를 생성해서 배열에 저장
        MyStudent std = new MyStudent(grade, classNum, num, name);
        stds[count] = std;
        count++;
        return count;
    }
}

class MyStudent {
    String name;
    int grade;
    int classNum;
    int num;

    MyStudent(int grade, int classNum, int num, String name) {
        this.grade = grade;
        this.classNum = classNum;
        this.num = num;
        this.name = name;
    }
}


