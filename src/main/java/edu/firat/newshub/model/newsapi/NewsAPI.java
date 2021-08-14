package edu.firat.newshub.model.newsapi;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewsAPI {

    private String status;
    private int totalResults;
    private ArrayList<Article> articles;


}
