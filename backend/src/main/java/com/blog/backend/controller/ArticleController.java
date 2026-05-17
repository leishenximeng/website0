package com.blog.backend.controller;

import com.blog.backend.entity.Article;
import com.blog.backend.mapper.ArticleMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/articles")
@CrossOrigin
public class ArticleController {

    private final ArticleMapper articleMapper;

    public ArticleController(ArticleMapper articleMapper) {
        this.articleMapper = articleMapper;
    }

    @GetMapping
    public List<Article> list() {
        return articleMapper.findAll();
    }

    @GetMapping("/{id}")
    public Article detail(@PathVariable Integer id) {
        return articleMapper.findById(id);
    }

    @PostMapping
    public void create(@RequestBody Article article) {
        articleMapper.insert(article);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        articleMapper.deleteById(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Integer id,
            @RequestBody Article article) {

        article.setId(id);
        articleMapper.update(article);
    }
}