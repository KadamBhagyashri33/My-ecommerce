package com.productservicecatalog.productservicecatalog.service;

import java.util.List;

import com.productservicecatalog.productservicecatalog.vo.ProductVO;

public interface ProductService {
	List<ProductVO> getAllProducts();

	ProductVO getProductById(Long id);

	public ProductVO createProduct(ProductVO pVo);

	public void deleteProduct(Long id);

	public List<ProductVO> getAllByCategory(String category);

	public List<ProductVO> getAllByProductName(String productName);

}
