package edu.firat.newshub.controller;


import edu.firat.newshub.model.newsapi.NewsAPI;
import edu.firat.newshub.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
public class NewsController {

    NewsService newsService;

    @Autowired
    public void setNewsService(NewsService newsService) { this.newsService = newsService; }

    @GetMapping("/news/{countryCode}")
    public NewsAPI callAPI(@PathVariable String countryCode) {
        return newsService.callAPI(countryCode);
    }

    @GetMapping("/category/{countryCode}/{category}")
    public NewsAPI callByCategory(@PathVariable String countryCode,@PathVariable String category) {
        return newsService.callByCategory(countryCode,category);
    }

    @GetMapping("/query/{countryCode}/{query}")
    public NewsAPI callByQuery(@PathVariable String countryCode, @PathVariable String query) {
        return newsService.callByQuery(countryCode,query);
    }

}
