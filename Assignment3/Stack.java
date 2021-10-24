import java.util.*;

import Assignment2.main;

public class Stack <E> {
    private int stackSize;
    private int top;
    private E[] stackArray;

    public Stack(int size) {
        this.stackSize = size;
        this.stackArray = (E[]) new Object[stackSize];
        this.top = -1;
    }

    public void push(E item) {
        if(this.isFull()) {
            this.ensureSize();
        }
        System.out.println("Adding: " + item);
        this.stackArray[++top] = item;
        getSize();
    }
    
    public E pop() {  
        if(stackSize != top) {
            stackSize = top;
        } 
        E item = this.stackArray[top--];
        System.out.println("Removed: " + item);
        getSize();
        return item; 
    }

    public E peek() {
        return stackArray[top];
    }

    public boolean isFull() {
        return (top == stackSize -1);
    }

    public void ensureSize() {
        E[] temp = (E[]) new Object[this.stackSize * 2];
        for(int i= 0; i <stackSize; i++){
            temp[i] = this.stackArray[i];
        }
        this.stackArray = temp;
        this.stackSize = this.stackSize*2;        
    }

    public void getSize() {
        System.out.println("Size of the stack is currently: " + top);
        System.out.println("Length of the stack is currently: " + stackSize);
    }

    public static void main(String[] args) {
        Stack<String> stringStack = new Stack<String>(2);
        stringStack.push("first");
        stringStack.push("banana");
        stringStack.push("flower");
        stringStack.push("cup");
        stringStack.push("glasses");

        stringStack.pop();
        stringStack.pop();

        Stack<Integer> intStack = new Stack<Integer>(2);
        intStack.push(100);
        intStack.push(200);
        intStack.push(300);
        intStack.push(400);
        intStack.push(500);

        intStack.pop();
        intStack.pop();
    }
}
