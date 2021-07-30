package edu.firat.habermerkezi.model.newsapi;

import java.util.ArrayList;

public class NewsAPI {

    private String status;
    private int totalResults;
    private ArrayList<Article> articles;

    public NewsAPI() {
        this.articles = new ArrayList<Article>();
    }

    public NewsAPI(String status, int totalResults) {
        this.status = status;
        this.totalResults = totalResults;
        this.articles = new ArrayList<Article>();
    }

    public ArrayList<Article> getArticles() {
        return articles;
    }

    public void setArticles(ArrayList<Article> articles) {
        this.articles = articles;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

}
