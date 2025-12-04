package day04;

public class EX03_ConditionalStatement {

	public static void main(String[] args) {
		/* 조건문
		 * - 언제 사용?
		 *   - 상황에 따라 결과가 달라질 때 사용
		 *   - 성적에 따라 학점이 달라질 때 
		 *   - A이면 B이다로 표현 가능하면 조건문을 사용
		 *   - A : 조건식, B : 실행문
		 * if문
		 * - 문법
		 *   if(조건식){
		 *     실행문;
		 *   }
		 * - 적용
		 *   - A이면 B하세요
		 *   if(A){
		 *     B;
		 *   }
		 * - 문법2
		 *   if(조건식){
		 *     실행문1;
		 *   }
		 *   else{
		 *     실행문2;
		 *   }
		 * - 적용
		 *   - A이면 B하고 아니면 C하세요.
		 *   if(A){
		 *     B;
		 *   }
		 *   else{
		 *     C;
		 *   }
		 * 문법3
		 *   if(조건식1){
		 *     실행문1;
		 *   }
		 *   else if(조건식2){
		 *     실행문2;
		 *   }
		 *   else{
		 *     실행문3;
		 *   }
		 * 적용
		 *   - A이면 B하고, A가 아니고 C이면 D하고, 아니면(A아니고 C도 아니면) F하세요.
		 *   if(A){
		 *     B;
		 *   }
		 *   else if(C){
		 *     D;
		 *   }
		 *   else{
		 *     F;
		 *   }
		 * */
		
		int 이수학점 = 151;
		final int 졸업학점 = 150;
		boolean 졸업작품여부 = false;
		
		/* 이수학점이 졸업학점 미만이면 졸업 실패
		 " 아니면(졸업학점 이상이면) 졸업작품을 했으면 졸업
		 * 아니면 졸업 실패라고 출력하도록 조건문을 작성
		 * */
		if(이수학점 < 졸업학점) {
			System.out.println("졸업 실패");
		}
		else if(졸업작품여부) {
			System.out.println("졸업");
		}
		else {
			System.out.println("졸업 실패");
		}
        /* switch문
         * - 언제 서용?
         *  - if문에서 각 조건문이 변수 ==값형태로 되어있는데 변수가 고정인 경우 사용
         * - 왜 사용?
         *  - if문 보다 구조가 간결
         * - 문법
         * switch (변수) {
         * case 값1:      if (변수 == 값1)
         *      실행문1;
         *      break;
         * case 값2:     else if (변수 == 값2)
         *      실행문2;
         *      break;
         * default:     else
k        *      실행문3;
         * }
         *
         * - 주의사항
         *   - 값에는 상수와 리터럴만 올 수 있음   =
         *   - 값은 문자(''), 정수, 문자열("")만 가능 (실수X)
         */

        // 문자가 산술연산자라면 산술연사자입니다라고 출력하는 예제
        char ch = '+';
        switch(ch) {
            case '+':
                System.out.println(ch );
                break;
        }
	}

}
