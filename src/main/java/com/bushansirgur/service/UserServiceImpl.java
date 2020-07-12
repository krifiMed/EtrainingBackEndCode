package com.bushansirgur.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bushansirgur.dao.InsititutDAO;
import com.bushansirgur.dao.UserDAO;
import com.bushansirgur.model.User;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	   private UserDAO userDao;

	@Transactional
	@Override
	public User get(long id) {
		// TODO Auto-generated method stub
		return userDao.get(id);
	}
	
	@Transactional
	@Override
	public List<User> list() {
		// TODO Auto-generated method stub
		return userDao.list();
	}
	
	@Transactional
	@Override
	public long save(User book) {
		// TODO Auto-generated method stub
		return userDao.save(book);
	}
	
	@Transactional
	@Override
	public void update(long id, User book) {
		userDao.update(id, book);
		
	}
	
	@Transactional
	@Override
	public void delete(long id) {
		userDao.delete(id);
		
	}

}
