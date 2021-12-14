public class Listing {
    private String name;
    private int idNumber;
    private double gpa;

    public Listing(String key, int id, double average) {
        this.name = key;
        this.idNumber = id;
        this.gpa = average;
    }

    public String toString() {
        return("Name: " + name +
        "\nID Number: " + this.idNumber + 
        "\nGPA: " + this.gpa);
    }

    public Listing deepCopy() {
        Listing clone = new Listing(name, idNumber, gpa);
        return clone;
    }

    public int compareTo(String targetKey) {
        return(name.compareTo(targetKey));
    }

    public String getKey() {
        return this.name;
    }
}