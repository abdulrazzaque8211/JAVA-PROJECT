/**
 * 
 */
package com.restapi.crud.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.crud.model.Product;
import com.restapi.crud.service.ProductService;

/**
 * @author AR
 *
 */
@RestController
public class ProductController {
	@Autowired
	ProductService productService;

//	CREATE
	@PostMapping("/products")
	public void add(@RequestBody Product product) {
		productService.save(product);
		System.out.println(product);
	}

//	READ
	@GetMapping("/products")
	public List<Product> list() {
		return (List<Product>) productService.listAll();
	}

//	UPDATE
	@PutMapping("/products/{id}")
	public ResponseEntity<?> update(@RequestBody Product product, @PathVariable("id") int id) {
		try {
			Product existProduct = productService.get(id);
			productService.save(product);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

//	DELETE
	@DeleteMapping("/products/{id}")
	public void delete(@PathVariable("id") int id) {
		productService.delete(id);
	}
 
}
