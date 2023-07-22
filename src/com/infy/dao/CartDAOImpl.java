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
import com.infy.entity.UserEntity;
import com.infy.model.Cart;
import com.infy.model.Product;

@Repository("cartDAOImpl")
public class CartDAOImpl implements CartDAO{
	
	@Autowired
	SessionFactory sessionFactory;
	
	public Integer addinto(Cart cart,Integer q){
		System.out.println("Hi from DAO "+cart.getEmailId() +q); 
		try{
	
		Session session=null;
		session=sessionFactory.getCurrentSession();
		ProductEntity pe=session.get(ProductEntity.class,cart.getProdid());
		if(pe.getStockavailable()<q){
			return null;			
		}
	
		CartEntity ce=new CartEntity();
		ce.setProdid(cart.getProdid());
		ce.setEmailId(cart.getEmailId());
		ce.setQuantity(q);
		session.persist(ce); //insert val to cart
		
		/*CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery(Object.class);
		Root<CartEntity> root = criteriaQuery.from(CartEntity.class);
		criteriaQuery.multiselect(criteriaBuilder.sum(root.get("quantity"))).where(criteriaBuilder.equal(root.get("emailId"), cart.getEmailId()));
		Query query = session.createQuery(criteriaQuery);*/
		
		
		UserEntity ue_for_Price=session.get(UserEntity.class,cart.getEmailId());
		ue_for_Price.setGrandTotal((pe.getPrice()*q)+ue_for_Price.getGrandTotal());
		session.persist(ue_for_Price);
		pe.setStockavailable(pe.getStockavailable()-q);
		//Integer sum = (Integer) query.getSingleResult();
		/*LOGIC TO SET TOTAL*/
//		ProductEntity p=new ProductEntity();
//		if(p.getProdid()==cart.getProdid()){
//			p.getPrice();
//			System.out.println(p.getPrice());
//		}
		
	//	System.out.println(sum);
		//UserEntity ue = session.get(UserEntity.class,cart.getEmailId());
	//	ue.setGrandTotal(sum);
		
		//session.persist(ue);
		return ue_for_Price.getGrandTotal();
		
		}catch(Exception e){
			System.out.println("Exception raised!");
			return null;
		}
	}
	
	
	public List<Product> getfinalcart(Cart cart){
		
		System.out.println("----------------------------------------------");
		Session session=null;
		session=sessionFactory.getCurrentSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<CartEntity> criteriaQuery= builder.createQuery(CartEntity.class);
        Root<CartEntity> root = criteriaQuery.from(CartEntity.class);
        
        criteriaQuery.select(root).where(
        		builder.equal(root.get("emailId"), cart.getEmailId())
				);

        
        Query query1 = session.createQuery(criteriaQuery);
        List<CartEntity> l=query1.getResultList();
        System.out.println(l);
        List<Product> pr=new ArrayList<>();
		
		for(CartEntity i : l)
		{
			System.out.println(i.getEmailId());
			ProductEntity po = session.get(ProductEntity.class,i.getProdid());
			Product prod=new Product();
			prod.setProdid(po.getProdid());
			prod.setCategory(po.getCategory());
			prod.setDescription(po.getDescription());
			prod.setPrice(po.getPrice());
			prod.setProdname(po.getProdname());
			prod.setStockavailable(i.getQuantity());
			prod.setSum(i.getQuantity()*po.getPrice());
			pr.add(prod);
		}
		return pr;
		
	}
	
	
	public Cart delete(Cart cart){
		if(cart==null) {
			return null;
		}
		Session session1=sessionFactory.getCurrentSession();
		Session session=sessionFactory.getCurrentSession();
		ProductEntity pe=session1.get(ProductEntity.class,cart.getProdid());
		
		CriteriaBuilder criteriaBuilder = session1.getCriteriaBuilder();
		CriteriaQuery<Object> criteriaQueryI = criteriaBuilder.createQuery(Object.class);
		Root<CartEntity> rootI = criteriaQueryI.from(CartEntity.class);
		criteriaQueryI.multiselect(criteriaBuilder.sum(rootI.get("quantity"))).where(criteriaBuilder.and(
					criteriaBuilder.equal(rootI.get("emailId"), cart.getEmailId()),
					criteriaBuilder.equal(rootI.get("prodid"), cart.getProdid())
					));
		Query query = session1.createQuery(criteriaQueryI);
		Integer sum = (Integer) query.getSingleResult();
		pe.setStockavailable(pe.getStockavailable()+sum);
		
		CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<CartEntity> criteriaQuery= builder.createQuery(CartEntity.class);
        Root<CartEntity> root = criteriaQuery.from(CartEntity.class);
        
        criteriaQuery.select(root).where(builder.and(
        		builder.equal(root.get("emailId"), cart.getEmailId()),
        		builder.equal(root.get("prodid"), cart.getProdid())
				));
     
        Query query1 = session.createQuery(criteriaQuery);
        List<CartEntity> l=query1.getResultList();
        System.out.println(l);
        
        for(CartEntity i: l){
      	System.out.println(i.getQuantity());
      	UserEntity ue=session1.get(UserEntity.class,cart.getEmailId());
		ue.setGrandTotal(ue.getGrandTotal()-(pe.getPrice()*i.getQuantity()));
      	session.delete(i);
      	System.out.println("hgjhb"+i.getEmailId());
        }
        
		return cart;
	}
	
	public Cart buy(String email){
		if(email==null) {
			return null;
		}
		Session session=sessionFactory.getCurrentSession();

		
//		
//		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
//		CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery(Object.class);
//		Root<CartEntity> root = criteriaQuery.from(CartEntity.class);
//		criteriaQuery.multiselect(criteriaBuilder.sum(root.get("quantity"))).where(criteriaBuilder.and(
//					criteriaBuilder.equal(root.get("emailId"), email)
//					));
//		Query query = session1.createQuery(criteriaQueryI);
//		Integer sum = (Integer) query.getSingleResult();
//		pe.setStockavailable(pe.getStockavailable()+sum);
		
		CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<CartEntity> criteriaQuery= builder.createQuery(CartEntity.class);
        Root<CartEntity> root = criteriaQuery.from(CartEntity.class);
        
        criteriaQuery.select(root).where(builder.and(
        		builder.equal(root.get("emailId"),email)
				));
     
        Query query = session.createQuery(criteriaQuery);
        List<CartEntity> l=query.getResultList();
        System.out.println(l);
        
        for(CartEntity i: l){
        UserEntity ue=session.get(UserEntity.class, i.getEmailId());
		ue.setGrandTotal(0);
      	session.delete(i);
      	System.out.println("hgjhb"+i.getEmailId());
        }
        Cart c= new Cart();
        c.setEmailId(email);
		return c;
	}
	
}


