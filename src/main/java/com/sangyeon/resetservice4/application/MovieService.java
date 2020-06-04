package com.sangyeon.resetservice4.application;
import com.sangyeon.resetservice4.application.dto.MovieDTO;
import com.sangyeon.resetservice4.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieService {


    private static MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public static List<MovieDTO> findByQuery(String query, Integer len, Integer offset) {

//        MovieDTO movie1 = MovieDTO.builder()
//                .actor("디카프리오")
//                .director("놀란")
//                .link("https://movie.naver.com/movie/bi/mi/basic.nhn?code=166619")
//                .pubDate(2010)
//                .subtitle("Inception")
//                .title(query)
//                .userRating(9.3f).build();
//        List<MovieDTO> movieList = new ArrayList<>();
//        movieList.add(movie1);

        return movieRepository.findByQuery(query, len, offset);
    }

}
