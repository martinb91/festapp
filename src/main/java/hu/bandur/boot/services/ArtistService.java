package hu.bandur.boot.services;

import hu.bandur.boot.dto.ArtistDTO;
import hu.bandur.boot.dto.MusicStyleDTO;
import hu.bandur.boot.entities.Artist;

import java.util.List;

public interface ArtistService {


    Artist addArtist(ArtistDTO artistDTO);
    void addStyleForFestival(List<MusicStyleDTO> musicStyleDTOs, Artist artist);
    Artist updateArtist(ArtistDTO artistDTO);
    List<Artist> findAllArtists();

    List<Artist> findByName(String s);

    Artist findById(int id);

    Artist updateArtistById(int id, ArtistDTO artistDTO);

    Artist updateArtistById(int id, Artist artist);
}
