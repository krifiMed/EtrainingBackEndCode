package com.bushansirgur.service;

import java.util.List;

import com.bushansirgur.model.Institut;

public interface ServiceInstitut {
	
	long save(Institut formation);

	Institut get(long id);

	   List<Institut> list();

	   void update(long id, Institut institut);

	   void delete(long id);

}
