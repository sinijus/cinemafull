package com.jaanussinivali.cinemaback.util;

import java.util.HashMap;
import java.util.List;

public class MovieGenreRecommender {
    public static HashMap<String, Integer> genreWordWeights(List<String> genres) {
        int[] frequency;
        HashMap<String, Integer> genresFrequency = new HashMap<>();
        for (String genre : genres) {
            HashMap<String, Integer> genreFrequency = new HashMap<>();
            Integer count = 0;
            for (int i = 0; i < genres.size(); i++) {
                if (genre == genres.get(i)) {
                    count++;
                }
            }
            genreFrequency.put(genre, count);
        }



//        genres.sort();
//        genres.reverse();

        return genresFrequency;
    }
}
