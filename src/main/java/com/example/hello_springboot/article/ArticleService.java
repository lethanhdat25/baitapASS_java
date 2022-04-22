package com.example.hello_springboot.article;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleService {
    @Autowired
    private ArticleRepository articleRepository;

    public List<Article> findAll(){
       return articleRepository.findAll();
    }
    public Article save(Article article){
        return articleRepository.save(article);
    }
    public Optional<Article> findById(int id){
        return articleRepository.findById(id);
    }
    public void delete(int id){
        articleRepository.deleteById(id);
    }

}
