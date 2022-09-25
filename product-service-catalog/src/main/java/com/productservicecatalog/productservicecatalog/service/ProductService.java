package com.productservicecatalog.productservicecatalog.service;

import java.util.List;

import com.productservicecatalog.productservicecatalog.vo.ProductVO;

public interface ProductService {
	List<ProductVO> getAllProducts();
	
	ProductVO getProductById(Long id);
	
	ProductVO getProductByName(String productName);
	
	ProductVO createProduct(ProductVO pVo);
	

}
