package student.manager.repository;

import com.google.gson.Gson;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import student.manager.model.Student;
import student.manager.util.LogUtil;

import java.util.ArrayList;
import java.util.List;

import static student.manager.util.HibernateUtil.*;

public class StudentRepositoryImpl implements StudentRepository {
    Gson gson = new Gson();

    @Override
    public Student createStudent(Student student) {
        LogUtil.logRequest("createStudent", gson.toJson(student));
        Transaction transaction = null;
        Session session = createSession();
        try {
            transaction = session.getTransaction();
            transaction.begin();
            session.save(student);
            transaction.commit();
            LogUtil.logResponse("createStudent", "Success");
            return student;
        } catch (Exception e) {
            LogUtil.logError("createStudent", e.getMessage());
            rollback(transaction);
            return null;
        } finally {
            closeSession(session);
        }
    }

    @Override
    public Student getStudentById(int id) {
        LogUtil.logRequest("getStudentById", String.valueOf(id));
        Student student = null;
        Session session = createSession();
        try {
            student = session.get(Student.class, id);
        } catch (Exception e) {
            LogUtil.logError("getStudentById", e.getMessage());
        } finally {
            closeSession(session);
        }
        LogUtil.logResponse("getStudentById", gson.toJson(student));
        return student;
    }


    @Override
    public List<Student> getStudents() {
        Session session = createSession();
        List<Student> students = new ArrayList<>();
        try {
            students = session.createQuery("FROM Student", Student.class).list();
        } catch (HibernateException e) {
            LogUtil.logError("getStudents", e.getMessage());
        } finally {
            session.close();
        }
        LogUtil.logResponse("getStudents", gson.toJson(students));
        return students;
    }

    @Override
    public Student updateStudent(Student student) {
        LogUtil.logRequest("updateStudent", gson.toJson(student));
        Transaction transaction = null;
        Session session = createSession();
        try {
            transaction = session.beginTransaction();
            session.update(student);
            transaction.commit();
            LogUtil.logResponse("updateStudent", "success");
            return student;
        } catch (Exception e) {
            LogUtil.logError("updateStudent", e.getMessage());
            rollback(transaction);
            return null;
        } finally {
            closeSession(session);
        }
    }

    @Override
    public void deleteStudent(Student student) {
        LogUtil.logRequest("deleteStudent", gson.toJson(student));
        Transaction transaction = null;
        Session session = createSession();
        try {
            transaction = session.beginTransaction();
            session.delete(student);
            transaction.commit();
            LogUtil.logRequest("deleteStudent", "success");
        } catch (Exception e) {
            LogUtil.logError("deleteStudent", e.getMessage());
            rollback(transaction);
        } finally {
            closeSession(session);
        }
    }
}
