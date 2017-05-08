package com.globant.challenge.dao;

import com.globant.challenge.domain.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author gervasio.amy.
 */
@Repository
public class ArticlesDAO {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${articles.webservice.url}")
    private String articlesUrl;

    public Article[] fetchArticles() {
        return restTemplate.getForObject(articlesUrl, Article[].class);
    }

}
