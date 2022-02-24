package com.react.learning.reactbackend.repository;

import com.react.learning.reactbackend.model.Article;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface ArticleRepository extends MongoRepository<Article, String> {

    @Query("{name:'?0'}")
    Article findArticleByName(String name);

}
