package hu.bandur.boot.mapper;

import hu.bandur.boot.dto.ConcertDTO;
import hu.bandur.boot.dto.FestivalDTO;
import hu.bandur.boot.entities.Concert;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;


public class ConcertMapperImpl implements ConcertMapper {

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ConcertDTO toDTO(Concert concert) {
        ArtistMapper artistMapper = new ArtistMapperImpl();
        return new ConcertDTO(artistMapper.toDTO(concert.getArtist()), modelMapper.map(concert.getFestival(), FestivalDTO.class), concert.getBeginDate(),concert.getId());
    }


    @Override
    public Concert toEntity(ConcertDTO concertDTO) {
        return null;
    }

    @Override
    public void mapToEntity(ConcertDTO concertDTO, Concert concert) {

    }
}
