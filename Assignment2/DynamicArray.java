package Assignment2;

import java.util.*;

public class DynamicArray {
    private Student[] students;
    private int size;
    private int capacity;

    public DynamicArray() {
        students = new Student[2];
        size = 0;
        capacity = 2;
    }

    public int getSize() {
        return size;
    }

    public int getCap() {
        return capacity;
    }

    public void growSize(int minimum) {
        Student temp[] = null;

        temp = new Student[size * minimum];
        for (int i = 0; i < capacity; i++) {
            temp[i] = students[i];
        }

        students = temp;
        capacity = capacity * 2;
    }

    public void shrinkSize() {
        Student temp[] = new Student[size];
        for (int i = 0; i < size; i++) {
            temp[i] = students[i];
        }
        students = temp;
        capacity = students.length;
    }

    public Student fetch(int index) {
        return students[index];
    }

    public void append(Student newStudent) {
        if (capacity == size) {
            growSize(2);
        }
        students[size] = newStudent;
        size++;
    }

    public void insert(int index, Student newStudent) {
        if (capacity == size) {
            growSize(2);
        }
        for (int i = size - 1; i >= index; i--) {
            students[i + 1] = students[i];
        }
        students[index] = newStudent;
        size++;
    }

    public void removeAt(int index) {
        if (index >= size || index < 0) {
            System.out.println("Nothing here, try another number !");
        } else {
            for (int i = index; i < size - 1; i++) {
                students[i] = students[i + 1];
            }
            students[size - 1] = null;
            size--;
        }
    }

    public void print() {
        System.out.println("The size of the array is: " + getSize());
        System.out.println("The capacity of the array is: " + getCap());
        for (Student student : this.students)
            System.out.println("Name: " + student.getName() + ", ID: " + student.getId());
    }
}
