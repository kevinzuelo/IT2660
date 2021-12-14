import java.util.Scanner;

public class MainMenu {
    public static void main(String[] args) {
        BinarySearchTree newTree = new BinarySearchTree();        
        Scanner sc = new Scanner(System.in);
        boolean mainMenu = true;

        while(mainMenu) {
            System.out.println("Enter:");
            System.out.println("1 to insert a new student's information");
            System.out.println("2 to fetch and output a student's information");
            System.out.println("3 to delete a student's information");
            System.out.println("4 to update a student's information");
            System.out.println("5 to output all the student information in descending order");
            System.out.println("6 to exit the program.");
        
            int input = sc.nextInt();

            switch(input) {
                case 1 : {
                    System.out.println("Enter new student's Name: ");
                    String newName = sc.next();            
                    System.out.println("Enter new student's ID number: ");
                    int newId = sc.nextInt();
                    System.out.println("Enter new student's GPA: ");
                    double newGpa = sc.nextDouble();

                    Listing newListing = new Listing(newName, newId, newGpa);
                    newTree.insert(newListing);
                    System.out.println(newName + " " + "has been added.");
                    break;                
                }

                case 2: {
                    System.out.println("Enter student's name you would like to fetch: ");
                    String newFetch = sc.next();
                    System.out.println(newTree.fetch(newFetch).toString() + "");
                    break; 
                }

                case 3: {
                    System.out.println("Enter student's name you would like to delete: ");
                    String newDelete = sc.next();
                    if(newTree.delete(newDelete))                       
                        System.out.println(newDelete + " " + "has been removed.");
                    break;                    
                }

                case 4: {
                    System.out.println("Enter student's name you would like to update: ");
                    String oldName = sc.next(); 
                    System.out.println("Enter the updated student's Name: ");
                    String newName = sc.next();            
                    System.out.println("Enter the updated student's ID number: ");
                    int newId = sc.nextInt();
                    System.out.println("Enter the updated student's GPA: ");
                    double newGpa = sc.nextDouble(); 

                    Listing newListing = new Listing(newName, newId, newGpa);
                    newTree.update(oldName, newListing);
                    System.out.println(oldName + " " + "has been updated to: " + newName + "");
                    break;                  
                }

                case 5: {
                    newTree.printTree(newTree.getRoot());
                    break;
                }

                case 6: {
                    sc.close();
                    mainMenu = false;
                    System.out.println("Goodbye");
                    break;
                }

                default:    
                    System.out.println("Please enter a valid number.");
            }
        }
    } 
}
