package hu.bandur.boot.services.impl;

import hu.bandur.boot.dto.ArtistDTO;
import hu.bandur.boot.entities.Artist;
import hu.bandur.boot.entities.MusicStyle;
import hu.bandur.boot.pictureHandler.storage.StoreFileService;
import hu.bandur.boot.repositories.ArtistRepository;
import hu.bandur.boot.repositories.ConcertRepository;
import hu.bandur.boot.repositories.MusicStyleRepository;
import hu.bandur.boot.services.ArtistService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;


import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Component("artistService")
@Transactional
public class ArtistServiceImpl implements ArtistService, StoreFileService {

	private ArtistRepository artistRepository;
	private MusicStyleRepository musicStyleRepository;
    private ModelMapper modelMapper;
    private ConcertRepository concertRepository;

    @Autowired
    public void setArtistRepository(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    @Autowired
	public void setMusicStyleRepository(MusicStyleRepository musicStyleRepository) { this.musicStyleRepository = musicStyleRepository; }

    @Autowired
    public void setModelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

	@Autowired
	public void setConcertRepository(ConcertRepository concertRepository) {
		this.concertRepository = concertRepository;
	}

    @Override
    public List<Artist> findAllArtists() {
		return this.artistRepository.findAll();
	}

	@Override
	public Artist findById(int id) {
		return artistRepository.findOne(id);
	}

	@Override
	public Artist addArtist(ArtistDTO artistDTO) {
		Artist artist = modelMapper.map(artistDTO, Artist.class);
		Artist a = artistRepository.save(artist);
		a.setStyles(artist.getStyles());
		this.changeStyles(a);
//		 artist.setStyles(this.setArtistReferencesForStyles(artist, artist.getStyles()));
		return a;
	}

	@Override
	public Artist updateArtist(ArtistDTO artistDTO) {
    	artistDTO.setPicture(artistRepository.findOne(artistDTO.getId()).getPicture());
		return addArtist(artistDTO);
	}

    @Override
    public void changeStyles(Artist artist) {
		List<MusicStyle> ms = new ArrayList<>();
		for (MusicStyle musicStyle: musicStyleRepository.findByArtist(artist)) {
			boolean var = false;
			for(MusicStyle m : artist.getStyles()){
				if (m.getId()==musicStyle.getId() && !m.getStyle().equals("")){
					var = true;
					break;
				}
			}
			if (!var){
				ms.add(musicStyle);
			}
		}
		musicStyleRepository.delete(ms);
		addStyles(artist);
    }

	@Override
	public void addStyles(Artist artist) {
		for(MusicStyle m : artist.getStyles()) {
			if (m.getStyle() != null && !m.getStyle().equals("") ) {
				if (m.getId() == 0 || ((Integer) m.getId()) == null) {
					musicStyleRepository.save(new MusicStyle(m.getStyle(), artist));
				} else {
					m.setArtist(artist);
					musicStyleRepository.save(m);
				}
			}
		}
	}

	@Override
    public List<Artist> findByName(String s) {
        String str = "%" + s +"%";
        return artistRepository.findByNameLike(str);
    }

	@Override
	public int deleteArtistById(int id) {
    	concertRepository.deleteByArtist_Id(id);
		musicStyleRepository.deleteMusicStyleByArtist(artistRepository.findOne(id));
		return artistRepository.deleteById(id);
	}

	@Override
	public List<Artist> getArtistsByStyleName(String styleName) {
		List<MusicStyle> musicStyles = musicStyleRepository.findMusicStyleByStyleLike(styleName);
		List<Artist> artists = new ArrayList<Artist>();
		for(MusicStyle musicStyle: musicStyles){
			artists.add(musicStyle.getArtist());
		}
		return artists;
	}

	@Override
	public void storeFile(MultipartFile file, int id) {
		String currentDate = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
		try {
			String newName =  currentDate + file.getOriginalFilename();
			Files.copy(file.getInputStream(), this.rootLocation.resolve(newName));
			Artist artist = artistRepository.findOne(id);
			artist.setPicture(newName);
			artistRepository.save(artist);
		} catch (Exception e) {
			throw new RuntimeException("FAIL!");
		}
	}
}
