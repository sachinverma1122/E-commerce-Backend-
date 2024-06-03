package com.ecomm.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecomm.Dto.ProductDTO;
import com.ecomm.Entity.Product;
import com.ecomm.Service.impl.ProductServiceImpl;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/products")
public class ProductController {

	@Autowired
	private ProductServiceImpl productServiceimpl;

	@PostMapping
	public ResponseEntity<ProductDTO> addProduct(@RequestBody ProductDTO productDTO) {
		// Product product = convertToEntity(productDTO);
		ProductDTO addProductDto = productServiceimpl.addProduct(productDTO);
		return new ResponseEntity<>(addProductDto, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
    public ResponseEntity<ProductDTO> updateProduct(@PathVariable Long id, @RequestBody ProductDTO productDTO) {
        //Optional<ProductDTO> existingProduct = productServiceimpl.getProductById(id);
	Optional<ProductDTO> existingProduct = productServiceimpl.getProductById(id);
        if (existingProduct.isPresent()) {
           
             ProductDTO updateProduct = productServiceimpl.updateProduct(id, productDTO);
            return new ResponseEntity<ProductDTO>(updateProduct, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

	@GetMapping("/{id}")
	public ResponseEntity<ProductDTO> getProductById(@PathVariable Long id) {
		Optional<ProductDTO> productById = productServiceimpl.getProductById(id);
		return productById.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
				.orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
		Optional<ProductDTO> productDto = productServiceimpl.getProductById(id);
		if (productDto.isPresent()) {
			productServiceimpl.deleteProduct(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/getAll")
	public List<ProductDTO> getAllProducts() {
		return productServiceimpl.getAllProducts();
	}

	@GetMapping("/search")
    public List<ProductDTO> searchProducts(@RequestParam String keyword) {
        return productServiceimpl.searchProducts(keyword);
    }
	
}
