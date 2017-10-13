package hu.bandur.mvc.services.impl;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.bandur.mvc.data.entities.Artist;
import hu.bandur.mvc.domain.repository.ArtistRepository;
import hu.bandur.mvc.services.ArtistService;

@Service
public class ArtistServiceImpl implements ArtistService {

	@Autowired
	private ArtistRepository artistRepository;

	@Override
	public List<Artist> getAllArtists() {
		return artistRepository.getAllArtists();
	}

	
	public Artist getArtistById(String ID) {
		return artistRepository.getArtistById(ID);
	}

	public List<Artist> getArtistsByCategory(String category) {
		return artistRepository.getArtistsByCategory(category);
	}

	public Set<Artist> getArtistsByFilter(Map<String, List<String>> filterParams) {
		return artistRepository.getArtistsByFilter(filterParams);
	}
	
	public void addArtist(Artist artist) {
		artistRepository.addArtist(artist);
		}

}
