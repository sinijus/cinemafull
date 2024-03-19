package com.jaanussinivali.cinemaback.util;

import java.util.*;

public class MovieGenreRecommender {

    public static List<Integer> createRandomUniqueNumbers(int screeningsSize, int nrOfRecommendations) {
        List<Integer> uniqueNumbers = new ArrayList<>();
        Random random = new Random();
        while (uniqueNumbers.size() < nrOfRecommendations) {
            uniqueNumbers.add(random.nextInt(screeningsSize));
        }
        return uniqueNumbers;
    }
}
