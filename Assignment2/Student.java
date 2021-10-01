package Assignment2;

import javax.swing.JOptionPane;

public class Student {
    private String name;
    private String studentId;

    public String getName() {
        return this.name;
    }

    public String getId() {
        return this.studentId;
    }

    public Student(String name, String studentId) {
        this.name = name;
        this.studentId = studentId;
    }
}
