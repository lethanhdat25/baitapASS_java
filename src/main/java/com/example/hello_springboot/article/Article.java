package com.example.hello_springboot.article;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    public String title;
    public String description;
    public String image;
    public String category;

    @CreationTimestamp
    public Date create_at;
    @UpdateTimestamp
    public Date update_at;
    public String status;

    public Article(String title, String description, String image, String category, String status) {
        this.title = title;
        this.description = description;
        this.image = image;
        this.category = category;
        this.status = status;
    }
}
