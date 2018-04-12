package hu.bandur.boot.controller;

import hu.bandur.boot.dto.FestivalDTO;
import hu.bandur.boot.entities.Festival;
import hu.bandur.boot.services.FestivalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/festival")
public class FestivalController {

	private FestivalService festivalService;

	@Autowired
	public void setFestivalService(FestivalService festivalService) {
		this.festivalService = festivalService;
	}

	@RequestMapping(path = "/new.json", method = RequestMethod.POST)
	public void create(@RequestBody FestivalDTO f) {
		festivalService.addFestival(f);
	}
	
	@RequestMapping(path = "/all.json", method = RequestMethod.GET)
	public List<Festival> all() {
		return festivalService.findAllFestival();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Festival updateById(@PathVariable int id, @RequestBody Festival festival) {
		System.out.println(id);
		System.out.println(festival);
		return festival;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Festival festivalById(@PathVariable int id) {
		return festivalService.findById(id);
	}

	//addExtraStyleForAnExistFest
	//byName
	//Positon+xkm(Település név alapján googlemapsAPI vagy másik freemapAPI alapján el lehet valszeg kérni a koordinátákat.
	// így elég a koordinátákat letárolni)
	//betweenDates
	//deleteFest esetén figyelni kell arra is hogy felszabadítsuk a foglalt erőforrásokat, gondolok itt a Stílusok, Koncertek, Hely

}
