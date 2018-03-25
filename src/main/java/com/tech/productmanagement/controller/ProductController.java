package com.tech.productmanagement.controller;

import java.util.List;

import java.util.Set;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tech.productmanagement.dao.impl.IProductDAO;
import com.tech.productmanagement.model.AddProduct;
import com.tech.productmanagement.service.IProductService;

@CrossOrigin(origins = "*")
@RestController
public class ProductController {
	private final Logger logger = Logger.getLogger("ProductController");

	@Autowired
	IProductService iProductService;
	
	 @Autowired
	    IProductDAO iProductDAO;

	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public ResponseEntity<List<AddProduct>> getProducts() {
		ResponseEntity res = null;
		List<AddProduct> product = iProductService.getProducts();
		res = new ResponseEntity<List<AddProduct>>(product, HttpStatus.OK);
		return res;
	}
	
	 @RequestMapping(value = "/addproduct", method = RequestMethod.POST)
	    public ResponseEntity<List<AddProduct>> addToProduct(@RequestBody AddProduct ProductReqObj ) {
	        List<AddProduct> products = iProductService.addToProduct(ProductReqObj);
	        logger.warning("created productId");
	        return new ResponseEntity<List<AddProduct>>(products, HttpStatus.CREATED);
	    }


}
