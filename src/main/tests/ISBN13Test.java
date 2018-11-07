package tests;

import model.ISBN;
import model.ISBN13;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ISBN13Test {
    private ISBN testISBN;

    @BeforeEach
    public void runBefore() {
        testISBN = new ISBN13();
    }

    @Test
    public void testValidISBN() {
        // Brave New World ISBN-10: 978-0060850524
        testISBN.addNumber(1, 9);
        testISBN.addNumber(3, 7);
        testISBN.addNumber(1, 8);
        testISBN.addNumber(3, 0);
        testISBN.addNumber(1, 0);
        testISBN.addNumber(3, 6);
        testISBN.addNumber(1, 0);
        testISBN.addNumber(3, 8);
        testISBN.addNumber(1, 5);
        testISBN.addNumber(3, 0);
        testISBN.addNumber(1, 5);
        testISBN.addNumber(3, 2);
        testISBN.addNumber(3, 4);
    }

    @Test
    public void testInvalidISBN() {
    }
}