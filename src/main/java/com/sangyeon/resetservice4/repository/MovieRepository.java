package com.sangyeon.resetservice4.repository;

import com.sangyeon.resetservice4.application.dto.MovieDTO;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class MovieRepository {

    @Value("${naver.openapi.clientId}")
    private String naverOpenApiClientId;

    @Value("${naver.openapi.clientSecret}")
    private String naverOpenApiClientSecret;

    public List<MovieDTO> findByQuery(String query, Integer len, Integer offset) {

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("X-Naver-Client-Id", naverOpenApiClientId);
        httpHeaders.add("X-Naver-Client-Secret", naverOpenApiClientSecret);

        String url = "https://openapi.naver.com/v1/search/movie.json";

        String paramsUrl = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("query", query)
                .queryParam("display", len)
                .queryParam("start", offset)
                .build().toString();

        System.out.println(paramsUrl);

        ArrayList<Map> movieList = (ArrayList<Map>)restTemplate.exchange(paramsUrl, HttpMethod.GET, new HttpEntity(httpHeaders), Map.class).getBody().get("items");
        return movieList.stream()
                .map(e -> MovieDTO.builder()
                        .actor((String)e.get("actor"))
                        .director((String)e.get("director"))
                        .link((String)e.get("link"))
                        .subtitle((String)e.get("subtitle"))
                        .title((String)e.get("title")).build())
                .collect(Collectors.toList());
    }

}
