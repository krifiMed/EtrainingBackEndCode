package com.bushansirgur.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bushansirgur.model.Book;
import com.bushansirgur.model.Inscrit_institut;

@Repository
public class Inscrit_InstituDAOImpl implements inscrit_InstitutDAO {

	@Autowired
	   private SessionFactory sessionFactory;
	
	@Override
	public long save(Inscrit_institut inscrit) {
		 sessionFactory.getCurrentSession().save(inscrit);
	      return inscrit.getId();
	}

	@Override
	public List<Inscrit_institut> list() {
		List<Inscrit_institut> list = sessionFactory.getCurrentSession().createQuery("from Inscrit_institut").list();
	      return list;
	}

	@Override
	public void update(long id, Inscrit_institut inscrit) {
		 Session session = sessionFactory.getCurrentSession();
	      Inscrit_institut book2 = session.byId(Inscrit_institut.class).load(id);
	      book2.setValide(true);
	      session.flush();
		
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		
		Inscrit_institut book = sessionFactory.getCurrentSession().byId(Inscrit_institut.class).load(id);
	      sessionFactory.getCurrentSession().delete(book);
		
	}

	@Override
	public Inscrit_institut get(long id) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().get(Inscrit_institut.class, id);
	}

}
