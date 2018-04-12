package hu.bandur.boot.services.impl;

import hu.bandur.boot.dto.FestivalDTO;
import hu.bandur.boot.dto.FestivalStyleDTO;
import hu.bandur.boot.dto.PositionDTO;
import hu.bandur.boot.entities.Festival;
import hu.bandur.boot.entities.FestivalStyle;
import hu.bandur.boot.entities.Position;
import hu.bandur.boot.repositories.FestivalRepository;
import hu.bandur.boot.repositories.FestivalStyleRepository;
import hu.bandur.boot.repositories.PositionRepository;
import hu.bandur.boot.services.FestivalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Component("festivalService")
@Transactional
public class FestivalServiceImpl  implements FestivalService{
	private FestivalRepository festivalRepository;
	private PositionRepository positionRepository;
	private FestivalStyleRepository festivalStyleRepository;

	@Autowired
	public void setFestivalRepository(FestivalRepository festivalRepository) {
		this.festivalRepository = festivalRepository;
	}

	@Autowired
	public void setPositionRepository(PositionRepository positionRepository) {
		this.positionRepository = positionRepository;
	}
	
	@Autowired
	public void setFestivalStyleRepository(FestivalStyleRepository festivalStyleRepository) {
		this.festivalStyleRepository = festivalStyleRepository;
	}


	public List<Festival> findAllFestival(){
        List<Festival> f = this.festivalRepository.findAll();
		return f;
	}

	@Override
	public void addStyleForFestival(List<FestivalStyleDTO> festivalStyle, Festival festival) {
		for(FestivalStyleDTO f : festivalStyle){
			festivalStyleRepository.save(new FestivalStyle(f.getStyle(), festival));
		}
	}

	@Override
	public Festival updateFestival(FestivalDTO festivalDTO) {
		Festival festival = festivalRepository.findOne(festivalDTO.getId());
		festival.setBeginDate(festivalDTO.getBeginDate());
		festival.setEndDate(festivalDTO.getEndDate());
		festival.setDescription(festivalDTO.getDescription());
		festival.setName(festivalDTO.getName());
     //   PositionDTO positionDTO = festivalDTO.getPosition();
        festivalRepository.save(festival);
		return festival;
	}

	@Override
	public Festival findById(int id) {
		return festivalRepository.findOne(id);
	}


	public void addFestival(FestivalDTO fest) {
		PositionDTO p = fest.getPosition();
		Position place = new Position(p.getX(), p.getY(), p.getCity(), p.getDescription());
		System.out.println(place);
		this.positionRepository.save(place);
		Festival f = new Festival(place, fest.getBeginDate(), fest.getEndDate(), fest.getDescription(), fest.getName());
		this.festivalRepository.save(f);
		addStyleForFestival(fest.getStyles(), f);
	}

}
