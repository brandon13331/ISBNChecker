package model;

import java.util.HashMap;
import java.util.Map;

public class ISBN13 extends ISBN {
    private Map<Integer, Integer> numbers;

    public ISBN13() {
        numbers = new HashMap<>();
    }
}
