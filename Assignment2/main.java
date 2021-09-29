package Assignment2;

public class main

{
    public static void main(String[] args)
    {
        DynamicArray studentArray = new DynamicArray();
        studentArray.appendStudent(new Student("John", "260"));
        studentArray.appendStudent(new Student("Timmy", "842"));
        studentArray.appendStudent(new Student("Martin", "654"));
        studentArray.appendStudent(new Student("Seth", "654"));
        studentArray.insertStudent(new Student("Beth", "654"),1);

        studentArray.removeStudent();
        studentArray.removeStudent();
        studentArray.fetchStudent(3);

        studentArray.shrinkArray();
        

        
        studentArray.print();
    }

}
