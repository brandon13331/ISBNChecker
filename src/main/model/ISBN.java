package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class ISBN {
    private Map<Integer, List<Integer>> numbers;
    private List<Integer> keys;

    public ISBN() {
        numbers = new HashMap<>();
        keys = new ArrayList<>();

    }

    public void addNumber(int digit, int number) {
        numbers.put(digit, keys);
        keys.add(number);
    }

    public Map<Integer, List<Integer>> getNumbers() {
        return numbers;
    }
}