package com.tech.productmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.google.common.base.Preconditions;
import com.tech.productmanagement.dao.impl.IProductDAO;
import com.tech.productmanagement.model.AddProduct;

import lombok.NonNull;

@Service
public class ProductService implements IProductService{
	 @Autowired
	    IProductDAO iProductDAO;
	public List<AddProduct> getProducts() {
		List<AddProduct> products = iProductDAO.getProducts();
		return products;
		
	}
	@Override
	public List<AddProduct> addToProduct(AddProduct ProductReqObj){
		List<AddProduct> products = iProductDAO.addToProduct(ProductReqObj);
        return products;
	}
}
