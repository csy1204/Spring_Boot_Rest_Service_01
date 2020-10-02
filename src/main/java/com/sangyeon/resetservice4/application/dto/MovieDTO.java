package com.sangyeon.resetservice4.application.dto;


import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MovieDTO {
    private String title;
    private String link;
    private String subtitle;
    private String director;
    private Integer pubDate;
    private String actor;
    private float userRating;
}
