package com.example.productservice.controller;
import com.example.productservice.model.Product;
import com.example.productservice.repository.ProductRepository;
//обёртка HTTP-ответов
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductRepository repository;

    public ProductController(ProductRepository repository){
        this.repository = repository;
    }

    //таймаут
    public void simDelay(){
        try{
            int delay = ThreadLocalRandom.current().nextInt(500,1500);
            Thread.sleep(delay);
        } catch(InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }

    @GetMapping
    public List<Product> getAllProducts(){
        return repository.findAll();
    }

    //получить товар id
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id){
        simDelay();
        Optional<Product> product = repository.findById(id);
        return product.map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    //добавить новый товар
    @PostMapping
    public Product createProduct(@RequestBody Product product){
        simDelay();
        return repository.save(product);
    }

    //обновить товар
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product updated){
        simDelay();
        return repository.findById(id).map(product ->{
            updated.setId(id);
            return ResponseEntity.ok(repository.save(updated));
        }).orElse(ResponseEntity.notFound().build());
    }

    //удалить товар
    @DeleteMapping("/{id}")
    public ResponseEntity <Void> deleteProduct(@PathVariable Long id){
        simDelay();
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
