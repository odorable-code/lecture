package day07;

import java.io.*;

public class EX03_IOStream {
    public static void main(String[] args) {
        /* 스트림
        *  - 데이터를 읽거나 쓰는데 추상화된 개념
        *  - 데이터를 연속적으로 처리
        *  - 분류
        *     - 입력 vs 출력
        *     - 바이트 vs 문자
        *     - 기반 vs 보조
        *
        *  표준 입출력 (p549)
        *  - PrintStream out : 표준 출력 스트림
        *  - InputStream in : 표준 입력 스트림,
        *  - OutputStream err : 표준 오류 스트림
        *
        *  InputStream
        *  - 바이트 단위 입력 스트림 중 최상위 스트림
        *
        * OutputStream
        * - 바이트 단위 출력 스트림 중 최상위 스트림
        *
        * Reader
        * - 문자 단위 입력 스트림 중 최상위 스트림
        * - FileReader
        * Writer
        * - 문자 단위 출력 스트림 중 최상위 스트림
        * - FileWriter
        * */

        //day07 패키지에 data.txt파일을 염
        String filename = "src/day07/data.txt";


        // 한 글자씩 읽어오기
        FileReader reader = null;
        try {
            reader = new FileReader(filename);
            while (reader.ready()) {
                char ch = (char) reader.read();
                System.out.print(ch);
            }
        } catch (FileNotFoundException e) {
            System.out.println("파일을 열 수 없습니다;");
        } catch (IOException e) {
            System.out.println("IO 에러");
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch(IOException e){
                    System.out.println("IO 예외 발생");
                }
            }
        }

        BufferedReader br;
        try {
            reader = new FileReader(filename);
            // BufferedReader는 보조 스트림으로 한줄씩 읽어올 수 있게 도와줌
            br = new BufferedReader(reader);
            String line;
//            do {
//                line = br.readLine();
//                // null이 아니면 출력
//                if (line != null) {
//                    System.out.println(line);
//                }
//            } while(line != null); // null이면 반복문 종료
            // 한줄 읽어와서 null이 아니면출력하고 null이면 종료
            while((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("파일을 찾을 수 없습니다.");
        } catch (IOException e) {
            System.out.println("IO 에러 발생");
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    System.out.println("IO 예외 발생");
                }
            }
        }
    }
}

class System2 {
    public static InputStream in = new InputStream() {
        @Override
        public int read() throws IOException {
            throw new IOException();
        }
    };
}
