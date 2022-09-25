package com.productservicecatalog.productservicecatalog.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.productservicecatalog.productservicecatalog.model.Product;
import com.productservicecatalog.productservicecatalog.repository.ProductRepository;
import com.productservicecatalog.productservicecatalog.service.ProductService;
import com.productservicecatalog.productservicecatalog.vo.ProductVO;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	ProductRepository productRepo;

	@Override
	public List<ProductVO> getAllProducts() {

		List<Product> product = productRepo.findAll();

		return product.stream().map(products -> entityToVO(products)).collect(Collectors.toList());
	}

	@Override
	public ProductVO getProductById(Long id) {
		Product p1 = productRepo.findById(id).get();
		ProductVO pVo = entityToVO(p1);
		return pVo;
	}


	@Override
	public ProductVO getProductByName(String productName) {
	

		return null;
	}

	@Override
	public ProductVO createProduct(ProductVO pVo) {
		Product p=voToEntity(pVo);
		productRepo.save(p);
			return pVo;
	}
	private ProductVO entityToVO(Product p1) {
		ProductVO pVo = new ProductVO();
		pVo.setId(p1.getId());
		pVo.setProductName(p1.getProductName());
		pVo.setCategory(p1.getCategory());
		pVo.setAvailability(p1.getAvailability());
		pVo.setPrice(p1.getPrice());
		pVo.setDescription(p1.getDescription());
		return pVo;

	}

	private Product voToEntity(ProductVO pVo) {
		Product p1 = new Product();
		p1.setId(pVo.getId());
		p1.setProductName(pVo.getProductName());
		p1.setAvailability(pVo.getAvailability());
		p1.setCategory(pVo.getCategory());
		p1.setDescription(pVo.getDescription());
		p1.setPrice(pVo.getPrice());
		return p1;

	}

}
