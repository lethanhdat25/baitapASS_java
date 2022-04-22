package com.example.hello_springboot.article;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping(path = "api/v1/article")
public class ArticleController {
    @Autowired
    public ArticleService articleService;
    @RequestMapping(method = RequestMethod.GET)
    public List<Article> findAll(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int limit){
        return articleService.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Article> save(@RequestBody Article article){
        System.out.println(article);
        return ResponseEntity.ok(articleService.save(article));
    }

    @RequestMapping(method = RequestMethod.PUT, path = "{id}")
    public ResponseEntity<Article> update(@PathVariable int id, @RequestBody Article article) {
        Optional<Article> articleOptional = articleService.findById(id);
        if (!articleOptional.isPresent()) {
            ResponseEntity.badRequest().build();
        }
        Article existArticle = articleOptional.get();
        // map object
        existArticle.setTitle(article.title);
        existArticle.setDescription(article.description);
        existArticle.setCategory(article.category);
        existArticle.setImage(article.image);
        existArticle.setStatus(article.status);
        return ResponseEntity.ok(articleService.save(existArticle));
    }

    @RequestMapping(method = RequestMethod.GET, path = "{id}")
    public Optional<Article> findById(@PathVariable int id) {
        return articleService.findById(id);

    }
    @RequestMapping(method = RequestMethod.DELETE, path = "{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        if (!articleService.findById(id).isPresent()) {
            ResponseEntity.badRequest().build();
        }
        articleService.delete(id);
        return ResponseEntity.ok().build();
    }

}
