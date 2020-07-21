package concurrency;

class Reasoning extends Thread {
    //set up this class so it can become a valid thread. 
    void distinguish() {
        //print to the console the difference between a thread and a process
        //print out you think will happen if you invoke the run() method of a thread as opposed to the start() method of a thread.
        System.out.println("A process is a program under execution i.e an active program. A thread is a lightweight process that can be managed independently");
        System.out.println("When start() is called, a new process is created, and the code in run is called to run on this thread.  When run() is called directly, no new thread is created, and the code is run from the current process.");
    }

    public void run() {
        distinguish();
    }
}

