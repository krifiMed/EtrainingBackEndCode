package com.bushansirgur.dao;

import java.util.List;

import com.bushansirgur.model.Formation;


public interface FormationDAO {
	
	long save(Formation formation);

	   Formation get(long id);

	   List<Formation> list();

	   void update(long id, Formation book);

	   void delete(long id);

}
