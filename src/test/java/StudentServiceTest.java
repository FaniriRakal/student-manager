import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import student.manager.model.Student;
import student.manager.service.StudentService;
import student.manager.service.StudentServiceImpl;
import student.manager.util.HibernateUtil;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class StudentServiceTest {

    private StudentService studentService;
    public StudentServiceTest() {
        HibernateUtil.init();
        studentService = new StudentServiceImpl();
    }

    @Test
    public void testCreate() {
        Student student = new Student("M10001", "Rakoto Vao", 10);
        Student result = studentService.createStudent("M10001", "Rakoto Vao", 10);
        assertEquals(student.getRegistered(), result.getRegistered());
    }

    @Test
    public void testRead() {
        Student student = studentService.createStudent("M10001", "Rakoto Vao", 10);
        Student result = studentService.getStudentById(student.getId());

        assertEquals(student.getId(), result.getId());
    }

    @Test
    public void testUpdate() {
        Student student = studentService.createStudent("M10001", "Rakoto Vao", 10);
        Student studentUpdated = studentService.updateStudent(student.getId(),"M10002","RANDRIA", 20);
        Student resultUpdate = studentService.getStudentById(student.getId());
        assertEquals(studentUpdated.getRegistered(), resultUpdate.getRegistered());
    }

    @Test
    public void testDelete() {
        Student student = studentService.createStudent("M10001", "Rakoto Vao", 10);
        String token = "dea86ae8-58ea-4310-bde1-59805352dec7_" + student.getId();
        studentService.deleteStudent(student.getId(), token);
        assertNull(studentService.getStudentById(student.getId()));
    }
}
