package edu.firat.newshub.model.newsapi;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.net.URL;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Article {

    @Id
    private long id;
    private String author;
    private String title;
    private String description;
    private URL url;
    private URL urlToImage;
    private String publishedAt;
    private String content;

    @OneToOne
    private Source source;

}
