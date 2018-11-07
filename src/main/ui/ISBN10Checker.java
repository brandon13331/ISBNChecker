package ui;

import exceptions.NegativeIntegerException;
import model.ISBN;
import model.ISBN10;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ISBN10Checker {
    private Scanner scanner;
    private ISBN isbn = new ISBN10();

    public static void main(String[] args) {
        new ISBN10Checker();
    }

    private ISBN10Checker() {
        int operation;
        scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Check ISBN Number");
            System.out.println("2. Quit");
            operation = scanner.nextInt();
            if (operation == 1) {
                try {
                    setUp();
                } catch (NegativeIntegerException e) {
                    System.out.println("Invalid input");
                    break;
                }
                if (checkValidity()) {
                    System.out.println("Your ISBN number is valid");
                } else
                    System.out.println("Your ISBN number is invalid");
                break;
            }
        }
    }

    private void setUp() throws NegativeIntegerException {
        int number = 0;
        for (int i = 0; i < 10; i++) {
            if (number < 0) {
                throw new NegativeIntegerException();
            }
            if (i == 0) {
                System.out.println("Enter the number for the " + (i + 1) + "st digit");
                number = scanner.nextInt();
                isbn.addNumber(i + 1, number);
            } else if (i == 1) {
                System.out.println("Enter the number for the " + (i + 1) + "nd digit");
                number = scanner.nextInt();
                isbn.addNumber(i + 1, number);
            } else if (i == 2) {
                System.out.println("Enter the number for the " + (i + 1) + "rd digit");
                number = scanner.nextInt();
                isbn.addNumber(i + 1, number);
            } else {
                System.out.println("Enter the number for the " + (i + 1) + "th digit");
                number = scanner.nextInt();
                isbn.addNumber(i + 1, number);
            }
        }
    }

    private boolean checkValidity() {
        int number;
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i < isbn.getNumbers().size() + 1; i++) {
            number = i * isbn.getNumbers().get(i);
            numbers.add(number);
        }
        int sum = 0;
        for (int i : numbers) {
            sum = sum + i;
        }
        // mod 11
        if (sum % 11 == 0) {
            return true;
        } else
            return false;
    }
}
