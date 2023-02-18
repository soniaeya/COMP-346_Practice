package testAlgorithm;

class Worker extends Thread
{
    public Worker(String n, int i, MutualExclusion s)
    {
        name = n;
        id = i;
        shared = s;
    }

    public void run()
    {
        while (true)
        {
            shared.enteringCS(id);
            System.out.println(name + "is in CS");
            MutualExclusion.criticalSection();
            shared.leavingCS(id);
            System.out.println(name + "is out of CS");
            MutualExclusion.nonCriticalSection();

        }

    }

    private String name;
    private int id;
    private MutualExclusion shared;
}



abstract class MutualExclusion
{
    public static void criticalSection()
    {
        try
        {
            Thread.sleep( (int) (Math.random() * TIME));

        }
        catch (InterruptedException e) {}

    }

    public static void nonCriticalSection()
    {
        try
        {
            Thread.sleep( (int) (Math.random() * TIME));

        }
        catch (InterruptedException e) {}

    }

    public abstract void enteringCS(int t);
    public abstract void leavingCS(int t);
    public static final int TURN_0 = 0;
    public static final int TURN_1 = 1;
    private static final int TIME = 3000;

}


public class testAlgorithm
{
    public static void main (String args[])
    {
        MutualExclusion alg = new Algorithm1();

        Worker first = new Worker("Runner 0", 0, alg);
        Worker second = new Worker("Runner 1", 1, alg);

        first.start();
        second.start();

    }
}



class Algorithm1 extends MutualExclusion
{
    public Algorithm1()
    {
        turn = TURN_0;

    }

    public void enteringCS(int t)
    {
        while (turn !=t )
            Thread.yield();
    }

    public void leavingCS(int t)
    {
        turn = 1 - t;

    }

    private volatile int turn;
}




class Algorithm2 extends MutualExclusion
{
    public Algorithm2()
    {
        flag[0] = false;
        flag[1] = false;
    }

    public void enteringCS(int t)
    {

        int other;
        other = 1 - t;
        flag[t] = true;

        while (flag[other] == true )
            Thread.yield();
    }

    public void leavingCS(int t)
    {
        flag[t] = false;


    }

    private volatile boolean[] flag = new boolean[2];
}



class Algorithm3 extends MutualExclusion
{
    public Algorithm3()
    {
        flag[0] = false;
        flag[1] = false;
        turn = TURN_0;
    }

    public void enteringCS(int t)
    {

        int other;
        other = 1 - t;
        flag[t] = true;
        turn = other;

        while ((flag[other] == true)  && (turn == other))
            Thread.yield();
    }

    public void leavingCS(int t)
    {
        flag[t] = false;


    }

    private volatile int turn;

    private volatile boolean[] flag = new boolean[2];
}


