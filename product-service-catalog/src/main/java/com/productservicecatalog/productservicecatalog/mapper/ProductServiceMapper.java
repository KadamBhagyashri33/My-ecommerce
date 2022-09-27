package com.productservicecatalog.productservicecatalog.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import com.productservicecatalog.productservicecatalog.model.Product;
import com.productservicecatalog.productservicecatalog.vo.ProductVO;

@Mapper(componentModel="spring")
public interface ProductServiceMapper {
	
	ProductServiceMapper mapper=Mappers.getMapper(ProductServiceMapper.class);
	
	Product voToEntity(ProductVO ProductVo);
	
	ProductVO entityTOVo(Product product);

}
