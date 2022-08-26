package go_it_hw.hw_12.task_1;

/**
 * @author Nazarii Soviak
 */

public class SecondsPrinter {
    private static int point = 1;

    public static void main(String[] args) {
        Runnable second = new Runnable() {
            @Override
            public void run() {
                while (!Thread.currentThread().isInterrupted()) {
                    System.out.println(point + " one second has passed since the program has been initiated!");
                    try {
                        Thread.sleep(1000);
                    }catch (InterruptedException ex) {
                        ex.getMessage();
                    }
                    point++;
                }
            }
        };


        Runnable fiveSecAfter = new Runnable() {
            @Override
            public void run() {
                while (!Thread.currentThread().isInterrupted()) {
                    if (point % 5 == 0) {
                        System.out.println("5 seconds has passed!");
                        try {
                            Thread.sleep(1500);
                        }catch (InterruptedException e) {
                            e.getMessage();
                        }
                    }
                }
            }
        };

        Thread thread = new Thread(second);
        Thread thread1 = new Thread(fiveSecAfter);
        thread.start();
        thread1.start();
    }
}
