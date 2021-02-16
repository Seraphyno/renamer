package org.example.renamer;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RenamerService service = null;
        boolean isRunning = true;

        while (isRunning) {
            if (service == null) {
                service = new RenamerService();
            }
            printMenu();
            int input = scanner.nextInt();
            scanner.nextLine();

            switch (input) {
                case 0:
                    System.out.println("Thank you for using this application");
                    isRunning = false;
                    break;
                case 1:
                    System.out.print("Please input the path to the desired folder: ");
                    String path = scanner.nextLine();
                    service.rename(path);
                    break;
                default:
                    break;
            }

        }
        // display a menu and keep app running until exited

        // dynamically read a path to the desired folder

        // read all files from that path and store inside a list

        // process all the file paths and clean them up

        // save new names

        // display a message for each processed file
    }

    private static void printMenu() {
        System.out.println("Application Running\nPlease choose an option:");
        System.out.println("0 - Exit\n" +
                            "1 - Clean up song names\n");
    }
}
