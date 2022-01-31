import java.util.*;

public class NextGenHelloWorld {

    /**
     * Authors: gouravkhunger and Kushagra-Jain99
     *
     * This code keeps on printing Hello World after printing
     * numbers from 1 to 'time' which is set by the user.
     *
     * The delay between each console output is 1 second
     *
     * The above mentioned is implemented by running input and
     * output tasks on different threads and handling events
     * independent of others.
     **/

    // variables
    private static int time; // time to be taken to print Hello World
    private static String input = "nothing"; // checks what is entered
    private static Thread outputThread, inputThread; // threads for output and input
    private static Scanner ob; // gets inputs
    private static boolean flag = true; // checks if threads should be stopped or continued to run

    public static void main(String[] args) {

        // initialise variables and input timer seconds
        init();

        // output thread handles console outputs
        outputThread = new Thread(
        new Runnable() {
            @Override
            public void run() {

                // continue printing if not stopped
                while (flag) {
                    for (int i = time; i > 0; i--) {
                        if (!flag) break; // if stopped, break loop
                        System.out.println(i);
                        sleep(); // 1 second delay
                    }

                    if (!flag) break; // if stopped, leave prining
                    System.out.println("Hello World!");
                    sleep();
                }

            }
        }
        );

        // input thread handles whether to stop the program or not
        inputThread = new Thread(
        new Runnable() {
            @Override
            public void run() {
                // while not stopped, continue to listen for inputs
                while (flag) {
                    input = ob.nextLine();

                    // if "s" found, break the loop
                    if (input.toLowerCase().equals("s")) {
                        flag = false;
                        break;
                    }
                }
            }
        }
        );

        // start the threads
        inputThread.start();
        outputThread.start();
    }

    // simulate 1 second delay
    public static void sleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }
    }

    // initialise stuff
    static void init() {
        ob = new Scanner(System.in);

        // until a valid integer value is provided for the time
        // keep asking for it
        while (true) {
            try {
                System.out.print("Please Enter the delay duration in Seconds: ");
                time = ob.nextInt();
                if (time < 0) throw new InputMismatchException(); // we don't want negative integers
                break;
            } catch (InputMismatchException e) {
                System.out.println("Not a valid positive integer, try again");
            }
            ob.nextLine();
        }

        // general info
        System.out.println();
        System.out.println("Type 's' without the quotes to stop the program.");
        System.out.println();
    }
}
