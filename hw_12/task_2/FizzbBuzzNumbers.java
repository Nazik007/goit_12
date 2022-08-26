package go_it_hw.hw_12.task_2;

import java.util.Scanner;

/**
 * @author Nazarii Soviak
 */

public class FizzbBuzzNumbers {

    private static int number = 0;
    private static StringBuilder result = new StringBuilder();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type in any number from 1 to n, please: ");

        int n = scanner.nextInt();

        for (int i = 0; i <=n; i++) {
            number++;
            logicToTheProgram();
        }

        System.out.println(result.substring(0,result.length()-2).toString());
    }

    private static void logicToTheProgram () {

        Thread threadA = new Thread(() -> {
            if (number % 3 == 0 && number % 5 != 0 ){
                result.append("fizz, ");
            }
        });
        threadA.start();
        threadA.interrupt();

        Thread threadB = new Thread(() -> {
            if (number % 5 == 0 && number % 3 != 0 ) {
                result.append("buzz, ");
            }
        });
        threadB.start();
        try {
            threadB.join();
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        threadB.interrupt();

        Thread threadC = new Thread(() -> {
            if (number % 15 == 0 ) {
                result.append("fizzbuzz, ");
            }
        });
        threadC.start();
        try {
            threadC.join();
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        threadC.interrupt();

        Thread threadD = new Thread(() -> {
            if (number % 3 != 0 && number % 5 != 0 ) {
                result.append(number + ", ");
            }
        });
        threadD.start();
        try {
            threadD.join();
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        threadD.interrupt();
    }
}


