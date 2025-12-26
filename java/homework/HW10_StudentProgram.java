package homework;

import java.util.*;

interface Managable {
    public boolean addStudent(Student student);
    public boolean removeStudent(Student student);
    public Student findStudent(Student student);
    public boolean addSubject(Subject subject);
    public boolean removeSubject(Subject subject);
    public void showAllSubject();
    public boolean registerScore(SubjectScore subjectScore);
    public boolean unregisterScore(SubjectScore subjectScore);
}

public class HW10_StudentProgram implements Managable {
    private ArrayList<Student> students;
    private ArrayList<Subject> subjects;
    private ArrayList<SubjectScore> subjectScores;

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
        HW10_StudentProgram program = new HW10_StudentProgram();

        while (true) {
            Student student = null;
            Subject subject = null;
            SubjectScore subjectScore = null;
            switch (program.chooseMenu()) {
                case 1:
                    student = Student.newStudentFromInput();
                    if (program.addStudent(student)) {
                        System.out.println("\"" + student + "\" 등록되었습니다.");
                        program.pause();
                    } else {
                        System.out.println("이미 등록된 학생입니다.");
                        program.pause();
                    }
                    break;
                case 2:
                    student = Student.newStudentWithoutNameFromInput();
                    if (program.removeStudent(student)) {
                        System.out.println("\"" + student + "\" 삭제되었습니다.");
                        program.pause();
                    } else {
                        System.out.println("삭제되지 않았습니다.");
                        program.pause();
                    }
                    break;
                case 3:
                    student = program.findStudent(Student.newStudentWithoutNameFromInput());
                    System.out.println("=========학생조회==========");
                    System.out.println(student);
                    System.out.println("=========================");
                    program.pause();
                    break;
                case 4:
                    subject = Subject.newSubjectFromInput();
                    if (program.addSubject(subject)) {
                        System.out.println(subject + "\n과목이 추가됐습니다.");
                        program.pause();
                    }
                    break;
                case 5:
                    subject = Subject.newSubjectFromInput();
                    if (program.removeSubject(subject)) {
                        System.out.println(subject + "\n과목이 삭제됐습니다.");
                        program.pause();
                    }
                    break;
                case 6:
                    program.showAllSubject();
                    program.pause();
                    break;
                case 7:
                    student = Student.newStudentWithoutNameFromInput();
                    if (!program.students.contains(student)) {
                        System.out.println("존재하지 않는 학생입니다.");
                        program.pause();
                        break;
                    }
                    subject = Subject.newSubjectFromInput();
                    if (!program.subjects.contains(subject)) {
                        System.out.println("존재하지 않는 과목입니다.");
                        program.pause();
                        break;
                    }
                    String[] in = Utils.readUserInput(new String[] { "성적" });
                    int scoreValue = Integer.parseInt(in[0]);
                    subjectScore = new SubjectScore(subject.getGrade(),
                                                    subject.getSemester(),
                                                    subject.getName(),
                                                    scoreValue);
                    if (program.registerScore(subjectScore)) {
                        System.out.println(subjectScore + " 추가됨");
                        program.pause();
                    }
                  break;
                case 8:
                    subject = Subject.newSubjectFromInput();
                    subjectScore = new SubjectScore(subject.getGrade(),
                                                    subject.getSemester(),
                                                    subject.getName(),
                                                    0.0);
                    if (program.unregisterScore(subjectScore)) {
                        System.out.println("제거됨");
                        program.pause();
                    };
                    break;
                case 9:
                    program.exit();
                    break;
            }
        }
	}
    public HW10_StudentProgram() {
        students = new ArrayList<Student>();
        subjects = new ArrayList<Subject>();
        subjectScores = new ArrayList<SubjectScore>();
    }

    public int chooseMenu() {
        int choice = 0;
        Scanner scan = new Scanner(System.in);
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
        System.out.print("메뉴 입력: ");
        try {
            choice = scan.nextInt();
        } catch (InputMismatchException e) {
            System.err.println("잘못된 입력입니다");
            e.printStackTrace();
        }
        return choice;
    }

    public void pause() {
        System.out.println("계속하려면 엔터를 누르세요.");
        new Scanner(System.in).nextLine();
    }

    public void exit() {
        System.out.println("시스템 종료");
    }

    @Override
    public boolean addStudent(Student student) {
        if (students.contains(student)) {
            return false;
        }
        return students.add(student);
    }

    @Override
     public boolean removeStudent(Student student) {
        return students.remove(student);
    }

    @Override
    public Student findStudent(Student student) {
        int index = students.indexOf(student);
        return index != -1? students.get(index) : null;
    }

    @Override
    public boolean addSubject(Subject subject) {
        if (subjects.contains(subject)) {
            return false;
        }
        return subjects.add(subject);
    }

    @Override
    public boolean removeSubject(Subject subject) {
        return subjects.remove(subject);
    }

    @Override
    public void showAllSubject() {
        for (Subject s : subjects) {
            System.out.println(s);
        }
    }

    @Override
    public boolean unregisterScore(SubjectScore subjectScore) {
        return subjectScores.remove(subjectScore);
    }

    @Override
    public boolean registerScore(SubjectScore subjectScore) {
        if (subjectScores.contains(subjectScore)) {
            return false;
        }
        return subjectScores.add(subjectScore);
    }
}

class Student {
    private int grade;
    private int classNum;
    private int num;
    private String name;
    private List<SubjectScore> subjectScores;

    public Student(int grade, int classNum, int num, String name) {
        this.grade = grade;
        this.classNum = classNum;
        this.num = num;
        this.name = name;
        this.subjectScores = new ArrayList<>();
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

    public void setName(String name) { this.name = name; }

    public List<SubjectScore> getSubjectScores() {
        return subjectScores;
    }

    public void setSubjectScores(List<SubjectScore> subjectScores) {
        this.subjectScores = subjectScores;
    }

    @Override
    public String toString() {
        return String.format("%d학년 %d반 %d번 %s", grade, classNum, num, name);
    }

    public void printScore() {
        System.out.println("====================");
        System.out.printf("%s 성적\n", this.toString(), name);
        System.out.println("====================");
        for (SubjectScore s : subjectScores) {
            Subject subject = s.getSubject();
            double score = s.getScore();
            System.out.printf("%s %f\n", subject.toString(), score);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return grade == student.grade && classNum == student.classNum && num == student.num;
    }

    @Override
    public int hashCode() {
        return Objects.hash(grade, classNum, num);
    }

    public static Student newStudentFromInput() {
        String[] input = Utils.readUserInput(new String[] { "학년", "반", "번호" });
        int grade = Integer.parseInt(input[0]);
        int classNum = Integer.parseInt(input[1]);
        int num = Integer.parseInt(input[2]);
        System.out.print("이름 입력: ");
        String name = new Scanner(System.in).nextLine().trim();
        return new Student(grade, classNum, num, name);
    }
    public static Student newStudentWithoutNameFromInput() {
        String[] input = Utils.readUserInput(new String[] { "학년", "반", "번호" });
        int grade = Integer.parseInt(input[0]);
        int classNum = Integer.parseInt(input[1]);
        int num = Integer.parseInt(input[2]);
        return new Student(grade, classNum, num,"");
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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Subject subject = (Subject) o;
        return grade == subject.grade && semester == subject.semester && Objects.equals(name, subject.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(grade, semester, name);
    }

    @Override
    public String toString() {
        return String.format("%d학년 %d학기 - %s", grade, semester, name);
    }

    public Subject(int grade, int semester, String name) {
        this.grade = grade;
        this.semester = semester;
        this.name = name;
    }
   		/* * 4. 과목 등록
		 *  - 학년, 학기, 과목명을 입력받아 등록
		 *  - 같은 학년, 학기, 과목명을 가진 과목은 등록 못함  */
    public static Subject newSubjectFromInput() {
        String[] input = Utils.readUserInput(new String[] { "학년", "학기", "과목" });
        int grade = Integer.parseInt(input[0]);
        int semester = Integer.parseInt(input[1]);
        String name = input[2];
        return new Subject(grade, semester, name);
    }
}

class SubjectScore {
    private Subject subject;
    private double score;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        SubjectScore subjectScore = (SubjectScore) o;
        return Objects.equals(subject, subjectScore.subject);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subject);
    }

    @Override
    public String toString() {
        return String.format("%s\n점수: %f", subject, score);
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public SubjectScore(int grade, int semester, String name, double score) {
        this.subject = new Subject(grade, semester, name);
        this.score = score;
    }
}

class Utils {
    public static String[] readUserInput(String[] fields) {
        Scanner scan = new Scanner(System.in);
        String[] result = new String[fields.length];
        int i = 0;
        while (i < fields.length) {
            String field = fields[i];
            System.out.print(field + " 입력: ");
            try {
                result[i] = scan.next().trim();
            } catch (InputMismatchException e) {
                System.err.println("잘못된 입력입니다.");
                scan.nextLine(); // 버퍼 비우기
                continue;
            }
            i++;
        }
        return result;
    }
}