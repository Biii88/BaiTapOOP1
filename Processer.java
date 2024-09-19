package baitapoop_student_ver1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Processer  {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentList studentList = new StudentList();

        while (true) {
            System.out.println("1. Add a new student");
            System.out.println("2. Update a student by ID");
            System.out.println("3. Delete a student by ID");
            System.out.println("4. Display all students");
            System.out.println("5. Find the student with the highest GPA");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.print("ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Full name: ");
                    String fullName = scanner.nextLine();
                    System.out.print("Date of birth (dd/MM/yyyy): ");
                    Date dateOfBirth;
                    try {
                        dateOfBirth = sdf.parse(scanner.nextLine());
                    } catch (ParseException e) {
                        System.out.println("Invalid date format. Please use dd/MM/yyyy.");
                        continue;
                    }
                    System.out.print("GPA: ");
                    float GPA;
                    try {
                        GPA = Float.parseFloat(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid GPA format.");
                        continue;
                    }
                    System.out.print("Major: ");
                    String major = scanner.nextLine();
                    
                    Student student = new Student(id, fullName, dateOfBirth, GPA, major);
                    studentList.addStudent(student);
                    System.out.println("Student added successfully.");
                    break;

                case 2:
                    System.out.print("Enter ID of the student to update: ");
                    String updateId = scanner.nextLine();
                    Student existingStudent = studentList.findStudentByID(updateId);
                    if (existingStudent == null) {
                        System.out.println("Student not found.");
                        break;
                    }
                    System.out.print("Enter new Name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter new Date of birth (dd/MM/yyyy): ");
                    try {
                        Date newDateOfBirth = sdf.parse(scanner.nextLine());
                        existingStudent.setDateOfBirth(newDateOfBirth);
                    } catch (ParseException e) {
                        System.out.println("Invalid date format. Please use dd/MM/yyyy.");
                        continue;
                    }
                    System.out.print("Enter new GPA: ");
                    float newGPA;
                    try {
                        newGPA = Float.parseFloat(scanner.nextLine());
                        existingStudent.setGpa(newGPA);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid GPA format.");
                        continue;
                    }
                    System.out.print("Enter new Major: ");
                    String newMajor = scanner.nextLine();
                    existingStudent.setMajor(newMajor);
                    System.out.println("Student updated successfully.");
                    break;

                case 3:
                    System.out.print("Enter ID of the student to delete: ");
                    String deleteId = scanner.nextLine();
                    studentList.deleteStudentById(deleteId);
                    System.out.println("Student deleted successfully.");
                    break;

                case 4:
                    studentList.displayAllStudent();
                    break;

                case 5:
                    Student topStudent = studentList.findTopStudent();
                    if (topStudent != null) {
                        System.out.println("Top Student:");
                        topStudent.displayInfo();
                    } else {
                        System.out.println("No students available.");
                    }
                    break;

                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }      
}