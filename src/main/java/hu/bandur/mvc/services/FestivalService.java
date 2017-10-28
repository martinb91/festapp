package hu.bandur.mvc.services;

import java.util.List;

import hu.bandur.mvc.data.entities.Festival;

public interface FestivalService {

	void addFestival(Festival fest);
	List<Festival> findAllFestival();
	
}
