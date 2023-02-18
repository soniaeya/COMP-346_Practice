package Tut1_Processes_Threads;

class ThreadEx1 extends Thread {
    private final String name;

    ThreadEx1(String name) {
        this.name = name;
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("I am " + name);
        }
    }
}