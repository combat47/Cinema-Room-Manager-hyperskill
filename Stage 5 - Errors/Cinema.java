package cinema;

import java.util.Arrays;
import java.util.Scanner;

public class Cinema {
    
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        char[][] seats = createSeats();
        int ticketsPurchased = 0;
        int income = 0;
        int choice;
        do {
            System.out.println("1. Show the seats");
            System.out.println("2. Buy a ticket");
            System.out.println("3. Statistics");
            System.out.println("0. Exit");
            choice = scanner.nextInt();
            System.out.println();

            switch (choice) {
                case 1 -> showSeats(seats);
                case 2 -> {
                    income += buySeat(seats);
                    ticketsPurchased++;
                }
                case 3 -> statistics(seats, ticketsPurchased, income);
            }
        } while (choice != 0);
    }
    public static char[][] createSeats() {
        System.out.println("Enter the number of rows:");
        int row = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int col = scanner.nextInt();
        System.out.println();

        char[][] seats = new char[row][col];
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[i].length; j++) {
                seats[i][j] = 'S';
            }
        }
        return seats;
    }
    public static void showSeats(char[][] seats) {
        System.out.println("Cinema:");
        System.out.print(" ");
        for (int i = 0; i < seats[0].length; i++) {
            System.out.print(" " + (i + 1));
        }
        System.out.println();
        for (int i = 0; i < seats.length; i++) {
            System.out.print(i + 1);
            for (int j = 0; j < seats[i].length; j++) {
                System.out.print(" " + seats[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
    public static int buySeat(char[][] seats) {
        int rowS, colS;
        boolean error;
        do {
            System.out.println("Enter a row number:");
            rowS = scanner.nextInt() - 1;
            System.out.println("Enter a seat number in that row:");
            colS = scanner.nextInt() - 1;
            error = false;
            if (rowS < 0 || rowS >= seats.length || colS < 0 || colS >= seats[0].length) {
                System.out.println("\nWrong input!\n");
                error = true;
            } else if (seats[rowS][colS] == 'B') {
                System.out.println("\nThat ticket has already been purchased!\n");
                error = true;
            }
        } while (error);
        seats[rowS][colS] = 'B';
        int price = seats.length * seats[0].length > 60 && rowS >= seats.length / 2 ? 8 : 10;
        System.out.printf("Ticket price : $%d%n", price);
        System.out.println();
        return price;
    }
    public static void statistics(char[][] seats, int ticketsPurchased, int income) {
        int totalIncome = ((seats.length / 2) * 10 + (seats.length / 2 + seats.length % 2) * 8) * seats[0].length;

        System.out.println("Number of purchased tickets: " + ticketsPurchased);
        System.out.printf("Percentage: %.2f%%%n", (ticketsPurchased * 100f / (seats.length * seats[0].length)));
        System.out.println("Current income: $" + income);
        System.out.println("Total income: $" + totalIncome);
        System.out.println();
    }
}
