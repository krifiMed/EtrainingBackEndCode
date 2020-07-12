package com.bushansirgur.service;

import java.util.List;

import com.bushansirgur.model.Inscrit_institut;
import com.bushansirgur.model.Participation_Formation;

public interface Inscrit_InstitutService {
long save(Inscrit_institut inscrit);
	
	List<Inscrit_institut> list();
	
	Inscrit_institut get(long id);
	
	void update(long id, Inscrit_institut inscrit);

	   void delete(long id);

}
