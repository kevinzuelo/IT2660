public class Listing {
    private int value;
    private boolean pushed;

    public Listing(int value) {
        this.value = value; 
    }

    public Listing deepCopy() {
        Listing clone = new Listing(value);
        return clone;
    }

    public int getValue() {
        return this.value;
    }

    public boolean getPushed() {
        return pushed;
    }

    public void setPushed(boolean value) {
        pushed = value;
    }

    public void visit() {
        System.out.println(this.value);
    }
}