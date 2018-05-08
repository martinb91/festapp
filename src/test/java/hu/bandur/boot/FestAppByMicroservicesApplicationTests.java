package hu.bandur.boot;

import hu.bandur.boot.dto.ArtistDTO;
import hu.bandur.boot.dto.MusicStyleDTO;
import hu.bandur.boot.entities.Artist;
import hu.bandur.boot.repositories.MusicStyleRepository;
import hu.bandur.boot.services.ArtistService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FestAppByMicroservicesApplicationTests {

	@Autowired
	public void setArtistService(ArtistService artistService) {
		this.artistService = artistService;
	}
	@Autowired
	public void setMusicStyleRepository(MusicStyleRepository musicStyleRepository) { this.musicStyleRepository = musicStyleRepository; }

	@Test
	public void contextLoads() {
	}

	ArtistService artistService = null;
	MusicStyleRepository musicStyleRepository = null;
	@Before
	public void init(){
		MusicStyleDTO musicStyleDTO= new MusicStyleDTO(0, "sfsdssd");
		MusicStyleDTO musicStyleDTO1= new MusicStyleDTO(0, "sfsdss");
		MusicStyleDTO musicStyleDTO2= new MusicStyleDTO(0, "sfsdsds");
		List<MusicStyleDTO> musicStyleDTOList = new ArrayList<>();
		musicStyleDTOList.add(musicStyleDTO);
		musicStyleDTOList.add(musicStyleDTO1);
		musicStyleDTOList.add(musicStyleDTO2);
		artistService.addArtist(new ArtistDTO("name",  "description", 0, musicStyleDTOList, "picture"));
	}

	@Test
	public void addArtist(){
		List<Artist> artist = artistService.findByName("name");
		assertEquals(artist.isEmpty(), false);
	}

	@Test
	public void findFest(){
		List<Artist> artist = artistService.findAllArtists();
		assertEquals(artist.size(), 9);
	}

}
