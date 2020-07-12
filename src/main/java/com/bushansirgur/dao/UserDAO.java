package com.bushansirgur.dao;

import java.util.List;

import com.bushansirgur.model.Institut;
import com.bushansirgur.model.User;


public interface UserDAO {
	
	User get(long id);
	List<User> list();
	long save(User book);
	void update(long id, User book);
	void delete(long id);

}
