package com.infy.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;





import com.infy.entity.CartEntity;
import com.infy.entity.ProductEntity;
import com.infy.model.Product;

@Repository("productDAOImpl")
public class ProductDAOImpl implements ProductDAO{

	@Autowired
	SessionFactory sessionFactory;
	
	public Product addProduct(Product product){
		if(product==null) {
			return null;
		}
		Session session=null;
		session=sessionFactory.getCurrentSession();
		ProductEntity po=new ProductEntity();
//		po.setProdid(product.getProdid());
		po.setCategory(product.getCategory());
		po.setImg(product.getImg());
		po.setDescription(product.getDescription());
		po.setPrice(product.getPrice());
		po.setProdname(product.getProdname());
		po.setStockavailable(product.getStockavailable());
		session.persist(po);
		return product;
	}
	 
	public Product deleteProduct(Product product){
		if(product==null) {
			return null;
		}
		Session session=sessionFactory.getCurrentSession();
		ProductEntity po = session.get(ProductEntity.class,product.getProdid());
		session.delete(po);
		return product;
		
	}
	
	public Product updateProduct(Product product){
		Session session=null;
		session=sessionFactory.getCurrentSession();
		ProductEntity po = session.get(ProductEntity.class,product.getProdid());
		
		if(po==null) {
			return null;
		}
		
		if (po!=null)
		{
			po.setProdid(product.getProdid());
			po.setCategory(product.getCategory());
			po.setImg(product.getImg());
			po.setDescription(product.getDescription());
			po.setPrice(product.getPrice());
			po.setProdname(product.getProdname());
			po.setStockavailable(product.getStockavailable());
		}
		return product;
	}
	
	public Product showProduct(Product product){
		System.out.println("**************************************");
		Session session=null;
		session=sessionFactory.getCurrentSession();
		ProductEntity po = session.get(ProductEntity.class,product.getProdid());
		if(po==null) {
			return null;
		}
		if (po!=null)
		{
			product.setProdid(po.getProdid());
			product.setCategory(po.getCategory());
			product.setImg(po.getImg());
			product.setImg(po.getImg());
			product.setDescription(po.getDescription());
			product.setPrice(po.getPrice());
			product.setProdname(po.getProdname());
			product.setStockavailable(po.getStockavailable());
		}
		return product;
	}
	
	public List<Product> showProductName(Product product){
		System.out.println("----------------------------------------------");
		Session session=null;
		session=sessionFactory.getCurrentSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<ProductEntity> criteriaQuery= builder.createQuery(ProductEntity.class);
        Root<ProductEntity> root = criteriaQuery.from(ProductEntity.class);
        
        criteriaQuery.select(root).where(
        		builder.equal(root.get("prodname"), product.getProdname())
				);
        Query query1 = session.createQuery(criteriaQuery);
        List<ProductEntity> l=query1.getResultList();
        
        System.out.println(l);
		List<Product> pr=new ArrayList<>();
		
		for(ProductEntity i : l)
		{
			Product prod=new Product();
			prod.setProdid(i.getProdid());
			prod.setCategory(i.getCategory());
			prod.setImg(i.getImg());
			prod.setDescription(i.getDescription());
			prod.setPrice(i.getPrice());
			prod.setProdname(i.getProdname());
			prod.setStockavailable(i.getStockavailable());
			pr.add(prod);
		}
		return pr;
	}
	
	public List<Product> search(String s){
		System.out.println("----------------------------------------------131"); 
		List<Product> pr=new ArrayList<>();
		/*****************************for name***************************************/
		{Session session=null;
		session=sessionFactory.getCurrentSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<ProductEntity> criteriaQuery= builder.createQuery(ProductEntity.class);
        Root<ProductEntity> root = criteriaQuery.from(ProductEntity.class);
        
        criteriaQuery.select(root).where(
        		builder.like(builder.lower(root.get("prodname")), "%"+s.toLowerCase()+"%")
				);
        Query query1 = session.createQuery(criteriaQuery);
        List<ProductEntity> l=query1.getResultList();
        
        System.out.println(l);
		
		
		for(ProductEntity i : l)
		{
			Product prod=new Product();
			prod.setProdid(i.getProdid());
			prod.setCategory(i.getCategory());
			prod.setImg(i.getImg());
			prod.setDescription(i.getDescription());
			prod.setPrice(i.getPrice());
			prod.setProdname(i.getProdname());
			prod.setStockavailable(i.getStockavailable());
			System.out.println(prod.getProdname());
			pr.add(prod);
		}}
		
		/**************************for category******************************************/
		System.out.println("----------------------------------------------162"); 
		Session session2=null;
		System.out.println("----------------------------------------------164"); 
		session2=sessionFactory.getCurrentSession();
		CriteriaBuilder builder2 = session2.getCriteriaBuilder();
		System.out.println("----------------------------------------------166"); 
        CriteriaQuery<ProductEntity> criteriaQuery2= builder2.createQuery(ProductEntity.class);
        System.out.println("----------------------------------------------169"); 
        Root<ProductEntity> root2 = criteriaQuery2.from(ProductEntity.class);
        System.out.println("----------------------------------------------170"); 
        criteriaQuery2.select(root2).where(
        		builder2.like(builder2.lower(root2.get("category")), "%"+s.toLowerCase()+"%")
				);
        Query query2 = session2.createQuery(criteriaQuery2);
        List<ProductEntity> l2=query2.getResultList();
        System.out.println("----------------------------------------------178"); 
        
		
		for(ProductEntity i : l2)
		{
			Product prod=new Product();
			prod.setProdid(i.getProdid());
			prod.setCategory(i.getCategory());
			prod.setDescription(i.getDescription());
			prod.setImg(i.getImg());
			prod.setPrice(i.getPrice());
			prod.setProdname(i.getProdname());
			prod.setStockavailable(i.getStockavailable());
			System.out.println(prod.getCategory());
			pr.add(prod);
		}
		
		/**************************for disc******************************************/
		{Session session3=null;
		session3=sessionFactory.getCurrentSession();
		CriteriaBuilder builder3 = session3.getCriteriaBuilder();
        CriteriaQuery<ProductEntity> criteriaQuery3= builder3.createQuery(ProductEntity.class);
        Root<ProductEntity> root3 = criteriaQuery3.from(ProductEntity.class);
        
        criteriaQuery3.select(root3).where(
        		builder3.like(builder3.lower(root3.get("description")), "%"+s.toLowerCase()+"%")
				);
        Query query3 = session3.createQuery(criteriaQuery3);
        List<ProductEntity> l3=query3.getResultList();
        
        System.out.println(l3);
		
		for(ProductEntity i : l3)
		{
			Product prod=new Product();
			prod.setProdid(i.getProdid());
			prod.setCategory(i.getCategory());
			prod.setImg(i.getImg());
			prod.setDescription(i.getDescription());
			prod.setPrice(i.getPrice());
			prod.setProdname(i.getProdname());
			prod.setStockavailable(i.getStockavailable());
			pr.add(prod);
		}}
		
		return pr;
	}
	
	
	//29th April 2019 Mano Get by category
	public List<Product> showByCategory(Product product){
		Session session=null;
		session=sessionFactory.getCurrentSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<ProductEntity> criteriaQuery= builder.createQuery(ProductEntity.class);
        Root<ProductEntity> root = criteriaQuery.from(ProductEntity.class);
        
        criteriaQuery.select(root).where(
        		builder.equal(root.get("category"), product.getCategory())
				);
        Query query1 = session.createQuery(criteriaQuery);
        List<ProductEntity> l=query1.getResultList();
        
        List<Product> pr=new ArrayList<>();
		
		for(ProductEntity i : l)
		{
			Product prod=new Product();
			prod.setProdid(i.getProdid());
			prod.setCategory(i.getCategory());
			prod.setImg(i.getImg());
			prod.setDescription(i.getDescription());
			prod.setPrice(i.getPrice());
			prod.setProdname(i.getProdname());
			prod.setStockavailable(i.getStockavailable());
			pr.add(prod);
		}
		return pr;
	}
	
	
	
	
}
