package homework;

import java.util.Arrays;

public class HW07_Lotto {

	public static void main(String[] args) {
		/* 1~45사이의 랜덤한 수 6개를 생성하여 배열에 저장하고 출력하세요.
		 * 중복 X
		 * */
		
		int [] lotto = new int[6];
		int min = 1, max = 45;
//		//테스트 할 때는 1~8로 테스트하여 중복되지 않는지 확인 후 이상 없으면 1~45로 변경
        for (int i = 0; i < 6; i++) {
            boolean isContaining;
            int random;
            do {
                isContaining = false;
                random = (int) (Math.random() * (max - min + 1) + 1);
                for (int j = 0; j <= i; j++)
                    if (random == lotto[j]) {
                        isContaining = true;
                    }
            } while(isContaining);
            lotto[i] = random;
            System.out.print(random + " ");
        }
        System.out.println();
	}

}
