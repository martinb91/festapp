package hu.bandur.boot.mapper;

import hu.bandur.boot.dto.ArtistDTO;
import hu.bandur.boot.entities.Artist;
import hu.bandur.boot.entities.MusicStyle;

import java.util.ArrayList;
import java.util.List;

public class ArtistMapperImpl implements ArtistMapper{
    @Override
    public ArtistDTO toDTO(Artist artist) {
        List<String> list = new ArrayList<String>();
        for ( MusicStyle musicStyle: artist.getStyles()){
           list.add( musicStyle.getStyle());
        }
        return new ArtistDTO(artist.getName(), artist.getDescription(), artist.getId(), list);
     }

    @Override
    public Artist toEntity(ArtistDTO artistDTO) {
        return null;
    }

    @Override
    public void mapToEntity(ArtistDTO artistDTO, Artist artist) {

    }
}
