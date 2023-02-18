package Tut1_Processes_Threads;

class Test1 {
    public static void main(String[] args) {
        ThreadEx1 tr1 = new ThreadEx1("alpha");
        ThreadEx1 tr2 = new ThreadEx1("beta");
        tr1.start(); // Start the first thread
        tr2.start(); // Start the second thread
    }
}