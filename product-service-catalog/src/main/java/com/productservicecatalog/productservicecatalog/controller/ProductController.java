package com.productservicecatalog.productservicecatalog.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.productservicecatalog.productservicecatalog.service.ProductService;
import com.productservicecatalog.productservicecatalog.vo.ProductVO;

@RestController
public class ProductController {
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	
	@Autowired
	ProductService productService;
	
	@GetMapping("/products")
	public List<ProductVO> getAllProducts()
	{
		return productService.getAllProducts();
	}
	
	@GetMapping("/products/{id}")
	public ProductVO getProductById(@PathVariable(name="id") Long id)
	{
		return productService.getProductById(id);
	}
	
	@GetMapping(value="/products",params="category")
	@ResponseBody
	public List<ProductVO> getAllProductsByCategory(@RequestParam("category") String category)
	{
		return productService.getAllByCategory(category);
	}

	@GetMapping(value="/products",params="productName")
	@ResponseBody
	public List<ProductVO> getAllProductsByproductName(@RequestParam("productName") String productName)
	{
		return productService.getAllByProductName(productName);
	}


}
