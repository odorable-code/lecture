package day07;

import java.io.*;
import java.util.ArrayList;

public class EX05_ObjectStream {
    public static void main(String[] args) {
        /* ObjectInputStream/ObjectOutputStream
        *  - 보조 스트림
        *  - 스트링을 통해 객체 단위로 읽어옴/씀
        *  - 클래스가 직렬화가 된 경우에만 ObjectStream을 사용할 수 있음
        *
        * 직렬화/역직렬화
        * - 클래스에 Serializable 인터페이스 구현하면 됨
        * - ObjectStream을 이용하여 읽어오거나 (readObject()) 쓰면 됨 ( WriteObject())
        * */

        String filename = "src/day07/data2.txt";

        ArrayList<Point> list = new ArrayList<Point>();
        list.add(new Point(0,0));
        list.add(new Point(10,10));
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))){
            oos.writeObject(list);
        } catch(Exception e) {
            System.out.println("예외 발생");
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            list = (ArrayList<Point>) ois.readObject();
            System.out.println(list);
        } catch (Exception e) {
            System.out.println("예외 발생");
        }
    }
}

class Point implements Serializable {

    private static final long serialVerisonID = 1L;

    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }


}
