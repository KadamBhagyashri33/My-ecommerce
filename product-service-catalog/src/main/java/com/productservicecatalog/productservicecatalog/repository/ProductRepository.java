package com.productservicecatalog.productservicecatalog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.productservicecatalog.productservicecatalog.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
	List<Product> findAllByCategory(String category);
	List<Product> findAllByProductName(String productName);

}
