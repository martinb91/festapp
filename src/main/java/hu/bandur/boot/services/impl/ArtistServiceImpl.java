package hu.bandur.boot.services.impl;

import hu.bandur.boot.dto.ArtistDTO;
import hu.bandur.boot.dto.MusicStyleDTO;
import hu.bandur.boot.entities.Artist;
import hu.bandur.boot.entities.MusicStyle;
import hu.bandur.boot.repositories.ArtistRepository;
import hu.bandur.boot.repositories.MusicStyleRepository;
import hu.bandur.boot.services.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Component("artistService")
@Transactional
public class ArtistServiceImpl implements ArtistService {

	private ArtistRepository artistRepository;
	private MusicStyleRepository musicStyleRepository;

	@Autowired
	public void setMusicStyleRepository(MusicStyleRepository musicStyleRepository) {
		this.musicStyleRepository = musicStyleRepository;
	}

	@Autowired
	public void setArtistRepository(ArtistRepository artistRepository) {
		this.artistRepository = artistRepository;
	}

	@Override
	public Artist addArtist(ArtistDTO artistDTO) {
		Artist artist = new Artist(artistDTO.getName(), artistDTO.getDescription());
		return artistRepository.save(artist);
	//	addStyleForFestival(artistDTO.getMusicStyleList(), artist);
	}

	@Override
	public void addStyleForFestival(List<MusicStyleDTO> musicStyleDTOs,  Artist artist) {
		for(MusicStyleDTO m : musicStyleDTOs){
			musicStyleRepository.save(new MusicStyle(m.getStyle(), artist));
		}
	}

	public List<Artist> findAllArtists() {
		return this.artistRepository.findAll();

	}

	@Override
	public List<Artist> findByName(String s) {
		String str = "%" + s +"%";
		return artistRepository.findByNameLike(str);
	}

	@Override
	public Artist findById(int id) {
		return artistRepository.findOne(id);
	}

	@Override
	public Artist updateArtistById(int id, ArtistDTO artistDTO) {
		Artist artist = artistRepository.findOne(id);
		artist.setDescription(artistDTO.getDescription());
		artist.setName(artistDTO.getName());
		musicStyleRepository.deleteMusicStyleByArtist(artist);
		for (String style : artistDTO.getStyles()){
			musicStyleRepository.save(new MusicStyle(style,artist));
		}
		artistRepository.save(artist);
		return artist;
	}


	@Override
	public Artist updateArtist(ArtistDTO artistDTO) {
		Artist artist = artistRepository.findOne(artistDTO.getId());
		artist.setDescription(artistDTO.getDescription());
		artist.setName(artistDTO.getName());
//		artist.setMusicStyleList(artistDTO.getStyles());
        artistRepository.save(artist);
		return artist;
	}

}
