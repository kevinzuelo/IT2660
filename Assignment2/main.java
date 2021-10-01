package Assignment2;

public class main

{
    public static void main(String[] args) {
        DynamicArray array = new DynamicArray();

        array.append(new Student("John", "260"));
        array.append(new Student("Mary", "872"));
        array.append(new Student("Liam", "127"));
        array.append(new Student("Dylan", "001"));
        array.append(new Student("Monica", "785"));
        array.append(new Student("Carson", "852"));
        array.append(new Student("Justin", "762"));
        array.append(new Student("Sara", "758"));

        array.insert(1, new Student("Lilith", "789"));

        array.removeAt(1);
        array.shrinkSize();
        array.print();

    }

}
