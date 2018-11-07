package tests;

import model.ISBN;
import model.ISBN10;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ISBN10Test {
    private ISBN testISBN;

    @BeforeEach
    public void runBefore() {
        testISBN = new ISBN10();
    }

    @Test
    public void testValidISBN() {
        // Brave New World ISBN-10: 0060850523
        testISBN.addNumber(1, 0);
        testISBN.addNumber(2, 0);
        testISBN.addNumber(3, 6);
        testISBN.addNumber(4, 0);
        testISBN.addNumber(5, 8);
        testISBN.addNumber(6, 5);
        testISBN.addNumber(7, 0);
        testISBN.addNumber(8, 5);
        testISBN.addNumber(9, 2);
        testISBN.addNumber(10, 3);
    }

    @Test
    public void testInvalidISBN() {
    }
}
