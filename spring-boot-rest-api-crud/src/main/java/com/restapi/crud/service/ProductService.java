/**
 * 
 */
package com.restapi.crud.service;

import java.util.List;
//import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.restapi.crud.dao.ProductRepository;
import com.restapi.crud.model.Product;

/**
 * @author AR
 *
 */
@Service
//@Transactional
public class ProductService {
	@Autowired
	private ProductRepository repo;

	public List<Product> listAll() {
		return (List<Product>) repo.findAll();
	}

	public void save(Product product) {
		repo.save(product);
	}

	public Product get(int id) {
		return repo.findById(id).get();

	}

	public void delete(Integer id) {
		repo.deleteById(id);
	}
}
