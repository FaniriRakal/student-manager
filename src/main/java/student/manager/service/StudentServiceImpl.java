package student.manager.service;

import student.manager.model.Student;
import student.manager.repository.StudentRepository;
import student.manager.repository.StudentRepositoryImpl;
import student.manager.util.LogUtil;

import java.util.List;

public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl() {
        this.studentRepository = new StudentRepositoryImpl();
    }


    @Override
    public Student createStudent(String registered, String name, int age) {
        Student student = new Student(registered, name, age);
        return this.studentRepository.createStudent(student);
    }

    @Override
    public Student getStudentById(int id) {
        return studentRepository.getStudentById(id);
    }

    @Override
    public List<Student> getStudents() {
        return this.studentRepository.getStudents();
    }

    @Override
    public Student updateStudent(int id, String registered, String name, int age) {
        Student student = this.getStudentById(id);
        student.setRegistered(registered);
        student.setName(name);
        student.setAge(age);
        return this.studentRepository.updateStudent(student);
    }


    @Override
    public void deleteStudent(int id, String csrfField) {
        String token = "dea86ae8-58ea-4310-bde1-59805352dec7_" + id;
        if (token.equals(csrfField)) {
            Student student = this.getStudentById(id);
            this.studentRepository.deleteStudent(student);
        } else {
            LogUtil.logError("StudentServiceImpl.deleteStudent", "Token Error");
        }
    }


}
