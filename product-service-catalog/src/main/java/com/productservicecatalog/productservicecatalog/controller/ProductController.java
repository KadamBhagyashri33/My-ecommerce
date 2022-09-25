package com.productservicecatalog.productservicecatalog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.productservicecatalog.productservicecatalog.service.ProductService;
import com.productservicecatalog.productservicecatalog.vo.ProductVO;

@RestController
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	public ProductController(ProductService productService) {
		super();
		this.productService = productService;
	}
	
	
	@GetMapping("/products")
	public List<ProductVO> allProducts()
	{
		return productService.getAllProducts();
	}
	@GetMapping("/products/{id}")
	public ProductVO productById(@PathVariable(name="id") Long id)
	{
		return productService.getProductById(id);
	}
	@PostMapping("/products")
	public ProductVO addProduct(@RequestBody ProductVO pVo)
	{
		return productService.createProduct(pVo);
	}
	

}
