package com.bushansirgur.service;

import java.util.List;

import com.bushansirgur.model.Institut;
import com.bushansirgur.model.Participation_Formation;

public interface Participation_FormationService {
	
	long save(Participation_Formation participation);

		Participation_Formation get(long id);

	   List<Participation_Formation> list();

	   void update(long id, Participation_Formation participation);
	   
	   void updatePresnece(long id, Participation_Formation participation);
	   
	   void updateNote(long id, Participation_Formation participation);

	   void delete(long id);

}
