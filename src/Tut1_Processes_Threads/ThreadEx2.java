package Tut1_Processes_Threads;


class ThreadEx2 implements Runnable {
    private String name;

    ThreadEx2(String name) {
        this.name = name;
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("I am " + name);
        }
    }
}