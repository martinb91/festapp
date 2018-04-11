package hu.bandur.boot.services.impl;

import hu.bandur.boot.dto.AccommodationDTO;
import hu.bandur.boot.dto.FestivalDTO;
import hu.bandur.boot.dto.PositionDTO;
import hu.bandur.boot.entities.Accommodation;
import hu.bandur.boot.entities.Position;
import hu.bandur.boot.repositories.AccommodationRepository;
import hu.bandur.boot.repositories.PositionRepository;
import hu.bandur.boot.services.AccommodationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Component("accommodationService")
@Transactional
public class AccommodationServiceImpl implements AccommodationService {

	private PositionRepository positionRepository;
	private AccommodationRepository accommondationRepository;

	@Autowired
	public void setAccommondationRepository(AccommodationRepository accommondationRepository) {
		this.accommondationRepository = accommondationRepository;
	}

	@Autowired
	public void setPositionRepository(PositionRepository positionRepository) {
		this.positionRepository = positionRepository;
	}

	@Override
	public void addAccommodation(AccommodationDTO newA) {
		System.out.println(newA);
		PositionDTO positionDTO = newA.getAddress();
		Position position = new Position(positionDTO.getX(),positionDTO.getY(), positionDTO.getCity(),positionDTO.getDescription());
		System.out.println(position);
		positionRepository.save(position);
		accommondationRepository.save(new Accommodation(newA.getPrice(),newA.getName(),newA.getHeads(), position, newA.getDescription(),newA.getEmail(), newA.getPhoneNumber(), null));
		//az utolsó sort majd javítani (a null érték csak a konverzió miatt van)
	}

	public List<Accommodation> FindAllWhatNearTheFest(FestivalDTO festival){
		System.out.println(festival);
		double fx =	festival.getPosition().getX();
		double fy =  festival.getPosition().getY();
		List<Accommodation> accommondations = accommondationRepository.findAll();
		List<Accommodation> accommodationList = new ArrayList<Accommodation>();
		for (Accommodation accommodation : accommondations){
			double x = accommodation.getAddress().getX();
			double y = accommodation.getAddress().getY();
			System.out.println(Math.abs(fy-y)+ " " + Math.abs(fx-x));
			if(Math.abs(fx-x) < 10 && Math.abs(fy-y) < 10){
				accommodationList.add(accommodation);
			}
		}
		return accommodationList;
	}

	@Override
	public void modifyAccommodation(AccommodationDTO accommodationDTO) {
		Accommodation accommodation = accommondationRepository.findOne(accommodationDTO.getId());
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
		accommondationRepository.save(accommodation); // itt lehet nem menti le a címet
	}

	@Override
	public List<Accommodation> findByName(AccommodationDTO accommodationDTO) {
		accommodationDTO.getAddress().getCity();
		return accommondationRepository.findByName(accommodationDTO.getName());
	}

	@Override
	public List<Accommodation> findAccommodations() {
		return accommondationRepository.findAll();
	}

	@Override
	public List<Accommodation> findByAddress(AccommodationDTO accommodationDTO) {
		accommodationDTO.getAddress().getCity();
		return accommondationRepository.findByAddress_City(accommodationDTO.getAddress().getCity());
	}

}