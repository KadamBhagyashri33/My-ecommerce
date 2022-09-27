package com.productservicecatalog.productservicecatalog.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productservicecatalog.productservicecatalog.exception.ProductNotFoundException;
import com.productservicecatalog.productservicecatalog.mapper.ProductServiceMapper;
import com.productservicecatalog.productservicecatalog.model.Product;
import com.productservicecatalog.productservicecatalog.repository.ProductRepository;
import com.productservicecatalog.productservicecatalog.service.ProductService;
import com.productservicecatalog.productservicecatalog.vo.ProductVO;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductServiceMapper productMapper;

	@Autowired
	private ProductRepository productRepo;

	@Override
	public List<ProductVO> getAllProducts() {

		List<Product> product = productRepo.findAll();

		return product.stream().map(products -> productMapper.entityTOVo(products)).collect(Collectors.toList());
	}

	@Override
	public ProductVO getProductById(Long id) {

		Product product = productRepo.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
		ProductVO productVo = productMapper.entityTOVo(product);
		return productVo;
	}

	@Override
	public ProductVO createProduct(ProductVO productVo) {
		Product product = productMapper.voToEntity(productVo);
		productRepo.save(product);
		ProductVO productvo = productMapper.entityTOVo(product);
		return productvo;

	}

	@Override
	public void deleteProduct(Long id) {
		productRepo.findById(id).orElseThrow(() -> new ProductNotFoundException(id));

		productRepo.deleteById(id);

	}

	@Override
	public List<ProductVO> getAllByCategory(String category) {
		List<Product> product = productRepo.findAllByCategory(category);
		List<ProductVO> productvos = product.stream().map(products -> productMapper.entityTOVo(products))
				.collect(Collectors.toList());

		return productvos;
	}

	@Override
	public List<ProductVO> getAllByProductName(String productName) {
		List<Product> product = productRepo.findAllByProductName(productName);

		return product.stream().map(products -> productMapper.entityTOVo(products)).collect(Collectors.toList());
	}

}
