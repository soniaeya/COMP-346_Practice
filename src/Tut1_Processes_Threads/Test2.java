package Tut1_Processes_Threads;

class Test2 {
    public static void main(String args[]) {
        Thread tr1,tr2;
        tr1 = new Thread(new ThreadEx2 ("alpha"));
        tr2 = new Thread( new ThreadEx2 ("beta"));
        try{
            tr1.start(); // Start the first thread
            tr2.start(); // Start the second thread
            tr1.join();
            tr2.join();
        } catch (InterruptedException e) {}
        System.out.println("“main finished”");
    }
}