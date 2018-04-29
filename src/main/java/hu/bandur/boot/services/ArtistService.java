package hu.bandur.boot.services;

import hu.bandur.boot.dto.ArtistDTO;
import hu.bandur.boot.dto.MusicStyleDTO;
import hu.bandur.boot.entities.Artist;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ArtistService {

    List<Artist> findAllArtists();
    void changeStyles(Artist artist);
    void addStyles(Artist artist);
    Artist findById(int id);
    Artist updateArtist(ArtistDTO artistDTO);
    Artist addArtist(ArtistDTO artistDTO);
    List<Artist> getArtistsByStyleName(String styleName);

    //---- these we don't use until now
    List<Artist> findByName(String s);
    boolean deleteArtistById(int id);


}
