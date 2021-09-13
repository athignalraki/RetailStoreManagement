package com.myapp.spring.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.spring.model.ShoppingCart;
import com.myapp.spring.repository.ShoppingCartRepository;
@RestController
@RequestMapping("/api/v1/shoppingcart")

public class ShoppingCartAPI {

	
	

		@Autowired
		private ShoppingCartRepository repo;
		
		@PostMapping
		public ResponseEntity<ShoppingCart> addProduct(@RequestBody ShoppingCart cart) {
			return new ResponseEntity<>(repo.save(cart), HttpStatus.CREATED);
		}
		
		@PostMapping
		public ResponseEntity<ShoppingCart> addProductQuantity(@RequestBody ShoppingCart cart) {
			return new ResponseEntity<>(repo.save(cart), HttpStatus.CREATED);
		}
		
		@PutMapping("/{id}")
		public ResponseEntity<ShoppingCart> updateProductQuantity(@PathVariable("id") String id, @RequestBody ShoppingCart product)
				throws ResourceNotFoundException {
			ShoppingCart existingProduct = repo.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Quantity not found for this id :: " + id));

			BeanUtils.copyProperties(product, existingProduct);

			return new ResponseEntity<ShoppingCart>(repo.save(existingProduct), HttpStatus.CREATED);
		}
		
		@DeleteMapping("/{id}")
		public Map<String, Boolean> delete(@PathVariable(value = "id") String id) throws ResourceNotFoundException {
			ShoppingCart product = repo.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + id));

			repo.delete(product);
			Map<String, Boolean> response = new HashMap<>();
			response.put("deleted", Boolean.TRUE);
			return response;
		}
		

		@GetMapping
		public ResponseEntity<List<ShoppingCart>> findAll() {
			return new ResponseEntity<List<ShoppingCart>>(repo.findAll(), HttpStatus.OK);
		}
	}
		

