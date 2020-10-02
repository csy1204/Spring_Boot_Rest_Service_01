package com.sangyeon.resetservice4.repository;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MovieResponseDTO {

    private List<Item> items;

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Item {
        private String title;
        private String link;
        private String subtitle;
        private String director;
        private Integer pubDate;
        private String actor;
        private float userRating;
    }
}