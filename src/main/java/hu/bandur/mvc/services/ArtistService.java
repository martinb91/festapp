package hu.bandur.mvc.services;

import java.util.List;
import java.util.Map;
import java.util.Set;

import hu.bandur.mvc.data.entities.Artist;

public interface ArtistService {
	
	List<Artist> getAllArtists();
	Artist getArtistById(String ID);
	List<Artist> getArtistsByCategory(String category);
	Set<Artist> getArtistsByFilter(Map<String, List<String>> filterParams);
	void addArtist(Artist artist);
	

}
