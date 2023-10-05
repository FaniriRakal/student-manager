package student.manager.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Student")
public class Student implements Serializable {
    public Student() {
        super();
    }

    public Student(String registered, String name, int age) {
        this.registered = registered;
        this.name = name;
        this.age = age;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private int id;
    @Column(name = "registered", length = 10)
    private String registered;
    @Column(name = "name", length = 30)
    private String name;
    @Column(name = "age")
    private int age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRegistered() {
        return registered;
    }

    public void setRegistered(String registered) {
        this.registered = registered;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
