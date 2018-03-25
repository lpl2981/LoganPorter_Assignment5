package com.tech.productmanagement.dao.impl;

import java.util.List;
import java.util.Set;

import com.tech.productmanagement.model.AddProduct;

public interface IProductDAO {

	  List<AddProduct> getProducts();
	  List<AddProduct> addToProduct(AddProduct ProductReqObj);
}
