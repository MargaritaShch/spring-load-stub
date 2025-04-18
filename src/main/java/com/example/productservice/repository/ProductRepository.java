package com.example.productservice.repository;
import com.example.productservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

//интерфейс работающий с таблицей Product
public interface ProductRepository extends JpaRepository <Product,Long> {
    
}
