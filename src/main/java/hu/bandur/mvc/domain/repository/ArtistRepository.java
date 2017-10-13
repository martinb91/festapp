package hu.bandur.mvc.domain.repository;

import java.util.List;
import java.util.Map;
import java.util.Set;


import hu.bandur.mvc.data.entities.Artist;

public interface ArtistRepository {
	List <Artist> getAllArtists();
	List <Artist> getArtistsByCategory(String category);
	Artist getArtistByName(String name);
	Artist getArtistById(String id);
	Set<Artist> getArtistsByFilter(Map<String, List<String>> filterParams);
	void addArtist(Artist artist);
}
