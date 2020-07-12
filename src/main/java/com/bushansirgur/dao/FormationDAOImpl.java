package com.bushansirgur.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bushansirgur.model.Book;
import com.bushansirgur.model.Formation;

@Repository
public class FormationDAOImpl implements FormationDAO {

	@Autowired
	   private SessionFactory sessionFactory;

	@Override
	public long save(Formation formation) {
		sessionFactory.getCurrentSession().save(formation);
	      return formation.getId();
	}

	@Override
	public Formation get(long id) {
		return sessionFactory.getCurrentSession().get(Formation.class, id);
	}

	@Override
	public List<Formation> list() {
		List<Formation> list = sessionFactory.getCurrentSession().createQuery("from Formation").list();
	      return list;
	}

	@Override
	public void update(long id, Formation formation) {
		Session session = sessionFactory.getCurrentSession();
	      Formation for2 = session.byId(Formation.class).load(id);
	      for2.setName(formation.getName());
	      for2.setType(formation.getType());
	      for2.setDescription(formation.getDescription());
	      for2.setDate(formation.getDate());
	      session.flush();
		
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
	      Formation formation = sessionFactory.getCurrentSession().byId(Formation.class).load(id);
	      formation.setDeleted(true);
	      session.flush();
		
	}
	
	
	

}
