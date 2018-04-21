package hu.bandur.boot.services.impl;

import hu.bandur.boot.dto.FestivalDTO;
import hu.bandur.boot.dto.FestivalStyleDTO;
import hu.bandur.boot.dto.PositionDTO;
import hu.bandur.boot.entities.Festival;
import hu.bandur.boot.entities.FestivalStyle;
import hu.bandur.boot.entities.MusicStyle;
import hu.bandur.boot.entities.Position;
import hu.bandur.boot.repositories.FestivalRepository;
import hu.bandur.boot.repositories.FestivalStyleRepository;
import hu.bandur.boot.repositories.PositionRepository;
import hu.bandur.boot.services.FestivalService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Component("festivalService")
@Transactional
public class FestivalServiceImpl  implements FestivalService{
	private FestivalRepository festivalRepository;
	private PositionRepository positionRepository;
	private FestivalStyleRepository festivalStyleRepository;
	private ModelMapper modelMapper;

	@Autowired
	public void setModelMapper(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}

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
        List<Festival> festivals = this.festivalRepository.findAll();
		return festivals;
	}

	@Override
	public Festival findById(int id) {
		return festivalRepository.findOne(id);
	}

	@Override
	public List<Festival> getFestivalsByStyleName(String styleName) {
		List<FestivalStyle> festivalStyles = festivalStyleRepository.findFestivalStyleByStyleLike(styleName);
		List<Festival> festivals = new ArrayList<>();
		for(FestivalStyle festivalStyle: festivalStyles){
			festivals.add(festivalStyle.getFestival());
		}
		return festivals;
	}

	@Override
	public void changeStyles(Festival festival) {
		List<FestivalStyle> fs = new ArrayList<>();
		for (FestivalStyle festivalStyle: festivalStyleRepository.findFestivalStyleByFestival(festival)) {
			boolean var = false;
			for(FestivalStyle m : festival.getStyles()){
				if (m.getId()==festivalStyle.getId() && !m.getStyle().equals("")){
					var = true;
					break;
				}
			}
			if (!var){
				fs.add(festivalStyle);
			}
		}
		festivalStyleRepository.delete(fs);
		addStyles(festival);
	}

	@Override
	public void addStyles(Festival festival) {
		for(FestivalStyle fs : festival.getStyles()) {
			if (fs.getStyle() != null && !fs.getStyle().equals("") ) {
				if (fs.getId() == 0 || ((Integer) fs.getId()) == null) {
					festivalStyleRepository.save(new FestivalStyle(fs.getStyle(), festival));
				} else {
					fs.setFestival(festival);
					festivalStyleRepository.save(fs);
				}
			}
		}
	}

	@Override
	public Festival addFestival(Festival fest) {
		positionRepository.save(fest.getPosition());
		festivalRepository.save(fest);
		changeStyles(fest);
		return fest;
	}


	@Override
	public Festival updateFestival(Festival festival) {
	return addFestival(festival);
	}

}
