package concurrency;

import java.util.ArrayList;
import java.util.List;

class TeamTC1 implements Runnable {

    List<String> team = new ArrayList<>();
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

    public void run() {

        try {
            System.out.println(ANSI_RED + "Emilios" + ANSI_RESET);
            Thread.sleep(1000);
            team.add("Emilios");

            System.out.println(ANSI_BLUE + "Abigail"+ ANSI_RESET);
            Thread.sleep(1000);
            team.add("Abigail");

            System.out.println(ANSI_PURPLE + "Adam" + ANSI_RESET);
            Thread.sleep(1000);
            team.add("Adam");

            System.out.println(ANSI_YELLOW + "Christian" + ANSI_RESET);
            Thread.sleep(1000);
            team.add("Cristian");

            System.out.println(ANSI_GREEN + "Devon" + ANSI_RESET);
            Thread.sleep(1000);
            team.add("Devon");

            System.out.println(ANSI_WHITE_BACKGROUND + ANSI_BLACK + "Gabe" + ANSI_RESET);
            Thread.sleep(1000);
            team.add("Gabe");

            System.out.println(ANSI_PURPLE_BACKGROUND + "Monica" + ANSI_RESET);
            Thread.sleep(1000);
            team.add("Monica");

            System.out.println(ANSI_GREEN_BACKGROUND + "Jose" + ANSI_RESET);
            Thread.sleep(1000);
            team.add("Jose");

            System.out.println(ANSI_YELLOW_BACKGROUND + "Michael" + ANSI_RESET);
            Thread.sleep(1000);
            team.add("Michael");

            System.out.println(ANSI_CYAN_BACKGROUND + "Marcelo" + ANSI_RESET);
            Thread.sleep(1000);
            team.add("Marcelo");

            System.out.println(ANSI_RED_BACKGROUND + "Julian" + ANSI_RESET);
            Thread.sleep(1000);
            team.add("Julian");

        } catch(Throwable e) {
            System.out.println(e.getMessage());
        }

        team.stream().forEach(t -> System.out.println(t));

    }

    //This thread should be created by implementing the Runnable interface, NOT by extending the Thread class.  In the run method of this thread, print out the name of each student in your TA group, (starting with your TA).  There should be a pause of 1 second before each name is printed to the console.The name should then be pushed to the team List  After all the names have been pushed to this List, print out the entire list of all the students in your TA group. Don't forget your TA as well!  All of these steps should be done whenever the thread is started.  (i.e. it can be done directly in the run()method of the thread itself).  Kick off the thread in the Main class of the concurrency package.  
}