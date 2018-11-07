package ui;

import exceptions.NegativeIntegerException;
import model.ISBN;
import model.ISBN10;
import model.ISBN13;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ISBNChecker {
    private Scanner scanner;
    private int operation;
    private ISBN isbn10 = new ISBN10();
    private ISBN isbn13 = new ISBN13();

    public static void main(String[] args) {
        new ISBNChecker();
    }

    private ISBNChecker() {
        scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Check ISBN-10 Number");
            System.out.println("2. Check ISBN-13 Number");
            System.out.println("3. Quit");
            operation = scanner.nextInt();
            if (operation == 1) {
                try {
                    setUp(10);
                } catch (NegativeIntegerException e) {
                    System.out.println("Invalid input");
                    break;
                }
                if (checkValidity()) {
                    System.out.println("Your ISBN-10 number is valid");
                } else
                    System.out.println("Your ISBN-10 number is invalid");
                break;
            }
            if (operation == 2) {
                try {
                    setUp(13);
                } catch (NegativeIntegerException e) {
                    System.out.println("Invalid input");
                    break;
                }
                if (checkValidity()) {
                    System.out.println("Your ISBN-13 number is valid");
                } else
                    System.out.println("Your ISBN-13 number is invalid");
                break;
            } else
                break;
        }
    }

    private void setUp(int digits) throws NegativeIntegerException {
        for (int i = 1; i < digits + 1; i++) {
            if (i == 1) {
                System.out.println("Enter the number for the " + i + "st digit");
                addNumberToISBN(i);
            } else if (i == 2) {
                System.out.println("Enter the number for the " + i + "nd digit");
                addNumberToISBN(i);
            } else if (i == 3) {
                System.out.println("Enter the number for the " + i + "rd digit");
                addNumberToISBN(i);
            } else {
                System.out.println("Enter the number for the " + i + "th digit");
                addNumberToISBN(i);
            }
        }
    }

    private void addNumberToISBN(int i) throws NegativeIntegerException {
        if (operation == 1) {
            int number = scanner.nextInt();
            if (number < 0) {
                throw new NegativeIntegerException();
            }
            isbn10.addNumber(i, number);
        } else if (operation == 2) {
            int number = scanner.nextInt();
            if (number < 0) {
                throw new NegativeIntegerException();
            }
            if (i % 2 == 0) {
                isbn13.addNumber(3, number);
            } else {
                isbn13.addNumber(1, number);
            }
        }
    }

    private boolean checkValidity() {
        int number;
        List<Integer> numbers = new ArrayList<>();
        if (operation == 1) {
            for (int i = 1; i < 11; i++) {
                number = i * isbn10.getNumbers().get(i).get(0);
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
        } else if (operation == 2) {
            for (int i = 1; i < 14; i++) {
                if (i % 2 == 0) {
                    number = 3 * isbn13.getNumbers().get(3).get(i - 1);
                    numbers.add(number);
                } else {
                    number = 1 * isbn13.getNumbers().get(1).get(i - 1);
                    numbers.add(number);
                }
            }
            int sum = 0;
            for (int i : numbers) {
                sum = sum + i;
            }
            // mod 10
            if (sum % 10 == 0) {
                return true;
            } else
                return false;
        }
        return false;
    }
}
