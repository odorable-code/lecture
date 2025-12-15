package exam;

import java.util.*;

public class StudentManager {
    static ArrayList<Student> students = new ArrayList<Student>();
    public static void main(String[] args) {
        Student s1 = new Student(2, 1, 5, "김수현", 95);
        Student s2 = new Student(2, 1, 12, "최민수", 88);
        Student s3 = new Student(1, 3, 2, "이영희", 77);
        addStudent(s1);
        addStudent(s2);
        addStudent(s3);

        System.out.println("검색할 학생 정보 입력");
        Student toFind = readStudentInfo();
        ArrayList<Student> foundStudent = findStudent(toFind);
        for (Student s : foundStudent) {
            System.out.println(s);
        }
        addStudent(toFind);

        System.out.println("삭제할 학생 정보 입력");
        Student toRemove = readStudentInfo();
        removeStudent(toRemove);

        Collections.sort(students);
        System.out.println("=== 정렬 ===");
        for (Student s: students) {
            System.out.println(s);
        }
    }
    static Student readStudentInfo() {
        Scanner scan = new Scanner(System.in);
        int[] choice = new int[4];
        String[] fields = new String[]{ "학년", "반", "번호", "점수" };
        int index = 0;
        while (index < choice.length) {
            try {
                System.out.print(fields[index] + " 입력: ");
                choice[index] = scan.nextInt();
            } catch (InputMismatchException e) {
                System.out.println(fields[index] + "을 잘못 입력했습니다.");
                scan.nextLine();
                continue;
            }
            index++;
        }
        int grade = choice[0];
        int classNum = choice[1];
        int num = choice[2];
        int score = choice[3];
        System.out.print("이름 입력: ");
        String name = scan.next().trim();
        return new Student(grade, classNum, num, name, score);
    }

    static boolean addStudent(Student s) {
        for (Student s1: students) {
            if (s1.equals(s)) {
                return false;
            }
        }
        return students.add(s);
    }

    static boolean removeStudent(Student s) {
        return students.remove(s);
    }

    static ArrayList<Student> findStudent(Student s) {
        ArrayList<Student> found = new ArrayList<Student>();
        for (Student s1 : students) {
            if (s1.equals(s)) {
                found.add(s1);
            }
        }
        return found;
    }
}




