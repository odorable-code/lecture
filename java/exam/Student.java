package exam;

import java.util.Objects;

class Student implements Comparable<Student> {
    private int grade;
    private int classNum;
    private int num;
    private String name;
    private int score;

    @Override
    public int compareTo(Student other) {
        if (this.getGrade() != other.getGrade()) {
            return this.getGrade() - other.getGrade();
        }
        if (this.getClassNum() != other.getClassNum()) {
            return  this.getClassNum() - other.getClassNum();
        }
        return this.getNum() - other.getNum();
    }

    public Student(int grade, int classNum, int num, String name, int score) {
        this.grade = grade;
        this.classNum = classNum;
        this.num = num;
        this.name = name;
        this.score = score;
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
    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return grade + "학년 " + classNum + "반 " + num + "번 " + name + " - 점수: " + score;
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


}