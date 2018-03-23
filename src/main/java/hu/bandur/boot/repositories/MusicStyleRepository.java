package hu.bandur.boot.repositories;

import hu.bandur.boot.entities.Artist;
import hu.bandur.boot.entities.MusicStyle;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface MusicStyleRepository extends CrudRepository<MusicStyle, Integer>{

    List<MusicStyle> findMusicStyleByStyleLike(String style);
    void deleteMusicStyleByArtist( Artist artist);

}
