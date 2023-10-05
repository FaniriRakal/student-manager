package student.manager.controller;

import student.manager.model.Student;
import student.manager.service.StudentService;
import student.manager.service.StudentServiceImpl;
import student.manager.util.HibernateUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/")
public class StudentServlet extends HttpServlet {
    private StudentService studentService;

    @Override
    public void init() {
        HibernateUtil.init();
        studentService = new StudentServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();
        switch (path) {
            case "/index.s": {
                this.showAllStudents(request);
                request.getRequestDispatcher("showAllStudent.jsp").forward(request, response);
                break;
            }
            case "/add.s": {
                request.setAttribute("student", new Student());
                request.getRequestDispatcher("addStudent.jsp").forward(request, response);
                break;
            }
            case "/edit.s": {
                int id = Integer.parseInt(request.getParameter("id"));
                this.showStudentById(request, id);
                request.getRequestDispatcher("EditStudent.jsp").forward(request, response);
                break;
            }
            case "/confirm.s": {
                int id = Integer.parseInt(request.getParameter("id"));
                this.showStudentById(request, id);
                request.getRequestDispatcher("ConfirmationStudent.jsp").forward(request, response);
                break;
            }
            default:
                this.showAllStudents(request);
                request.getRequestDispatcher("showAllStudent.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        String path = request.getServletPath();
        try {
            switch (path) {
                case "/create.s": {
                    String registered = request.getParameter("registered");
                    String name = request.getParameter("name");
                    int age = Integer.parseInt(request.getParameter("age"));
                    this.studentService.createStudent(registered, name, age);
                    this.showAllStudents(request);
                    request.getRequestDispatcher("showAllStudent.jsp").forward(request, response);
                    break;
                }
                case "/update.s": {
                    int id = Integer.parseInt(request.getParameter("id"));
                    String registered = request.getParameter("registered");
                    String name = request.getParameter("name");
                    int age = Integer.parseInt(request.getParameter("age"));
                    this.studentService.updateStudent(id, registered, name, age);
                    this.showAllStudents(request);
                    request.getRequestDispatcher("showAllStudent.jsp").forward(request, response);
                    break;
                }
                case "/delete.s": {
                    int id = Integer.parseInt(request.getParameter("id"));
                    String csrf = request.getParameter("_csrf");
                    this.studentService.deleteStudent(id, csrf);
                    this.showAllStudents(request);
                    request.getRequestDispatcher("showAllStudent.jsp").forward(request, response);
                    break;
                }
                default:
                    throw new IllegalArgumentException("Unexpected value: " + path);
            }
        } catch (Exception e) {
            // TODO not found
        }
    }


    private void showAllStudents(HttpServletRequest request) {
        List<Student> students = this.studentService.getStudents();
        request.setAttribute("students", students);
        request.setAttribute("studentSize", students.size());
    }

    private void showStudentById(HttpServletRequest request, int id) {
        Student student = this.studentService.getStudentById(id);
        request.setAttribute("student", student);
    }

}
