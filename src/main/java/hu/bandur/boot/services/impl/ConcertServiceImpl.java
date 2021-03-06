package hu.bandur.boot.services.impl;

import hu.bandur.boot.dto.ArtistDTO;
import hu.bandur.boot.dto.ConcertDTO;
import hu.bandur.boot.dto.FestivalDTO;
import hu.bandur.boot.entities.Artist;
import hu.bandur.boot.entities.Concert;
import hu.bandur.boot.entities.Festival;
import hu.bandur.boot.repositories.ArtistRepository;
import hu.bandur.boot.repositories.ConcertRepository;
import hu.bandur.boot.repositories.FestivalRepository;
import hu.bandur.boot.services.ConcertService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service("concertService")
@Transactional
public class ConcertServiceImpl implements ConcertService {

    private ConcertRepository concertRepository;
    private ArtistRepository artistRepository;
    private FestivalRepository festivalRepository;
    private ModelMapper modelMapper;

    @Autowired
    public void setModelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Autowired
    public void setConcertRepository(ConcertRepository concertRepository) {
        this.concertRepository = concertRepository;
    }
    @Autowired
    public void setArtistRepository(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    @Autowired
    public void setFestivalRepository(FestivalRepository festivalRepository) {
        this.festivalRepository = festivalRepository;
    }

    @Override
    public List<ConcertDTO> ConcertsByArtistId(int id) {
        List<ConcertDTO> concertDTOS = new ArrayList<>();
        for(Concert concert : concertRepository.findByArtist_Id(id)){
            if (concert.getFestival().getEndDate().getTime() > new Date().getTime()) {
                concertDTOS.add(modelMapper.map(concert, ConcertDTO.class));
            }
        }
        return concertDTOS;
    }

    @Override
    public List<ConcertDTO> ConcertsByEventId(int id) {
        List<ConcertDTO> concertDTOS = new ArrayList<>();
        for(Concert concert : concertRepository.findByFestival_Id(id)){
            if (concert.getFestival().getEndDate().getTime() > new Date().getTime()) {
                concertDTOS.add(modelMapper.map(concert, ConcertDTO.class));
            }
        }
        return concertDTOS;
    }

    @Override
    public Concert addConcert(ConcertDTO concertDTO) {
        Concert concert = modelMapper.map(concertDTO, Concert.class);
        concert.setFestival(festivalRepository.findOne(concert.getFestival().getId()));
        concert.setArtist(artistRepository.findOne(concert.getArtist().getId()));
        return concertRepository.save(concert);
    }


    //-.------------------------

    @Override
    public List<Concert> findAllConcerts() {
        return concertRepository.findAll();
    }

    @Override
    public List<Concert> betweenDates(Date after, Date before) { //after ami utáni, before és ami előtti időpontot
        if (after == null) {
            after = new Date(0);
        }
        if (before == null) {
            before = new Date(0);
        }
        List<Concert> concerts = concertRepository.findAll();
        List<Concert> results = new ArrayList<Concert>();
        if (before.getTime() != 0) {
            for (Concert concert : concerts) {
                if ((concert.getBeginDate().getTime() > after.getTime()) && (concert.getBeginDate().getTime() < before.getTime())) {
                    results.add(concert);
                }
            }
        }else if(before.getTime() == 0 && after.getTime()==0){
            return concerts;
        }
        else{
            for (Concert concert : concerts) {
                if ((concert.getBeginDate().getTime() > after.getTime()) ) {
                    results.add(concert);
                }
            }
        }
        return results;
    }

    @Override
    public List<Concert> ConcertsByArtistName(ArtistDTO artistDTO) {
        return concertRepository.findConcertsByArtist_Name("%" + artistDTO.getName() + "%");
    }

    @Override
    public List<Concert> ConcertsByFestName(FestivalDTO festivalDTO) {
        return concertRepository.findConcertsByFestival_Name("%" + festivalDTO.getName() +"%");
    }

}