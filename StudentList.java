
package baitapoop_student_ver1;

import java.util.ArrayList;
import java.util.Iterator;

public class StudentList {
    private ArrayList <Student> studentList;

    public StudentList(ArrayList <Student> studentList) {
        this.studentList = studentList;
    }

    public StudentList() {
        this.studentList = new ArrayList<>();
    }

    public ArrayList<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(ArrayList<Student> studentList) {
        this.studentList = studentList;
    }

    public void addStudent (Student student) {
        studentList.add(student);
    }
    
    public void deleteStudentById(String id) {
        Iterator<Student> iterator = studentList.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getId().equals(id)) {
                iterator.remove();
            }
        }
        System.out.println("Student not found.");
    }
    
    public Student findStudentByID (String id) {
        for (Student student : studentList) {
            if (student.getId().equals(id)) {
                return student;
            }
        }
        return null;
    }
    
    public void displayAllStudent() {
        for (Student student : studentList) {
            student.displayInfo();
            System.out.println();
        }
    }
    
    public Student findTopStudent() {
        Student topStudent = studentList.get(0);
        for (Student student : studentList) {
            if (student.getGpa() > topStudent.getGpa()) {
                topStudent = student;
            }
        }
        return topStudent;
    }
}