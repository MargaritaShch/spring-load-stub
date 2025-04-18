package com.example.productservice.model;
import jakarta.persistence.*;

//сущность в БД
@Entity
public class Product {
    @Id
    //БД сама генерит значение ID
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String category;
    private Double price;
    private Integer stock;

    public Product(){}

    //получить значение поля 
    public Long getId(){
        return id;
    }

    //установить новое значение поля
    public void setId(Long id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getCategory(){
        return category;
    }

    public void setCategory(String category){
        this.category = category;
    }

    public Double getPrice(){
        return price;
    }

    public void setPrice(Double price){
        this.price = price;
    }

    public Integer getStock(){
        return stock;
    }

    public void setStock(Integer stock){
        this.stock = stock;
    }
}
