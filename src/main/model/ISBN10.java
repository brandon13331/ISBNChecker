package model;

import java.util.HashMap;
import java.util.Map;

public class ISBN10 extends ISBN {
    private Map<Integer, Integer> numbers;

    public ISBN10() {
        numbers = new HashMap<>();
    }
}
