package cinema;

import java.util.Arrays;
import java.util.Scanner;

public class Cinema {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int seats = scanner.nextInt();
        String[][] cinema = new String[rows][seats];
        for (String[] row: cinema) Arrays.fill(row, "S");
        showMenu(cinema);
    }

    public static void showMenu(String[][] cinema) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n1. Show the seats\n2. Buy a ticket\n0. Exit");
        int menuItemSelected = scanner.nextInt();
        switch (menuItemSelected) {
            case 0:
                break;
            case 1:
                printSeats(cinema);
                showMenu(cinema);
                break;
            case 2:
                bookTicket(cinema);
                showMenu(cinema);
                break;
        }
    }

    public static void printSeats(String[][] cinema) {
        System.out.print("Cinema:\n  ");
        for (int i = 1; i <= cinema[0].length; i++) {
            System.out.print(i + " ");
        }
        for (int i = 1; i < cinema.length + 1; i++) {
            System.out.print("\n" + i + " ");
            for (int j = 1; j < cinema[i-1].length + 1; j++) {
                System.out.print(cinema[i-1][j-1] + " ");
            }
        }
    }

    public static String[][] bookTicket(String[][] cinema) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n\nEnter a row number:");
        int row = scanner.nextInt();
        System.out.println("Enter a seat number in that row:");
        int seat = scanner.nextInt();
        countTicketPrice(cinema, row);
        cinema[row-1][seat-1] = "B";
        return cinema;
    }

    public static void countTicketPrice(String[][] cinema, int row) {
        final int smallRoomSeats = 60;
        final int frontHalfTicket = 10;
        final int backHalfTicket = 8;
        int ticketPrice = cinema.length * cinema[0].length <= smallRoomSeats
                || row <= cinema.length / 2 ? frontHalfTicket : backHalfTicket;
        System.out.println("Ticket price: $" + ticketPrice);
    }
}
