package student.manager.service;

import student.manager.model.Student;

import java.util.List;

public interface StudentService {
    Student createStudent(String registered, String name, int age);

    Student getStudentById(int id);

    List<Student> getStudents();

    Student updateStudent(int id, String registered, String name, int age);

    void deleteStudent(int id, String csrfField);

}
