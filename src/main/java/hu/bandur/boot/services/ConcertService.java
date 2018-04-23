package hu.bandur.boot.services;

import hu.bandur.boot.dto.ArtistDTO;
import hu.bandur.boot.dto.ConcertDTO;
import hu.bandur.boot.dto.FestivalDTO;
import hu.bandur.boot.entities.Concert;

import java.util.Date;
import java.util.List;

public interface ConcertService {

    List<ConcertDTO> ConcertsByArtistId(int id);
    List<ConcertDTO> ConcertsByEventId(int id);
    Concert addConcert(ConcertDTO concertDTO);

    void addConcertsForFestival(List<ConcertDTO> concertDTOs);
    void deleteConcertsForFestival(FestivalDTO festivalDTO);
    List<Concert> findAllConcerts();
    List<Concert> betweenDates(Date after, Date before);
    List<Concert> ConcertsByArtistName(ArtistDTO artistDTO);
    List<Concert> ConcertsByFestName(FestivalDTO festivalDTO);
}
