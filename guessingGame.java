import java.util.Scanner;
import java.util.Random;

class guessingGame{
    static int generateNumber(){
        Random rand = new Random();
        int number = rand.nextInt(101); // to generate an integer from 0 - 100. The bound is not inclusive here
        return number;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the guessing game");

        boolean exit = false;
        while (!exit) {
            System.out.println("\nPlease choose your mode");
            System.out.println("1. Endless mode");
            System.out.println("2. Limited mode");
            System.out.println("3. Exit");

            int mode = 0;
            while (true) {
                if (scanner.hasNextInt()) {
                    mode = scanner.nextInt();
                    if (mode == 1 || mode == 2 || mode == 3) {
                        break;
                    } else {
                        System.out.println("Invalid mode. Please enter 1, 2, or 3.");
                    }
                } else {
                    System.out.println("Invalid input. Please enter a number (1, 2, or 3).");
                    scanner.next(); // clear invalid input
                }
            }

            if (mode == 3) {
                System.out.println("Thank you for playing. Goodbye!");
                exit = true;
                break;
            }

            boolean playAgain = true;
            while (playAgain) {
                if (mode == 1){
                    System.out.println("The number you are looking for is between 0 and 100");
                    int number = generateNumber();
                    System.out.println("Please enter your guess");
                    int guess = 120;
                    while (number != guess){
                        if (scanner.hasNextInt()) {
                            guess = scanner.nextInt();
                            if (guess < 0 || guess > 100) {
                                System.out.println("Please enter a number between 0 and 100.");
                                continue;
                            }
                            if (guess < number){
                                System.out.println("Too low, try again");
                            } else if (guess > number){
                                System.out.println("Too high, try again");
                            } else {
                                System.out.println("Congrats, you win!");
                            }
                        } else {
                            System.out.println("Invalid input. Please enter a number between 0 and 100.");
                            scanner.next(); // clear invalid input
                        }
                    }
                } else if (mode == 2){
                    int limit = 0;
                    System.out.println("Please set the number of attempts");
                    while (true) {
                        if (scanner.hasNextInt()) {
                            limit = scanner.nextInt();
                            if (limit > 0) {
                                break;
                            } else {
                                System.out.println("Please enter a positive number for attempts.");
                            }
                        } else {
                            System.out.println("Invalid input. Please enter a positive number.");
                            scanner.next(); // clear invalid input
                        }
                    }
                    System.out.println("The number you are looking for is between 0 and 100");
                    int number = generateNumber();
                    System.out.println("Please enter your guess");
                    int guess = 120;
                    boolean won = false;
                    while (limit > 0){
                        if (scanner.hasNextInt()) {
                            guess = scanner.nextInt();
                            if (guess < 0 || guess > 100) {
                                System.out.println("Please enter a number between 0 and 100.");
                                continue;
                            }
                            if (guess < number){
                                System.out.println("Too low, try again");
                                limit --;
                            } else if (guess > number){
                                System.out.println("Too high, try again");
                                limit --;
                            } else {
                                System.out.println("Congrats, you win!");
                                won = true;
                                break;
                            }
                            if (limit == 0 && !won){
                                System.out.println("You have run out of attempts.");
                                System.out.println("The correct number was: " + number);
                                break;
                            }
                        } else {
                            System.out.println("Invalid input. Please enter a number between 0 and 100.");
                            scanner.next(); // clear invalid input
                        }
                    }
                }

                // Ask if user wants to play again in the same mode, go to menu, or exit
                System.out.println("\nWhat would you like to do next?");
                System.out.println("1. Play again in this mode");
                System.out.println("2. Go back to main menu");
                System.out.println("3. Exit");

                int nextAction = 0;
                while (true) {
                    if (scanner.hasNextInt()) {
                        nextAction = scanner.nextInt();
                        if (nextAction == 1 || nextAction == 2 || nextAction == 3) {
                            break;
                        } else {
                            System.out.println("Invalid choice. Please enter 1, 2, or 3.");
                        }
                    } else {
                        System.out.println("Invalid input. Please enter a number (1, 2, or 3).");
                        scanner.next(); // clear invalid input
                    }
                }

                if (nextAction == 1) {
                    playAgain = true;
                } else if (nextAction == 2) {
                    playAgain = false;
                } else if (nextAction == 3) {
                    playAgain = false;
                    exit = true;
                    System.out.println("Thank you for playing. Goodbye!");
                }
            }
        }

        scanner.close();
    }
}