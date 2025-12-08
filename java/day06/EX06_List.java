package day06;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class EX06_List {
    public static void main(String[] args) {
        /* 리스트를 이용하여 1~5 사이의 정수를 입력받아 중복이 안되면 저장하고 중복이 되면 저장하지 않는 예제를 작성하세요
        * 과정1. 앞 예제를 활용하여 정수를 5번 입력받는 코드 구현
        * 과정2. 과정1 코드를 고민하며 중복이 안될때만 추가되도록 구현
        * */
        /*
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> vals = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            System.out.print("1~5사이의 정수를 입력하시오: ");
            int val = sc.nextInt();
            if (val >= 1 && val <= 5 && !vals.contains(val)) {
                vals.add(val);
                System.out.println(val + "이 추가됐습니다.");
            } else {
                System.out.println("범위를 벗어났거나 중복된 수입니다.");
            }
        }
        System.out.println("저장된 값은 : " + vals);
        */
        // 1~5 사이의 중복되지 않은 3개의 정수를 입력. => 리스트에 저장된 갯수가 3개가 되면 종료
        /*
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> vals = new ArrayList<>();

        for (int i = 0; vals.size() < 3; i++) {
            System.out.print("1~5사이의 정수를 입력하시오: ");
            int val = sc.nextInt();
            if (val >= 1 && val <= 5 && !vals.contains(val)) {
                vals.add(val);
                System.out.println(val + "이 추가됐습니다.");
            } else {
                System.out.println("범위를 벗어났거나 중복된 수입니다.");
            }
        }
        System.out.println("저장된 값은 : " + vals);
        */
        ArrayList<Integer> items = createRandomList(1, 9, 8);
        System.out.println("랜덤한 수는: " + items);
    }
    // 기능 : min~max 사이의 중복되지 않은 size개의 정수를 랜덤으로 생성하여 리스트에 담아 반환하는 메서드
    // 매개변수: min~max, size => int min, int max, int size
    // 리턴타입: 랜덤한 정수가 담긴 리스트
    // 메서드명: createRandomList
    public static ArrayList<Integer> createRandomList(int min, int max, int size) {
        ArrayList<Integer> list = new ArrayList<>();
        //최소가 최대보다 크면
        if (min > max) {
            int tmp = min;
            min = max;
            max = tmp;
        }
        // 랜덤으로 생성할 수 있는 수보다 크기가 더 큰 경우 => 무한루프
        if (max - min + 1 < size) {
            return null;
        }
        Random rand = new Random();
        while (list.size() < size) {
//            int randomValue = (int)(Math.random() * (max - min + 1) + min);
            int randomValue = rand.nextInt(min, max+1);
            if (!list.contains(randomValue)) {
                list.add(randomValue);
            }
        }
        return list;
    }
}
