public class javaReview
{
    public static class Car
    {
        private Engine engine = new Engine();
        
        public void start()
        {
            Phone.connect();
            
            engine.combust();
            
            System.out.print("Car Started\n\n");
        }
    }
    public static class Engine
    {
        public void combust()
        {
           System.out.print("Engine on\n");
        }
    }
    public static class Phone
    {
        static void connect()
        {
            System.out.print("Phone Connected\n");
        }
    }
    public static void main(String args[])
    {        
        Car mustang = new Car();
        
        Phone android = new Phone();
        
        mustang.start();
        
        System.out.println("Bye");
    }
}