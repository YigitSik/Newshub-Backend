package edu.firat.newshub.service;


import edu.firat.newshub.model.newsapi.NewsAPI;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.MalformedURLException;


@Service
public class NewsService {

    private final String APIKey;
    private final String url;
    private RestTemplate restTemplate;


    // calls the values from application.properties
    public NewsService(@Value("${APIKey}") String APIKey, @Value("${URL}") String url, RestTemplate restTemplate) {
        this.APIKey = APIKey;
        this.url = url;
        this.restTemplate = restTemplate;
    }

    public NewsAPI callAPI(String countryCode)  {
        String url = buildURL(countryCode);
        System.out.println(url);
        NewsAPI newsAPI = restTemplate.getForObject( url, NewsAPI.class);


//        System.out.println(newsAPI.getArticles());
//        ArrayList<Article> articles = newsAPI.getArticles();
//        articles.forEach((element)->{
//            System.out.println("elm: "+element.getContent());
//        });
//
//        System.out.println(newsAPI.getStatus());
//        System.out.println(newsAPI.getTotalResults());
//        System.out.println(newsAPI);

        return newsAPI;
    }

    public NewsAPI callByCategory(String countryCode, String category) {
        String url = buildURL(countryCode,category);
        System.out.println(url);
        NewsAPI newsAPI = restTemplate.getForObject( url, NewsAPI.class);

        return newsAPI;
    }

    public NewsAPI callByQuery( String countryCode,String query)  {

        String url = buildURLQuery(countryCode,query);
        System.out.println(url);
        NewsAPI newsAPI = restTemplate.getForObject( url, NewsAPI.class);

        return newsAPI;
    }

    public String buildURLQuery(String countryCode,String query) {
        return this.url + "?country="+countryCode+"&q="+query +"&apiKey="+ APIKey;
    }

    public String buildURL(String country) {
        return this.url + "?country="+country +"&apiKey="+ APIKey;
    }

    public String buildURL(String countryCode, String category) {
        return this.url + "?country=" + countryCode + "&category=" + category + "&apiKey=" + APIKey;
    }


}

