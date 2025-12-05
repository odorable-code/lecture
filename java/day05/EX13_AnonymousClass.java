package day05;

public class EX13_AnonymousClass {
    public static void main(String[] args) {
        /* 익명 클래스
         * - 이름이 없는 클래스로 인터페이스나 추상 클래스의 객체가 필요할 때 사용
         * - 재사용이 안됨 => 이름이 없어서 다시 불릴 수 없음
         * - 상황에 따라 람다식을 이용할 수 있음
         * - 인터페이스에 객체를 필요로 한는데 구현 클래스를 만들자니 굳이라는 생각이 들 때
         *   (필드와 메서드가 추가로 필요 하지 않아 인터페이스의 추상 메서드만 구현하려고 할 때)
         *   익명클래스를 이용하여 객체를 생성
         * */
        Game game = new Game() {
            @Override
            public void run() {
                System.out.println("게임을 실행합니다.");
                System.out.println(".....");
                System.out.println("게임 플레이 중...");
                System.out.println(".....");
                System.out.println("게임을 종료합니다.");
            }
        };
        game.run();
        // 람다식을 이용, 익명 클래스의 객체를 생성
        Game game2 = () -> {
            System.out.println("게임을 실행합니다.");
            System.out.println(".....");
            System.out.println("게임 플레이 중...");
            System.out.println(".....");
            System.out.println("게임을 종료합니다.");
        };
        game2.run();
    }
}
class GameImp implements Game {
    @Override
    public void run() {

    }
}

interface Game {
    void run();
}