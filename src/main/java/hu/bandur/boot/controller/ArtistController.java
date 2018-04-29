package hu.bandur.boot.controller;

import hu.bandur.boot.dto.ArtistDTO;
import hu.bandur.boot.entities.Artist;
import hu.bandur.boot.pictureHandler.storage.StoreFileService;
import hu.bandur.boot.services.ArtistService;
import hu.bandur.boot.services.impl.ArtistServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/artists")
public class ArtistController {

	private ArtistService artistService;
	private ModelMapper modelMapper;
	private StoreFileService storeFileService;

	@Autowired
	public void setStoreFileService(ArtistServiceImpl storeFileService) {
		this.storeFileService = storeFileService;
	}

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
	public List<ArtistDTO> ArtistsByStyleName(@PathVariable String styleName) {
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

	@RequestMapping( method = RequestMethod.POST, path = "/upload/{id}")
	public ResponseEntity<String> uploadPicture(@RequestParam("file") MultipartFile file, @PathVariable int id) {
		String message = "";
		try {
			storeFileService.storeFile(file, id);
			//files.add(file.getOriginalFilename());
			message = "You successfully uploaded " + file.getOriginalFilename() + "!";
			return ResponseEntity.status(HttpStatus.OK).body(message);
		} catch (Exception e) {
			message = "FAIL to upload " + file.getOriginalFilename() + "!";
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
		}
	}

}
