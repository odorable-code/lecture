package day03;

import java.util.Arrays;

public class EX04_ArrayCopy {
    public static void main(String[] args) {
        /* 배열 복사하기
         * 1. 반복문을 이용해 직접 구현
         * 2. System.arraycopy(src, srcPos, dest, destPos, length)를 이용 p.218
         *  - src : 복사할 배열
         *  - srcPos = 복사할 배열의 시작 위치, 배열에서 몇번지에서 복사할건지
         *  - dest: 복사해서 붙여넣을 예정
         *  - destPos: 붙여넣을 시작 위치
         *  - length: 복사할 갯수
         */
        int num1 = 10;
        int num2 = num1;
        System.out.println("num1: " + num1);
        System.out.println("num2: " + num2);
        num1 = 20;
        System.out.println("num2를 20으로 수정");
        System.out.println("num1: " + num1);
        System.out.println("num2: " + num2);

        int arr1[] = { 1, 2, 3 };
        int arr2[] = arr1;

        System.out.println("arr1[0] = " + arr1[0]);
        System.out.println("arr1[0] = " + arr2[0]);
        arr1[0] = 20;
        System.out.println("arr1[0] = " + arr1[0]);
        System.out.println("arr2[0] = " + arr2[0]);

        arr1 = new int[] { 1,2,3 };
        // 반복문으로 직접 복사
        int arr3[] = new int[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            arr3[i] = arr1[i];
        }
        System.out.println("=======================");
        System.out.println("arr1[0] = " + arr1[0]);
        System.out.println("arr3[0] = " + arr3[0]);
        arr1[0] = 20;
        System.out.println("num1[0]를 20으로 수정");
        System.out.println("arr1[0] = " + arr1[0]);
        System.out.println("arr3[0] = " + arr3[0]);

        arr1 = new int[] { 1,2,3 };
        int arr4[] = new int[arr1.length];
        System.arraycopy(arr1, 0, arr4, 0, arr1.length);

        System.out.println("=======================");
        System.out.println("arr1[0] = " + arr1[0]);
        System.out.println("arr4[0] = " + arr4[0]);
        arr1[0] = 20;
        System.out.println("num1[0]를 20으로 수정");
        System.out.println("arr1[0] = " + arr1[0]);
        System.out.println("arr4[0] = " + arr4[0]);
    }
}
