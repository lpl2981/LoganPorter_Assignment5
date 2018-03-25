package com.tech.productmanagement.service;

import java.util.List;
import java.util.Set;

import com.tech.productmanagement.model.AddProduct;

import lombok.NonNull;

public interface IProductService {

	 List<AddProduct> getProducts();

	 List<AddProduct> addToProduct(AddProduct ProductReqObj);
}
