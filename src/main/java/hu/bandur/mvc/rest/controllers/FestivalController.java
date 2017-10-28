package hu.bandur.mvc.rest.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import hu.bandur.mvc.dao.FestivalDAO;
import hu.bandur.mvc.data.entities.Festival;
import hu.bandur.mvc.data.entities.FestivalStyle;
import hu.bandur.mvc.data.entities.Position;
import hu.bandur.mvc.services.FestivalService;



@RestController
@RequestMapping("/festival")
public class FestivalController {
	
	@Autowired
	private FestivalService festivalService;
	
	@RequestMapping(path = "/new.json", method = RequestMethod.POST)
	public void create(@RequestBody Festival f) {
		System.out.println(f);
//		Festival fest= new Festival();
//		fest.setBeginDate(new Date(2017, 10, 12, 13, 14));
//		fest.setEndDate(new Date(2017, 10, 17, 13, 14));
//		fest.setDescription("Hello");
//		fest.setFestivalName("Rock Maraton");
//		Position place = new Position();
//		place.setCity("city");
//		place.setOthers("dasggg");
//		place.setX(1.1);
//		place.setY(2.1);
//		fest.setPlace(place);
//		List festStyleList = new ArrayList<FestivalStyle>();
//		FestivalStyle fs = new FestivalStyle();
//		fs.setStyle("rock");
//		festStyleList.add(fs);
//		fest.setFestStyleList(festStyleList);
//		festivalService.addFestival(fest);
	}
	
	
}
