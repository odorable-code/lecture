package homework.hw10;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringJoiner;

public class HW10_StudentProgram {

	private static Scanner scan = new Scanner(System.in);
	
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
		int menu = 0;
		final int EXIT = 9;
		//학생 정보를 관리하는 리스트 
		List<Student> students = new ArrayList<Student>();
		List<Subject> subjects = new ArrayList<Subject>();

		do {
			//메뉴 출력
			printMenu();
			menu = scan.nextInt();
			switch(menu) {
			case 1:	
				addStudent2(students);
				break;
			case 2:
				removeStudent(students);
				break;
			case 3: 
				searchStudent2(students);
				break;
			case 4:
                addSubject2(subjects);
                break;
			case 5:
                removeSubject(subjects);
                break;
			case 6:
                printSubjects(subjects);
                break;
			case 7:
                addSubjectScore(students, subjects);
                break;

			case 8:
                removeSubjectScore(students, subjects);
			break;
			case EXIT: 
				exit();
				break;
			default:
				
			}
		} while(menu != EXIT);
	}

    private static void removeSubjectScore(List<Student> students, List<Subject> subjects) {
        Student student = inputSubject(false);

    }

    private static void addSubjectScore(List<Student> students, List<Subject> subjects) {
        //성적을 추가할 학생의 학년, 반, 번호를 입력
        Student student = inputStudent(false);

        //학생이 없으면 일치하는 학생이 없습니다 출력 후 종료
        //List의 indexOf 활용
        int index = students.indexOf(student);
        if(index < 0) {
            printinfo("일치하는 학생이 없습니다.");
            return;
        }

        //과목 성적 정보를 입력(학년, 학기, 과목명, 성적)
        Subject subject = inputSubject();
        System.out.print("성적 : ");
        int score = scan.nextInt();

        //기존 코드에 추가작업 없이 과목 성적을 추가
        //0학년 0학기로 한 이유는 subject.getGrade로 학년을 넣어주면 되는데
        //그러면 코드가 길어져서 간단히 하기위해 0학년으로 대체
        SubjectScore subjectScore =
                new SubjectScore(0, 0, "", score);
        subjectScore.setSubject(subject);

        //아래 코드는 생성자를 추가해서 위 코드 대신 사용할 수 있음
        //SubjectScore subjectScore = new SubjectScore(subject, score);

        //없는 과목이면 등록되지 않은 과목입니다를 출력후 종료
        if(!subjects.contains(subject)) {
            printinfo("등록되지 않은 과목입니다.");
            return;
        }

        // 학생 정보에 성적을 추가해서 성공하면
        // 성적을 추가했습니다.
        // 입력한 학생정보를 학생목록에서 가져와야 함
        Student selectedStudent = students.get(index);
        List<SubjectScore> ss = selectedStudent.getList();
        if (ss.add(subjectScore)) {
            printinfo("성적을 추가했습니다.");
        } else {
            index = ss.indexOf(subjectScore);
            ss.get(index).setScore(subjectScore.getScore());
            printinfo("성적을 수정했습니다.");
        }

        // 실패하면 성적을 수정했습니다를 출력
        // 실패 => 새로운 추가 실패 => 기존 성적을 수정


    }

    private static void removeSubject(List<Subject> subjects) {
        // 학년, 학기, 과목명을 입력
        Subject subject = inputSubject();
        // 일치하는 정보가 있으면 삭제후 알림 (과목이 삭제 되었습니다.)
        // 없으면 알림 (일치하는 과목이 없습니다)
        if (subjects.remove(subject)){
            printinfo("과목 정보를 삭제했습니다.");
            return;
        }
        //있으면 list에서 학생 정보가 있는 번지의 객체를 제거1
        printinfo("일치하는 과목이 없습니다.");

    }

    //Student클래스의 equals를 활용
	private static void removeStudent(List<Student> students) {
		//학생 정보를 입력받아 학생 객체를 생성
		Student student = inputStudent(false);
		
		//list에 학생 객체가 몇번지에 있는지 확인
		int index = students.indexOf(student);
		//학생 정보가 없으면 일치하는 학생이 없습니다. 안내문구 출력후 종료
		if(index < 0) {
			printinfo("일치하는 학생이 없습니다.");
			return;
		}
		//학생을 삭제했습니다를 출력
		students.remove(index);
		printinfo("학생 정보를 삭제했습니다.");
	}

    private static void printSubjects(List<Subject> subjects) {
        if (subjects.isEmpty()) {
            printinfo("등록된 과목이 없습니다.");
        }
        System.out.println("====================");
        for (Subject s : subjects) {
            System.out.println(s);
        }
        System.out.println("====================");
    }

    private static void printinfo(String str) {
        System.out.println("====================");
        System.out.println(str);
        System.out.println("====================");
    }
	//학생을 조회하는데 equals를 이용 안함
	private static void searchStudent(List<Student> list) {
		//학년, 반, 번호를 입력받아 학생 객체를 생성. inputStudent 활용
		Student student = inputStudent(false);
		
		boolean isFind = false;
		//반복문을 통해서
		for(Student tmp : list) {
			//tmp의 학년, 반, 번호가 student의 학년,반,번호와 같으면 
			if( tmp.getGrade() == student.getGrade() 
				&& tmp.getClassNum() == student.getClassNum() 
				&& tmp.getNum() == student.getNum()) {
				//학생 정보 tmp를 출력
				tmp.printScore();
				isFind = true;
			}
		}
		//일치하는 학생이 없는 경우
		if(!isFind) {
			printinfo("일치하는 학생이 없습니다.");
		}
		
	}
	
	//searchStudent는 equals를 이용하지 않음.
	//searchStudent2는 Student 클래스의 equals를 오버라이딩하여 이용
	private static void searchStudent2(List<Student> list) {
		//학년, 반, 번호를 입력받아 학생 객체를 생성. inputStudent 활용
		Student student = inputStudent(false);
		
		int index = list.indexOf(student);
		//일치하는 학생이 없는 경우
		if(index < 0) {
			printinfo("일치하는 학생이 없습니다.");
			return;
		}
		//있으면 학생 정보(성적을 포함한)를 출력
		//list.get(index).printScore();
		Student tmp = list.get(index);
		tmp.printScore();
		
	}

	private static Student inputStudent(boolean isName) {
		//학년, 반, 번호, 이름을 scan를 이용하여 입력 받음 
		System.out.println("학생 정보를 입력하세요.");
		System.out.print("학년 : ");
		int grade = scan.nextInt();
		System.out.print("반  : ");
		int classNum = scan.nextInt();
		System.out.print("번호 : ");
		int num = scan.nextInt();

		String name = null;
		//이름까지 입력을 받아야 하면 
		if(isName) {
			System.out.print("이름 : ");
			name = scan.next();
			
		}
		return new Student(grade, classNum, num, name);
	}
	
	//학생 정보 입력받은 후 학생 추가 
	private static void addStudent(List<Student> list) {
		//학년, 반, 번호, 이름을 scan를 이용하여 입력 받음 
//		System.out.println("학생 정보를 입력하세요.");
//		System.out.print("학년 : ");
//		int grade = scan.nextInt();
//		System.out.print("반  : ");
//		int classNum = scan.nextInt();
//		System.out.print("번호 : ");
//		int num = scan.nextInt();
//		System.out.print("이름 : ");
//		String name = scan.next();
		
		//학년, 반, 번호, 이름을 이용하여 학생 객체를 생성
		//new를 통해 인스턴스를 생성한 후 객체에 저장 
		//A a = new ~~~
		Student stduent = inputStudent(true);
		
		//리스트에 학생 객체를 추가 
		//list.add를 이용
		list.add(stduent);
		
		//학생을 추가했습니다라고 콘솔에 출력
		printinfo("학생을 추가했습니다.");

		System.out.println(list);
	}
	//Student 클래스의 equals를 이용, 중복 학생 처리
	private static void addStudent2(List<Student> list) {
		//학년, 반, 번호, 이름을 scan를 이용하여 입력 받음 
		Student stduent = inputStudent(true);
		
		//등록된 학생인지 확인
		//학생 정보가 학생 리스트에서 몇번지에 있는지 확인
		int index = list.indexOf(stduent);
		//있는 학생이면 이미 등록된 학생입니다라고 출력 후 종료
		if(index >= 0) {
            printinfo("이미 등록된 학생입니다.");
			return;
		}
		
		//리스트에 학생 객체를 추가 
		list.add(stduent);

		//학생을 추가했습니다라고 콘솔에 출력
		printinfo("학생을 추가했습니다.");

		System.out.println(list);
	}

    // 학년, 학기, 과목명을 입력받아 객체를 반환하는 메서드
    private static Subject inputSubject() {
        System.out.println("==================");
        System.out.println("과목 정보를 입력하세요.");
        System.out.println("학년 : ");
        int grade = scan.nextInt();
        System.out.println("학기 : ");
        int semester = scan.nextInt();
        System.out.println("과목명 : ");
        String name = scan.next();
        System.out.println("==================");
        return new Subject(grade, semester, name);
    }

    private static Subject getSubjectBySubject(List<Subject> subjects, Subject subject) {
        int index = subjects.indexOf(subject);
        if (index < 0) {
            return  null;
        }
        return subjects.get(index);
    }

    // 중복 과목 체크 안함. Subject 클래스에 equals를 오버라이딩 하기 전
    private static void addSubject(List<Subject> subjects) {

        Subject subject = inputSubject();

        if(subjects.contains(subject)) {
            printinfo("이미 등록된 과복입니다.");
        }
        // 과목을 과목 목록에 추가
        subjects.add(subject);

        // 알림 문구를 등록
        printinfo("과목을 추가했습니다.");
        System.out.println(subjects);
    }
    // 중복 과목 체크 함. Subject 클래스에 equals를 오버라이딩 해서
	private static void addSubject2(List<Subject> subjects) {

        Subject subject = inputSubject();

        // 과목을 과목 목록에 추가
        subjects.add(subject);

        // 알림 문구를 등록
        printinfo("과목을 추가했습니다.");
        System.out.println(subjects);
    }
	//프로그램 종료
	private static void exit() {
		//프로그램을 종료합니다라고 출력
		printinfo("프로그램을 종료합니다.");
	}
	
	private static void printMenu() {
		System.out.println("메뉴");
		System.out.println("1. 학생 등록");
		System.out.println("2. 학생 삭제");
		System.out.println("3. 학생 조회");
		System.out.println("4. 과목 등록");
		System.out.println("5. 과목 삭제");
		System.out.println("6. 과목 전체 조회");
		System.out.println("7. 학생 성적 추가");
		System.out.println("8. 학생 성적 삭제");
		System.out.println("9. 종료");
		System.out.print("메뉴 선택 : ");
	}
}







