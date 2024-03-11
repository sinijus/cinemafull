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
    private DirectorService directorService;

    @Resource
    private GenreService genreService;

    @Resource
    private LanguageService languageService;

    @Resource
    private RestrictionService restrictionService;

    @Resource
    private HallService hallService;

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


    public List<ScreeningResponse> findAllMovieScreenings() {
        List<ScreeningResponse> screeningsResponse = new ArrayList<>();
        List<Screening> screenings = screeningService.findAllScreenings();
        for (Screening screening : screenings) {
            ScreeningResponse screeningResponse = screeningMapper.toScreeningResponse(screening);
            Integer movieId = screening.getMovie().getId();

            getAndSetScreeningResponse(movieId, screeningResponse);

            screeningsResponse.add(screeningResponse);
        }
        return screeningsResponse;

    }

    private void getAndSetScreeningResponse(Integer movieId, ScreeningResponse screeningResponse) {
        Movie movie = movieService.findMovieById(movieId);
        screeningResponse.setMovieTitle(movie.getTitle());
        screeningResponse.setMovieReleaseYear(movie.getReleaseYear());

        List<MovieDirector> movieDirectors = movieDirectorService.findMovieDirectorsByMovieId(movieId);
        List<Director> directors = new ArrayList<>();
        for (MovieDirector movieDirector : movieDirectors) {
            directors.add(movieDirector.getDirector());
        }
        List<DirectorResponse> directorsResponse = directorMapper.toDirectorsResponse(directors);
        screeningResponse.setDirectors(directorsResponse);

        List<MovieGenre> movieGenres = movieGenreService.findMovieGenresByMovieId(movieId);
        List<Genre> genres = new ArrayList<>();
        for (MovieGenre movieGenre : movieGenres) {
            genres.add(movieGenre.getGenre());
        }
        List<GenreResponse> genresResponse = genreMapper.toGenresResponse(genres);
        screeningResponse.setGenres(genresResponse);

        List<MovieLanguage> movieLanguages = movieLanguageService.findMovieLanguagesByMovieId(movieId);
        List<Language> languages = new ArrayList<>();
        for (MovieLanguage movieLanguage : movieLanguages) {
            languages.add(movieLanguage.getLanguage());
        }
        List<LanguageResponse> languagesResponse = languageMapper.toLanguagesResponse(languages);
        screeningResponse.setLanguages(languagesResponse);

        List<MovieRestriction> movieRestrictions = movieRestrictionService.findMovieRestrictionsByMovieId(movieId);
        List<Restriction> restrictions = new ArrayList<>();
        for (MovieRestriction movieRestriction : movieRestrictions) {
            restrictions.add(movieRestriction.getRestriction());
        }
        List<RestrictionResponse> restrictionsResponse = restrictionMapper.toRestrictionsResponse(restrictions);
        screeningResponse.setRestrictions(restrictionsResponse);
    }


    public List<ScreeningResponse> findFilteredScreenings(FilteredScreeningRequest request) {
        List<ScreeningResponse> filteredScreeningResults = new ArrayList<>();
        List<Screening> filteredScreenings = screeningService.findFilteredScreeningsMovieIds(request);
        List<Integer> directorsFilteredMovieIds = movieDirectorService.findMovieDirectorsMovieIds(request.getDirectorId());
        List<Integer> genresFilteredMovieIds = movieGenreService.findFilteredGenresMovieIds(request.getGenreId());
        List<Integer> languagesFilteredMovieIds = movieLanguageService.findFilteredLanguagesMovieIds(request.getLanguageId());
        List<Integer> restrictionsFilteredMovieIds = movieRestrictionService.findFilteredRestrictionsMovieIds(request.getRestrictionId());

        for (Screening screening : filteredScreenings) {
            Integer movieId = screening.getMovie().getId();
            if (!directorsFilteredMovieIds.isEmpty() && !directorsFilteredMovieIds.contains(movieId)) break;
            else if (!genresFilteredMovieIds.isEmpty() && !genresFilteredMovieIds.contains(movieId)) break;
            else if (!languagesFilteredMovieIds.isEmpty() && !languagesFilteredMovieIds.contains(movieId)) break;
            else if (!restrictionsFilteredMovieIds.isEmpty() && !restrictionsFilteredMovieIds.contains(movieId)) break;

            ScreeningResponse screeningResponse = screeningMapper.toScreeningResponse(screening);
            getAndSetScreeningResponse(movieId,screeningResponse);
            filteredScreeningResults.add(screeningResponse);
        }


        return filteredScreeningResults;
    }
}
