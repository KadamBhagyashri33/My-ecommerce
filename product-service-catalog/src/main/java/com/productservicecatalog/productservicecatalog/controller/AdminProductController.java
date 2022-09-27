package com.productservicecatalog.productservicecatalog.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.productservicecatalog.productservicecatalog.service.ProductService;
import com.productservicecatalog.productservicecatalog.vo.ProductVO;

import ch.qos.logback.classic.Logger;

@RestController
@RequestMapping("/admin")
public class AdminProductController {
	private final Logger LOGGER = (Logger) LoggerFactory.getLogger(this.getClass());

	@Autowired
	ProductService productService;

	@GetMapping("/products")
	public List<ProductVO> allProducts() {
		LOGGER.info("inside class!!!AdminProductController,method!!!:allProducts");
		return productService.getAllProducts();
	}

	@GetMapping("/products/{id}")
	public ProductVO productById(@PathVariable(name = "id") Long id) {
		LOGGER.info("inside method:productById {}" + id);
		// LOGGER.warn("This is a warn message");
		// LOGGER.error("This is an error message");

		return productService.getProductById(id);
	}

	@PostMapping("/products")
	public ProductVO addProduct(@Valid @RequestBody ProductVO productVo) {
		// LOGGER.info("product details entered{}"ProductVO.class.toString());
		// LOGGER.info(ProductVO.class.toString());

		return productService.createProduct(productVo);

	}

	@DeleteMapping("/products/{id}")
	@ResponseBody
	public String deleteProductById(@PathVariable(name = "id") Long id) {
		productService.deleteProduct(id);
		return "deleted successfully";
	}

}
