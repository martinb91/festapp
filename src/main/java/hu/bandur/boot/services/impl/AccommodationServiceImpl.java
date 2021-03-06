package hu.bandur.boot.services.impl;

import hu.bandur.boot.dto.AccommodationDTO;
import hu.bandur.boot.dto.FestivalDTO;
import hu.bandur.boot.dto.PositionDTO;
import hu.bandur.boot.entities.Accommodation;
import hu.bandur.boot.entities.Festival;
import hu.bandur.boot.entities.Position;
import hu.bandur.boot.math.Haversine;
import hu.bandur.boot.repositories.AccommodationRepository;
import hu.bandur.boot.repositories.FestivalRepository;
import hu.bandur.boot.repositories.PositionRepository;
import hu.bandur.boot.services.AccommodationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Component("accommodationService")
@Transactional
public class AccommodationServiceImpl implements AccommodationService {

	private PositionRepository positionRepository;
	private AccommodationRepository accommodationRepository;
	private ModelMapper modelMapper;
	private FestivalRepository festivalRepository;

	@Autowired
	public void setModelMapper(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}

	@Autowired
	public void setAccommodationRepository(AccommodationRepository accommodationRepository) {
		this.accommodationRepository = accommodationRepository;
	}

	@Autowired
	public void setPositionRepository(PositionRepository positionRepository) {
		this.positionRepository = positionRepository;
	}

	@Autowired
	public void setFestivalRepository(FestivalRepository festivalRepository) {
		this.festivalRepository = festivalRepository;
	}

	@Override
	public AccommodationDTO addAccommodation(AccommodationDTO newA) {
		Accommodation accommodation = modelMapper.map(newA, Accommodation.class);
		positionRepository.save(accommodation.getAddress());
		return modelMapper.map(accommodationRepository.save(accommodation), AccommodationDTO.class);
	}

	@Override
	public List<AccommodationDTO> FindAllWhatNearTheFest(int id){
		Festival festival = festivalRepository.findOne(id);
		double fx =	festival.getPosition().getX();
		double fy =  festival.getPosition().getY();
		List<Accommodation> accommodations = accommodationRepository.findAll();
		List<AccommodationDTO> accommodationDTOS = new ArrayList<>();
		for (Accommodation accommodation : accommodations){
			double x = accommodation.getAddress().getX();
			double y = accommodation.getAddress().getY();
			if(Haversine.distance(x, y, fx, fy) < 10){
				accommodationDTOS.add(modelMapper.map(accommodation, AccommodationDTO.class));
			}
		}
		return accommodationDTOS;
	}

	@Override
	public void modifyAccommodation(AccommodationDTO accommodationDTO) {
		Accommodation accommodation = accommodationRepository.findOne(accommodationDTO.getId());
		PositionDTO positionDTO=accommodationDTO.getAddress();
		Position p = accommodation.getAddress();
		p.setCity(positionDTO.getCity());
		p.setDescription(positionDTO.getDescription());
		p.setX(positionDTO.getX());
		p.setY(positionDTO.getY());
		accommodation.setDescription(accommodationDTO.getDescription());
		accommodation.setEmail(accommodationDTO.getEmail());
		accommodation.setHeads(accommodationDTO.getHeads());
		accommodation.setName(accommodationDTO.getName());
		accommodation.setPrice(accommodationDTO.getPrice());
		accommodation.setPhoneNumber(accommodationDTO.getPhoneNumber());
		accommodationRepository.save(accommodation); // itt lehet nem menti le a címet
	}

	@Override
	public List<Accommodation> findByName(AccommodationDTO accommodationDTO) {
		accommodationDTO.getAddress().getCity();
		return accommodationRepository.findByName(accommodationDTO.getName());
	}

	@Override
	public List<Accommodation> findAccommodations() {
		return accommodationRepository.findAll();
	}

	@Override
	public List<Accommodation> findByAddress(AccommodationDTO accommodationDTO) {
		accommodationDTO.getAddress().getCity();
		return accommodationRepository.findByAddress_City(accommodationDTO.getAddress().getCity());
	}

}