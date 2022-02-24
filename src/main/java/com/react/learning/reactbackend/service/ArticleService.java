package com.react.learning.reactbackend.service;

import com.react.learning.reactbackend.model.Article;
import com.react.learning.reactbackend.model.Comment;
import com.react.learning.reactbackend.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;
    
    public Article getArticle(String name) {
        return articleRepository.findArticleByName(name);
    }

    public Article upVoteArticle(String name) {
        Article article = articleRepository.findArticleByName(name);
        if (article != null) {
            article.setUpVotes(article.getUpVotes() + 1);
            return articleRepository.save(article);
        } else {
            throw new RuntimeException("Article " + name + "not found");
        }
    }

    public Article addComments(String name, Comment comment) {
        Article article = articleRepository.findArticleByName(name);
        if (article != null) {
            List<Comment> comments = article.getComments();
            comments.add(comment);
            return articleRepository.save(article);
        } else {
            throw new RuntimeException("Article " + name + "not found");
        }
    }
}
