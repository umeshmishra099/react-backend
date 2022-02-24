package com.react.learning.reactbackend.controller;

import com.react.learning.reactbackend.model.Article;
import com.react.learning.reactbackend.model.Comment;
import com.react.learning.reactbackend.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping(value = "/api/article/{name}")
    public ResponseEntity<Article> getArticle(@PathVariable("name") String name) {
        Article article = articleService.getArticle(name);
        if (article == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(article);
    }

    @PostMapping(value = "/api/article/{name}/up-votes")
    public Article upVote(@PathVariable("name") String name) {
        return articleService.upVoteArticle(name);
    }

    @PostMapping(value = "/api/article/{name}/add-comment")
    public Article addComments(@PathVariable("name") String name, @RequestBody Comment comment) {
        return articleService.addComments(name, comment);
    }

}
