package edu.firat.habermerkezi.controller;


import edu.firat.habermerkezi.model.newsapi.NewsAPI;
import edu.firat.habermerkezi.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
public class NewsController {

    NewsService newsService;

    @Autowired
    public void setNewsService(NewsService newsService) { this.newsService = newsService; }

    @GetMapping("/news/{countryCode}/{category}")
    public NewsAPI callAPI(@PathVariable String countryCode,@PathVariable String category) {
        return newsService.callAPI(countryCode,category);
    }

}
