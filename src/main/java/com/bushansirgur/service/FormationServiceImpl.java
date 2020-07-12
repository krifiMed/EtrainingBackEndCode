package com.bushansirgur.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bushansirgur.dao.BookDao;
import com.bushansirgur.dao.FormationDAO;
import com.bushansirgur.model.Book;
import com.bushansirgur.model.Formation;

@Service
public class FormationServiceImpl implements FormationService {
	
	 @Autowired
	   private FormationDAO formationDao;

	@Transactional
	@Override
	public long save(Formation formation) {
		// TODO Auto-generated method stub
		 return formationDao.save(formation);
	}
	@Transactional
	@Override
	public Formation get(long id) {
		// TODO Auto-generated method stub
		return formationDao.get(id);
	}
	@Transactional
	@Override
	public List<Formation> list() {
		// TODO Auto-generated method stub
		return formationDao.list();
	}
	@Transactional
	@Override
	public void update(long id, Formation formation) {
		formationDao.update(id, formation);
		
	}
	@Transactional
	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		formationDao.delete(id);	
	}

}
