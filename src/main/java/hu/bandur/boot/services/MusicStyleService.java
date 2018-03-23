package hu.bandur.boot.services;

import hu.bandur.boot.entities.Artist;

import java.util.List;

public interface MusicStyleService {
    List<Artist> findAllArtistByStyleName(String s);
}
