package com.jaanussinivali.cinemaback.util;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class MovieGenreRecommender {
    public static HashMap<String, Integer> genreWordWeights(List<String> genres) {
        int[] frequency;
        HashMap<String, Integer> genresFrequency = new HashMap<>();
        //TODO for tsüklid omavahel vahetada ümbber pöörata
        for (String genre : genres) {
//            HashMap<String, Integer> genreFrequency = new HashMap<>();
            Integer count = 0;
            for (String s : genres) {
                if (Objects.equals(genre, s)) {
                    count++;
                }
            }
            genresFrequency.put(genre, count);
        }

//        genres.sort();
//        genres.reverse();

        return genresFrequency;
    }
}
