package student.manager.repository;

import student.manager.model.Student;

import java.util.List;

public interface StudentRepository {
    Student createStudent(Student student);
    Student getStudentById(int id);
    List<Student> getStudents();
    Student updateStudent(Student student);
    void deleteStudent(Student student);
}
