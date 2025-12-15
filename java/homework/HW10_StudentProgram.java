package homework;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class HW10_StudentProgram {
    private static ArrayList<Student> students = new ArrayList<Student>();
	public static void main(String[] args) {
		/* 학생의 성적을 관리하는 프로그램을 구현하세요.
		 * - 파일에 저장. 파일에서 불러오기 
		 * 메뉴
		 * 1. 학생 등록
		 *  - 학년, 반, 번호, 이름을 입력받아 등록
		 *  - 학년, 반, 번호가 같은 학생은 등록 못함
		 * 2. 학생 삭제
		 *  - 학년, 반, 번호를 입력받아 삭제
		 * 3. 학생 조회
		 *  - 학년, 반, 번호를 입력받아 조회
		 * 4. 과목 등록
		 *  - 학년, 학기, 과목명을 입력받아 등록
		 *  - 같은 학년, 학기, 과목명을 가진 과목은 등록 못함
		 * 5. 과목 삭제
		 *  - 학년, 학기, 과목명을 입력받아 삭제
		 * 6. 과목 전체 조회
		 * 7. 학생 성적 추가
		 *  - 학생의 학년, 반, 번호를 입력받아 있으면 과목 학년, 학기, 과목명, 성적을 입력받아 추가
		 * 8. 학생 성적 삭제
		 *  - 학생의 학년, 반, 번호를 입력받아 있으면 과목 학년, 학기, 과목명을 입력받아 삭제 
		 * 9. 프로그램 종료 
		 * */
        while (true) {
            Scanner scan = new Scanner(System.in);
            showMenu();
            int choice = 0;
            System.out.print("메뉴 입력: ");
            try {
                choice = scan.nextInt();
            } catch (InputMismatchException e) {
                System.err.println("잘못된 입력입니다");
                e.printStackTrace();
            }

            switch (choice) {
                case 1:
                    addStudent(readStudentInfo());
                    break;
                case 2:
                    removeStudent(readStudentInfo());
                    break;
                case 3:
                    System.out.println("=========학생 목록========");
                    for (Student s : students) {
                        System.out.println(s);
                    }
                    scan.nextLine();
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    break;
            }
        }
	}

    static void showMenu() {
        System.out.println("=======메뉴=======");
        System.out.println("1. 학생 등록");
        System.out.println("2. 학생 삭제");
        System.out.println("3. 학생 조회");
        System.out.println("4. 과목 등록");
        System.out.println("5. 과목 삭제");
        System.out.println("6. 과목 전체 조회");
        System.out.println("7. 학생 성적 추가");
        System.out.println("8. 학생 성적 삭제");
        System.out.println("9. 프로그램 종료");
        System.out.println("==================");
    }
    private static int[] readUserInput(String[] fields) {
        Scanner scan = new Scanner(System.in);
        int[] result = new int[fields.length];
        int i = 0;
        while (i < fields.length) {
            String field = fields[i];
            System.out.print(field + " 입력: ");
            try {
                result[i] = scan.nextInt();
            } catch (InputMismatchException e) {
                System.err.println("잘못된 입력입니다.");
                scan.nextLine(); // 버퍼 비우기
                continue;
            }
            i++;
        }
        return result;
    }
    private static Student readStudentInfo() {
        int[] input = readUserInput(new String[] { "학년", "반", "번호" });
        int grade = input[0];
        int classNum = input[1];
        int num = input[2];
        System.out.print("이름 입력: ");
        String name = new Scanner(System.in).nextLine();
        return new Student(grade, classNum, num, name);
    }

    static boolean addStudent(Student student) {
        if (students.contains(student)) {
            return false;
        }
        return students.add(student);
    }

    static boolean removeStudent(Student student) {
        return students.remove(student);
    }

    static Student findStudent(Student student) {
        int index = students.indexOf(student);
        return index != -1? students.get(index) : null;
    }
}

class Student {
    private int grade;
    private int classNum;
    private int num;
    private String name;

    public Student(int grade, int classNum, int num, String name) {
        this.grade = grade;
        this.classNum = classNum;
        this.num = num;
        this.name = name;
    }

    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        Student student = (Student) object;
        return grade == student.grade && classNum == student.classNum && num == student.num;
    }

    public int hashCode() {
        return java.util.Objects.hash(super.hashCode(), grade, classNum, num);
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getClassNum() {
        return classNum;
    }

    public void setClassNum(int classNum) {
        this.classNum = classNum;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("%d학년 %d반 %d번 - %s", grade, classNum, num, name);
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Subject {
    private int grade;
    private int semester;
    private String name;

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        Subject subject = (Subject) object;
        return grade == subject.grade && semester == subject.semester && java.util.Objects.equals(name, subject.name);
    }

    public int hashCode() {
        return java.util.Objects.hash(super.hashCode(), grade, semester, name);
    }

    public Subject(int grade, int semester, String name) {
        this.grade = grade;
        this.semester = semester;
        this.name = name;
    }
}

class Score {
    private Student student;
    private Subject subject;
    private int value;

    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        Score score = (Score) object;
        return value == score.value && java.util.Objects.equals(student, score.student) && java.util.Objects.equals(subject, score.subject);
    }

    public int hashCode() {
        return java.util.Objects.hash(super.hashCode(), student, subject, value);
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Score(homework.Student student, homework.Subject subject, int value) {
        this.student = student;
        this.subject = subject;
        this.value = value;
    }
}