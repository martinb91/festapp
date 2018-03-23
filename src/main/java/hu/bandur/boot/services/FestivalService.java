package hu.bandur.boot.services;

import hu.bandur.boot.dto.FestivalDTO;
import hu.bandur.boot.dto.FestivalStyleDTO;
import hu.bandur.boot.entities.Festival;

import java.util.List;


public interface FestivalService {

	void addFestival(FestivalDTO fest);
	List<Festival> findAllFestival();
	void addStyleForFestival(List<FestivalStyleDTO> festivalStyle, Festival festival);
	Festival updateFestival(FestivalDTO festivalDTO);

	Festival findById(int id);
}
