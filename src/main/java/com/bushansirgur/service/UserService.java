package com.bushansirgur.service;

import java.util.List;

import com.bushansirgur.model.User;

public interface UserService {
	
	User get(long id);
	List<User> list();
	long save(User book);
	void update(long id, User book);
	void delete(long id);
	

}
