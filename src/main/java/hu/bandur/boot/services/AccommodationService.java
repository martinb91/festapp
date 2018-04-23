package hu.bandur.boot.services;

import hu.bandur.boot.dto.AccommodationDTO;
import hu.bandur.boot.dto.FestivalDTO;
import hu.bandur.boot.entities.Accommodation;

import java.util.List;

public interface AccommodationService {
    AccommodationDTO addAccommodation(AccommodationDTO newA);
    List<AccommodationDTO> FindAllWhatNearTheFest(int id);

    void modifyAccommodation(AccommodationDTO accommodationDTO);
    List<Accommodation> findByAddress(AccommodationDTO accommodationDTO);
    List<Accommodation> findByName(AccommodationDTO accommodationDTO);
    List<Accommodation> findAccommodations();
}
