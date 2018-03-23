package hu.bandur.boot.controller;

import hu.bandur.boot.dto.ArtistDTO;
import hu.bandur.boot.entities.Artist;
import hu.bandur.boot.mapper.ArtistMapperImpl;
import hu.bandur.boot.services.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/artists")
public class ArtistController {

	private ArtistService artistService;

	@Autowired
	public void setArtistService(ArtistService artistService) {
		this.artistService = artistService;
	}

	@RequestMapping( method = RequestMethod.GET, path = "/artists.json")
	public List<ArtistDTO> all() {
		List<ArtistDTO> artistDTOS = new ArrayList<ArtistDTO>();
		for (Artist a : artistService.findAllArtists()) {
			ArtistMapperImpl artistMapper= new ArtistMapperImpl();
			artistDTOS.add(artistMapper.toDTO(a));
		}
		return artistDTOS;
		//return artistService.findAllArtists();
	}

	@RequestMapping(path = "/new.json", method = RequestMethod.POST)
	public Artist create(@RequestBody ArtistDTO artistDTO) {
		return artistService.addArtist(artistDTO);
		 //ezt majd végig kell kisérni a serveren, hogy valahol nem-e bukik el.
	}


//	@RequestMapping( method = RequestMethod.GET)
//	public List<Artist> byName(@RequestBody String name) {
//		return artistService.findByName(name);
//	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ArtistDTO artistById(@PathVariable int id) {
		ArtistMapperImpl artistMapper= new ArtistMapperImpl();
		return artistMapper.toDTO(artistService.findById(id));
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Artist updateById(@PathVariable int id, @RequestBody ArtistDTO artistDTO) {
		return artistService.updateArtistById(id, artistDTO);
	}

	//byStyle

	/*
	@RequestMapping(path="update", method = RequestMethod.PUT)
	public Festival updateFestival(@RequestBody FestivalDTO festival){
		if(festival.getID()!= 0) {
			return festivalService.updateFestival(festival);
		}
		return null;
	}
	*/
}
