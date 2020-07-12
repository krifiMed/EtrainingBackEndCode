package com.bushansirgur.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bushansirgur.model.Institut;
import com.bushansirgur.model.Participation_Formation;

@Repository
public class Participation_FormationImpl implements Participation_FormationDAO {
	

	@Autowired
	   private SessionFactory sessionFactory;

	@Override
	public long save(Participation_Formation participation) {
		sessionFactory.getCurrentSession().save(participation);
	      return participation.getId();
	}


	@Override
	public List<Participation_Formation> list() {
		List<Participation_Formation> list = sessionFactory.getCurrentSession().createQuery("from Participation_Formation").list();
	      return list;
	}

	@Override
	public void update(long id, Participation_Formation participation) {
		
				Session session = sessionFactory.getCurrentSession();
			      Participation_Formation institut2 = session.byId(Participation_Formation.class).load(id);
			      institut2.setValide(true);      
			      session.flush();
		
	}

	@Override
	public void delete(long id) {
		Session session = sessionFactory.getCurrentSession();
	      Participation_Formation p = sessionFactory.getCurrentSession().byId(Participation_Formation.class).load(id);
	      sessionFactory.getCurrentSession().delete(p);
		
	}

	@Override
	public Participation_Formation getByUser(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Participation_Formation getByFormation(long id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Participation_Formation getByid(long id) {
		// TODO Auto-generated method stub
		  return sessionFactory.getCurrentSession().get(Participation_Formation.class, id);
	}


	@Override
	public void updatePresnece(long id, Participation_Formation participation) {
		Session session = sessionFactory.getCurrentSession();
	      Participation_Formation institut2 = session.byId(Participation_Formation.class).load(id);
	      institut2.setPresence(true);     
	      System.out.println(institut2);
	      session.flush();
		
	}


	@Override
	public void updateNote(long id, Participation_Formation participation) {
		Session session = sessionFactory.getCurrentSession();
	      Participation_Formation institut2 = session.byId(Participation_Formation.class).load(id);
	      institut2.setNote(participation.getNote());      
	      session.flush();
		
	}

}
