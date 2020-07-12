package com.bushansirgur.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bushansirgur.dao.FormationDAO;
import com.bushansirgur.dao.inscrit_InstitutDAO;
import com.bushansirgur.model.Inscrit_institut;

@Service
public class Inscrit_InstitutServiceImpl implements Inscrit_InstitutService {

	@Autowired
	   private inscrit_InstitutDAO inscritDao;
	@Transactional
	@Override
	public long save(Inscrit_institut inscrit) {
		// TODO Auto-generated method stub
		return inscritDao.save(inscrit);
	}
	
	@Transactional
	@Override
	public List<Inscrit_institut> list() {
		// TODO Auto-generated method stub
		return inscritDao.list();
	}

	@Transactional
	@Override
	public void update(long id, Inscrit_institut inscrit) {
		// TODO Auto-generated method stub
		inscritDao.update(id, inscrit);
		
	}

	@Transactional
	@Override
	public void delete(long id) {
		inscritDao.delete(id);
		
	}

	@Transactional
	@Override
	public Inscrit_institut get(long id) {
		// TODO Auto-generated method stub
		return inscritDao.get(id);
	}

}
