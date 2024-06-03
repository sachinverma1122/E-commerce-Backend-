package com.ecomm.Service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecomm.Dto.ProductDTO;
import com.ecomm.Entity.Product;
import com.ecomm.Service.ProductService;
import com.ecomm.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductRepository productRepository;

	@Override
	public ProductDTO addProduct(ProductDTO productDTO) {
		Product product = new Product();
		product.setId(productDTO.getId());
		product.setName(productDTO.getName());
		product.setColor(productDTO.getColor());
		product.setCategory(productDTO.getCategory());
		product.setDescription(productDTO.getDescription());
		product.setImage(productDTO.getImage());
		product.setPrice(productDTO.getPrice());
		Product save = productRepository.save(product);

		ProductDTO DTO2 = new ProductDTO();
		DTO2.setId(save.getId());
		DTO2.setName(save.getName());
		DTO2.setColor(save.getColor());
		DTO2.setCategory(save.getCategory());
		DTO2.setDescription(save.getDescription());
		DTO2.setImage(save.getImage());
		DTO2.setPrice(save.getPrice());
		return DTO2;
	}

	@Override
	public Optional<ProductDTO> getProductById(Long id) {
		Optional<Product> findById = productRepository.findById(id);
		ProductDTO dto = new ProductDTO();
		dto.setId(findById.get().getId());
		dto.setName(findById.get().getName());
		dto.setColor(findById.get().getColor());
		dto.setCategory(findById.get().getCategory());
		dto.setDescription(findById.get().getDescription());
		dto.setImage(findById.get().getImage());
		dto.setPrice(findById.get().getPrice());
		return Optional.of(dto);
	}

	@Override
	public List<ProductDTO> getAllProducts() {
		List<Product> productList = productRepository.findAll();
		List<ProductDTO> Listdto = new ArrayList<>();
		for (Product product : productList) {
			ProductDTO dto = new ProductDTO();
			dto.setId(product.getId());
			dto.setName(product.getName());
			dto.setColor(product.getColor());
			dto.setCategory(product.getCategory());
			dto.setDescription(product.getDescription());
			dto.setImage(product.getImage());
			dto.setPrice(product.getPrice());
			Listdto.add(dto);
		}
		return Listdto;

	}

	@Override
	public ProductDTO updateProduct(Long id, ProductDTO updatedProduct) {
        updatedProduct.setId(id);
        Product product = new Product();
        product.setId(updatedProduct.getId());
        product.setName(updatedProduct.getName());
        product.setColor(updatedProduct.getColor());
        product.setCategory(updatedProduct.getCategory());
        product.setDescription(updatedProduct.getDescription());
        product.setImage(updatedProduct.getImage());
        product.setPrice(updatedProduct.getPrice());
        
        Product save = productRepository.save(product);
        ProductDTO dto = new ProductDTO();
		dto.setId(save.getId());
		dto.setName(save.getName());
		dto.setColor(save.getColor());
		dto.setCategory(save.getCategory());
		dto.setDescription(save.getDescription());
		dto.setImage(save.getImage());
		dto.setPrice(save.getPrice());
        
        return dto;
    }

	@Override
	public void deleteProduct(Long id) {
		productRepository.deleteById(id);

	}
	
	@Override
    public List<ProductDTO> searchProducts(String keyword) {
		 List<Product> products = productRepository.searchProducts(keyword);
	        List<ProductDTO> productDTOs = new ArrayList<>();
	        for (Product product : products) {
	            productDTOs.add(convertToDTO(product));
	        }
	        return productDTOs;
	}
	
	private ProductDTO convertToDTO(Product product) {
		ProductDTO dto = new ProductDTO();
		dto.setId(product.getId());
		dto.setName(product.getName());
		dto.setColor(product.getColor());
		dto.setCategory(product.getCategory());
		dto.setDescription(product.getDescription());
		dto.setImage(product.getImage());
		dto.setPrice(product.getPrice());
		return dto;
        // Convert Product entity to ProductDTO
    }

}
