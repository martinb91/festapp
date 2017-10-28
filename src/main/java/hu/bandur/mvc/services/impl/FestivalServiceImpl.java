package hu.bandur.mvc.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hu.bandur.mvc.dao.FestivalDAO;
import hu.bandur.mvc.data.entities.Festival;
import hu.bandur.mvc.services.FestivalService;

@Service("festivalService")
@Transactional
public class FestivalServiceImpl implements FestivalService{

	@Autowired
	private FestivalDAO festivalDAO;
	
	public List<Festival> findAllFestival(){
		return this.festivalDAO.findAll();
	}
	
	public void addFestival(Festival fest) {
		this.festivalDAO.save(fest);
	}
	
}
