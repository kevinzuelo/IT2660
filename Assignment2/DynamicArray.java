package Assignment2;

public class DynamicArray {
    private Student[] studentList;
    private int capacity;
    private int size;

    public DynamicArray()
    {
        studentList = new Student[1];
        capacity = 0;
        size = 1;
    }

    public void appendStudent(Student newStudent)
    {
        if (capacity == studentList.length)
        growArray();
        studentList[capacity] = newStudent;
        capacity++;
    }

    public void insertStudent(Student newStudent, int index)
    {
        if (index == capacity)
        appendStudent(newStudent);

        else
            growArray();
            studentList[index] = newStudent;
            capacity++;

    }

    public void removeStudent()
    {
        if(capacity > 0)
        {
            studentList[capacity - 1] = null;
            capacity--;
        }
    }

    public void removeStudentAt(int index)
    {
        if (capacity > 0)
        {
            for(int i = index; i < capacity; i++)
            {
                studentList[i] = studentList[i + 1];
            }
            studentList[capacity - 1] = null;
            capacity--;
        }
    }

    public Student fetchStudent(int index)
    {
            return studentList[index];  
    }

    private void growArray()
    {
        Student[] tempArray = new Student[studentList.length * 2];
        for(int i = 0; i < capacity;i++)
        {
            tempArray[i] = studentList[i];
        }
        studentList = tempArray;
    }

    public void shrinkArray()
    {
        Student[] tempArray = null;
        if (capacity > 0)
            tempArray = new Student[capacity];
        for(int i = 0 ; i < capacity;i++)
        {
            tempArray[i] = studentList[i];
        }
        size = capacity;
         
    }

    public void print() {
        for (Student student: this.studentList) {
            System.out.println(student.getName() + ", " + student.getId());
        }
    }
}
