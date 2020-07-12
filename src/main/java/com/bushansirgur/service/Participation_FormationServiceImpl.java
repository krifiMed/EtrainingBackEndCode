package com.bushansirgur.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bushansirgur.dao.InsititutDAO;
import com.bushansirgur.dao.Participation_FormationDAO;
import com.bushansirgur.model.Institut;
import com.bushansirgur.model.Participation_Formation;

@Service
public class Participation_FormationServiceImpl implements Participation_FormationService {
	
	 @Autowired
	   private Participation_FormationDAO participationDao;

	@Transactional
	@Override
	public long save(Participation_Formation participation) {
		// TODO Auto-generated method stub
		return participationDao.save(participation);
	}

	@Transactional
	@Override
	public Participation_Formation get(long id) {
		// TODO Auto-generated method stub
		return participationDao.getByid(id);
	}

	@Transactional
	@Override
	public List<Participation_Formation> list() {
		// TODO Auto-generated method stub
		return participationDao.list();
	}

	@Transactional
	@Override
	public void update(long id, Participation_Formation participation) {
		// TODO Auto-generated method stub
		participationDao.update(id, participation);
		
	}

	@Transactional
	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		participationDao.delete(id);
		
	}

	@Transactional
	@Override
	public void updatePresnece(long id, Participation_Formation participation) {
		// TODO Auto-generated method stub
		participationDao.updatePresnece(id, participation);
		
	}

	@Transactional
	@Override
	public void updateNote(long id, Participation_Formation participation) {
		// TODO Auto-generated method stub
		participationDao.updateNote(id, participation);
		
	}

}
