package com.robin.GoSoftChallengeProjectAPI.controller;

import com.robin.GoSoftChallengeProjectAPI.model.Product;
import com.robin.GoSoftChallengeProjectAPI.model.Tutorial;
import com.robin.GoSoftChallengeProjectAPI.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class ProductController {
    @Autowired
    ProductRepository productRepository;

    @GetMapping(path = "/products")
    public ResponseEntity<List<Product>> getAllProducts(@RequestParam(required = false) String name){
        try {
            List<Product> products = new ArrayList<Product>();
            if (name == null) {
                productRepository.findAll(Sort.by(Sort.Direction.ASC, "id")).forEach(products::add);
            } else {
                productRepository.findByNameContaining(name).forEach(products::add);
            }

            if (products.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(products, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    };

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") long id) {
        Optional<Product> productData = productRepository.findById(id);
        if (productData.isPresent()) {
            return new ResponseEntity<>(productData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(path = "/products")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
//        return ResponseEntity.ok("post tutorials");
        try {
            Product _product = productRepository.save(new Product(product.getName(), product.getDetail(), product.getPrice(), false, product.getImages()));
            return new ResponseEntity<>(_product, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
