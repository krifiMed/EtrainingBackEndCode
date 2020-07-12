package com.bushansirgur.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bushansirgur.dao.FormationDAO;
import com.bushansirgur.dao.InsititutDAO;
import com.bushansirgur.model.Formation;
import com.bushansirgur.model.Institut;
@Service
public class ServiceInstitutImpl implements ServiceInstitut {
	 @Autowired
	   private InsititutDAO institutDao;

	@Transactional
	@Override
	public long save(Institut institut) {
		// TODO Auto-generated method stub
		 return institutDao.save(institut);
	}

	@Transactional
	@Override
	public Institut get(long id) {
		// TODO Auto-generated method stub
		return institutDao.get(id);
	}

	@Transactional
	@Override
	public List<Institut> list() {
		// TODO Auto-generated method stub
		return institutDao.list();
	}

	@Transactional
	@Override
	public void update(long id, Institut institut) {
		// TODO Auto-generated method stub
		institutDao.update(id, institut);
		
	}

	@Transactional
	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		
		institutDao.delete(id);
		
	}

}
