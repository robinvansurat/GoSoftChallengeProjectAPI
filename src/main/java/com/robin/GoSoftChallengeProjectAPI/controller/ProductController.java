package com.robin.GoSoftChallengeProjectAPI.controller;

import com.robin.GoSoftChallengeProjectAPI.model.Product;
import com.robin.GoSoftChallengeProjectAPI.model.Tutorial;
import com.robin.GoSoftChallengeProjectAPI.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
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

    @PutMapping(path = "/products/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable("id") long id, @RequestBody Product product) {
        Optional<Product> productData = productRepository.findById(id);
        if (productData.isPresent()) {
            Product _product = productData.get();
            _product.setName(product.getName());
            _product.setDetail(product.getDetail());
            _product.setImages(product.getImages());
            _product.setPrice(product.getPrice());
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            _product.setUpdate_at(timestamp);
            return new ResponseEntity<>(productRepository.save(_product), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/products/{id}")
    public ResponseEntity<HttpStatus> deleteProduct(@PathVariable("id") long id) {
        try {
            productRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/products")
    public ResponseEntity<HttpStatus> deleteAllTutorials() {
        try {
            productRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    @GetMapping("/products/status")
//    public ResponseEntity<List<Tutorial>> findByPublished() {
//        try {
//            List<Product> product = productRepository.findByStatus(true);
//            if (product.isEmpty()) {
//                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//            }
//            return new ResponseEntity<>(product, HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
}
