package Practice;

public class Threading extends Thread {
    private final String name;
    Threading(String name){
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

            if(i ==2){
                this.interrupt();
            }

            System.out.println("I am Practice.Threading" + " "+name);

        }


    }

}
