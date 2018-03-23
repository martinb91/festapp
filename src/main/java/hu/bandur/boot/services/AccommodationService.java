package hu.bandur.boot.services;

import hu.bandur.boot.dto.AccommodationDTO;
import hu.bandur.boot.dto.FestivalDTO;
import hu.bandur.boot.entities.Accommodation;

import java.util.List;

public interface AccommodationService {
    void addAccommodation(AccommodationDTO newA);
    List<Accommodation> FindAllWhatNearTheFest(FestivalDTO festival);

    void modifyAccommodation(AccommodationDTO accommodationDTO);
    List<Accommodation> findByAddress(AccommodationDTO accommodationDTO);
    List<Accommodation> findByName(AccommodationDTO accommodationDTO);
}
