package com.robin.GoSoftChallengeProjectAPI.repository;

import com.robin.GoSoftChallengeProjectAPI.model.Product;
import com.robin.GoSoftChallengeProjectAPI.model.Tutorial;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByNameContaining(String name);

    List<Product> findByStatus(boolean status);
}
