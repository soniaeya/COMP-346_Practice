package Practice;

public class Main {
    public static void main(String[] args) throws InterruptedException{
        Threading ex1 = new Threading("A");
        Threading ex2 = new Threading("B");

        Running run1 = new Running("X");
        Running run2 = new Running("Y");



        ex1.run();
        ex2.run();
        run1.run();









    }
}