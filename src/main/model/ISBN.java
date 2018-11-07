package model;

import java.util.HashMap;
import java.util.Map;

public abstract class ISBN {
    private Map<Integer, Integer> numbers;

    public ISBN() {
        numbers = new HashMap<>();
    }

    public void addNumber(int digit, int number) {
        numbers.put(digit, number);
    }

    public Map<Integer, Integer> getNumbers() {
        return numbers;
    }
}