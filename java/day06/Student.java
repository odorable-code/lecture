package day06;

import java.util.Comparator;
import java.util.Objects;

public class Student implements Comparator<Student>, Comparable<Student> {
    private int grade, classNum, num;
    private String name;

    public Student(int grade, int classNum, int num, String name) {
        this.grade = grade;
        this.classNum = classNum;
        this.num = num;
        this.name = name;
    }

    @Override
    public String toString() {
        return grade + "학년 " + classNum + "반 " + num + "번 " + name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return grade == student.grade && classNum == student.classNum && num == student.num && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(grade, classNum, num, name);
    }

    public int getGrade() {
        return grade;
    }

    public int getClassNum() {
        return classNum;
    }

    public int getNum() {
        return num;
    }

    public String getName() {
        return name;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public void setClassNum(int classNum) {
        this.classNum = classNum;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compare(Student o1, Student o2) {
        if (o1.getGrade() != o2.getGrade()) {
            return o1.getGrade() - o2.getGrade();
        }
        if (o1.getClassNum() != o2.getClassNum()) {
            return  o1.getClassNum() - o2.getClassNum();
        }
        return o1.getNum() - o2.getNum();
    }

    @Override
    public int compareTo(Student o) {
        if (this.getGrade() != o.getGrade()) {
            return this.getGrade() - o.getGrade();
        }
        if (this.getClassNum() != o.getClassNum()) {
            return  this.getClassNum() - o.getClassNum();
        }
        return this.getNum() - o.getNum();
    }
}
