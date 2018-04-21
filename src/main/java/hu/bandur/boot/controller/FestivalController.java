package hu.bandur.boot.controller;

import hu.bandur.boot.dto.FestivalDTO;
import hu.bandur.boot.entities.Festival;
import hu.bandur.boot.services.FestivalService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/festival")
public class FestivalController {

	private FestivalService festivalService;
	private ModelMapper modelMapper;

	@Autowired
	public void setModelMapper(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}

	@Autowired
	public void setFestivalService(FestivalService festivalService) {
		this.festivalService = festivalService;
	}
	
	@RequestMapping(path = "/all.json", method = RequestMethod.GET)
	public List<FestivalDTO> all() {
		List<FestivalDTO> festivalDTOS = new ArrayList<>();
		for(Festival festival : festivalService.findAllFestival()){
			festivalDTOS.add(modelMapper.map(festival, FestivalDTO.class));
		}
		return festivalDTOS;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public FestivalDTO festivalById(@PathVariable int id) {
		return modelMapper.map(festivalService.findById(id), FestivalDTO.class);
	}

	@RequestMapping( method = RequestMethod.GET, path = "/style/{styleName}")
	public List<FestivalDTO> ArtistsByStyleName(@PathVariable String styleName) {
		List<FestivalDTO> festivalDTOS =
				new ArrayList<>();
		for(Festival artist : festivalService.getFestivalsByStyleName(styleName)){
			festivalDTOS.add(modelMapper.map(artist, FestivalDTO.class));
		}return festivalDTOS;
	}
//------------
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public FestivalDTO updateById(@PathVariable int id, @RequestBody FestivalDTO festivalDTO) {
		return modelMapper.map(
				festivalService.updateFestival(
						modelMapper.map(festivalDTO, Festival.class)),
				FestivalDTO.class);
	}

	@RequestMapping(path = "/new.json", method = RequestMethod.POST)
	public void create(@RequestBody FestivalDTO f) {
		System.out.println(f);
		festivalService.addFestival(modelMapper.map(f, Festival.class));
	}

}
