package hu.bandur.mvc.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hu.bandur.mvc.dao.FestivalDAO;
import hu.bandur.mvc.dao.FestivalStyleDAO;
import hu.bandur.mvc.dao.PositionDAO;
import hu.bandur.mvc.data.entities.Festival;
import hu.bandur.mvc.data.entities.FestivalStyle;
import hu.bandur.mvc.data.entities.Position;
import hu.bandur.mvc.services.FestivalService;

@Service("festivalService")
@Transactional
public class FestivalServiceImpl implements FestivalService{

	private FestivalDAO festivalDAO;
	private PositionDAO positionDAO;
	private FestivalStyleDAO festivalStyleDAO;

	@Autowired
	public void setFestivalDAO(FestivalDAO festivalDAO) {
		this.festivalDAO = festivalDAO;
	}

	@Autowired
	public void setPositionDAO(PositionDAO positionDAO) {
		this.positionDAO = positionDAO;
	}
	
	@Autowired
	public void setFestivalStyleDAO(FestivalStyleDAO festivalStyleDAO) {
		this.festivalStyleDAO = festivalStyleDAO;
	}

	
	public List<Festival> findAllFestival(){
		return this.festivalDAO.findAll();
	}
	
	public void addFestival(Festival fest) {
		Position p = fest.getPosition();
		Position place = new Position(p.getX(), p.getY(), p.getCity(), p.getDescription());
		System.out.println(place);
		this.positionDAO.save(place);
		System.out.println("fffffffffffff");
		Festival f = new Festival(place, fest.getBeginDate(), fest.getEndDate(), fest.getDescription(), fest.getName());
		this.festivalDAO.save(f);
		for(FestivalStyle fs : fest.getFestStyleList()) {
			FestivalStyle festStyle = new FestivalStyle(fs.getStyle(), f);
			System.out.println(festStyle);
			festivalStyleDAO.save(festStyle);
		}
	}
	
}
