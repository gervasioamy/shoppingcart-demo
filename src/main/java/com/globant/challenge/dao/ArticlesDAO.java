package com.globant.challenge.dao;

import com.globant.challenge.domain.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

/**
 * DAO for articles. In this case, this is not a DB repository, it uses a {@link RestTemplate} the get articles from
 * the url specified in <code>articles.webservice.url</code> property
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

    public Article fetchArticle(String articleId) {
        return restTemplate.getForObject(articlesUrl + "/" + articleId, Article.class);
    }

}
