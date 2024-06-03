package com.ecomm.Service;

import java.util.List;
import java.util.Optional;

import com.ecomm.Dto.ProductDTO;
import com.ecomm.Entity.Product;

public interface ProductService {

	 public ProductDTO addProduct(ProductDTO productDTO);
	 public Optional<ProductDTO> getProductById(Long id);
	 public List<ProductDTO> getAllProducts();
//	 public ProductDTO updateProduct(Long id, ProductDTO updatedProductDto);
	 public ProductDTO updateProduct(Long id, ProductDTO updatedProduct);
	 public void deleteProduct(Long id);
	 public List<ProductDTO> searchProducts(String keyword);
}
