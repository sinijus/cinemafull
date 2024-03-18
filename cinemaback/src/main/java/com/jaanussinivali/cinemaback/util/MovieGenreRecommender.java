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
    public static ArrayList<GenreFrequency> getSortedGenreWordFrequencies(List<String> genres) {
        ArrayList<GenreFrequency> genresFrequency = new ArrayList<>();
        setGenreWeights(genres, genresFrequency);
        genresFrequency.sort(new GenreFrequencyComparator());
        return genresFrequency;
    }

    private static void setGenreWeights(List<String> genres, ArrayList<GenreFrequency> genresFrequency) {
        for (String genre : genres) {
            Integer count = 0;
            for (String s : genres) {
                if (Objects.equals(genre, s)) {
                    count++;
                }
            }
            addGenreFrequencyToGenresFrequencyIfNoDuplicates(genresFrequency, genre, count);
        }
    }

    private static void addGenreFrequencyToGenresFrequencyIfNoDuplicates(ArrayList<GenreFrequency> genresFrequency, String genre, Integer count) {
        GenreFrequency genreFrequency = new GenreFrequency(count, genre);
        boolean isGenreFrequencyNotContainedInGenresFrequency = true;
        for (GenreFrequency genresFrequencyItem : genresFrequency) {
            if (genreFrequency.equals(genresFrequencyItem)) {
                isGenreFrequencyNotContainedInGenresFrequency = false;
                break;
            }
        }
        if (isGenreFrequencyNotContainedInGenresFrequency) {
            genresFrequency.add(genreFrequency);
        }
    }
}
class GenreFrequencyComparator implements java.util.Comparator<GenreFrequency> {
    @Override
    public int compare(GenreFrequency a, GenreFrequency b) {
        return b.getFrequency() - a.getFrequency();
    }
}
