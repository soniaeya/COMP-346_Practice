package Practice;

public class Running implements Runnable{

    String name;

    Running(String name){
        this.name = name;
    }
    public void run(){

        for(int i = 0;i<3;i++){

            try {
                Thread.sleep(400);
            }
            catch (InterruptedException e) {
                System.out.println("We've been interrupted: no more messages.");
                return;
            }

            System.out.println("I am Practice.Running" + " "+name);

        }

    }

}
