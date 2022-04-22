package com.example.hello_springboot.controller;

import com.example.hello_springboot.entity.Product;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping(path = "api/v1/products")
@RestController
public class productController {
    public static List<Product> productList;
    static {
        productList = new ArrayList<>();
        productList.add(new Product(1,"ledat","aa",123,1));
        productList.add(new Product(1,"ledat","aa",123,1));
        productList.add(new Product(1,"ledat","aa",123,1));
        productList.add(new Product(1,"ledat","aa",123,1));
        productList.add(new Product(1,"ledat","aa",123,1));
    }
    @GetMapping("/")
    public List<Product> getProducts(){
        return  productList;
    }

    @PostMapping
    public  boolean saveProduct(@RequestBody Product product){
        productList.add(product);
        return true;
    }

    @DeleteMapping
    public  boolean deleteProduct(@PathVariable int id){
        return productList.removeIf(product -> product.getId() == id);
    }
}
