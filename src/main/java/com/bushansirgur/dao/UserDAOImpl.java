package com.bushansirgur.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bushansirgur.model.Book;
import com.bushansirgur.model.Institut;
import com.bushansirgur.model.User;
import com.bushansirgur.model.role;

@Repository
public class UserDAOImpl implements UserDAO {

	//injection de dependance
	@Autowired
	   private SessionFactory sessionFactory;
	
	@Override
	public User get(long id) {
		// TODO Auto-generated method stub
		 return sessionFactory.getCurrentSession().get(User.class, id);
	}

	@Override
	public List<User> list() {
		List<User> list = sessionFactory.getCurrentSession().createQuery("from User").list();
	      return list;
	}

	@Override
	public long save(User book) {
		sessionFactory.getCurrentSession().save(book);
	      return book.getId();
	}

	@Override
	public void update(long id, User u) {
		Session session = sessionFactory.getCurrentSession();
	      User user2 = session.byId(User.class).load(id);
	      user2.setFirstName(u.getFirstName());
	      user2.setLastName(u.getLastName());
	      user2.setEmail(u.getEmail());
	      user2.setDiplome(u.getDiplome());
	      user2.setPassword(u.getPassword());   
	      user2.setDate(u.getDate());
	      user2.setRole(u.getRole());
	      user2.setSpecialite(u.getSpecialite());
	      user2.setDiplome(u.getDiplome());
	      user2.setIsactive(true);
	      session.flush();
		
	}

	@Override
	public void delete(long id) {
		User book = sessionFactory.getCurrentSession().byId(User.class).load(id);
	      sessionFactory.getCurrentSession().delete(book);
		
	}

}
