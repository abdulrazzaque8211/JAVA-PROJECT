/**
 * 
 */
package com.restapi.crud.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import com.restapi.crud.model.Product;

/**
 * @author AR
 *
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
