package hu.bandur.boot.controller;

import hu.bandur.boot.dto.ArtistDTO;
import hu.bandur.boot.entities.Artist;
import hu.bandur.boot.mapper.ArtistMapperImpl;
import hu.bandur.boot.services.ArtistService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/artists")
public class ArtistController {

	private ArtistService artistService;
	private ModelMapper modelMapper;

	@Autowired
	public void setModelMapper(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}
	@Autowired
	public void setArtistService(ArtistService artistService) {
		this.artistService = artistService;
	}

	@RequestMapping( method = RequestMethod.GET, path = "/artists.json")
	public List<ArtistDTO> all() {
		List<ArtistDTO> artistDTOS =
				new ArrayList<>();
		for(Artist artist : artistService.findAllArtists()){
			artistDTOS.add(modelMapper.map(artist, ArtistDTO.class));
		}
/*	------- 	Just I can to understand, how works the mapper		---------------------------
		List<Artist> artist =
				new ArrayList<>();
		for (ArtistDTO artistDTO : artistDTOS){
			artist.add(modelMapper.map(artistDTO, Artist.class));
		}
		for (Artist a : artist){
			System.out.println(a);
		}	*/
		return artistDTOS;
	}

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ArtistDTO artistById(@PathVariable int id) {
        return modelMapper.map(artistService.findById(id), ArtistDTO.class);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ArtistDTO update(@PathVariable int id, @RequestBody ArtistDTO artistDTO) {
        return modelMapper.map(artistService.updateArtist(artistDTO), ArtistDTO.class);
    }

	@RequestMapping(path = "/new.json", method = RequestMethod.POST)
	public Artist create(@RequestBody ArtistDTO artistDTO) {
		return artistService.addArtist(artistDTO);
	}

	@RequestMapping( method = RequestMethod.GET, path = "/style/{styleName}")
	public List<ArtistDTO> ArtistsByName(@PathVariable String styleName) {
		List<ArtistDTO> artistDTOS =
				new ArrayList<>();
		for(Artist artist : artistService.getArtistsByStyleName(styleName)){
			artistDTOS.add(modelMapper.map(artist, ArtistDTO.class));
		}return artistDTOS;
	}

	//------ valamiért nem veszi át, valszeg authentikációval van gond, volt már hasonló probléma a PUT-tal, de nem emlékszem már rá, hogy oldodott meg
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public boolean delete(@PathVariable int id) {
		System.out.println(id);
		return artistService.deleteArtistById(id);
	}

}
