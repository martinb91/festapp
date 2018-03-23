package hu.bandur.boot.services.impl;

import hu.bandur.boot.entities.Artist;
import hu.bandur.boot.entities.MusicStyle;
import hu.bandur.boot.repositories.MusicStyleRepository;
import hu.bandur.boot.services.MusicStyleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("musicStyleService")
public class MusicStyleServiceImpl implements MusicStyleService {

private MusicStyleRepository musicStyleRepository;

    @Autowired
    public void setMusicStyleRepository(MusicStyleRepository musicStyleRepository) {
        this.musicStyleRepository = musicStyleRepository;
    }

    public List<MusicStyle> findAllMusiciStyleByStyleName(String s) {
        String string = "%" + s +"%";
        return musicStyleRepository.findMusicStyleByStyleLike(string);
    }

    @Override
    public List<Artist> findAllArtistByStyleName(String s) {
        List<MusicStyle> musicStyles = findAllMusiciStyleByStyleName(s);
        List<Artist> artists = new ArrayList<Artist>();
        for (MusicStyle musicStyle: musicStyles){
            if(!artists.contains(musicStyle.getArtist()))
                artists.add(musicStyle.getArtist());
        }
        return artists;
    }
}
