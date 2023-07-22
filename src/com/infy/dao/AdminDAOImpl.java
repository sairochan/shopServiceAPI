package com.infy.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.infy.entity.AdminEntity;
import com.infy.entity.UserEntity;
import com.infy.model.Admin;
import com.infy.model.users;

@Repository("adminDAOImpl")
public class AdminDAOImpl implements AdminDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	public Admin getUsernameAndPassword(String username) {
	
		Session session=sessionFactory.getCurrentSession();
		AdminEntity ae = session.get(AdminEntity.class, username);
		
//		CriteriaBuilder cb=session.getCriteriaBuilder();
//		CriteriaQuery<AdminEntity> cq=cb.createQuery(AdminEntity.class);
//		Root<AdminEntity> root=cq.from(AdminEntity.class);
//		cq.select(root.get("username"))
//		Query q=session.createQuery("select * from Admin where username="+username);
//		AdminEntity ae1=(AdminEntity) q.getSingleResult();
		
		Admin a=new Admin();
		a.setUsername(ae.getUsername());
		a.setPassword(ae.getPassword());
		a.setName(ae.getName());
		
		return a;
	}
	
	public users getUserdet(String email){
		Session session=sessionFactory.getCurrentSession();
		UserEntity ue = session.get(UserEntity.class, email);
		users u =new users();
		u.setEmailId(ue.getEmailId());
		u.setName(ue.getName());
		u.setPassword(ue.getPassword());
		u.setPhoneNo(ue.getPhoneNo());
		return u;
	}
}
