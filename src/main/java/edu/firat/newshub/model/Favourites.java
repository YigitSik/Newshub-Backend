package edu.firat.newshub.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Favourites {

    @Id
    @Column(name="favorite_id",nullable=false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int favoriteId;

    private String author;

    private String title;

    @Column(columnDefinition="TEXT")
    private String description;

    private String url;

    private String urlToImage;

    private String publishedAt;

    @Column(columnDefinition="TEXT")
    private String content;




}
