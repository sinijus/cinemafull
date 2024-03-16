package com.jaanussinivali.cinemaback.service;

import com.jaanussinivali.cinemaback.dto.*;
import com.jaanussinivali.cinemaback.mapper.*;
import com.jaanussinivali.cinemaback.model.*;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ScreeningsService {

    @Resource
    private ScreeningService screeningService;

    @Resource
    private MovieService movieService;

    @Resource
    private MovieDirectorService movieDirectorService;

    @Resource
    private MovieGenreService movieGenreService;

    @Resource
    private MovieLanguageService movieLanguageService;

    @Resource
    private MovieRestrictionService movieRestrictionService;

    @Resource
    private MovieSubtitleService movieSubtitleService;
    @Resource
    private MovieCountryService movieCountryService;

    @Resource
    private ScreeningMapper screeningMapper;

    @Resource
    private DirectorMapper directorMapper;

    @Resource
    private GenreMapper genreMapper;

    @Resource
    private LanguageMapper languageMapper;

    @Resource
    private RestrictionMapper restrictionMapper;

    @Resource
    private CountryMapper countryMapper;


    public List<ScreeningListResponse> findAllMovieScreenings() {
        List<ScreeningListResponse> screeningsResponse = new ArrayList<>();
        List<Screening> screenings = screeningService.findAllScreenings();
        for (Screening screening : screenings) {
            ScreeningListResponse screeningListResponse = screeningMapper.toScreeningListResponse(screening);
            Integer movieId = screening.getMovie().getId();
            getAndSetScreeningListResponse(movieId, screeningListResponse);
            screeningsResponse.add(screeningListResponse);
        }
        return screeningsResponse;
    }

    private void getAndSetScreeningListResponse(Integer movieId, ScreeningListResponse screeningListResponse) {
        Movie movie = movieService.findMovie(movieId);
        List<DirectorResponse> directorsResponse = getAndSetDirectorsResponse(movieId);
        List<GenreResponse> genresResponse = getAndSetGenresResponse(movieId);
        List<LanguageResponse> languagesResponse = getAndSetLanguagesResponse(movieId);
        List<RestrictionResponse> restrictionsResponse = getAndSetRestrictionsResponse(movieId);

        screeningListResponse.setMovieTitle(movie.getTitle());
        screeningListResponse.setMovieReleaseYear(movie.getReleaseYear());
        screeningListResponse.setDirectors(directorsResponse);
        screeningListResponse.setGenres(genresResponse);
        screeningListResponse.setLanguages(languagesResponse);
        screeningListResponse.setRestrictions(restrictionsResponse);
    }

    private List<DirectorResponse> getAndSetDirectorsResponse(Integer movieId) {
        List<MovieDirector> movieDirectors = movieDirectorService.findMovieDirectorsByMovieId(movieId);
        List<Director> directors = new ArrayList<>();
        for (MovieDirector movieDirector : movieDirectors) {
            directors.add(movieDirector.getDirector());
        }
        return directorMapper.toDirectorsResponse(directors);
    }

    private List<GenreResponse> getAndSetGenresResponse(Integer movieId) {
        List<MovieGenre> movieGenres = movieGenreService.findMovieGenresByMovieId(movieId);
        List<Genre> genres = new ArrayList<>();
        for (MovieGenre movieGenre : movieGenres) {
            genres.add(movieGenre.getGenre());
        }
        return genreMapper.toGenresResponse(genres);
    }

    private List<LanguageResponse> getAndSetLanguagesResponse(Integer movieId) {
        List<MovieLanguage> movieLanguages = movieLanguageService.findMovieLanguagesByMovieId(movieId);
        List<Language> languages = new ArrayList<>();
        for (MovieLanguage movieLanguage : movieLanguages) {
            languages.add(movieLanguage.getLanguage());
        }
        return languageMapper.toLanguagesResponse(languages);
    }

    private List<RestrictionResponse> getAndSetRestrictionsResponse(Integer movieId) {
        List<MovieRestriction> movieRestrictions = movieRestrictionService.findMovieRestrictionsByMovieId(movieId);
        List<Restriction> restrictions = new ArrayList<>();
        for (MovieRestriction movieRestriction : movieRestrictions) {
            restrictions.add(movieRestriction.getRestriction());
        }
        return restrictionMapper.toRestrictionsResponse(restrictions);
    }

    public ScreeningInfoResponse findMovieScreening(Integer screeningId) {
        Screening screening = screeningService.findScreening(screeningId);
        ScreeningInfoResponse screeningInfoResponse = screeningMapper.toScreeningInfoResponse(screening);
        Integer movieId = screening.getMovie().getId();
        getAndSetScreeningInfoResponse(movieId, screeningInfoResponse);
        return screeningInfoResponse;
    }

    private void getAndSetScreeningInfoResponse(Integer movieId, ScreeningInfoResponse screeningInfoResponse) {
        Movie movie = movieService.findMovie(movieId);
        List<DirectorResponse> directorsResponse = getAndSetDirectorsResponse(movieId);
        List<GenreResponse> genresResponse = getAndSetGenresResponse(movieId);
        List<LanguageResponse> languagesResponse = getAndSetLanguagesResponse(movieId);
        List<RestrictionResponse> restrictionsResponse = getAndSetRestrictionsResponse(movieId);
        List<LanguageResponse> subtitlesResponse = getAndSetSubtitlesLanguageResponse(movieId);
        List<CountryResponse> countriesResponse = getAndSetCountriesResponse(movieId);

        screeningInfoResponse.setMovieTitle(movie.getTitle());
        screeningInfoResponse.setMovieReleaseYear(movie.getReleaseYear());
        screeningInfoResponse.setMovieDescription(movie.getDescription());
        screeningInfoResponse.setMovieLength(movie.getLength());
        screeningInfoResponse.setDirectors(directorsResponse);
        screeningInfoResponse.setGenres(genresResponse);
        screeningInfoResponse.setLanguages(languagesResponse);
        screeningInfoResponse.setRestrictions(restrictionsResponse);
        screeningInfoResponse.setSubtitles(subtitlesResponse);
        screeningInfoResponse.setCountries(countriesResponse);
    }

    private List<LanguageResponse> getAndSetSubtitlesLanguageResponse(Integer movieId) {
        List<MovieSubtitle> movieSubtitles = movieSubtitleService.findMovieSubtitlesByMovieId(movieId);
        List<Language> subtitles = new ArrayList<>();
        for (MovieSubtitle movieSubtitle : movieSubtitles) {
            subtitles.add(movieSubtitle.getLanguage());
        }
        return languageMapper.toLanguagesResponse(subtitles);
    }

    private List<CountryResponse> getAndSetCountriesResponse(Integer movieId) {
        List<MovieCountry> movieCountries = movieCountryService.findMovieCountriesByMovieId(movieId);
        List<Country> countries = new ArrayList<>();
        for (MovieCountry movieCountry : movieCountries) {
            countries.add(movieCountry.getCountry());
        }
        return countryMapper.toCountriesResponse(countries);
    }

    public List<ScreeningListResponse> findFilteredScreenings(FilteredScreeningRequest request) {
        List<ScreeningListResponse> filteredScreeningResults = new ArrayList<>();
        List<Screening> filteredScreenings = screeningService.findFilteredScreeningsMovieIds(request);
        List<Integer> directorsFilteredMovieIds = movieDirectorService.findMovieDirectorsMovieIds(request.getDirectorId());
        List<Integer> genresFilteredMovieIds = movieGenreService.findFilteredGenresMovieIds(request.getGenreId());
        List<Integer> languagesFilteredMovieIds = movieLanguageService.findFilteredLanguagesMovieIds(request.getLanguageId());
        List<Integer> restrictionsFilteredMovieIds = movieRestrictionService.findFilteredRestrictionsMovieIds(request.getRestrictionId());

        for (Screening screening : filteredScreenings) {
            Integer movieId = screening.getMovie().getId();
            if (hasAnyOfIncludedSearchCriteriaReturnedEmptyList(directorsFilteredMovieIds,
                    genresFilteredMovieIds, languagesFilteredMovieIds,
                    restrictionsFilteredMovieIds)) break;
            if (doesAnyOfSearchCriteriaNotIncludeMovieId(directorsFilteredMovieIds,
                    movieId, genresFilteredMovieIds, languagesFilteredMovieIds,
                    restrictionsFilteredMovieIds)) continue;
            ScreeningListResponse screeningListResponse = screeningMapper.toScreeningListResponse(screening);
            getAndSetScreeningListResponse(movieId, screeningListResponse);
            filteredScreeningResults.add(screeningListResponse);
        }
        return filteredScreeningResults;
    }

    private static boolean doesAnyOfSearchCriteriaNotIncludeMovieId(List<Integer> directorsFilteredMovieIds, Integer movieId, List<Integer> genresFilteredMovieIds, List<Integer> languagesFilteredMovieIds, List<Integer> restrictionsFilteredMovieIds) {
        return !directorsFilteredMovieIds.contains(movieId) || !genresFilteredMovieIds.contains(movieId) || !languagesFilteredMovieIds.contains(movieId) || !restrictionsFilteredMovieIds.contains(movieId);
    }

    private static boolean hasAnyOfIncludedSearchCriteriaReturnedEmptyList(List<Integer> directorsFilteredMovieIds, List<Integer> genresFilteredMovieIds, List<Integer> languagesFilteredMovieIds, List<Integer> restrictionsFilteredMovieIds) {
        return directorsFilteredMovieIds.isEmpty() || genresFilteredMovieIds.isEmpty() ||
                languagesFilteredMovieIds.isEmpty() || restrictionsFilteredMovieIds.isEmpty();
    }
}
