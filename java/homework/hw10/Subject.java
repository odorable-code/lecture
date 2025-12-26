package homework.hw10;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class Subject {

	//학년(grade), 학기(semeter), 과목명(name)을 필드로 선언하세요. 
	private int grade, semester;
	private String name;
	
	//grade, semester, name의 getter와 setter를 추가
	
	
	//toString 오버라이딩해서 1학년 1학기 국어 형태의 문자열이
	//반환되도록 작성하세요. 
	@Override
	public String toString() {
		return grade + "학년 " + semester + "학기 " + name;
	}

	//학년, 학기, 이름를 이용한 생성자를 추가하세요. 
	public Subject(int grade, int semester, String name) {
		this.grade = grade;
		this.semester = semester;
		this.name = name;
	}

    // equals 오버라이딩 학년, 학기, 과목명이 같으면 같은 객체로 판별
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
//        if (getClass() != obj.getClass()) {
//            return false;
//        }
        if (obj instanceof SubjectScore) {
            SubjectScore ss = (SubjectScore) obj;
            return this.equals(ss.getSubject());
        }
        Subject other = (Subject) obj;
        return this.grade == other.grade
                && this.semester == other.semester
                && Objects.equals(name, other.name);
    }

}







