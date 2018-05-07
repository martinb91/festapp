package hu.bandur.boot.controller;

import hu.bandur.boot.dto.FestivalDTO;
import hu.bandur.boot.dto.FestivalStyleDTO;
import hu.bandur.boot.entities.Festival;
import hu.bandur.boot.services.FestivalStyleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/feststyle")
public class FestivalStyleController {

    private FestivalStyleService festivalStyleService;

	@Autowired
	public void setFestivalStyleService(FestivalStyleService festivalStyleService) {
		this.festivalStyleService = festivalStyleService;
	}

	
	@RequestMapping(path = "/bystyle", method = RequestMethod.POST)
	public List<FestivalDTO> allFestivalByStyle(@RequestBody String s) {
        return festivalStyleService.findAllFestivalByStyleName(s);
	}

	//allStyle

}
