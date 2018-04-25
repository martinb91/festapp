package hu.bandur.boot.services;

import hu.bandur.boot.dto.FestivalDTO;
import hu.bandur.boot.entities.Festival;

import java.util.Date;
import java.util.List;


public interface FestivalService {

	List<Festival> findAllFestival();
	void changeStyles(Festival festival);
	void addStyles(Festival festival);
	Festival findById(int id);
	List<Festival> getFestivalsByStyleName(String styleName);

	Festival addFestival(Festival fest);
	Festival updateFestival(Festival festival);

    List<FestivalDTO> festsByQuery(String style, boolean isFree, Date begin, Date end, Double posX, Double posY, Double maxFromPos);
}
