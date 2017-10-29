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
		festivalService.addFestival(f);
	}
	
	@RequestMapping(path = "/all", method = RequestMethod.GET)
	public void all() {
		System.out.println(festivalService.findAllFestival());
	}
	
}
