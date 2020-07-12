package com.bushansirgur.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bushansirgur.model.Formation;
import com.bushansirgur.model.Institut;

@Repository
public class InsctitutDAOImpl implements InsititutDAO {
	
	@Autowired
	   private SessionFactory sessionFactory;

	@Override
	public long save(Institut institut) {
		sessionFactory.getCurrentSession().save(institut);
	      return institut.getId();
	}

	@Override
	public Institut get(long id) {
		// TODO Auto-generated method stub
		 return sessionFactory.getCurrentSession().get(Institut.class, id);
	}

	@Override
	public List<Institut> list() {
		List<Institut> list = sessionFactory.getCurrentSession().createQuery("from Institut").list();
	      return list;
	}

	@Override
	public void update(long id, Institut institut) {
		// TODO Auto-generated method stub
		
		Session session = sessionFactory.getCurrentSession();
	      Institut institut2 = session.byId(Institut.class).load(id);
	      institut2.setName(institut.getName());
	      institut2.setAdresse(institut.getAdresse());
	      institut2.setTel(institut.getTel());
	      institut2.setNombre(institut.getNombre());
	      session.flush();
		
	}

	@Override
	public void delete(long id) {
				Session session = sessionFactory.getCurrentSession();
			      Institut institut = sessionFactory.getCurrentSession().byId(Institut.class).load(id);
			      institut.setDeleted(true);			      
			      session.flush();
		
	}

}
