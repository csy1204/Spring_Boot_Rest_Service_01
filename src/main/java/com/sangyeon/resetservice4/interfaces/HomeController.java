package com.sangyeon.resetservice4.interfaces;


import com.sangyeon.resetservice4.application.MovieService;
import com.sangyeon.resetservice4.application.dto.MovieDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class HomeController {

//    @Autowired
    private MovieService movieService;



    @GetMapping("/movie")
    public List<MovieDTO> searchMovieByQuery(@RequestParam(name = "q") String query,
                                             @RequestParam(name = "len") Integer len,
                                             @RequestParam(name = "offset") Integer offset) {
        return movieService.findByQuery(query, len, offset);
    }



}
