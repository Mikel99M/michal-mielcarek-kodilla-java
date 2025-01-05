package com.kodilla.patterns.testing.collection;

import java.util.ArrayList;
import java.util.List;

public class oddNumbersExterminator {

    public List<Integer> exterminate(List<Integer> numbers) {
        List<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) % 2 == 0) {
                result.add(numbers.get(i));
            }
        }
        return result;
    }

}
