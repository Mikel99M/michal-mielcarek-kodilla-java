package com.kodilla.patterns.good.patterns.challenges;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MovieStore {
    public Map<String, List<String>> getMovies() {

        List<String> ironManTranslations = new ArrayList<>();
        ironManTranslations.add("Żelazny Człowiek");
        ironManTranslations.add("Iron Man");

        List<String> avengersTranslations = new ArrayList<>();
        avengersTranslations.add("Mściciele");
        avengersTranslations.add("Avengers");

        List<String> flashTranslations = new ArrayList<>();
        flashTranslations.add("Błyskawica");
        flashTranslations.add("Flash");

        Map<String, List<String>> booksTitlesWithTranslations = new HashMap<>();
        booksTitlesWithTranslations.put("IM", ironManTranslations);
        booksTitlesWithTranslations.put("AV", avengersTranslations);
        booksTitlesWithTranslations.put("FL", flashTranslations);

        return booksTitlesWithTranslations;
    }

    public void getZadanieOne() {

        Map<String, List<String>> data = getMovies();
        data.entrySet().stream().forEach(entry -> System.out.println(entry.getKey() + ": " + String.join("-", entry.getValue())));

    }

    public void getZadanieDodatkowe(int num) {

        int result;

        if (num == 0) {
            result = 0;
        } else {
            result = 1;
        }

        for (int i = 1; i <= num; i++) {
            result *= i;
        }

        System.out.println("Silnia z " + num + " wynosi " + result);
    }
}
