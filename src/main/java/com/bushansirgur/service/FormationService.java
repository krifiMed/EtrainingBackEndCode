package com.bushansirgur.service;

import java.util.List;

import com.bushansirgur.model.Book;
import com.bushansirgur.model.Formation;

public interface FormationService {
	
	 long save(Formation formation);
	 Formation get(long id);
	   List<Formation> list();
	   void update(long id, Formation formation);
	   void delete(long id);

}
