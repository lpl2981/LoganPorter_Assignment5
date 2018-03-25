package com.tech.productmanagement.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tech.productmanagement.dao.impl.IProductDAO;
import com.tech.productmanagement.model.AddProduct;

@Transactional
@Repository
public class ProductDAO implements IProductDAO{
	  @Autowired
	    private SessionFactory sessionFactory;
	  
	  public void setSessionFactory(SessionFactory sf) {
	        this.sessionFactory = sf;
	    }

	  
	public List<AddProduct> getProducts() {
		// TODO Auto-generated method stub
		 List<AddProduct> products = getProductEntities();
	        return products;
	}

	
	  private List<AddProduct> getProductEntities() {
		  Session session = this.sessionFactory.getCurrentSession();
	        List<AddProduct> productList = session.createQuery("select p from AddProduct p").list();
	        return productList;
	    }
	  
	  private Session getSession() {
	        return this.sessionFactory.getCurrentSession();
	    }

	public List<AddProduct> addToProduct(AddProduct ProductReqObj) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(ProductReqObj);
		List<AddProduct> products = session.createQuery("select p from AddProduct p").list();
		return products;
	}

}
