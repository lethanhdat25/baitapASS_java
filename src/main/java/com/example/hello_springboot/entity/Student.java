package com.example.hello_springboot.entity;

import lombok.*;
import org.springframework.web.bind.annotation.RequestMapping;

@Getter
@Setter
@NoArgsConstructor
@ToString

public class Student {

    public String name;
    public int age;
}
